package jetbrains.mps.smodel;

/*Generated by MPS */

import java.util.Set;
import org.jetbrains.mps.openapi.model.SNode;
import java.util.HashSet;
import org.jetbrains.mps.openapi.model.SModel;
import org.jetbrains.mps.openapi.module.SModule;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import org.jetbrains.mps.openapi.model.SModelReference;
import java.util.function.Predicate;
import java.util.Collections;

/**
 * Scanner of a model with {@code ConceptDeclarations}to find cross-model dependencies.
 * Much like {@link jetbrains.mps.smodel.ModelDependencyScanner } albeit narrow tailored for structure models and extends relation between Language modules.
 */
public class ConceptDeclarationScanner {
  private final Set<SNode> myExternalConcepts = new HashSet<SNode>();
  private final Set<SNode> myExternalIfaces = new HashSet<SNode>();
  private final Set<SModel> myExtendedModels = new HashSet<SModel>();
  private final Set<SModule> myExtendedModules = new HashSet<SModule>();
  private boolean myExcludeLangCore = false;

  public ConceptDeclarationScanner() {
  }

  /**
   * As long as languages implicitly extend j.m.lang.core, any ConceptDeclaration implies import of
   * j.m.lang.core.structure.BaseConcept. 
   * By default, this scanner gives all cross-model dependencies, including one of {@code BaseConcept}.
   * However, generally, there's little use for explicit lang.core import and we can safely omit it.
   * 
   * @return {@code this} for convenience
   */
  public ConceptDeclarationScanner omitLangCore() {
    myExcludeLangCore = true;
    return this;
  }

  public ConceptDeclarationScanner scan(SModel m) {
    List<SNode> roots = SModelOperations.roots(m, null);
    for (SNode cd : SNodeOperations.ofConcept(roots, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, "jetbrains.mps.lang.structure.structure.ConceptDeclaration"))) {
      SNode ex = SLinkOperations.getTarget(cd, MetaAdapterFactory.getReferenceLink(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, 0xf979be93cfL, "extends"));
      // ex could be null if no explicit BaseConcept in super 
      if (ex != null && SNodeOperations.getModel(ex) != m) {
        myExternalConcepts.add(ex);
      }
      for (SNode icd : SLinkOperations.collect(SLinkOperations.getChildren(cd, MetaAdapterFactory.getContainmentLink(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0xf979ba0450L, 0x110358d693eL, "implements")), MetaAdapterFactory.getReferenceLink(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x110356fc618L, 0x110356fe029L, "intfc"))) {
        if (SNodeOperations.getModel(icd) != m) {
          myExternalIfaces.add(icd);
        }
      }
    }
    for (SNode icd : SNodeOperations.ofConcept(roots, MetaAdapterFactory.getConcept(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x1103556dcafL, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration"))) {
      for (SNode iface : SLinkOperations.collect(SLinkOperations.getChildren(icd, MetaAdapterFactory.getContainmentLink(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x1103556dcafL, 0x110356e9df4L, "extends")), MetaAdapterFactory.getReferenceLink(0xc72da2b97cce4447L, 0x8389f407dc1158b7L, 0x110356fc618L, 0x110356fe029L, "intfc"))) {
        if (SNodeOperations.getModel(iface) != m) {
          myExternalIfaces.add(iface);
        }
      }
    }
    for (SNode cd : myExternalConcepts) {
      myExtendedModels.add(SNodeOperations.getModel(cd));
    }
    // XXX for the time being, consider implements of a CD as 'extends' relation between the languages, although this needs extra consideration 
    // perhaps, shall not treat CD.implements (but still ICD.extends) as mandatory for 'extends' between languages, as it's common to see marker interfaces 
    // (like IMainClass) that bring (sometimes huge) dependency hierarchy for no added value. 
    for (SNode cd : myExternalIfaces) {
      myExtendedModels.add(SNodeOperations.getModel(cd));
    }
    if (myExcludeLangCore) {
      // here comes an odd way to deal with missing model-reference expression 
      final SModelReference langCoreStructureModelRef = new SNodePointer("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)", "1133920641626").getModelReference();

      myExtendedModels.removeIf(new Predicate<SModel>() {
        public boolean test(SModel m) {
          return langCoreStructureModelRef.equals(SModelOperations.getPointer(m));
        }
      });
    }
    for (SModel em : myExtendedModels) {
      myExtendedModules.add(em.getModule());
    }
    return this;
  }

  public Set<SModel> getDependencyModels() {
    return Collections.unmodifiableSet(myExtendedModels);
  }

  public Set<SModule> getDependencyModules() {
    return Collections.unmodifiableSet(myExtendedModules);
  }

  public Set<SNode> getExternalConcepts() {
    return Collections.unmodifiableSet(myExternalConcepts);
  }

  public Set<SNode> getExternalInterfaces() {
    return Collections.unmodifiableSet(myExternalIfaces);
  }
}