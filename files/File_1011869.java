package jetbrains.mps.samples.requirementTracking.Traces.intentions;

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
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.editor.runtime.selection.SelectionUtil;
import jetbrains.mps.openapi.editor.selection.SelectionManager;
import java.util.Objects;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class ToggleRequirementTrace_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public ToggleRequirementTrace_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:fddf7047-be18-427f-9162-f31299b900ec(jetbrains.mps.samples.requirementTracking.Traces.intentions)", "4174052498196375444"));
  }
  @Override
  public String getPresentation() {
    return "ToggleRequirementTrace";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return ((SNodeOperations.getParent(node) == null) || SNodeOperations.getContainingLink(node).isMultiple()) && ListSequence.fromList(SNodeOperations.getNodeAncestors(node, MetaAdapterFactory.getConcept(0x81a3307bd10f4e90L, 0x8043ff6aa5380c33L, 0x39ed36a1ccd3a494L, "jetbrains.mps.samples.requirementTracking.Traces.structure.RequirementTrace"), true)).isEmpty();
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new ToggleRequirementTrace_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      if ((AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0x81a3307bd10f4e90L, 0x8043ff6aa5380c33L, 0x39ed36a1ccd3a494L, "jetbrains.mps.samples.requirementTracking.Traces.structure.RequirementTrace"))) != null)) {
        return "Remove Requirement Traces";
      } else {
        return "Add Requirement Traces";
      }
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      if ((AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0x81a3307bd10f4e90L, 0x8043ff6aa5380c33L, 0x39ed36a1ccd3a494L, "jetbrains.mps.samples.requirementTracking.Traces.structure.RequirementTrace"))) != null)) {
        SNodeOperations.deleteNode(AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0x81a3307bd10f4e90L, 0x8043ff6aa5380c33L, 0x39ed36a1ccd3a494L, "jetbrains.mps.samples.requirementTracking.Traces.structure.RequirementTrace"))));
        SelectionUtil.selectLabelCellAnSetCaret(editorContext, node, SelectionManager.LAST_CELL, -1);
      } else {
        try {
          String[] initialEditorHints = editorContext.getEditorComponent().getUpdater().getInitialEditorHints();
          if (initialEditorHints == null) {
            initialEditorHints = new String[0];
          }
          String[] newHints = new String[initialEditorHints.length + 1];
          for (int i = 0; i < initialEditorHints.length; i++) {
            if (Objects.equals(initialEditorHints[i], "jetbrains.mps.samples.requirementTracking.Traces.editor.Requirements.ShowTraces")) {
              return;
            }
            newHints[i] = initialEditorHints[i];
          }
          newHints[initialEditorHints.length] = "jetbrains.mps.samples.requirementTracking.Traces.editor.Requirements.ShowTraces";
          editorContext.getEditorComponent().getUpdater().setInitialEditorHints(newHints);
          editorContext.getEditorComponent().getUpdater().update();
        } finally {
          AttributeOperations.createAndSetAttrbiute(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0x81a3307bd10f4e90L, 0x8043ff6aa5380c33L, 0x39ed36a1ccd3a494L, "jetbrains.mps.samples.requirementTracking.Traces.structure.RequirementTrace")), MetaAdapterFactory.getConcept(0x81a3307bd10f4e90L, 0x8043ff6aa5380c33L, 0x39ed36a1ccd3a494L, "jetbrains.mps.samples.requirementTracking.Traces.structure.RequirementTrace"));
          SelectionUtil.selectCell(editorContext, AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0x81a3307bd10f4e90L, 0x8043ff6aa5380c33L, 0x39ed36a1ccd3a494L, "jetbrains.mps.samples.requirementTracking.Traces.structure.RequirementTrace"))), SelectionManager.LAST_EDITABLE_CELL);
        }

      }
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return ToggleRequirementTrace_Intention.this;
    }
  }
}