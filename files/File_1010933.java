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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.baseLanguage.util.OverridingMethodsCalculator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.core.behavior.INamedConcept__BehaviorDescriptor;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.SReference;

public final class AddOverrideAnnotation_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public AddOverrideAnnotation_Intention() {
    super(Kind.NORMAL, true, new SNodePointer("r:00000000-0000-4000-0000-011c895902c6(jetbrains.mps.baseLanguage.intentions)", "1645752949779063112"));
  }
  @Override
  public String getPresentation() {
    return "AddOverrideAnnotation";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    SNode classConcept = SNodeOperations.as(SNodeOperations.getParent(node), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c108ca66L, "jetbrains.mps.baseLanguage.structure.ClassConcept"));
    if (classConcept == null) {
      return false;
    }
    if (!(OverridingMethodsCalculator.canOverride(node)) || ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x114a6be947aL, 0x114a6beb0bdL, "annotation"))).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return "java.lang.Override".equals(INamedConcept__BehaviorDescriptor.getFqName_idhEwIO9y.invoke(SLinkOperations.getTarget(it, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x114a6b4ccabL, 0x114a6b85d40L, "annotation"))));
      }
    })) {
      return false;
    }
    OverridingMethodsCalculator finder = new OverridingMethodsCalculator(classConcept, Sequence.<SNode>singleton(node));
    return SetSequence.fromSet(finder.getOverridingMethods()).isNotEmpty();
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new AddOverrideAnnotation_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Add @Override Annotation";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNode classConcept = SNodeOperations.cast(SNodeOperations.getParent(node), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c108ca66L, "jetbrains.mps.baseLanguage.structure.ClassConcept"));
      OverridingMethodsCalculator finder = new OverridingMethodsCalculator(classConcept, Sequence.<SNode>singleton(node));
      for (SNode meth : SetSequence.fromSet(finder.getOverridingMethods())) {
        ListSequence.fromList(SLinkOperations.getChildren(meth, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x114a6be947aL, 0x114a6beb0bdL, "annotation"))).addElement(createAnnotationInstance_4i19oe_a0a0a2a0());
      }
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return AddOverrideAnnotation_Intention.this;
    }
  }
  private static SNode createAnnotationInstance_4i19oe_a0a0a2a0() {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode n1 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x114a6b4ccabL, "jetbrains.mps.baseLanguage.structure.AnnotationInstance"), null, null, false);
    n1.setReference(MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x114a6b4ccabL, 0x114a6b85d40L, "annotation"), SReference.create(MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x114a6b4ccabL, 0x114a6b85d40L, "annotation"), n1, facade.createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"), facade.createNodeId("~Override")));
    return n1;
  }
}