package jetbrains.mps.execution.configurations.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.model.SNode;

public class RunConfigurationCreator_DataFlow extends DataFlowBuilder {
  public void build(final DataFlowBuilderContext _context) {
    _context.getBuilder().emitRead(SLinkOperations.getTarget(_context.getNode(), MetaAdapterFactory.getReferenceLink(0x22e72e4c0f6946ceL, 0x84036750153aa615L, 0x328e81d9f20cd1deL, 0x328e81d9f20cd1dfL, "configuration")), "r:a2b2ec6f-979b-40b3-95b7-73340d2d1923(jetbrains.mps.execution.configurations.dataFlow)/3665474332687279477");
    _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), MetaAdapterFactory.getContainmentLink(0x22e72e4c0f6946ceL, 0x84036750153aa615L, 0x328e81d9f20cd1deL, 0x758d43e19b4fdb6L, "configurationName")));
  }
}