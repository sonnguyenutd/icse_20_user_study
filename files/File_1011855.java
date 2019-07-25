package jetbrains.mps.baseLanguage.math.intentions;

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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import jetbrains.mps.smodel.SModelUtil_new;

public final class DivExpressionFractionToDiv_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public DivExpressionFractionToDiv_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:57529505-426f-4f87-bbc0-2843f12bd318(jetbrains.mps.baseLanguage.math.intentions)", "1237104496404"));
  }
  @Override
  public String getPresentation() {
    return "DivExpressionFractionToDiv";
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
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new DivExpressionFractionToDiv_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Use Java Notation for Division Operation";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNodeOperations.replaceWithAnother(node, _quotation_createNode_smjisl_a0a0a0(SLinkOperations.getTarget(node, MetaAdapterFactory.getContainmentLink(0x3304fc6e7c6b401eL, 0xa016b944934bb21fL, 0x12008f4e805L, 0x12009149b1aL, "denominator")), SLinkOperations.getTarget(node, MetaAdapterFactory.getContainmentLink(0x3304fc6e7c6b401eL, 0xa016b944934bb21fL, 0x12008f4e805L, 0x1200914977fL, "numerator"))));
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return DivExpressionFractionToDiv_Intention.this;
    }
  }
  private static SNode _quotation_createNode_smjisl_a0a0a0(Object parameter_1, Object parameter_2) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_3 = null;
    SNode quotedNode_4 = null;
    SNode quotedNode_5 = null;
    quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xff2bbc13daL, "DivExpression"), null, null, false);
    quotedNode_4 = (SNode) parameter_1;
    if (quotedNode_4 != null) {
      quotedNode_3.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xfbdeb6fecfL, 0xfbdeb7a11bL, "rightExpression"), SNodeOperations.copyIfNecessary(quotedNode_4));
    }
    quotedNode_5 = (SNode) parameter_2;
    if (quotedNode_5 != null) {
      quotedNode_3.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xfbdeb6fecfL, 0xfbdeb7a11cL, "leftExpression"), SNodeOperations.copyIfNecessary(quotedNode_5));
    }
    return quotedNode_3;
  }
}