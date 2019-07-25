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
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.SingleLineComment__BehaviorDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class UpdateComment_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public UpdateComment_Intention() {
    super(Kind.NORMAL, true, new SNodePointer("r:00000000-0000-4000-0000-011c895902c6(jetbrains.mps.baseLanguage.intentions)", "4710708256402121309"));
  }
  @Override
  public String getPresentation() {
    return "UpdateComment";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x57d533a7af15ed3aL, 0x12bc996bc5882f24L, "text"))).isEmpty();
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new UpdateComment_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Update Comment";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {

      SNode l = SNodeFactoryOperations.addNewChild(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x57d533a7af15ed3aL, 0x12bc996bc5882f24L, "text"), null);
      ListSequence.fromList(SLinkOperations.getChildren(l, MetaAdapterFactory.getContainmentLink(0xc7fb639fbe784307L, 0x89b0b5959c3fa8c8L, 0x2331694e561af166L, 0x2331694e561af167L, "elements"))).clear();
      ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x57d533a7af15ed3aL, 0x57d533a7af16ff73L, "commentPart"))).visitAll(new IVisitor<SNode>() {
        public void visit(SNode part) {
          if (SNodeOperations.isInstanceOf(part, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x57d533a7af15ed3dL, "jetbrains.mps.baseLanguage.structure.TextCommentPart"))) {
            SingleLineComment__BehaviorDescriptor.parseAndAddWords_id45vN3dBFprj.invoke(node, SPropertyOperations.getString(SNodeOperations.cast(part, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x57d533a7af15ed3dL, "jetbrains.mps.baseLanguage.structure.TextCommentPart")), MetaAdapterFactory.getProperty(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x57d533a7af15ed3dL, 0x57d533a7af15ed3eL, "text")));
          }
        }
      });
      if (ListSequence.fromList(SLinkOperations.getChildren(l, MetaAdapterFactory.getContainmentLink(0xc7fb639fbe784307L, 0x89b0b5959c3fa8c8L, 0x2331694e561af166L, 0x2331694e561af167L, "elements"))).isEmpty()) {
        SNodeFactoryOperations.addNewChild(l, MetaAdapterFactory.getContainmentLink(0xc7fb639fbe784307L, 0x89b0b5959c3fa8c8L, 0x2331694e561af166L, 0x2331694e561af167L, "elements"), MetaAdapterFactory.getConcept(0xc7fb639fbe784307L, 0x89b0b5959c3fa8c8L, 0x229012ddae35f04L, "jetbrains.mps.lang.text.structure.Word"));

      }
      ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x57d533a7af15ed3aL, 0x57d533a7af16ff73L, "commentPart"))).clear();
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return UpdateComment_Intention.this;
    }
  }
}