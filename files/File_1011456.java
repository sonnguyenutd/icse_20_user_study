package smodelLanguage.samples;

/*Generated by MPS */

import org.jetbrains.mps.openapi.model.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class Attributes {
  public void accessToNodeAttribute_1(SNode node) {
    List<SNode> macros = AttributeOperations.getAttributeList(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd47ed6742L, "jetbrains.mps.lang.generator.structure.NodeMacro")));
    SNode firstMacro = ListSequence.fromList(AttributeOperations.getAttributeList(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd47ed6742L, "jetbrains.mps.lang.generator.structure.NodeMacro")))).first();
  }
  public void accessToPropertyAttribute_1(SNode node) {
    SNode propertyMacro = AttributeOperations.getAttribute(node, new IAttributeDescriptor.PropertyAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd47e9f6f0L, "jetbrains.mps.lang.generator.structure.PropertyMacro"), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")));
    SAbstractConcept concept = SNodeOperations.getConcept(AttributeOperations.getAttribute(node, new IAttributeDescriptor.PropertyAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd47e9f6f0L, "jetbrains.mps.lang.generator.structure.PropertyMacro"), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name"))));
    SNode propertyMacro1 = AttributeOperations.getAttribute(node, new IAttributeDescriptor.PropertyAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd47e9f6f0L, "jetbrains.mps.lang.generator.structure.PropertyMacro"), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")));
  }
  public void accessToPropertyAttribute_2(SNode node) {
    SNode propMacro = null;
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.PropertyAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd47e9f6f0L, "jetbrains.mps.lang.generator.structure.PropertyMacro"), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")), propMacro);
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.PropertyAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd47e9f6f0L, "jetbrains.mps.lang.generator.structure.PropertyMacro"), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")), propMacro);
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.PropertyAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd47e9f6f0L, "jetbrains.mps.lang.generator.structure.PropertyMacro"), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")), propMacro);
  }
  public void accessToReferenceAttribute_1(SNode node) {
    SNode referenceMacro = AttributeOperations.getAttribute(node, new IAttributeDescriptor.LinkAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd7f44d616L, "jetbrains.mps.lang.generator.structure.ReferenceMacro"), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c77f1e98L, 0xf8cc6bf960L, "variableDeclaration")));
    SNode referenceMacro1 = AttributeOperations.getAttribute(node, new IAttributeDescriptor.LinkAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd7f44d616L, "jetbrains.mps.lang.generator.structure.ReferenceMacro"), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c77f1e98L, 0xf8cc6bf960L, "variableDeclaration")));
  }
  public void accessToReferenceAttribute_2(SNode node) {
    SNode refMacro = null;
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.LinkAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd7f44d616L, "jetbrains.mps.lang.generator.structure.ReferenceMacro"), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c77f1e98L, 0xf8cc6bf960L, "variableDeclaration")), refMacro);
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.LinkAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd7f44d616L, "jetbrains.mps.lang.generator.structure.ReferenceMacro"), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c77f1e98L, 0xf8cc6bf960L, "variableDeclaration")), refMacro);
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.LinkAttribute(MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfd7f44d616L, "jetbrains.mps.lang.generator.structure.ReferenceMacro"), MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8c77f1e98L, 0xf8cc6bf960L, "variableDeclaration")), refMacro);
  }
  public void other(SNode node) {
    SNodeOperations.isAttribute(node);
    List<SNode> nodes = AttributeOperations.getAttributeList(node, new IAttributeDescriptor.AllAttributes());
    SNode firstNode = ListSequence.fromList(AttributeOperations.getAttributeList(node, new IAttributeDescriptor.AllAttributes())).first();
  }
}