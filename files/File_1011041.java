package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.errors.QuickFix_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.module.SModule;
import jetbrains.mps.project.AbstractModule;

public class PutReexportForExtendedClassifier_QuickFix extends QuickFix_Runtime {
  public PutReexportForExtendedClassifier_QuickFix() {
    super(new SNodePointer("r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "2517404124519899276"));
  }
  public String getDescription(SNode node) {
    return "Set 'Export' flag at the " + ((SModule) PutReexportForExtendedClassifier_QuickFix.this.getField("moduleToImport")[0]) + " import";
  }
  public void execute(SNode node) {
    assert ((SModule) PutReexportForExtendedClassifier_QuickFix.this.getField("moduleToImport")[0]) != null;
    boolean reexport = true;
    ((AbstractModule) PutReexportForExtendedClassifier_QuickFix.this.getField("module")[0]).addDependency(((SModule) PutReexportForExtendedClassifier_QuickFix.this.getField("moduleToImport")[0]).getModuleReference(), reexport);
  }
}
