package jetbrains.mps.build.ant;

/*Generated by MPS */

import java.io.File;
import org.apache.tools.ant.BuildException;
import org.jetbrains.annotations.NotNull;
import java.net.URL;
import java.net.URLDecoder;
import java.net.MalformedURLException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.tools.ant.Project;
import java.util.ArrayList;
import java.util.Set;

public class MPSClasspathUtil {
  private static final String FILE = "file";
  private static final String JAR = "jar";
  private static final String JAR_DELIMITER = "!";
  private static final String PROTOCOL_DELIMITER = ":";


  /**
   * This method is solely for use in bootstrap scenario (building mps modules in mpsBootstrapCore project), where we assume all relevant jars to 
   * reside next to ant-mps.jar that hosts this class. It's mpsTrueBootstrap project that builds java modules and its layout we are going to treat as classpath here.
   */
  private static File getAntJARRelativeHome() {
    String containingJar = getAntMPSJar();
    if (!(containingJar.toLowerCase().endsWith(".jar"))) {
      throw new BuildException("cannot detect jar location: got `" + containingJar + "'");
    }
    // for bootstrap purposes, assume all relevant libraries are next to ant-mps.jar  
    return new File(containingJar).getParentFile();
  }

  @NotNull
  private static String getAntMPSJar() {
    Class aClass = MPSClasspathUtil.class;
    return getResourceRoot(aClass, "/" + aClass.getName().replace('.', '/') + ".class");
  }

  /**
   * Attempts to detect classpath entry which contains given resource
   */
  @NotNull
  private static String getResourceRoot(Class context, String path) {
    URL url = context.getResource(path);
    if (url == null) {
      url = ClassLoader.getSystemResource(path.substring(1));
    }
    if (url == null) {
      throw new BuildException("cannot detect jar location; no resource `" + path + "'");
    }
    // try to decode non-latin characters in url (MPS-20091) 
    try {
      url = new URL(url.getProtocol(), url.getHost(), url.getPort(), URLDecoder.decode(url.getFile(), "UTF-8"));
    } catch (MalformedURLException e) {
    } catch (UnsupportedEncodingException e) {
    }
    return extractRoot(url, path);
  }

  /**
   * Attempts to extract classpath entry part from passed URL.
   */
  @NotNull
  private static String extractRoot(@NotNull URL resourceURL, String resourcePath) {
    if (!((resourcePath.startsWith("/") || resourcePath.startsWith("\\")))) {
      throw new BuildException("cannot detect jar location: precondition failed for" + resourcePath);
    }
    String protocol = resourceURL.getProtocol();
    String resultPath = null;

    if (MPSClasspathUtil.FILE.equals(protocol)) {
      String path = resourceURL.getFile();
      String testPath = path.replace('\\', '/').toLowerCase();
      String testResourcePath = resourcePath.replace('\\', '/').toLowerCase();
      if (testPath.endsWith(testResourcePath)) {
        resultPath = path.substring(0, path.length() - resourcePath.length());
      }
    } else
    if (MPSClasspathUtil.JAR.equals(protocol)) {
      String fullPath = resourceURL.getFile();
      int delimiter = fullPath.indexOf(MPSClasspathUtil.JAR_DELIMITER);
      if (delimiter >= 0) {
        String archivePath = fullPath.substring(0, delimiter);
        if (archivePath.startsWith(MPSClasspathUtil.FILE + MPSClasspathUtil.PROTOCOL_DELIMITER)) {
          resultPath = archivePath.substring(MPSClasspathUtil.FILE.length() + MPSClasspathUtil.PROTOCOL_DELIMITER.length());
        }
      }
    }
    if (resultPath == null) {
      throw new BuildException("cannot detect jar location: url=`" + resourceURL.toString() + "'");
    }

    if (resultPath.endsWith(File.separator)) {
      resultPath = resultPath.substring(0, resultPath.length() - 1);
    }

    return replace(resultPath, "%20", " ");
  }

  @NotNull
  private static String replace(@NotNull String text, @NotNull String from, @NotNull String to) {
    final StringBuilder result = new StringBuilder(text.length());
    final int len = from.length();
    for (int i = 0; i < text.length(); i++) {
      if (text.regionMatches(i, from, 0, len)) {
        result.append(to);
        i += len - 1;
        continue;
      }
      result.append(text.charAt(i));
    }
    return result.toString();
  }

  public static List<File> getClassPathRootsFromDependencies(Project project) {
    List<File> roots = new ArrayList<File>();

    String mpsHome = project.getProperty("artifacts.mps");
    String pluginHome = project.getProperty("artifacts.mpsPlugin");
    String ideaHome = project.getProperty("artifacts.IDEA");
    String mpsCoreHome = project.getProperty("artifacts.mpsBootstrapCore");
    String mpsWorkbenchHome = project.getProperty("artifacts.mpsWorkbench");
    final String mpsStandaloneHome = project.getProperty("artifacts.mpsStandalone");

    if ((mpsHome != null && mpsHome.length() > 0)) {
      // we've got regular MPS installation and everything we need is under its "lib/" folder, both IDEA platform and MPS stuff (including lib/ext) 
      roots.add(new File(project.resolveFile(mpsHome).getPath(), "lib"));
    } else if ((pluginHome != null && pluginHome.length() > 0) && (ideaHome != null && ideaHome.length() > 0)) {
      // buildPlugin + IDEA 
      // XXX not sure if it's possible to build with an MPS-generated script having just an MPS-IDEA plugin, but anyway... 
      roots.add(new File(project.resolveFile(ideaHome).getPath(), "lib"));
      roots.add(new File(project.resolveFile(pluginHome).getPath(), "mps-core/lib"));
    } else if ((mpsCoreHome != null && mpsCoreHome.length() > 0) && (ideaHome != null && ideaHome.length() > 0)) {
      // we are building something with dependency to mpsBootstrapCore, likely part of MPS itself. 
      // There's IDEA installation we use, and we shall reference MPS-built artifacts 
      roots.add(new File(project.resolveFile(mpsCoreHome).getPath(), "lib"));
      roots.add(new File(project.resolveFile(ideaHome).getPath(), "lib"));
      if ((mpsWorkbenchHome != null && mpsWorkbenchHome.length() > 0)) {
        roots.add(new File(project.resolveFile(mpsWorkbenchHome).getPath(), "lib"));
      }
    } else if ((ideaHome != null && ideaHome.length() > 0) && "mpsBootstrapCore".equals(project.getName())) {
      // bootstrap hack. mpsBootstrapCore uses ant tasks defined in the jars it is about to compile/assemble. 
      // In particular, it's copyModels in <assemble> task that needs to start MPS in-process at PERSISTENCE level. 
      roots.add(new File(project.resolveFile(ideaHome).getPath(), "lib"));
      File antJarsHome = getAntJARRelativeHome();
      project.log("Bootstrap jar location: " + antJarsHome);
      roots.add(antJarsHome);
    } else if ((mpsStandaloneHome != null && mpsStandaloneHome.length() > 0)) {
      // pretty much identical to artifacts.mps, reduced set of modules for standalone applications 
      roots.add(new File(project.resolveFile(mpsStandaloneHome).getPath(), "lib"));
    }

    return roots;
  }


  /**
   * XXX shall rather be instance method of an mps classpath utility class
   */
  /*package*/ static void gatherAllClassesAndJarsUnder(File dir, Set<File> result) {
    if (dir.getName().equals("classes") || dir.getName().equals("classes_gen")) {
      result.add(dir);
      return;
    }
    File[] children = dir.listFiles();
    if (children == null) {
      return;
    }
    //  we do not want trove different from ours in $mps.home$/lib 
    String troveJar = "trove" + File.separator + "lib" + File.separator + "trove";
    //  to provide right order of class loading, 
    //  files go first, we replace them with null to process directories later 
    for (int i = 0; i < children.length; i++) {
      File f = children[i];
      if (f.isDirectory()) {
        continue;
      }
      children[i] = null;
      if (f.getName().endsWith(".jar") && !(f.getName().contains("ant.jar")) && !(f.getPath().contains(troveJar))) {
        result.add(f);
      }
    }
    for (File f : children) {
      if (f == null) {
        continue;
      }
      // inv: f.isDirectory() 
      gatherAllClassesAndJarsUnder(f, result);
    }
  }
}
