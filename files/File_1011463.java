package jetbrains.mps.lang.smodel.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.SReference;

public final class ConceptNodeType2NodeType_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public ConceptNodeType2NodeType_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c895902ff(jetbrains.mps.lang.smodel.intentions)", "7616135429950640506"));
  }
  @Override
  public String getPresentation() {
    return "ConceptNodeType2NodeType";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return (SLinkOperations.getTarget(node, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x110f9b63680L, 0x112da284156L, "conceptDeclaraton")) == null);
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new ConceptNodeType2NodeType_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Convert to node<ACD>";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNodeOperations.replaceWithAnother(node, _quotation_createNode_h48dv9_a0a0a0());
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return ConceptNodeType2NodeType_Intention.this;
    }
  }
  private static SNode _quotation_createNode_h48dv9_a0a0a0() {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_1 = null;
    quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 0x108f968b3caL, "SNodeType"), null, null, false);
    quotedNode_1.setReference(MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x108f968b3caL, 0x1090e46ca51L, "concept"), SReference.create(MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x108f968b3caL, 0x1090e46ca51L, "concept"), quotedNode_1, facade.createModelReference("r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)"), facade.createNodeId("1169125787135")));
    return quotedNode_1;
  }
}
