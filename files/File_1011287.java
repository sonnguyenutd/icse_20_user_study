package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.generator.helper.EditingUtil;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class NewTemplateFragment_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public NewTemplateFragment_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c895902e5(jetbrains.mps.lang.generator.intentions)", "9092065972411421046"));
  }
  @Override
  public String getPresentation() {
    return "NewTemplateFragment";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    if (!(MacroIntentionsUtil.isInGeneratorModel(node))) {
      return false;
    }
    if (SNodeOperations.getNodeAncestorWhereConceptInList(node, new SAbstractConcept[]{MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfe43cb41d0L, "jetbrains.mps.lang.generator.structure.TemplateDeclaration"), MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0x7b85dded0be53d6cL, "jetbrains.mps.lang.generator.structure.InlineTemplateWithContext_RuleConsequence")}, false, false) == null) {
      return false;
    }
    return EditingUtil.isAnyMacroApplicable(node) && !(EditingUtil.isInsideTemplateFragment(node));
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new NewTemplateFragment_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Create Template Fragment";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNode applyToNode = ListSequence.fromList(SNodeOperations.getNodeAncestors(node, null, true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return !(SNodeOperations.isAttribute(it));
        }
      }).first();
      EditingUtil.createTemplateFragment(applyToNode);
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return NewTemplateFragment_Intention.this;
    }
  }
}