package jetbrains.mps.lang.quotation.typesystem;

/*Generated by MPS */

import jetbrains.mps.errors.QuickFix_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class addLinkValue_QuickFix extends QuickFix_Runtime {
  public addLinkValue_QuickFix() {
    super(new SNodePointer("r:00000000-0000-4000-0000-011c8959034a(jetbrains.mps.lang.quotation.typesystem)", "8182547171709514600"));
  }
  public String getDescription(SNode node) {
    return "Initialize `" + SPropertyOperations.getString(((SNode) addLinkValue_QuickFix.this.getField("link")[0]), MetaAdapterFactory.getProperty(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979bd086aL, 0xf98052f333L, "role")) + "'";
  }
  public void execute(SNode node) {
    SNode val = SConceptOperations.createNewNode(MetaAdapterFactory.getConcept(0x3a13115c633c4c5cL, 0xbbcc75c4219e9555L, 0x4bb51009d20c8e1aL, "jetbrains.mps.lang.quotation.structure.NodeBuilderInitLink"));
    SLinkOperations.setTarget(val, MetaAdapterFactory.getReferenceLink(0x3a13115c633c4c5cL, 0xbbcc75c4219e9555L, 0x4bb51009d20c8e1aL, 0x4bb51009d20c8e1cL, "link"), ((SNode) addLinkValue_QuickFix.this.getField("link")[0]));
    ListSequence.fromList(SLinkOperations.getChildren(SNodeOperations.cast(node, MetaAdapterFactory.getConcept(0x3a13115c633c4c5cL, 0xbbcc75c4219e9555L, 0x4bb51009d20a4aa0L, "jetbrains.mps.lang.quotation.structure.NodeBuilderNode")), MetaAdapterFactory.getContainmentLink(0x3a13115c633c4c5cL, 0xbbcc75c4219e9555L, 0x4bb51009d20a4aa0L, 0x4bb51009d20b033bL, "values"))).addElement(val);
  }
}