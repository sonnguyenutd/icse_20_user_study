package jetbrains.mps.vcs.diff.changes;

/*Generated by MPS */

import org.jetbrains.mps.openapi.language.SLanguage;
import jetbrains.mps.vcs.diff.ChangeSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.model.SModel;
import jetbrains.mps.extapi.model.SModelBase;

public class EngagedLanguageChange extends DependencyChange {
  private final SLanguage myLanguage;

  public EngagedLanguageChange(ChangeSet cs, boolean delete, SLanguage lang) {
    super(cs, delete);
    myLanguage = lang;
  }


  public void apply(@NotNull SModel model, @NotNull NodeCopier nodeCopier) {
    if (isDelete()) {
      ((SModelBase) model).removeEngagedOnGenerationLanguage(myLanguage);
    } else {
      ((SModelBase) model).addEngagedOnGenerationLanguage(myLanguage);
    }
  }

  @NotNull
  protected ModelChange createOppositeChange() {
    return new EngagedLanguageChange(getChangeSet().getOppositeChangeSet(), !(isDelete()), myLanguage);
  }

  public SLanguage getLanguage() {
    return myLanguage;
  }

  @Override
  public String getDescription() {
    String fmt = (isDelete() ? "Disengaged language %s on generation" : "Engage language %s on generation");
    return String.format(fmt, myLanguage.getQualifiedName());
  }

  @Override
  public String toString() {
    return myLanguage.toString();
  }
}
