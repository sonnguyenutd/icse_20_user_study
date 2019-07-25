package jetbrains.mps.ide.actions;

/*Generated by MPS */

import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.project.Project;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.smodel.behaviour.BHReflection;
import jetbrains.mps.core.aspects.behaviour.SMethodTrimmedId;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.Sequence;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import jetbrains.mps.smodel.SModelUtil_new;
import org.jetbrains.mps.openapi.model.SNodeAccessUtil;

/*package*/ final class OverrideConceptMethodsHelper {
  private final SNode myClassConcept;
  private final SNode myContextMethod;
  private final boolean myRemoveAttributes;
  private final boolean myNeedReturnKW;

  public OverrideConceptMethodsHelper(Project project, SNode classConcept, SNode contextMethod, boolean removeAttributes, boolean needReturnKW) {
    myClassConcept = classConcept;
    myContextMethod = contextMethod;
    myRemoveAttributes = removeAttributes;
    myNeedReturnKW = needReturnKW;
  }

  public List<SNode> insertMethods(List<SNode> baseMethods) {
    List<SNode> result = new ArrayList<SNode>();
    int index = (myContextMethod != null && SNodeOperations.getParent(myContextMethod) == myClassConcept ? ListSequence.fromList(SLinkOperations.getChildren(myClassConcept, MetaAdapterFactory.getContainmentLink(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d43447b1aL, 0x11d43447b25L, "method"))).indexOf(myContextMethod) + 1 : -1);
    for (SNode m : baseMethods) {
      SNode baseMethod = SNodeOperations.cast(m, MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"));
      SNode method = SNodeOperations.cast(((SNode) BHReflection.invoke0(baseMethod, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"), SMethodTrimmedId.create("getMethodToImplement", MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"), "3RE744JWbF"), myClassConcept)), MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"));
      SPropertyOperations.assign(method, MetaAdapterFactory.getProperty(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d43480582L, "isAbstract"), false);
      SLinkOperations.setTarget(method, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1ffL, "body"), SNodeFactoryOperations.createNewNode(SNodeOperations.getModel(myClassConcept), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b200L, "jetbrains.mps.baseLanguage.structure.StatementList"), null));
      SLinkOperations.setTarget(method, MetaAdapterFactory.getReferenceLink(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d4348057fL, "overriddenMethod"), ((SNode) BHReflection.invoke0(baseMethod, MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), SMethodTrimmedId.create("getOverridenMethod", MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "hP3pnNO"))));
      SPropertyOperations.assign(method, MetaAdapterFactory.getProperty(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, 0x11d43480580L, "isVirtual"), false);

      if (index != -1) {
        ListSequence.fromList(SLinkOperations.getChildren(myClassConcept, MetaAdapterFactory.getContainmentLink(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d43447b1aL, 0x11d43447b25L, "method"))).insertElement(index++, method);
      } else {
        ListSequence.fromList(SLinkOperations.getChildren(myClassConcept, MetaAdapterFactory.getContainmentLink(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d43447b1aL, 0x11d43447b25L, "method"))).addElement(method);
      }
      update(method, baseMethod);
      ListSequence.fromList(result).addElement(method);
    }
    return result;
  }

  private void update(SNode method, SNode baseMethod) {
    if (myRemoveAttributes) {
      for (SNode child : SNodeOperations.getChildren(method)) {
        removeAttributes(child);
      }
    }
    boolean isAbstractMethod = ((boolean) (Boolean) BHReflection.invoke0(baseMethod, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"), SMethodTrimmedId.create("isAnAbstractMethod", null, "28P2dHxCoRl")));

    SNode defaultExpr;
    if (isAbstractMethod) {
      defaultExpr = ((SNode) BHReflection.invoke0(SLinkOperations.getTarget(baseMethod, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1fdL, "returnType")), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c37f506dL, "jetbrains.mps.baseLanguage.structure.Type"), SMethodTrimmedId.create("createDefaultTypeExpression", null, "2UvJdVpqUA4")));
    } else {
      SNode sourceMethodConcept = SLinkOperations.getTarget(SNodeOperations.getNodeAncestor(baseMethod, MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d43447b1aL, "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), false, false), MetaAdapterFactory.getReferenceLink(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d43447b1aL, 0x11d43447b1fL, "concept"));
      if (SNodeOperations.isInstanceOf(sourceMethodConcept, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, "jetbrains.mps.lang.structure.structure.ConceptDeclaration"))) {
        sourceMethodConcept = null;
      }
      Iterable<SNode> paramList = ListSequence.fromList(SLinkOperations.getChildren(method, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1feL, "parameter"))).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return _quotation_createNode_7wts1u_a0a0a0a2a0e0j(it);
        }
      });
      defaultExpr = _quotation_createNode_7wts1u_a0d0a4a9(sourceMethodConcept, ((SNode) BHReflection.invoke0(baseMethod, MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), SMethodTrimmedId.create("getOverridenMethod", MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d4348057eL, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "hP3pnNO"))), Sequence.fromIterable(paramList).toListSequence());
    }

    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1fdL, "returnType")), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc6bf96dL, "jetbrains.mps.baseLanguage.structure.VoidType"))) {
      if (!(isAbstractMethod)) {
        ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(method, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1ffL, "body")), MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b200L, 0xf8cc6bf961L, "statement"))).addElement(_quotation_createNode_7wts1u_a0a0a0a6a9(defaultExpr));
      }
    } else {
      ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(method, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1ffL, "body")), MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b200L, 0xf8cc6bf961L, "statement"))).addElement(getReturnStatement(defaultExpr));
    }
  }

  private SNode getReturnStatement(SNode returnExpr) {
    if ((returnExpr == null)) {
      return null;
    }

    if (myNeedReturnKW) {
      return _quotation_createNode_7wts1u_a0a2a11(returnExpr);
    } else {
      return _quotation_createNode_7wts1u_a0a0c0l(returnExpr);
    }
  }

  private void removeAttributes(SNode node) {
    if (SNodeOperations.isAttribute(node)) {
      SNodeOperations.deleteNode(node);
    } else {
      for (SNode child : SNodeOperations.getChildren(node)) {
        removeAttributes(child);
      }
    }
  }
  private static SNode _quotation_createNode_7wts1u_a0a0a0a2a0e0j(Object parameter_1) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_2 = null;
    quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8c77f1e98L, "VariableReference"), null, null, false);
    SNodeAccessUtil.setReferenceTarget(quotedNode_2, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c77f1e98L, 0xf8cc6bf960L, "variableDeclaration"), (SNode) parameter_1);
    return quotedNode_2;
  }
  private static SNode _quotation_createNode_7wts1u_a0d0a4a9(Object parameter_1, Object parameter_2, Object parameter_3) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_4 = null;
    SNode quotedNode_5 = null;
    SNode quotedNode_6 = null;
    SNode quotedNode_7 = null;
    quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x116b46a08c4L, "DotExpression"), null, null, false);
    quotedNode_5 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, "jetbrains.mps.lang.behavior"), 0x11d434a6558L, "SuperNodeExpression"), null, null, false);
    SNodeAccessUtil.setReferenceTarget(quotedNode_5, MetaAdapterFactory.getReferenceLink(0xaf65afd8f0dd4942L, 0x87d963a55f2a9db1L, 0x11d434a6558L, 0x498a2c3387127040L, "superConcept"), (SNode) parameter_1);
    quotedNode_4.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46a4416L, "operand"), quotedNode_5);
    quotedNode_6 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 0x1129a43046bL, "Node_ConceptMethodCall"), null, null, false);
    SNodeAccessUtil.setReferenceTarget(quotedNode_6, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301adL, "baseMethodDeclaration"), (SNode) parameter_2);
    {
      List<SNode> nodes = (List<SNode>) parameter_3;
      for (SNode child : nodes) {
        quotedNode_6.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301aeL, "actualArgument"), SNodeOperations.copyIfNecessary(child));
      }
    }
    quotedNode_4.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46b36c4L, "operation"), quotedNode_6);
    return quotedNode_4;
  }
  private static SNode _quotation_createNode_7wts1u_a0a0a0a6a9(Object parameter_1) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_2 = null;
    SNode quotedNode_3 = null;
    quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc56b213L, "ExpressionStatement"), null, null, false);
    quotedNode_3 = (SNode) parameter_1;
    if (quotedNode_3 != null) {
      quotedNode_2.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b213L, 0xf8cc56b214L, "expression"), SNodeOperations.copyIfNecessary(quotedNode_3));
    }
    return quotedNode_2;
  }
  private static SNode _quotation_createNode_7wts1u_a0a2a11(Object parameter_1) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_2 = null;
    SNode quotedNode_3 = null;
    quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc67c7feL, "ReturnStatement"), null, null, false);
    quotedNode_3 = (SNode) parameter_1;
    if (quotedNode_3 != null) {
      quotedNode_2.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc67c7feL, 0xf8cc6bf96cL, "expression"), SNodeOperations.copyIfNecessary(quotedNode_3));
    }
    return quotedNode_2;
  }
  private static SNode _quotation_createNode_7wts1u_a0a0c0l(Object parameter_1) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_2 = null;
    SNode quotedNode_3 = null;
    quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc56b213L, "ExpressionStatement"), null, null, false);
    quotedNode_3 = (SNode) parameter_1;
    if (quotedNode_3 != null) {
      quotedNode_2.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b213L, 0xf8cc56b214L, "expression"), SNodeOperations.copyIfNecessary(quotedNode_3));
    }
    return quotedNode_2;
  }
}