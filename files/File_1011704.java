package jetbrains.mps.java.platform.actions;

/*Generated by MPS */

import jetbrains.mps.ide.platform.actions.core.MoveNodesAction;
import jetbrains.mps.smodel.structure.Extension;
import jetbrains.mps.project.MPSProject;
import java.util.List;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.ide.platform.refactoring.StringChooserDialog;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ConvertAnonymousRefactoring;

public class ConvertAnonymousClass implements MoveNodesAction {

  public static class ConvertAnonymousClass_extension extends Extension.Default<MoveNodesAction> {
    public ConvertAnonymousClass_extension() {
      super("jetbrains.mps.ide.platform.MoveNodesActionEP");
    }
    public MoveNodesAction get() {
      return new ConvertAnonymousClass();
    }
  }

  public String getName() {
    return "Convert Anonymous Class";
  }
  public boolean isApplicable(MPSProject project, final List<SNode> nodes) {
    final Wrappers._boolean result = new Wrappers._boolean();
    project.getRepository().getModelAccess().runReadAction(new Runnable() {
      public void run() {
        result.value = ListSequence.fromList(nodes).count() == 1 && SNodeOperations.isInstanceOf(ListSequence.fromList(nodes).first(), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1107e0cb103L, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) && (SNodeOperations.getNodeAncestor(ListSequence.fromList(nodes).first(), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101d9d3ca30L, "jetbrains.mps.baseLanguage.structure.Classifier"), false, false) != null);
      }
    });
    return result.value;
  }
  public void execute(final MPSProject project, List<SNode> nodes) {
    final SNode target = SNodeOperations.cast(ListSequence.fromList(nodes).first(), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1107e0cb103L, "jetbrains.mps.baseLanguage.structure.AnonymousClass"));

    final Wrappers._T<String> classifierName = new Wrappers._T<String>();
    project.getRepository().getModelAccess().runReadAction(new Runnable() {
      public void run() {
        classifierName.value = SPropertyOperations.getString(SLinkOperations.getTarget(target, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1107e0cb103L, 0x1107e0fd2a0L, "classifier")), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name"));
      }
    });

    final String newName = StringChooserDialog.getString(project.getProject(), "Convert Anonymous Class", "Class Name", "My" + classifierName.value, true);

    if (newName == null) {
      return;
    }
    project.getRepository().getModelAccess().executeCommand(new Runnable() {
      public void run() {
        new ConvertAnonymousRefactoring(target, newName).doRefactor();
      }
    });
  }
}