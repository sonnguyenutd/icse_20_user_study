package jetbrains.mps.lang.smodel.generator.smodelAdapter;

/*Generated by MPS */

import java.util.List;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.model.SModel;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import java.util.Collections;
import java.util.ArrayList;
import org.jetbrains.mps.util.Condition;
import org.jetbrains.mps.util.InstanceOfCondition;
import jetbrains.mps.util.ConditionalIterable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.mps.openapi.model.SNodeUtil;
import jetbrains.mps.util.IterableUtil;
import org.jetbrains.mps.openapi.model.SNodeId;
import jetbrains.mps.smodel.adapter.MetaAdapterByDeclaration;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.behaviour.BHReflection;
import org.jetbrains.mps.openapi.language.SConcept;
import org.jetbrains.mps.openapi.module.SModule;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.project.structure.stub.ProjectStructureBuilder;
import org.jetbrains.mps.openapi.model.SModelReference;

public final class SModelOperations {
  public SModelOperations() {
  }
  public static List<SNode> roots(SModel model, final SAbstractConcept concept) {
    if (model == null) {
      return Collections.emptyList();
    }
    List<SNode> list = new ArrayList<SNode>();
    Iterable<SNode> iterable = model.getRootNodes();
    if (concept != null) {
      Condition<SNode> cond = new InstanceOfCondition(concept).tolerateNulls();
      iterable = new ConditionalIterable<SNode>(iterable, cond);
    }
    for (SNode node : iterable) {
      list.add(node);
    }
    return list;
  }
  @NotNull
  public static List<SNode> rootsIncludingImported(@Nullable SModel model, @Nullable SAbstractConcept concept) {
    if (model == null) {
      return Collections.emptyList();
    }
    return allNodesIncludingImported(model, true, concept);
  }
  @NotNull
  public static List<SNode> nodesIncludingImported(@Nullable SModel model, @Nullable SAbstractConcept concept) {
    if (model == null) {
      return Collections.emptyList();
    }
    return allNodesIncludingImported(model, false, concept);
  }
  private static List<SNode> allNodesIncludingImported(SModel sModel, boolean roots, @Nullable SAbstractConcept concept) {
    List<SModel> modelsList = new ArrayList<SModel>();
    modelsList.add(sModel);
    List<SModel> modelDescriptors = jetbrains.mps.smodel.SModelOperations.allImportedModels(sModel);
    for (SModel descriptor : modelDescriptors) {
      modelsList.add(descriptor);
    }
    List<SNode> resultNodes = new ArrayList<SNode>();
    final Condition<SNode> instanceCondition = (concept == null ? null : new InstanceOfCondition(concept));
    for (SModel aModel : modelsList) {
      if (concept == null || roots) {
        ConditionalIterable<SNode> nodes = new ConditionalIterable<SNode>((roots ? aModel.getRootNodes() : SNodeUtil.getDescendants(aModel)), instanceCondition);
        resultNodes.addAll(IterableUtil.asList(nodes));
      } else {
        resultNodes.addAll(jetbrains.mps.smodel.SModelOperations.getNodes(aModel, concept));
      }
    }
    return resultNodes;
  }
  public static List<SNode> nodes(SModel model, final SAbstractConcept concept) {
    if (model == null) {
      return new ArrayList<SNode>();
    }
    if (concept != null) {
      return jetbrains.mps.smodel.SModelOperations.getNodes(model, concept);
    }
    List<SNode> result = new ArrayList<SNode>();
    for (SNode node : SNodeUtil.getDescendants(model)) {
      result.add(node);
    }
    return result;
  }
  public static SNode createNewNode(SModel model, SNodeId id, SAbstractConcept concept) {
    if (concept == null) {
      return null;
    }

    final SNode result;
    if (model != null) {
      result = model.createNode(MetaAdapterByDeclaration.asInstanceConcept(concept), id);
    } else {
      // legacy mechanism 
      result = SModelUtil_new.instantiateConceptDeclaration(concept, model, id, false);
    }
    if (result == null) {
      return null;
    }

    BHReflection.initNode(result);
    return result;
  }
  public static SNode createNewRootNode(SModel model, SConcept concept) {
    SNode newNode = createNewNode(model, null, concept);
    model.addRootNode(newNode);
    return newNode;
  }
  public static SNode addRootNode(SModel model, SNode node) {
    if (model != null && node != null) {
      model.addRootNode(node);
    }
    return node;
  }
  public static String getModelName(SModel model) {
    if (model == null) {
      return null;
    }
    return model.getName().getLongName();
  }
  public static SNode getModuleStub(SModel model) {
    SModule module = model.getModule();
    // FIXME  we have to reference javastub classes, as we don't want j.m.runtime solution to depend from j.m.project 
    // FIXME     though the true defect is that Model_GetModule operation (which uses this rt code) lives in lang.smodel that doesn't 
    // FIXME     expose j.m.project as its runtime. Likely, shall move Model_GetModule operation to a distinct language with j.m.project as RT 
    // FIXME     or to specify j.m.project as lang.smodel's RT. This method has to get moved into respective solution regardless. 
    // I don't want to create blank model so provide the original one as a node factory. As long as PSB doesn't change it, it's all the same. 
    // XXX the only defect with stateless approach is that each query gets a new instance, therefore n1.model.module != n1.model.module 
    // XXX Guess, we shall support any SModule here, but at the moment PSB deals with AbstractModule only 
    if (module instanceof AbstractModule) {
      return (SNode) new ProjectStructureBuilder((AbstractModule) module, model).convert();
    }
    return null;
  }
  public static SModelReference getPointer(SModel model) {
    if (model == null) {
      return null;
    }
    return model.getReference();
  }
}