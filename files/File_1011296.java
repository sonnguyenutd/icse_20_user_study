package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.openapi.intentions.ParameterizedIntentionExecutable;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class ReplaceWithConcreteSubconcept_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  public ReplaceWithConcreteSubconcept_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c895902e5(jetbrains.mps.lang.generator.intentions)", "1210374656847760938"));
  }
  @Override
  public String getPresentation() {
    return "ReplaceWithConcreteSubconcept";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    if (!(MacroIntentionsUtil.isInGeneratorModel(node))) {
      return false;
    }
    SConcept selectedNodeConcept = SNodeOperations.getConcept(node);
    return selectedNodeConcept.isAbstract();
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    List<IntentionExecutable> list = ListSequence.fromList(new ArrayList<IntentionExecutable>());
    List<SConcept> paramList = parameter(node, context);
    if (paramList != null) {
      for (SConcept param : paramList) {
        ListSequence.fromList(list).addElement(new ReplaceWithConcreteSubconcept_Intention.IntentionImplementation(param));
      }
    }
    return list;
  }
  private List<SConcept> parameter(final SNode node, final EditorContext editorContext) {
    return ListSequence.fromList(SConceptOperations.getAllSubConcepts2(SNodeOperations.getConcept(node), SNodeOperations.getModel(node))).where(new IWhereFilter<SConcept>() {
      public boolean accept(SConcept it) {
        return !(it.isAbstract());
      }
    }).toListSequence();
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable implements ParameterizedIntentionExecutable {
    private SConcept myParameter;
    public IntentionImplementation(SConcept parameter) {
      myParameter = parameter;
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Replace with instance of  " + myParameter.getName() + " concept";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      SNode concreteConceptInstance = SNodeFactoryOperations.createNewNode(myParameter, null);
      SNodeOperations.replaceWithAnother(node, concreteConceptInstance);
      SNodeOperations.deleteNode(node);
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return ReplaceWithConcreteSubconcept_Intention.this;
    }
    public Object getParameter() {
      return myParameter;
    }
  }
}