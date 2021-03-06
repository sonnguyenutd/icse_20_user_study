package jetbrains.mps.lang.structure.findUsages;

/*Generated by MPS */

import jetbrains.mps.core.aspects.behaviour.api.AbstractConceptLike;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

/*package*/ abstract class AbstractConceptWrap implements AbstractConceptLike {
  private final SNode myPeer;

  protected AbstractConceptWrap(SNode peer) {
    myPeer = peer;
  }

  public SNode getPeer() {
    return myPeer;
  }

  @Override
  public String getName() {
    return SPropertyOperations.getString(myPeer, MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name"));
  }

  @Override
  public int hashCode() {
    return myPeer.hashCode();
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof AbstractConceptWrap) {
      return myPeer == ((AbstractConceptWrap) object).getPeer();
    }
    return false;
  }

  @NotNull
  public static AbstractConceptWrap wrap(SNode toWrap) {
    if (SNodeOperations.isInstanceOf(toWrap, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, "jetbrains.mps.lang.structure.structure.ConceptDeclaration"))) {
      return new ConceptWrap(SNodeOperations.cast(toWrap, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")));
    } else if (SNodeOperations.isInstanceOf(toWrap, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x1103556dcafL, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration"))) {
      return new InterfaceConceptWrap(SNodeOperations.cast(toWrap, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x1103556dcafL, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration")));
    }
    throw new IllegalArgumentException("Impossible to wrap the " + toWrap);
  }

  @Override
  public String toString() {
    return "AbstractConceptWrap{" + "myPeer=" + myPeer + "}";
  }
}
