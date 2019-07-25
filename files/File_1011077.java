package jetbrains.mps.baseLanguage.closures.helper;

/*Generated by MPS */

import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.baseLanguage.closures.behavior.FunctionType__BehaviorDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.baseLanguage.closures.constraints.ClassifierTypeUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.behavior.Classifier__BehaviorDescriptor;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.behavior.BaseMethodDeclaration__BehaviorDescriptor;
import java.util.LinkedList;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.baseLanguage.closures.util.Constants;
import jetbrains.mps.typechecking.TypecheckingFacade;
import jetbrains.mps.lang.core.behavior.INamedConcept__BehaviorDescriptor;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.Iterator;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.SReference;

public class FunctionTypeUtil {
  public static String getRuntimeSignature(SNode ft) {
    return FunctionType__BehaviorDescriptor.getRuntimeSignature_idhEwIOjZ.invoke(ft);
  }
  public static SNode getResultType(SNode functionTypeOrClassifier) {
    if (SNodeOperations.isInstanceOf(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x102467229d8L, "jetbrains.mps.baseLanguage.structure.TypeVariableReference"))) {
      return null;
    }
    if (SNodeOperations.isInstanceOf(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"))) {
      return FunctionType__BehaviorDescriptor.getResultType_idhTY4wo3.invoke(SNodeOperations.cast(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")));
    } else if (SNodeOperations.isInstanceOf(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType"))) {
      SNode meth = FunctionTypeUtil.getFunctionMethod(functionTypeOrClassifier);
      return ClassifierTypeUtil.resolveType(SLinkOperations.getTarget(meth, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1fdL, "returnType")), SNodeOperations.cast(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType")));
    } else {
      throw new IllegalArgumentException("Invalid argument: " + functionTypeOrClassifier);
    }
  }
  public static List<SNode> getParameterTypes(SNode functionTypeOrClassifier) {
    if (SNodeOperations.isInstanceOf(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x102467229d8L, "jetbrains.mps.baseLanguage.structure.TypeVariableReference"))) {
      return null;
    }
    if (SNodeOperations.isInstanceOf(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"))) {
      return SLinkOperations.getChildren(SNodeOperations.cast(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")), MetaAdapterFactory.getContainmentLink(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, 0x1174a4e013cL, "parameterType"));
    } else if (SNodeOperations.isInstanceOf(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType"))) {
      SNode meth = FunctionTypeUtil.getFunctionMethod(functionTypeOrClassifier);
      List<SNode> res = new ArrayList<SNode>();
      for (SNode pd : ListSequence.fromList(SLinkOperations.getChildren(meth, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1feL, "parameter")))) {
        ListSequence.fromList(res).addElement(ClassifierTypeUtil.resolveType(SLinkOperations.getTarget(pd, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x450368d90ce15bc3L, 0x4ed4d318133c80ceL, "type")), SNodeOperations.cast(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType"))));
      }
      return res;
    } else {
      throw new IllegalArgumentException("Invalid argument: " + functionTypeOrClassifier);
    }
  }
  public static List<SNode> normalizeThrowsTypes(List<SNode> ttypes) {
    List<SNode> result = new ArrayList<SNode>();
    List<SNode> visited = new ArrayList<SNode>();
with_throws:
    for (SNode tt : ttypes) {
      SNode clstt = SNodeOperations.as(tt, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType"));
      if (clstt != null) {
        if (!((boolean) Classifier__BehaviorDescriptor.isDescendant_id6dL7A1DpKo1.invoke(SLinkOperations.getTarget(clstt, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier")), SLinkOperations.getTarget(_quotation_createNode_2t0coq_a0a0a0a1a2a3(), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier"))))) {
          for (int i = 0; i < ListSequence.fromList(visited).count(); ++i) {
            SNode restt = ListSequence.fromList(visited).getElement(i);
            if ((boolean) Classifier__BehaviorDescriptor.isDescendant_id6dL7A1DpKo1.invoke(SLinkOperations.getTarget(restt, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier")), SLinkOperations.getTarget(clstt, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier")))) {
              ListSequence.fromList(visited).setElement(i, clstt);
              continue with_throws;
            }
          }
          ListSequence.fromList(visited).addElement(clstt);
        }
      } else {
        ListSequence.fromList(result).addElement(tt);
      }
    }
    ListSequence.fromList(result).addSequence(ListSequence.fromList(visited));
    return result;
  }
  private static SNode getFunctionMethod(SNode functionTypeOrClassifier) {
    return Sequence.fromIterable(Classifier__BehaviorDescriptor.methods_id4_LVZ3pBKCn.invoke(SLinkOperations.getTarget(SNodeOperations.cast(functionTypeOrClassifier, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType")), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier")))).findFirst(new IWhereFilter<SNode>() {
      @Override
      public boolean accept(SNode m) {
        return !("equals".equals(SPropertyOperations.getString(m, MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")))) && (boolean) BaseMethodDeclaration__BehaviorDescriptor.isAnAbstractMethod_id28P2dHxCoRl.invoke(m);
      }
    });
  }
  public static SNode unmeet(SNode possiblyMeet) {
    SNode tmp = possiblyMeet;
with_meet:
    while (SNodeOperations.isInstanceOf(tmp, MetaAdapterFactory.getConcept(0x7a5dda6291404668L, 0xab76d5ed1746f2b2L, 0x114b68ad132L, "jetbrains.mps.lang.typesystem.structure.MeetType"))) {
      for (SNode arg : SLinkOperations.getChildren(SNodeOperations.cast(tmp, MetaAdapterFactory.getConcept(0x7a5dda6291404668L, 0xab76d5ed1746f2b2L, 0x114b68ad132L, "jetbrains.mps.lang.typesystem.structure.MeetType")), MetaAdapterFactory.getContainmentLink(0x7a5dda6291404668L, 0xab76d5ed1746f2b2L, 0x114b68ad132L, 0x114b68b040bL, "argument"))) {
        if (!(SNodeOperations.isInstanceOf(arg, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc6bf96dL, "jetbrains.mps.baseLanguage.structure.VoidType")))) {
          tmp = arg;
          continue with_meet;
        }
      }
      return _quotation_createNode_2t0coq_a1a1a5();
    }
    if (SNodeOperations.isInstanceOf(tmp, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType"))) {
      List<SNode> params = SLinkOperations.getChildren(SNodeOperations.cast(tmp, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType")), MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x102419671abL, "parameter"));
      for (SNode p : params) {
        SNode up = unmeet(p);
        if (up != p) {
          SNodeOperations.replaceWithAnother(p, up);
        }
      }
    }
    return tmp;
  }
  public static SNode unbound(SNode maybeBound) {
    SNode res = null;
    List<SNode> q = ListSequence.fromListAndArray(new LinkedList<SNode>(), SNodeOperations.copyNode(maybeBound));
    while (!(ListSequence.fromList(q).isEmpty())) {
      SNode n = ListSequence.fromList(q).removeElementAt(0);
      if (SNodeOperations.isInstanceOf(n, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x110daeaa84aL, "jetbrains.mps.baseLanguage.structure.UpperBoundType"))) {
        n = SNodeOperations.replaceWithAnother(n, SLinkOperations.getTarget(SNodeOperations.cast(n, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x110daeaa84aL, "jetbrains.mps.baseLanguage.structure.UpperBoundType")), MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x110daeaa84aL, 0x110daeaa84bL, "bound")));
      }
      if (SNodeOperations.isInstanceOf(n, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x110dae9d53dL, "jetbrains.mps.baseLanguage.structure.LowerBoundType"))) {
        n = SNodeOperations.replaceWithAnother(n, SLinkOperations.getTarget(SNodeOperations.cast(n, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x110dae9d53dL, "jetbrains.mps.baseLanguage.structure.LowerBoundType")), MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x110dae9d53dL, 0x110dae9f25bL, "bound")));
      }
      if ((n != null)) {
        ListSequence.fromList(q).addSequence(ListSequence.fromList(SNodeOperations.getChildren(n)));
      }
      if ((res == null)) {
        res = n;
      }
      break;
    }
    return res;
  }
  public static SNode unmeetRecursively(SNode nodeWithMeetDescendants) {
    for (SNode dsc : SNodeOperations.getNodeDescendants(nodeWithMeetDescendants, null, false, new SAbstractConcept[]{})) {
      if (SNodeOperations.isInstanceOf(dsc, MetaAdapterFactory.getConcept(0x7a5dda6291404668L, 0xab76d5ed1746f2b2L, 0x114b68ad132L, "jetbrains.mps.lang.typesystem.structure.MeetType"))) {
        SNodeOperations.replaceWithAnother(dsc, SNodeOperations.copyNode(unmeet(dsc)));
      }
    }
    return nodeWithMeetDescendants;
  }
  public static void prepAdaptations(TemplateQueryContext genContext, SNode ltype, SNode rexpr) {
    SNode lCType = (SNodeOperations.isInstanceOf(ltype, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType")) ? SNodeOperations.cast(ltype, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType")) : null);
    SNode lFType = (SNodeOperations.isInstanceOf(ltype, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")) ? SNodeOperations.cast(ltype, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")) : null);
    if ((lFType == null) && (lCType == null)) {
      return;
    }
    if (Constants.ONLY_CLOSURE_LITERAL_AS_FUNCTION_TYPE) {
      //  TEMP HACK: proceed only if the "right" expression is a ClosureLiteral, balk otherwise 
      //  This may cause unexpected results, so please disable in case of difficulties generating some code 
      if (!(SNodeOperations.isInstanceOf(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")))) {
        return;
      }
    }
    SNode rtype = TypecheckingFacade.getFromContext().getTypeOf(rexpr);
    SNode rFType = (SNodeOperations.isInstanceOf(rtype, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")) ? SNodeOperations.cast(rtype, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")) : null);
    SNode rCType = (SNodeOperations.isInstanceOf(rtype, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType")) ? SNodeOperations.cast(rtype, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, "jetbrains.mps.baseLanguage.structure.ClassifierType")) : null);

    if ((lCType != null) && (rFType != null)) {
      if (SNodeOperations.isInstanceOf(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) && (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(TypecheckingFacade.getFromContext().coerceType(lCType, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")), MetaAdapterFactory.getContainmentLink(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, 0x1174a4d5371L, "resultType")), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc6bf96dL, "jetbrains.mps.baseLanguage.structure.VoidType"))) || SNodeOperations.isInstanceOf(SLinkOperations.getTarget(rFType, MetaAdapterFactory.getContainmentLink(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, 0x1174a4d5371L, "resultType")), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc6bf96dL, "jetbrains.mps.baseLanguage.structure.VoidType")) || ListSequence.fromList(SNodeOperations.getNodeDescendants(SLinkOperations.getTarget(SNodeOperations.cast(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")), MetaAdapterFactory.getContainmentLink(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, 0x1174bf0522fL, "body")), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc67c7feL, "jetbrains.mps.baseLanguage.structure.ReturnStatement"), false, new SAbstractConcept[]{})).all(new IWhereFilter<SNode>() {
        @Override
        public boolean accept(SNode rs) {
          return (SLinkOperations.getTarget(rs, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc67c7feL, 0xf8cc6bf96cL, "expression")) == null);
        }
      }))) {
        new ClosureLiteralTarget(genContext).setTarget(SNodeOperations.cast(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")), lCType);
      } else {
        new AdaptableClassifierTarget(genContext).setTarget(FunctionType__BehaviorDescriptor.getDeclarationRuntimeType_idhTOKQzf.invoke(rFType), lCType);
        Values.PREP_DATA.set(genContext, rexpr, INamedConcept__BehaviorDescriptor.getFqName_idhEwIO9y.invoke(SLinkOperations.getTarget(lCType, MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier"))));
      }
    } else
    if ((lFType != null) && (rCType != null)) {
      new AdaptableClassifierTarget(genContext).setTarget(rCType, FunctionType__BehaviorDescriptor.getDeclarationRuntimeType_idhTOKQzf.invoke(lFType));
      Values.PREP_DATA.set(genContext, rexpr, INamedConcept__BehaviorDescriptor.getFqName_idhEwIO9y.invoke(SLinkOperations.getTarget(FunctionType__BehaviorDescriptor.getDeclarationRuntimeType_idhTOKQzf.invoke(lFType), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier"))));
    } else
    if ((lFType != null) && (rFType != null)) {
      ClosureLiteralAdapterBuilder builder = new ClosureLiteralAdapterBuilder(genContext);

      if (SNodeOperations.isInstanceOf(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) && builder.hasAdapterClass(SNodeOperations.cast(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")))) {
        SNode adapterClassType = builder.buildAdapterClassType(SNodeOperations.cast(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")), lFType);
        new ClosureLiteralTarget(genContext).setTarget(SNodeOperations.cast(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")), adapterClassType);

      } else if (SNodeOperations.isInstanceOf(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) && (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(lFType, MetaAdapterFactory.getContainmentLink(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, 0x1174a4d5371L, "resultType")), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc6bf96dL, "jetbrains.mps.baseLanguage.structure.VoidType"))) || SNodeOperations.isInstanceOf(SLinkOperations.getTarget(rFType, MetaAdapterFactory.getContainmentLink(0xfd3920347849419dL, 0x907112563d152375L, 0x1174a4d19ffL, 0x1174a4d5371L, "resultType")), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc6bf96dL, "jetbrains.mps.baseLanguage.structure.VoidType")) || ListSequence.fromList(SNodeOperations.getNodeDescendants(SLinkOperations.getTarget(SNodeOperations.cast(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")), MetaAdapterFactory.getContainmentLink(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, 0x1174bf0522fL, "body")), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc67c7feL, "jetbrains.mps.baseLanguage.structure.ReturnStatement"), false, new SAbstractConcept[]{})).all(new IWhereFilter<SNode>() {
        @Override
        public boolean accept(SNode rs) {
          return (SLinkOperations.getTarget(rs, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc67c7feL, 0xf8cc6bf96cL, "expression")) == null);
        }
      }))) {
        new ClosureLiteralTarget(genContext).setTarget(SNodeOperations.cast(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")), FunctionType__BehaviorDescriptor.getDeclarationRuntimeType_idH4u0Q2K3hM.invoke(lFType, rFType));

      } else if (SNodeOperations.isInstanceOf(rexpr, MetaAdapterFactory.getConcept(0xfd3920347849419dL, 0x907112563d152375L, 0x1174bed3125L, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) || ListSequence.fromList(FunctionType__BehaviorDescriptor.getNormalizedThrowsTypes_id2ZrgyPlTDZP.invoke(lFType)).count() != ListSequence.fromList(FunctionType__BehaviorDescriptor.getNormalizedThrowsTypes_id2ZrgyPlTDZP.invoke(rFType)).count()) {
        new AdaptableClassifierTarget(genContext).setTarget(FunctionType__BehaviorDescriptor.getDeclarationRuntimeType_idhTOKQzf.invoke(rFType), FunctionType__BehaviorDescriptor.getDeclarationRuntimeType_idhTOKQzf.invoke(lFType));
        Values.PREP_DATA.set(genContext, rexpr, INamedConcept__BehaviorDescriptor.getFqName_idhEwIO9y.invoke(SLinkOperations.getTarget(FunctionType__BehaviorDescriptor.getDeclarationRuntimeType_idhTOKQzf.invoke(lFType), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier"))));
      }
    }
  }
  public static Map<SNode, SNode> mapAdaptableTargetTVDs(SNode adaptable, SNode target) {
    Map<SNode, SNode> resMap = MapSequence.fromMap(new HashMap<SNode, SNode>());
    SNode adMethod = Sequence.fromIterable(Classifier__BehaviorDescriptor.methods_id4_LVZ3pBKCn.invoke(adaptable)).first();
    SNode trgMethod = Sequence.fromIterable(Classifier__BehaviorDescriptor.methods_id4_LVZ3pBKCn.invoke(target)).first();
    doMapTVDS(resMap, SLinkOperations.getTarget(adMethod, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1fdL, "returnType")), SLinkOperations.getTarget(trgMethod, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1fdL, "returnType")));
    {
      Iterator<SNode> adParm_it = ListSequence.fromList(SLinkOperations.getChildren(adMethod, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1feL, "parameter"))).iterator();
      Iterator<SNode> trgParm_it = ListSequence.fromList(SLinkOperations.getChildren(trgMethod, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b1fcL, 0xf8cc56b1feL, "parameter"))).iterator();
      SNode adParm_var;
      SNode trgParm_var;
      while (adParm_it.hasNext() && trgParm_it.hasNext()) {
        adParm_var = adParm_it.next();
        trgParm_var = trgParm_it.next();
        doMapTVDS(resMap, SLinkOperations.getTarget(adParm_var, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x450368d90ce15bc3L, 0x4ed4d318133c80ceL, "type")), SLinkOperations.getTarget(trgParm_var, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x450368d90ce15bc3L, 0x4ed4d318133c80ceL, "type")));
      }
    }
    return resMap;
  }
  private static void doMapTVDS(Map<SNode, SNode> theMap, SNode adType, SNode trgType) {
    SNode adTVD = SLinkOperations.getTarget(SNodeOperations.as(adType, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x102467229d8L, "jetbrains.mps.baseLanguage.structure.TypeVariableReference")), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x102467229d8L, 0x1024673a581L, "typeVariableDeclaration"));
    SNode trgTVD = SLinkOperations.getTarget(SNodeOperations.as(trgType, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x102467229d8L, "jetbrains.mps.baseLanguage.structure.TypeVariableReference")), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x102467229d8L, 0x1024673a581L, "typeVariableDeclaration"));
    if ((adTVD != null) && (trgTVD != null)) {
      MapSequence.fromMap(theMap).put(adTVD, trgTVD);
    }
  }
  private static SNode _quotation_createNode_2t0coq_a0a0a0a1a2a3() {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_1 = null;
    quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x101de48bf9eL, "ClassifierType"), null, null, false);
    quotedNode_1.setReference(MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier"), SReference.create(MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier"), quotedNode_1, facade.createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"), facade.createNodeId("~RuntimeException")));
    return quotedNode_1;
  }
  private static SNode _quotation_createNode_2t0coq_a1a1a5() {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_1 = null;
    quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc6bf96dL, "VoidType"), null, null, false);
    return quotedNode_1;
  }
}