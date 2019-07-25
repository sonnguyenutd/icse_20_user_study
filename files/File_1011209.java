package jetbrains.mps.lang.dataFlow.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class AddModeToDataFlowBuilder_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public AddModeToDataFlowBuilder_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c8959037b(jetbrains.mps.lang.dataFlow.intentions)", "3880671512445174886"));
  }
  @Override
  public String getPresentation() {
    return "AddModeToDataFlowBuilder";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0x7fa12e9cb9494976L, 0xb4fa19accbc320b4L, 0x118e58cd635L, 0x6e8db6877fd04efbL, "modes"))).isEmpty();
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new AddModeToDataFlowBuilder_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Add Mode";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SLinkOperations.addNewChild(node, MetaAdapterFactory.getContainmentLink(0x7fa12e9cb9494976L, 0xb4fa19accbc320b4L, 0x118e58cd635L, 0x6e8db6877fd04efbL, "modes"), null);
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return AddModeToDataFlowBuilder_Intention.this;
    }
  }
}