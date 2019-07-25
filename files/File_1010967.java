package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.lang.core.behavior.IDeprecatable__BehaviorDescriptor;
import jetbrains.mps.baseLanguage.behavior.IBLDeprecatable__BehaviorDescriptor;
import jetbrains.mps.baseLanguage.actions.ModuleDependencyUtils;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class MakeDeprecated_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public MakeDeprecated_Intention() {
    super(Kind.NORMAL, true, new SNodePointer("r:00000000-0000-4000-0000-011c895902c6(jetbrains.mps.baseLanguage.intentions)", "1223648378225"));
  }
  @Override
  public String getPresentation() {
    return "MakeDeprecated";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return true;
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new MakeDeprecated_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      if ((boolean) IDeprecatable__BehaviorDescriptor.isDeprecated_idhOwoPtR.invoke(node)) {
        return "Remove Deprecation";
      } else {
        return "Deprecate";
      }
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      if ((boolean) IDeprecatable__BehaviorDescriptor.isDeprecated_idhOwoPtR.invoke(node)) {
        IBLDeprecatable__BehaviorDescriptor.unmarkDeprecated_id6Va_BJex$aE.invoke(node);
      } else {
        ModuleDependencyUtils.addDependencyOnJavaDocIfMissing(SNodeOperations.getModel(node));
        IBLDeprecatable__BehaviorDescriptor.markDeprecated_id6Va_BJexupi.invoke(node);
      }
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return MakeDeprecated_Intention.this;
    }
  }
}