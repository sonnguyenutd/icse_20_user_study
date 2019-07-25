package jetbrains.mps.lang.behavior.intentions;

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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class ToggleConceptMethodAbstract_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public ToggleConceptMethodAbstract_Intention() {
    super(Kind.NORMAL, true, new SNodePointer("r:dbb111e4-8af4-4e6d-b49d-e07620d0c285(jetbrains.mps.lang.behavior.intentions)", "1225201879279"));
  }
  @Override
  public String getPresentation() {
    return "ToggleConceptMethodAbstract";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return true;
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new ToggleConceptMethodAbstract_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      String methodName = SPropertyOperations.getString(node, MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name"));
      return (SPropertyOperations.getBoolean(node, MetaAdapterFactory.getProperty(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d43480582L, "isAbstract")) ? "Make '" + methodName + "' not abstract" : "Make '" + methodName + "' abstract");
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      if (!(SPropertyOperations.getBoolean(node, MetaAdapterFactory.getProperty(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d43480582L, "isAbstract")))) {
        ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1ffL, "body")), MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b200L, 0xf8cc6bf961L, "statement"))).clear();
        SPropertyOperations.assign(node, MetaAdapterFactory.getProperty(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d43480580L, "isVirtual"), true);
        SPropertyOperations.assign(node, MetaAdapterFactory.getProperty(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0x113294bffd2L, "isFinal"), false);
        SLinkOperations.setTarget(node, MetaAdapterFactory.getReferenceLink(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d4348057fL, "overriddenMethod"), null);
      }
      SPropertyOperations.set(node, MetaAdapterFactory.getProperty(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d43480582L, "isAbstract"), !(SPropertyOperations.getBoolean(node, MetaAdapterFactory.getProperty(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d43480582L, "isAbstract"))));
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return ToggleConceptMethodAbstract_Intention.this;
    }
  }
}