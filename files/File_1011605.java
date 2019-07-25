package jetbrains.mps.build.actions;

/*Generated by MPS */

import jetbrains.mps.openapi.actions.descriptor.PasteWrapper;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public final class wrappers_PasteWrapper_2 implements PasteWrapper {
  @Override
  public SAbstractConcept getSourceConcept() {
    return MetaAdapterFactory.getConcept(0x798100da4f0a421aL, 0xb99171f8c50ce5d2L, 0x11779a1dbcff551aL, "jetbrains.mps.build.structure.BuildSource_JavaJar");
  }
  @Override
  public SAbstractConcept getTargetConcept() {
    return MetaAdapterFactory.getConcept(0x798100da4f0a421aL, 0xb99171f8c50ce5d2L, 0x3395e884b6185c40L, "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar");
  }
  @Override
  public SNode wrap(SNode sourceNode) {
    SNode nn = SModelOperations.createNewNode(SNodeOperations.getModel(sourceNode), null, MetaAdapterFactory.getConcept(0x798100da4f0a421aL, 0xb99171f8c50ce5d2L, 0x3395e884b6185c40L, "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar"));
    SLinkOperations.setTarget(nn, MetaAdapterFactory.getContainmentLink(0x798100da4f0a421aL, 0xb99171f8c50ce5d2L, 0x3395e884b6185c40L, 0x3395e884b6185c41L, "jar"), sourceNode);
    return nn;
  }
}