package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.nodeEditor.CreateFromUsageUtil;
import jetbrains.mps.util.Setter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.editor.runtime.selection.SelectionUtil;
import org.jetbrains.mps.util.Condition;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class NewTemplateInCreateRootRule_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private Collection<IntentionExecutable> myCachedExecutable;
  public NewTemplateInCreateRootRule_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:00000000-0000-4000-0000-011c895902e5(jetbrains.mps.lang.generator.intentions)", "1216337594117"));
  }
  @Override
  public String getPresentation() {
    return "NewTemplateInCreateRootRule";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SLinkOperations.getTarget(node, MetaAdapterFactory.getReferenceLink(0xb401a68083254110L, 0x8fd384331ff25befL, 0x10fbbd5854aL, 0x10fbbd5854dL, "templateNode")) == null;
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new NewTemplateInCreateRootRule_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "New Root Template";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      final Wrappers._T<String> name = new Wrappers._T<String>(CreateFromUsageUtil.getText(editorContext));
      if (name.value == null || name.value.length() == 0) {
        name.value = "_name_";
      }
      final SNode rule = node;
      CreateFromUsageUtil.showCreateNewRootMenu(editorContext, new Setter<SNode>() {
        public void set(SNode root) {
          if (!(SNodeOperations.isInstanceOf(root, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, "jetbrains.mps.lang.core.structure.INamedConcept")))) {
            return;
          }
          SPropertyOperations.set(SNodeOperations.cast(root, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, "jetbrains.mps.lang.core.structure.INamedConcept")), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name"), name.value);
          MacroIntentionsUtil.copyVirtualPackage(root, node);
          SNodeFactoryOperations.setNewAttribute(root, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0x11017244494L, "jetbrains.mps.lang.generator.structure.RootTemplateAnnotation")), MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0x11017244494L, "jetbrains.mps.lang.generator.structure.RootTemplateAnnotation"));
          SLinkOperations.setTarget(rule, MetaAdapterFactory.getReferenceLink(0xb401a68083254110L, 0x8fd384331ff25befL, 0x10fbbd5854aL, 0x10fbbd5854dL, "templateNode"), SNodeOperations.cast(root, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, "jetbrains.mps.lang.core.structure.INamedConcept")));
          SelectionUtil.selectCell(editorContext, rule, "templateName");
        }
      }, new Condition<SConcept>() {
        public boolean met(SConcept c) {
          if (SConceptOperations.isExactly(SNodeOperations.asSConcept(c), MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0x10313ed7688L, "jetbrains.mps.lang.generator.structure.TemplateSwitch"))) {
            return false;
          }
          if (SConceptOperations.isExactly(SNodeOperations.asSConcept(c), MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xff0bea0475L, "jetbrains.mps.lang.generator.structure.MappingConfiguration"))) {
            return false;
          }
          if (SConceptOperations.isExactly(SNodeOperations.asSConcept(c), MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfe43cb41d0L, "jetbrains.mps.lang.generator.structure.TemplateDeclaration"))) {
            return false;
          }
          if (SConceptOperations.isExactly(SNodeOperations.asSConcept(c), MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0x1165958fcd6L, "jetbrains.mps.lang.generator.structure.MappingScript"))) {
            return false;
          }
          return true;
        }
      });
    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return NewTemplateInCreateRootRule_Intention.this;
    }
  }
}