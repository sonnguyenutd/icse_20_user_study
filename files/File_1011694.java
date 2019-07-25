package jetbrains.mps.ide.httpsupport.manager.plugin;

/*Generated by MPS */

import org.jetbrains.ide.HttpRequestHandler;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import io.netty.handler.codec.http.HttpRequest;
import com.intellij.util.io.NettyKt;
import java.net.URI;
import java.net.URISyntaxException;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.channel.ChannelHandlerContext;
import java.io.IOException;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.structure.ExtensionPoint;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.apache.log4j.Level;

public class MPSRequestManager extends HttpRequestHandler {
  private static final Logger LOG = LogManager.getLogger(MPSRequestManager.class);

  private static final Set<String> TRUSTED = new HashSet<String>(Arrays.asList("youtrack.jetbrains.com", "teamcity.jetbrains.com"));

  @Override
  public boolean isAccessible(@NotNull HttpRequest request) {
    // Do same things that super.isAccessible(request) does except that this definition 
    // also accepts local requests that triggered by trusted hosts (not only by user directly) 
    // TODO At current stage user can not define their own trusted hosts (see MPS-27006) 

    String host = NettyKt.getHost(request);
    if ((host == null || host.length() == 0) || !(NettyKt.parseAndCheckIsLocalHost("http://" + host))) {
      return false;
    }

    String referrer = NettyKt.getOrigin(request);
    if ((referrer == null || referrer.length() == 0)) {
      referrer = NettyKt.getReferrer(request);
    }
    if ((referrer == null || referrer.length() == 0)) {
      // refferer is local host 
      return true;
    }

    try {
      String referrerHost = new URI(referrer).getHost();
      return (referrerHost != null && referrerHost.length() > 0) && NettyKt.isLocalHost(referrerHost, true, false) || TRUSTED.contains(referrerHost);
    } catch (URISyntaxException e) {
      return false;
    }
  }

  @Override
  public boolean isSupported(@NotNull FullHttpRequest request) {
    return request.method() == HttpMethod.GET;
  }

  @Override
  public boolean process(@NotNull QueryStringDecoder decoder, @NotNull FullHttpRequest request, @NotNull ChannelHandlerContext context) throws IOException {
    jetbrains.mps.ide.httpsupport.manager.plugin.HttpRequest boxedRequest;
    try {
      boxedRequest = new jetbrains.mps.ide.httpsupport.manager.plugin.HttpRequest(request, decoder, context.channel());
    } catch (URISyntaxException exception) {
      return false;
    }

    for (IHttpRequestHandlerFactory handlerFactory : Sequence.fromIterable(new ExtensionPoint<IHttpRequestHandlerFactory>("jetbrains.mps.ide.httpsupport.HttpRequestHandlerEP").getObjects())) {
      IHttpRequestHandler handler = handlerFactory.create(boxedRequest);
      if (handler.canHandle()) {
        try {
          handler.handle();
        } catch (Throwable e) {
          handleException(e, handlerFactory, boxedRequest);
        } finally {
          return true;
        }
      }
    }
    return false;
  }

  public void handleException(Throwable e, IHttpRequestHandlerFactory factory, jetbrains.mps.ide.httpsupport.manager.plugin.HttpRequest request) {
    String errorHeader = "Request handler '" + factory.getHandlerName() + "' throws exception";

    request.sendErrorResponse(HttpResponseStatus.INTERNAL_SERVER_ERROR, errorHeader, e);
    if (LOG.isEnabledFor(Level.ERROR)) {
      LOG.error(errorHeader, e);
    }
  }
}