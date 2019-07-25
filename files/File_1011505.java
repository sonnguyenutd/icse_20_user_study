package jetbrains.mps.lang.structure.typesystem;

/*Generated by MPS */

import jetbrains.mps.errors.QuickFix_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.structure.behavior.AttributeDesignTimeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class FixAttributeInfo_QuickFix extends QuickFix_Runtime {
  public FixAttributeInfo_QuickFix() {
    super(new SNodePointer("r:00000000-0000-4000-0000-011c8959028f(jetbrains.mps.lang.structure.typesystem)", "7588428831943086210"));
  }
  public String getDescription(SNode node) {
    return ((((AttributeOperations.getAttribute(SNodeOperations.cast(node, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")), new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x29889a701b928195L, "jetbrains.mps.lang.structure.structure.AttributeInfo"))) == null)) ? "Add" : "Remove")) + " Attribute Info";
  }
  public void execute(SNode node) {
    SNode conceptDeclaration = SNodeOperations.cast(node, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, "jetbrains.mps.lang.structure.structure.ConceptDeclaration"));
    if (AttributeDesignTimeOperations.isAttributeDeclaration(conceptDeclaration) && (AttributeOperations.getAttribute(conceptDeclaration, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x29889a701b928195L, "jetbrains.mps.lang.structure.structure.AttributeInfo"))) == null)) {
      AttributeOperations.setAttribute(SNodeOperations.cast(node, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")), new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x29889a701b928195L, "jetbrains.mps.lang.structure.structure.AttributeInfo")), SConceptOperations.createNewNode(MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x29889a701b928195L, "jetbrains.mps.lang.structure.structure.AttributeInfo")));
    }
    if (!(AttributeDesignTimeOperations.isAttributeDeclaration(conceptDeclaration)) && (AttributeOperations.getAttribute(conceptDeclaration, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x29889a701b928195L, "jetbrains.mps.lang.structure.structure.AttributeInfo"))) != null)) {
      SNodeOperations.deleteNode(AttributeOperations.getAttribute(SNodeOperations.cast(node, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")), new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x29889a701b928195L, "jetbrains.mps.lang.structure.structure.AttributeInfo"))));
    }
  }
}