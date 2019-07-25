package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilder;
import jetbrains.mps.lang.dataFlow.DataFlowBuilderContext;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.baseLanguage.behavior.BreakStatement__BehaviorDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class BreakStatement_DataFlow extends DataFlowBuilder {
  public void build(final DataFlowBuilderContext _context) {
    SNode statement = BreakStatement__BehaviorDescriptor.getLoopOrSwitch_idhEwIHwh.invoke(_context.getNode());
    if ((statement != null) && SNodeOperations.getNodeAncestor(statement, MetaAdapterFactory.getInterfaceConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11750ef8265L, "jetbrains.mps.baseLanguage.structure.IStatementListContainer"), false, false) == SNodeOperations.getNodeAncestor(_context.getNode(), MetaAdapterFactory.getInterfaceConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11750ef8265L, "jetbrains.mps.baseLanguage.structure.IStatementListContainer"), false, false)) {
      _context.getBuilder().emitJump(_context.getBuilder().after(statement), "r:00000000-0000-4000-0000-011c895902c2(jetbrains.mps.baseLanguage.dataFlow)/1206465263853");
    } else {
      _context.getBuilder().emitNop("r:00000000-0000-4000-0000-011c895902c2(jetbrains.mps.baseLanguage.dataFlow)/5090797586239216724");
    }
  }
}