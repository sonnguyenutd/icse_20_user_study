package jetbrains.mps.lang.behavior.typesystem;

/*Generated by MPS */

import jetbrains.mps.errors.QuickFix_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class RemoveFinalFromTheMethod_QuickFix extends QuickFix_Runtime {
  public RemoveFinalFromTheMethod_QuickFix() {
    super(new SNodePointer("r:f7f8a091-d98d-402d-85c4-5f05cb2b8c61(jetbrains.mps.lang.behavior.typesystem)", "8014340958386523432"));
  }
  public String getDescription(SNode node) {
    return "Remove the 'final' modifier";
  }
  public void execute(SNode node) {
    assert SPropertyOperations.getBoolean(((SNode) RemoveFinalFromTheMethod_QuickFix.this.getField("conceptMethod")[0]), MetaAdapterFactory.getProperty(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0x113294bffd2L, "isFinal"));
    SPropertyOperations.assign(((SNode) RemoveFinalFromTheMethod_QuickFix.this.getField("conceptMethod")[0]), MetaAdapterFactory.getProperty(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0x113294bffd2L, "isFinal"), false);
  }
}
