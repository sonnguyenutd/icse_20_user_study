package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.errors.QuickFix_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class RemoveImplicitConstructorFromAnonymousClass_QuickFix extends QuickFix_Runtime {
  public RemoveImplicitConstructorFromAnonymousClass_QuickFix() {
    super(new SNodePointer("r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "7340437691573914999"));
  }
  public void execute(SNode node) {
    SLinkOperations.setTarget(SNodeOperations.cast(node, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1107e0cb103L, "jetbrains.mps.baseLanguage.structure.AnonymousClass")), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301adL, "baseMethodDeclaration"), null);
  }
}