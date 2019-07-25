package jetbrains.mps.samples.customizedDebugger.Bottomline.debug.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.part.ApplicationPluginPart;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import java.util.Set;
import jetbrains.mps.debug.api.BreakpointCreator;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.ide.plugins.PluginManager;
import jetbrains.mps.debug.api.BreakpointCreatorsManager;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.debug.api.breakpoints.ILocationBreakpoint;
import com.intellij.openapi.project.Project;
import jetbrains.mps.debug.api.Debuggers;
import jetbrains.mps.debug.api.DebuggerNotPresentException;
import org.apache.log4j.Level;

public class DebugInfoProvider_AppPluginPart extends ApplicationPluginPart {
  private static final Logger LOG = LogManager.getLogger(DebugInfoProvider_AppPluginPart.class);
  private Set<BreakpointCreator> myCreators = SetSequence.fromSet(new HashSet<BreakpointCreator>());
  public DebugInfoProvider_AppPluginPart() {
  }
  @Override
  public void init() {
    PluginId debuggerPlugin = PluginManager.getPluginByClassName("jetbrains.mps.debug.api.BreakpointCreatorsManager");
    if (debuggerPlugin == null) {
      return;
    }
    BreakpointCreatorsManager manager = BreakpointCreatorsManager.getInstance();
    if (manager == null) {
      return;
    }

    // next lines needed for to be sure that all classes in dispose() loaded after init() 
    // basically: this code do nothing, but class loading 
    for (BreakpointCreator creator : SetSequence.fromSet(DebugInfoProvider_AppPluginPart.this.myCreators)) {
    }
    {
      BreakpointCreator creator = new BreakpointCreator(null, null);
      creator.canCreate(new _FunctionTypes._return_P2_E0<Boolean, SAbstractConcept, SNode>() {
        public Boolean invoke(SAbstractConcept concept, SNode debuggableNode) {
          if (SConceptOperations.isSubConceptOf(SNodeOperations.asSConcept(concept), MetaAdapterFactory.getConcept(0x3f028972a2904cf2L, 0xa87e9b8f7e56076bL, 0x7df3f12f124a5e4L, "jetbrains.mps.samples.customizedDebugger.Bottomline.structure.OutputMessage"))) {
            return true;
          }
          return false;

        }
      });
      creator.create(new _FunctionTypes._return_P2_E0<ILocationBreakpoint, SNode, Project>() {
        public ILocationBreakpoint invoke(SNode debuggableNode, Project project) {
          try {
            return Debuggers.getInstance().getDebuggerByNameSafe("Java").createBreakpoint(debuggableNode, "JAVA_LINE_BREAKPOINT", project);
          } catch (DebuggerNotPresentException e) {
            if (LOG.isEnabledFor(Level.WARN)) {
              LOG.warn("Exception while creating breakpoint for node" + debuggableNode, e);
            }
            return null;
          }
        }
      });

      SetSequence.fromSet(DebugInfoProvider_AppPluginPart.this.myCreators).addElement(creator);
      manager.addCreator(creator);
    }
  }
  @Override
  public void dispose() {
    PluginId debuggerPlugin = PluginManager.getPluginByClassName("jetbrains.mps.debug.api.BreakpointCreatorsManager");
    if (debuggerPlugin == null) {
      return;
    }
    BreakpointCreatorsManager manager = BreakpointCreatorsManager.getInstance();
    if (manager == null) {
      return;
    }
    for (BreakpointCreator creator : SetSequence.fromSet(DebugInfoProvider_AppPluginPart.this.myCreators)) {
      manager.removeCreator(creator);
    }
    SetSequence.fromSet(DebugInfoProvider_AppPluginPart.this.myCreators).clear();
  }
}