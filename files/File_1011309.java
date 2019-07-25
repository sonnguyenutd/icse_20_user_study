package jetbrains.mps.lang.migration.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import org.jetbrains.mps.openapi.module.SRepository;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class SetIdsInMoveMigrations_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public SetIdsInMoveMigrations_Intention() {
    super(Kind.ERROR, true, new SNodePointer("r:8524dd83-cdb1-4841-877b-826d11a828b5(jetbrains.mps.lang.migration.intentions)", "3265844182377326076"));
  }
  @Override
  public String getPresentation() {
    return "SetIdsInMoveMigrations";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return Sequence.fromIterable(SNodeOperations.ofConcept(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0x9074634404fd4286L, 0x97d5b46ae6a81709L, 0x67236d4a5836cabbL, 0x67236d4a5836d7f3L, "part")), MetaAdapterFactory.getConcept(0x9074634404fd4286L, 0x97d5b46ae6a81709L, 0x67236d4a5830221eL, "jetbrains.mps.lang.migration.structure.MoveNodeMigrationPart"))).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode it) {
        return SLinkOperations.getChildren(it, MetaAdapterFactory.getContainmentLink(0x9074634404fd4286L, 0x97d5b46ae6a81709L, 0x67236d4a5830221eL, 0x2b3f57492c165c59L, "specialization"));
      }
    }).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return RefactoringIdHelper.isApplicable(it);
      }
    });
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new SetIdsInMoveMigrations_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Add Ids";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      final SRepository repo = editorContext.getRepository();
      Sequence.fromIterable(SNodeOperations.ofConcept(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0x9074634404fd4286L, 0x97d5b46ae6a81709L, 0x67236d4a5836cabbL, 0x67236d4a5836d7f3L, "part")), MetaAdapterFactory.getConcept(0x9074634404fd4286L, 0x97d5b46ae6a81709L, 0x67236d4a5830221eL, "jetbrains.mps.lang.migration.structure.MoveNodeMigrationPart"))).translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getChildren(it, MetaAdapterFactory.getContainmentLink(0x9074634404fd4286L, 0x97d5b46ae6a81709L, 0x67236d4a5830221eL, 0x2b3f57492c165c59L, "specialization"));
        }
      }).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          RefactoringIdHelper.migrate(repo, it);
        }
      });
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return SetIdsInMoveMigrations_Intention.this;
    }
  }
}