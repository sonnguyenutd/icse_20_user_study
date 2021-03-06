package jetbrains.mps.baseLanguage.jdk8.intentions;

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
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class MakeMethodDefault_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public MakeMethodDefault_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:0637bc33-0253-4dba-988b-464018c42f84(jetbrains.mps.baseLanguage.jdk8.intentions)", "4838165336397280137"));
  }
  @Override
  public String getPresentation() {
    return "MakeMethodDefault";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return !(ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x203eeb62af522fa5L, 0x203eeb62af522fb1L, "modifiers"))).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, MetaAdapterFactory.getConcept(0xfdcdc48fbfd84831L, 0xaa765abac2ffa010L, 0x40ed0df0ef40a332L, "jetbrains.mps.baseLanguage.jdk8.structure.DefaultModifier"));
      }
    }));
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new MakeMethodDefault_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Make The Method Default";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SLinkOperations.addNewChild(node, MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x203eeb62af522fa5L, 0x203eeb62af522fb1L, "modifiers"), MetaAdapterFactory.getConcept(0xfdcdc48fbfd84831L, 0xaa765abac2ffa010L, 0x40ed0df0ef40a332L, "jetbrains.mps.baseLanguage.jdk8.structure.DefaultModifier"));
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return MakeMethodDefault_Intention.this;
    }
  }
}
