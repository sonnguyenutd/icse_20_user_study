package jetbrains.mps.lang.editor.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.lang.editor.behavior.EditorCellModel__BehaviorDescriptor;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.editor.behavior.IStyleContainer__BehaviorDescriptor;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class RemoveNewLine_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public RemoveNewLine_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c8959029b(jetbrains.mps.lang.editor.intentions)", "1237403993138"));
  }
  @Override
  public String getPresentation() {
    return "RemoveNewLine";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return (boolean) EditorCellModel__BehaviorDescriptor.isNewLine_idi0pLPAc.invoke(node);
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new RemoveNewLine_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Remove New Line";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNodeOperations.deleteNode(ListSequence.fromList(IStyleContainer__BehaviorDescriptor.getClassItems_idhJF5KPu.invoke(node, MetaAdapterFactory.getConcept(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0x120154df6f3L, "jetbrains.mps.lang.editor.structure.IndentLayoutNewLineStyleClassItem"))).first());
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return RemoveNewLine_Intention.this;
    }
  }
}