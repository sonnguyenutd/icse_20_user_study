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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.lang.editor.behavior.CellModel_Collection__BehaviorDescriptor;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class ChangeOrientationCollection_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public ChangeOrientationCollection_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c8959029b(jetbrains.mps.lang.editor.intentions)", "1227110056528"));
  }
  @Override
  public String getPresentation() {
    return "ChangeOrientationCollection";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, MetaAdapterFactory.getContainmentLink(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0xf9eaff2517L, 0x10192e0d3baL, "cellLayout")), MetaAdapterFactory.getConcept(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0x10192dcf685L, "jetbrains.mps.lang.editor.structure.CellLayout_Horizontal")) || SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, MetaAdapterFactory.getContainmentLink(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0xf9eaff2517L, 0x10192e0d3baL, "cellLayout")), MetaAdapterFactory.getConcept(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0x10192dd4cbeL, "jetbrains.mps.lang.editor.structure.CellLayout_Vertical"));
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new ChangeOrientationCollection_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, MetaAdapterFactory.getContainmentLink(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0xf9eaff2517L, 0x10192e0d3baL, "cellLayout")), MetaAdapterFactory.getConcept(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0x10192dd4cbeL, "jetbrains.mps.lang.editor.structure.CellLayout_Vertical")) ? "Make Horizontal" : "Make Vertical");
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      if ((boolean) CellModel_Collection__BehaviorDescriptor.isVertical_idi0pAV23.invoke(node)) {
        SLinkOperations.setTarget(node, MetaAdapterFactory.getContainmentLink(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0xf9eaff2517L, 0x10192e0d3baL, "cellLayout"), SNodeFactoryOperations.createNewNode(MetaAdapterFactory.getConcept(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0x10192dcf685L, "jetbrains.mps.lang.editor.structure.CellLayout_Horizontal"), null));
      } else {
        SLinkOperations.setTarget(node, MetaAdapterFactory.getContainmentLink(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0xf9eaff2517L, 0x10192e0d3baL, "cellLayout"), SNodeFactoryOperations.createNewNode(MetaAdapterFactory.getConcept(0x18bc659203a64e29L, 0xa83a7ff23bde13baL, 0x10192dd4cbeL, "jetbrains.mps.lang.editor.structure.CellLayout_Vertical"), null));
      }
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return ChangeOrientationCollection_Intention.this;
    }
  }
}