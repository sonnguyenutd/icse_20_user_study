package jetbrains.mps.baseLanguage.collections.intentions;

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
import jetbrains.mps.typechecking.TypecheckingFacade;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import jetbrains.mps.smodel.SModelUtil_new;

public final class IterateOverSequence_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public IterateOverSequence_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c8959032c(jetbrains.mps.baseLanguage.collections.intentions)", "309173295241374789"));
  }
  @Override
  public String getPresentation() {
    return "IterateOverSequence";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    // TODO replace with isSubtype() when MPS-10610 is fixed 
    return SNodeOperations.isInstanceOf(TypecheckingFacade.getFromContext().getTypeOf(node), MetaAdapterFactory.getConcept(0x8388864671ce4f1cL, 0x9c53c54016f6ad4fL, 0x10c260e9444L, "jetbrains.mps.baseLanguage.collections.structure.SequenceType")) || SNodeOperations.isInstanceOf(TypecheckingFacade.getFromContext().getTypeOf(node), MetaAdapterFactory.getConcept(0x8388864671ce4f1cL, 0x9c53c54016f6ad4fL, 0x10c25fb076aL, "jetbrains.mps.baseLanguage.collections.structure.ListType")) || SNodeOperations.isInstanceOf(TypecheckingFacade.getFromContext().getTypeOf(node), MetaAdapterFactory.getConcept(0x8388864671ce4f1cL, 0x9c53c54016f6ad4fL, 0x11d91cbbcd0L, "jetbrains.mps.baseLanguage.collections.structure.SetType")) || TypecheckingFacade.getFromContext().isSubtype(TypecheckingFacade.getFromContext().getTypeOf(node), _quotation_createNode_7wizo7_b0a0b0a());
  }
  @Override
  public boolean isSurroundWith() {
    return true;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new IterateOverSequence_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Iterate over Sequence";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNode forStatement = SNodeFactoryOperations.createNewNode(MetaAdapterFactory.getConcept(0x8388864671ce4f1cL, 0x9c53c54016f6ad4fL, 0x10cac65f399L, "jetbrains.mps.baseLanguage.collections.structure.ForEachStatement"), null);
      SNode outerStatement = SNodeOperations.getNodeAncestor(node, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b215L, "jetbrains.mps.baseLanguage.structure.Statement"), false, false);
      boolean deleteStatement = SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b213L, "jetbrains.mps.baseLanguage.structure.ExpressionStatement"));
      SNodeOperations.insertNextSiblingChild(outerStatement, forStatement);
      SLinkOperations.setTarget(forStatement, MetaAdapterFactory.getContainmentLink(0x8388864671ce4f1cL, 0x9c53c54016f6ad4fL, 0x10cac65f399L, 0x10cac72911aL, "inputSequence"), node);
      if (deleteStatement) {
        SNodeOperations.deleteNode(outerStatement);
      }
      editorContext.select(SLinkOperations.getTarget(forStatement, MetaAdapterFactory.getContainmentLink(0x8388864671ce4f1cL, 0x9c53c54016f6ad4fL, 0x10cac65f399L, 0x10cac7231f1L, "variable")));
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return IterateOverSequence_Intention.this;
    }
  }
  private static SNode _quotation_createNode_7wizo7_b0a0b0a() {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_1 = null;
    SNode quotedNode_2 = null;
    quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x8388864671ce4f1cL, 0x9c53c54016f6ad4fL, "jetbrains.mps.baseLanguage.collections"), 0x10c25fb076aL, "ListType"), null, null, false);
    quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x110dae5f4a3L, "WildCardType"), null, null, false);
    quotedNode_1.addChild(MetaAdapterFactory.getContainmentLink(0x8388864671ce4f1cL, 0x9c53c54016f6ad4fL, 0x10c25fb076aL, 0x10c25fe95c5L, "elementType"), quotedNode_2);
    return quotedNode_1;
  }
}