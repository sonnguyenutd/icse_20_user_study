package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.errors.QuickFix_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class RemoveUnusedLocalVariable_QuickFix extends QuickFix_Runtime {
  public RemoveUnusedLocalVariable_QuickFix() {
    super(new SNodePointer("r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "7052739266022866096"));
  }
  public String getDescription(SNode node) {
    return "Remove Unused Local Variable";
  }
  public void execute(SNode node) {
    SNode p = SNodeOperations.as(SNodeOperations.getParent(node), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc67c7f0L, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"));
    if ((p != null)) {
      SNodeOperations.deleteNode(p);
    } else {
      SNodeOperations.deleteNode(node);
    }
  }
}