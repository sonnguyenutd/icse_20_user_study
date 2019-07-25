package jetbrains.mps.lang.constraints.migration;

/*Generated by MPS */

import jetbrains.mps.lang.migration.runtime.base.MigrationScriptBase;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.module.SModule;
import jetbrains.mps.lang.migration.runtime.base.Problem;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.jetbrains.mps.openapi.module.SearchScope;
import jetbrains.mps.lang.smodel.query.runtime.CommandUtil;
import jetbrains.mps.project.EditableFilteringScope;
import jetbrains.mps.lang.smodel.query.runtime.QueryExecutionContext;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.migration.runtime.base.MigrationScriptReference;

public class ConstraintScopeFactory_NodeToConcept extends MigrationScriptBase {
  public String getCaption() {
    return "Migrate concept and link declaration nodes in scope factory parameters";
  }
  @Override
  public boolean isRerunnable() {
    return false;
  }
  public SNode execute(final SModule m) {
    doExecute(m);
    return null;
  }
  public void doExecute(final SModule m) {
    // Migrated in 2017.1 
  }
  @Override
  public Iterable<Problem> check(SModule m) {
    final List<Problem> problems = ListSequence.fromList(new ArrayList<Problem>());
    {
      SearchScope scope_djohgv_b0e = CommandUtil.createScope(m);
      final SearchScope scope_djohgv_b0e_0 = new EditableFilteringScope(scope_djohgv_b0e);
      QueryExecutionContext context = new QueryExecutionContext() {
        public SearchScope getDefaultSearchScope() {
          return scope_djohgv_b0e_0;
        }
      };
      CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0x3f4bc5f5c6c14a28L, 0x8b10c83066ffa4a1L, 0x11a7208faaeL, "jetbrains.mps.lang.constraints.structure.ConceptConstraints"), false)).visitAll(new IVisitor<SNode>() {
        public void visit(SNode node) {
          ConstraintsMigrationUtil.findProblems(SLinkOperations.getTarget(SLinkOperations.getTarget(node, MetaAdapterFactory.getContainmentLink(0x3f4bc5f5c6c14a28L, 0x8b10c83066ffa4a1L, 0x11a7208faaeL, 0x11a727527f6L, "defaultScope")), MetaAdapterFactory.getContainmentLink(0x3f4bc5f5c6c14a28L, 0x8b10c83066ffa4a1L, 0x10dead47852L, 0x10dead647b3L, "searchScopeFactory")), problems);

          ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0x3f4bc5f5c6c14a28L, 0x8b10c83066ffa4a1L, 0x11a7208faaeL, 0x11a726c901bL, "referent"))).visitAll(new IVisitor<SNode>() {
            public void visit(SNode referent) {
              ConstraintsMigrationUtil.findProblems(SLinkOperations.getTarget(referent, MetaAdapterFactory.getContainmentLink(0x3f4bc5f5c6c14a28L, 0x8b10c83066ffa4a1L, 0x10b731752daL, 0x10b7319e797L, "searchScopeFactory")), problems);
            }
          });
        }
      });
    }
    return problems;
  }
  public MigrationScriptReference getDescriptor() {
    return new MigrationScriptReference(MetaAdapterFactory.getLanguage(0x3f4bc5f5c6c14a28L, 0x8b10c83066ffa4a1L, "jetbrains.mps.lang.constraints"), 1);
  }

}