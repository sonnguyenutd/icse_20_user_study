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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class ConvertClassCreatorToAnonimous_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public ConvertClassCreatorToAnonimous_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c895902c6(jetbrains.mps.baseLanguage.intentions)", "1214431614908"));
  }
  @Override
  public String getPresentation() {
    return "ConvertClassCreatorToAnonimous";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SLinkOperations.getTarget(node, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301adL, "baseMethodDeclaration")) != null;
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new ConvertClassCreatorToAnonimous_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Convert to Anonymous";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNode anonimousClassCreator = SNodeFactoryOperations.replaceWithNewChild(node, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1133e3b449aL, "jetbrains.mps.baseLanguage.structure.AnonymousClassCreator"));
      SLinkOperations.setTarget(SLinkOperations.getTarget(anonimousClassCreator, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1133e3b449aL, 0x1133e3b8b49L, "cls")), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1107e0cb103L, 0x1107e0fd2a0L, "classifier"), SNodeOperations.cast(SNodeOperations.getParent(SLinkOperations.getTarget(node, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301adL, "baseMethodDeclaration"))), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c108ca66L, "jetbrains.mps.baseLanguage.structure.ClassConcept")));
      for (SNode typeParm : ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11a59b0fbceL, 0x11a59c8ffe0L, "typeParameter")))) {
        ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(anonimousClassCreator, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1133e3b449aL, 0x1133e3b8b49L, "cls")), MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1107e0cb103L, 0x117ac45a693L, "typeParameter"))).addElement(typeParm);
      }
      for (SNode typeParm : ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11a59b0fbceL, 0x11a59c8ffe0L, "typeParameter")))) {
        ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(anonimousClassCreator, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1133e3b449aL, 0x1133e3b8b49L, "cls")), MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x1107e0cb103L, 0x117ac45a693L, "typeParameter"))).addElement(typeParm);
      }
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return ConvertClassCreatorToAnonimous_Intention.this;
    }
  }
}