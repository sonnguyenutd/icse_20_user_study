package jetbrains.mps.lang.smodel.migration;

/*Generated by MPS */

import jetbrains.mps.lang.migration.runtime.base.MigrationScriptBase;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.module.SModule;
import jetbrains.mps.lang.migration.runtime.base.Problem;
import org.jetbrains.mps.openapi.module.SearchScope;
import jetbrains.mps.lang.smodel.query.runtime.CommandUtil;
import jetbrains.mps.project.EditableFilteringScope;
import jetbrains.mps.lang.smodel.query.runtime.QueryExecutionContext;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.migration.runtime.base.DeprecatedConceptNotMigratedProblem;
import jetbrains.mps.lang.migration.runtime.base.MigrationScriptReference;
import jetbrains.mps.lang.structure.migration.EnumUsagesMigration;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.behavior.IOperation__BehaviorDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.structure.behavior.EnumerationMemberDeclaration_Old__BehaviorDescriptor;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.typechecking.TypecheckingFacade;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import jetbrains.mps.smodel.SModelUtil_new;
import org.jetbrains.mps.openapi.model.SNodeAccessUtil;

public class MigrateEnumPropertyAccess extends MigrationScriptBase {
  public String getCaption() {
    return "Update property operations to new enumerations";
  }
  @Override
  public boolean isRerunnable() {
    return true;
  }
  public SNode execute(final SModule m) {
    doExecute(m);
    return null;
  }
  public void doExecute(final SModule m) {
    migrate(m);
    EnumExpressionsMigration.optimize(m);
  }
  @Override
  public Iterable<Problem> check(SModule m) {
    {
      SearchScope scope_xqhmgi_a0e = CommandUtil.createScope(m);
      final SearchScope scope_xqhmgi_a0e_0 = new EditableFilteringScope(scope_xqhmgi_a0e);
      QueryExecutionContext context = new QueryExecutionContext() {
        public SearchScope getDefaultSearchScope() {
          return scope_xqhmgi_a0e_0;
        }
      };
      List<Problem> problems = ListSequence.fromList(new ArrayList<Problem>());
      ListSequence.fromList(problems).addSequence(CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120c01735d3L, "jetbrains.mps.lang.smodel.structure.EnumMember_NameOperation_Old"), false)).select(new ISelector<SNode, DeprecatedConceptNotMigratedProblem>() {
        public DeprecatedConceptNotMigratedProblem select(SNode it) {
          return new DeprecatedConceptNotMigratedProblem(it);
        }
      }));
      ListSequence.fromList(problems).addSequence(CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120bff92dbeL, "jetbrains.mps.lang.smodel.structure.EnumMember_ValueOperation_Old"), false)).select(new ISelector<SNode, DeprecatedConceptNotMigratedProblem>() {
        public DeprecatedConceptNotMigratedProblem select(SNode it) {
          return new DeprecatedConceptNotMigratedProblem(it);
        }
      }));
      ListSequence.fromList(problems).addSequence(CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091e6212fdL, "jetbrains.mps.lang.smodel.structure.EnumMemberReference_Old"), false)).select(new ISelector<SNode, DeprecatedConceptNotMigratedProblem>() {
        public DeprecatedConceptNotMigratedProblem select(SNode it) {
          return new DeprecatedConceptNotMigratedProblem(it);
        }
      }));
      ListSequence.fromList(problems).addSequence(CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed32e98bL, "jetbrains.mps.lang.smodel.structure.SEnumOperationInvocation"), false)).select(new ISelector<SNode, DeprecatedConceptNotMigratedProblem>() {
        public DeprecatedConceptNotMigratedProblem select(SNode it) {
          return new DeprecatedConceptNotMigratedProblem(it);
        }
      }));
      ListSequence.fromList(problems).addSequence(CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getInterfaceConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37273dL, "jetbrains.mps.lang.smodel.structure.SEnumOperation_Old"), false)).select(new ISelector<SNode, DeprecatedConceptNotMigratedProblem>() {
        public DeprecatedConceptNotMigratedProblem select(SNode it) {
          return new DeprecatedConceptNotMigratedProblem(it);
        }
      }));
      ListSequence.fromList(problems).addSequence(CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x60c7f83bafd83b5bL, "jetbrains.mps.lang.smodel.structure.EnumMemberValueRefExpression"), false)).select(new ISelector<SNode, DeprecatedConceptNotMigratedProblem>() {
        public DeprecatedConceptNotMigratedProblem select(SNode it) {
          return new DeprecatedConceptNotMigratedProblem(it);
        }
      }));
      ListSequence.fromList(problems).addSequence(CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091e6212fdL, "jetbrains.mps.lang.smodel.structure.EnumMemberReference_Old"), false)).select(new ISelector<SNode, DeprecatedConceptNotMigratedProblem>() {
        public DeprecatedConceptNotMigratedProblem select(SNode it) {
          return new DeprecatedConceptNotMigratedProblem(it);
        }
      }));

      return problems;
    }
  }
  public Iterable<MigrationScriptReference> executeAfter() {
    return ListSequence.fromListAndArray(new ArrayList<MigrationScriptReference>(), new MigrationScriptReference(MetaAdapterFactory.getLanguage(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, "jetbrains.mps.lang.structure"), 8));
  }
  public MigrationScriptReference getDescriptor() {
    return new MigrationScriptReference(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 15);
  }



  private static void migrate(SModule m) {
    {
      SearchScope scope_xqhmgi_a0k = CommandUtil.createScope(m);
      final SearchScope scope_xqhmgi_a0k_0 = new EditableFilteringScope(scope_xqhmgi_a0k);
      QueryExecutionContext context = new QueryExecutionContext() {
        public SearchScope getDefaultSearchScope() {
          return scope_xqhmgi_a0k_0;
        }
      };

      // node.enumProp 
      for (SNode propertyAccess : CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x108f96cca6fL, "jetbrains.mps.lang.smodel.structure.SPropertyAccess"), false))) {
        SNode newProperty = EnumUsagesMigration.migratePropertyReference(propertyAccess, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x108f96cca6fL, 0x108f9727bcdL, "property"));
        if (newProperty != null) {
          migratePropertyAccess(propertyAccess);
        }
      }

      for (SNode oldEnumMemberNameOp : CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120c01735d3L, "jetbrains.mps.lang.smodel.structure.EnumMember_NameOperation_Old"), false))) {
        if (ListSequence.fromList(SLinkOperations.getChildren(oldEnumMemberNameOp, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))).isNotEmpty()) {
          continue;
        }

        SNode memberExpression = IOperation__BehaviorDescriptor.getOperand_idhEwIP$m.invoke(oldEnumMemberNameOp);
        SNode dotExpression = SNodeOperations.as(SNodeOperations.getParent(oldEnumMemberNameOp), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, "jetbrains.mps.baseLanguage.structure.DotExpression"));

        SNode res = EnumExpressionsMigration.insertMemberNameOp(getEnumForMigratingEnumMemberOp(oldEnumMemberNameOp), dotExpression, memberExpression);
        ListSequence.fromList(SLinkOperations.getChildren(res, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))).addSequence(ListSequence.fromList(SLinkOperations.getChildren(dotExpression, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))));
      }

      for (SNode oldEnumMemberValueOp : CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120bff92dbeL, "jetbrains.mps.lang.smodel.structure.EnumMember_ValueOperation_Old"), false))) {
        if (ListSequence.fromList(SLinkOperations.getChildren(oldEnumMemberValueOp, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))).isNotEmpty()) {
          continue;
        }

        SNode memberExpression = IOperation__BehaviorDescriptor.getOperand_idhEwIP$m.invoke(oldEnumMemberValueOp);
        SNode dotExpression = SNodeOperations.as(SNodeOperations.getParent(oldEnumMemberValueOp), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, "jetbrains.mps.baseLanguage.structure.DotExpression"));

        SNode res = EnumExpressionsMigration.insertMemberValueOp(getEnumForMigratingEnumMemberOp(oldEnumMemberValueOp), dotExpression, memberExpression);
        ListSequence.fromList(SLinkOperations.getChildren(res, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))).addSequence(ListSequence.fromList(SLinkOperations.getChildren(dotExpression, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))));
      }

      // enum/.../.op 
      for (SNode enumOpInvocation : CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed32e98bL, "jetbrains.mps.lang.smodel.structure.SEnumOperationInvocation"), false))) {
        SNode operation = SLinkOperations.getTarget(enumOpInvocation, MetaAdapterFactory.getContainmentLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed32e98bL, 0x120ed35f667L, "operation"));

        if (ListSequence.fromList(SLinkOperations.getChildren(enumOpInvocation, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))).isNotEmpty()) {
          continue;
        }
        if (ListSequence.fromList(SLinkOperations.getChildren(operation, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))).isNotEmpty()) {
          continue;
        }

        SNode oldEnum = SLinkOperations.getTarget(enumOpInvocation, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed32e98bL, 0x120ed32e98cL, "enumDeclaration"));
        SNode newEnum = SNodeOperations.cast(SNodeOperations.getParent(SNodeOperations.getParent(oldEnum)), MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x2e770ca32c607c5fL, "jetbrains.mps.lang.structure.structure.EnumerationDeclartaion"));



        if (SNodeOperations.isInstanceOf(operation, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e6b4L, "jetbrains.mps.lang.smodel.structure.SEnum_MembersOperation_Old"))) {
          SNode replacement = SNodeOperations.replaceWithAnother(enumOpInvocation, _quotation_createNode_xqhmgi_a0a0a0k0j0a0k(newEnum));
          continue;
        }

        if (SNodeOperations.isInstanceOf(operation, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e691L, "jetbrains.mps.lang.smodel.structure.SEnum_MemberOperation_Old"))) {
          SNode oldLiteral = SNodeOperations.cast(operation, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e691L, "jetbrains.mps.lang.smodel.structure.SEnum_MemberOperation_Old"));
          SNodeOperations.replaceWithAnother(enumOpInvocation, _quotation_createNode_xqhmgi_a0a1a21a9a0a01(newEnum, EnumerationMemberDeclaration_Old__BehaviorDescriptor.findReplacement_id54m$yuDZW0l.invoke(SLinkOperations.getTarget(oldLiteral, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e691L, 0x120ed37e692L, "member")))));
          continue;
        }

        if (SNodeOperations.isInstanceOf(operation, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e64eL, "jetbrains.mps.lang.smodel.structure.SEnum_MemberForValueOperation_Old"))) {
          EnumExpressionsMigration.insertMemberForValueOp(newEnum, enumOpInvocation, SLinkOperations.getTarget(SNodeOperations.cast(operation, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e64eL, "jetbrains.mps.lang.smodel.structure.SEnum_MemberForValueOperation_Old")), MetaAdapterFactory.getContainmentLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e64eL, 0x120ed37e64fL, "valueExpression")));
          continue;
        }

        if (SNodeOperations.isInstanceOf(operation, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e60cL, "jetbrains.mps.lang.smodel.structure.SEnum_MemberForNameOperation_Old"))) {
          EnumExpressionsMigration.insertMemberForNameOp(newEnum, enumOpInvocation, SLinkOperations.getTarget(SNodeOperations.cast(operation, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e60cL, "jetbrains.mps.lang.smodel.structure.SEnum_MemberForNameOperation_Old")), MetaAdapterFactory.getContainmentLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120ed37e60cL, 0x120ed37e60dL, "nameExpression")));
          continue;
        }

        // theoretical extensions of SEnumOperation_Old should be migrated by their implementors 
      }

      for (SNode enumMemberValueRef : CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x60c7f83bafd83b5bL, "jetbrains.mps.lang.smodel.structure.EnumMemberValueRefExpression"), false))) {
        if (ListSequence.fromList(SLinkOperations.getChildren(enumMemberValueRef, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))).isNotEmpty()) {
          continue;
        }

        SNode newMember = EnumerationMemberDeclaration_Old__BehaviorDescriptor.findReplacement_id54m$yuDZW0l.invoke(SLinkOperations.getTarget(enumMemberValueRef, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x60c7f83bafd83b5bL, 0x60c7f83bafda1168L, "member")));

        EnumExpressionsMigration.insertMemberValueOp(SNodeOperations.as(SNodeOperations.getParent(newMember), MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x2e770ca32c607c5fL, "jetbrains.mps.lang.structure.structure.EnumerationDeclartaion")), enumMemberValueRef, _quotation_createNode_xqhmgi_c0e0l0a0k(SNodeOperations.cast(SNodeOperations.getParent(newMember), MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x2e770ca32c607c5fL, "jetbrains.mps.lang.structure.structure.EnumerationDeclartaion")), newMember));
      }

      for (SNode enumMemberType : CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120bfe51421L, "jetbrains.mps.lang.smodel.structure.SEnumerationMemberType"), false))) {
        EnumUsagesMigration.migrateEnumReference(enumMemberType, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120bfe51421L, 0x120bff1303bL, "enum"));
      }
    }
  }

  private static void migratePropertyAccess(SNode propertyAccess) {
    SNode dotExpression = SNodeOperations.cast(SNodeOperations.getParent(propertyAccess), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, "jetbrains.mps.baseLanguage.structure.DotExpression"));
    SNode newEnum = SNodeOperations.cast(SLinkOperations.getTarget(SLinkOperations.getTarget(propertyAccess, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x108f96cca6fL, 0x108f9727bcdL, "property")), MetaAdapterFactory.getReferenceLink(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979bd086bL, 0xfc26f42fe5L, "dataType")), MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x2e770ca32c607c5fL, "jetbrains.mps.lang.structure.structure.EnumerationDeclartaion"));

    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(dotExpression), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, "jetbrains.mps.baseLanguage.structure.DotExpression"))) {
      SNode grandDotExpression = SNodeOperations.as(SNodeOperations.getParent(dotExpression), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, "jetbrains.mps.baseLanguage.structure.DotExpression"));

      // node.enumProp.is(< enumMember >) 
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(grandDotExpression, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46b36c4L, "operation")), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x10add1ded2bL, "jetbrains.mps.lang.smodel.structure.Property_HasValue_Enum"))) {
        SNode operation = SNodeOperations.cast(SLinkOperations.getTarget(grandDotExpression, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46b36c4L, "operation")), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x10add1ded2bL, "jetbrains.mps.lang.smodel.structure.Property_HasValue_Enum"));
        if (ListSequence.fromList(SNodeOperations.getNodeDescendants(operation, MetaAdapterFactory.getConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x47bf8397520e5939L, "jetbrains.mps.lang.core.structure.Attribute"), false, new SAbstractConcept[]{})).isNotEmpty()) {
          return;
        }
        SNode oldMember = SLinkOperations.getTarget(SLinkOperations.getTarget(operation, MetaAdapterFactory.getContainmentLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x10add1ded2bL, 0x10add1ded2cL, "value")), MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091e6212fdL, 0x1091e625b13L, "enumMember"));
        SNode newMember = EnumerationMemberDeclaration_Old__BehaviorDescriptor.findReplacement_id54m$yuDZW0l.invoke(oldMember);
        SNode replacement = SNodeOperations.replaceWithNewChild(operation, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x414edd67c0135694L, "jetbrains.mps.lang.smodel.structure.EnumMember_IsOperation"));
        SLinkOperations.setTarget(replacement, MetaAdapterFactory.getContainmentLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x414edd67c0135694L, 0x414edd67c0135695L, "member"), createEnumMemberReference_xqhmgi_a0f0d0d0m(newMember));
        return;
      }

      // node.enumProp.set(...) 
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(grandDotExpression, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46b36c4L, "operation")), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091d8a1d53L, "jetbrains.mps.lang.smodel.structure.Property_SetOperation"))) {
        SNode operation = SNodeOperations.cast(SLinkOperations.getTarget(grandDotExpression, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46b36c4L, "operation")), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091d8a1d53L, "jetbrains.mps.lang.smodel.structure.Property_SetOperation"));
        SNode value = SLinkOperations.getTarget(operation, MetaAdapterFactory.getContainmentLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091d8a1d53L, 0x1091d8c01aaL, "value"));

        // set(< ... >) 
        if (SNodeOperations.isInstanceOf(value, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091e6212fdL, "jetbrains.mps.lang.smodel.structure.EnumMemberReference_Old"))) {
          if (ListSequence.fromList(SLinkOperations.getChildren(value, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, 0x47bf8397520e5942L, "smodelAttribute"))).isNotEmpty()) {
            return;
          }
          SNode oldMember = SLinkOperations.getTarget(SNodeOperations.cast(value, MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091e6212fdL, "jetbrains.mps.lang.smodel.structure.EnumMemberReference_Old")), MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1091e6212fdL, 0x1091e625b13L, "enumMember"));
          SNodeOperations.replaceWithAnother(value, createEnumMemberReference_xqhmgi_a0a2a4a6a3a21(EnumerationMemberDeclaration_Old__BehaviorDescriptor.findReplacement_id54m$yuDZW0l.invoke(oldMember)));
          return;
        }

        EnumExpressionsMigration.upgradeExpressionType(newEnum, value);
        return;
      }
    }

    // node.enumProp = ... 
    if (SNodeOperations.hasRole(dotExpression, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11b0d00332cL, 0xf8c77f1e97L, "lValue"))) {
      SNode assigmentExpression = SNodeOperations.cast(SNodeOperations.getParent(dotExpression), MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c77f1e96L, "jetbrains.mps.baseLanguage.structure.AssignmentExpression"));
      SNode value = SLinkOperations.getTarget(assigmentExpression, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11b0d00332cL, 0xf8c77f1e99L, "rValue"));

      EnumExpressionsMigration.upgradeExpressionType(newEnum, value);
      return;
    }

    // by default surrond exisiting dotExpression with member->value conversion code 
    EnumExpressionsMigration.downgradeExpressionType(newEnum, dotExpression);
  }

  private static SNode getEnumForMigratingEnumMemberOp(SNode migratingOp) {
    SNode enumm = SLinkOperations.getTarget(TypecheckingFacade.getFromContext().strongCoerceType(TypecheckingFacade.getFromContext().getTypeOf(IOperation__BehaviorDescriptor.getOperand_idhEwIP$m.invoke(migratingOp)), MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120bfe51421L, "jetbrains.mps.lang.smodel.structure.SEnumerationMemberType")), MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x120bfe51421L, 0x120bff1303bL, "enum"));
    if (SNodeOperations.hasRole(enumm, MetaAdapterFactory.getContainmentLink(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x160b046db949c266L, 0x5a14f1035942799cL, "oldEnum"))) {
      return SNodeOperations.cast(SNodeOperations.getParent(SNodeOperations.getParent(enumm)), MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x2e770ca32c607c5fL, "jetbrains.mps.lang.structure.structure.EnumerationDeclartaion"));
    }
    return SNodeOperations.cast(enumm, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x2e770ca32c607c5fL, "jetbrains.mps.lang.structure.structure.EnumerationDeclartaion"));
  }
  private static SNode _quotation_createNode_xqhmgi_a0a0a0k0j0a0k(Object parameter_1) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_2 = null;
    SNode quotedNode_3 = null;
    SNode quotedNode_4 = null;
    quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x116b46a08c4L, "DotExpression"), null, null, false);
    quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 0x50352c802d81bed4L, "EnumerationIdRefExpression"), null, null, false);
    SNodeAccessUtil.setReferenceTarget(quotedNode_3, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x50352c802d81bed4L, 0x50352c802d81bed5L, "enumDeclaration"), (SNode) parameter_1);
    quotedNode_2.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46a4416L, "operand"), quotedNode_3);
    quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 0x1b4bba1ba0012d68L, "Enum_MembersOperation"), null, null, false);
    quotedNode_2.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46b36c4L, "operation"), quotedNode_4);
    return quotedNode_2;
  }
  private static SNode _quotation_createNode_xqhmgi_a0a1a21a9a0a01(Object parameter_1, Object parameter_2) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_3 = null;
    SNode quotedNode_4 = null;
    SNode quotedNode_5 = null;
    quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x116b46a08c4L, "DotExpression"), null, null, false);
    quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 0x50352c802d81bed4L, "EnumerationIdRefExpression"), null, null, false);
    SNodeAccessUtil.setReferenceTarget(quotedNode_4, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x50352c802d81bed4L, 0x50352c802d81bed5L, "enumDeclaration"), (SNode) parameter_1);
    quotedNode_3.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46a4416L, "operand"), quotedNode_4);
    quotedNode_5 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 0x1b4bba1ba0012d60L, "Enum_MemberLiteral"), null, null, false);
    SNodeAccessUtil.setReferenceTarget(quotedNode_5, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1b4bba1ba0012d60L, 0x1b4bba1ba0012d64L, "memberDeclaration"), (SNode) parameter_2);
    quotedNode_3.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46b36c4L, "operation"), quotedNode_5);
    return quotedNode_3;
  }
  private static SNode _quotation_createNode_xqhmgi_c0e0l0a0k(Object parameter_1, Object parameter_2) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode quotedNode_3 = null;
    SNode quotedNode_4 = null;
    SNode quotedNode_5 = null;
    quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x116b46a08c4L, "DotExpression"), null, null, false);
    quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 0x50352c802d81bed4L, "EnumerationIdRefExpression"), null, null, false);
    SNodeAccessUtil.setReferenceTarget(quotedNode_4, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x50352c802d81bed4L, 0x50352c802d81bed5L, "enumDeclaration"), (SNode) parameter_1);
    quotedNode_3.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46a4416L, "operand"), quotedNode_4);
    quotedNode_5 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, "jetbrains.mps.lang.smodel"), 0x1b4bba1ba0012d60L, "Enum_MemberLiteral"), null, null, false);
    SNodeAccessUtil.setReferenceTarget(quotedNode_5, MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x1b4bba1ba0012d60L, 0x1b4bba1ba0012d64L, "memberDeclaration"), (SNode) parameter_2);
    quotedNode_3.addChild(MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x116b46a08c4L, 0x116b46b36c4L, "operation"), quotedNode_5);
    return quotedNode_3;
  }
  private static SNode createEnumMemberReference_xqhmgi_a0f0d0d0m(SNode node0) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode n1 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x414edd67c0112b91L, "jetbrains.mps.lang.smodel.structure.EnumMemberReference"), null, null, false);
    n1.setReferenceTarget(MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x414edd67c0112b91L, 0x414edd67c0112b98L, "decl"), node0);
    return n1;
  }
  private static SNode createEnumMemberReference_xqhmgi_a0a2a4a6a3a21(SNode node0) {
    PersistenceFacade facade = PersistenceFacade.getInstance();
    SNode n1 = SModelUtil_new.instantiateConceptDeclaration(MetaAdapterFactory.getConcept(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x414edd67c0112b91L, "jetbrains.mps.lang.smodel.structure.EnumMemberReference"), null, null, false);
    n1.setReferenceTarget(MetaAdapterFactory.getReferenceLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x414edd67c0112b91L, 0x414edd67c0112b98L, "decl"), node0);
    return n1;
  }
}