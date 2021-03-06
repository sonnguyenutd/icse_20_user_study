package jetbrains.mps.lang.core.typesystem;

/*Generated by MPS */

import jetbrains.mps.errors.QuickFix_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import org.jetbrains.mps.openapi.model.SNodeAccessUtil;

public class RemoveUnknownReference_QuickFix extends QuickFix_Runtime {
  public RemoveUnknownReference_QuickFix() {
    super(new SNodePointer("r:cec599e3-51d2-48a7-af31-989e3cbd593c(jetbrains.mps.lang.core.typesystem)", "1556973682253873271"));
  }
  public String getDescription(SNode node) {
    return "Remove reference in undeclared role \"" + ((SReferenceLink) RemoveUnknownReference_QuickFix.this.getField("role")[0]).getRoleName() + "\"";
  }
  public void execute(SNode node) {
    SNodeAccessUtil.setReferenceTarget(node, ((SReferenceLink) RemoveUnknownReference_QuickFix.this.getField("role")[0]), null);
  }
}
