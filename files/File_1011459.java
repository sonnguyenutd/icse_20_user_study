package jetbrains.mps.lang.smodel.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.model.SNode;

public class ModelReferenceExpression_DataFlow extends DataFlowBuilder {
  public void build(final DataFlowBuilderContext _context) {
    if ((SLinkOperations.getTarget(_context.getNode(), MetaAdapterFactory.getContainmentLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x7c3f2da20e92b62L, 0x13bfe1ec0ddbc5f8L, "repo")) != null)) {
      _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), MetaAdapterFactory.getContainmentLink(0x7866978ea0f04cc7L, 0x81bc4d213d9375e1L, 0x7c3f2da20e92b62L, 0x13bfe1ec0ddbc5f8L, "repo")));
    }
  }
}