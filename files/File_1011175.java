package jetbrains.mps.lang.core.util;

/*Generated by MPS */

import org.jetbrains.mps.openapi.language.SAbstractConcept;
import org.jetbrains.mps.openapi.module.SModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.internal.collections.runtime.Sequence;
import org.jetbrains.mps.openapi.model.SModel;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.core.behavior.IOldCommentContainer__BehaviorDescriptor;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.editor.runtime.impl.cellActions.CommentUtil;
import jetbrains.mps.lang.migration.runtime.base.Problem;
import org.jetbrains.mps.openapi.module.SearchScope;
import jetbrains.mps.lang.smodel.query.runtime.CommandUtil;
import jetbrains.mps.project.EditableFilteringScope;
import jetbrains.mps.lang.smodel.query.runtime.QueryExecutionContext;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.migration.runtime.base.DeprecatedConceptNotMigratedProblem;

public class OldCommentContainerMigration {
  private SAbstractConcept concept;
  private SModule module;
  public OldCommentContainerMigration(@NotNull SAbstractConcept concept, @NotNull SModule module) {
    this.concept = concept;
    this.module = module;
  }

  public void migrate() {
    Iterable<SNode> oldComments = Sequence.fromIterable(((Iterable<SModel>) module.getModels())).translate(new ITranslator2<SModel, SNode>() {
      public Iterable<SNode> translate(SModel it) {
        return it.getRootNodes();
      }
    }).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode it) {
        return SNodeOperations.getNodeDescendants(((SNode) it), SNodeOperations.asSConcept(concept), false, new SAbstractConcept[]{});
      }
    });
    for (SNode comment : Sequence.fromIterable(oldComments)) {
      Iterable<SNode> commentedNodes = IOldCommentContainer__BehaviorDescriptor.getCommentedNodes_id3$Sh7m_tmZE.invoke(SNodeOperations.cast(comment, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x39384475a5756fb0L, "jetbrains.mps.lang.core.structure.IOldCommentContainer")));
      if (Sequence.fromIterable(commentedNodes).isNotEmpty()) {
        SNode next = comment;
        for (SNode commentedNode : Sequence.fromIterable(commentedNodes)) {
          SNodeOperations.insertNextSiblingChild(next, commentedNode);
          next = commentedNode;
        }
        for (SNode commentedNode : Sequence.fromIterable(commentedNodes)) {
          CommentUtil.commentOut(commentedNode);
        }
      }
      SNodeOperations.deleteNode(comment);
    }
  }
  public Iterable<Problem> check() {
    {
      SearchScope scope_7l65wi_a0f = CommandUtil.createScope(module);
      final SearchScope scope_7l65wi_a0f_0 = new EditableFilteringScope(scope_7l65wi_a0f);
      QueryExecutionContext context = new QueryExecutionContext() {
        public SearchScope getDefaultSearchScope() {
          return scope_7l65wi_a0f_0;
        }
      };
      return CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), SNodeOperations.asSConcept(concept), false)).select(new ISelector<SNode, Problem>() {
        public Problem select(SNode it) {
          return ((Problem) new DeprecatedConceptNotMigratedProblem(it));
        }
      });
    }
  }

}