package jetbrains.mps.vcs.diff;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.mps.openapi.model.SNodeId;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.language.SProperty;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.vcs.diff.changes.SetPropertyStructChange;
import org.jetbrains.mps.openapi.model.SReference;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import jetbrains.mps.internal.collections.runtime.ISelector;
import org.jetbrains.mps.openapi.model.SModelReference;
import jetbrains.mps.smodel.DynamicReference;
import jetbrains.mps.vcs.diff.changes.SetReferenceStructChange;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.mps.openapi.language.SContainmentLink;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.util.LongestCommonSubsequenceFinder;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.vcs.diff.changes.NodeGroupStructChange;
import java.util.Iterator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IMapping;
import org.jetbrains.mps.openapi.language.SDataType;
import org.jetbrains.mps.openapi.language.SType;

public class StructChangeSetBuilder {
  private StructChangeSetImpl myChangeSet;
  private List<ModelChange> myNewChanges = ListSequence.fromList(new ArrayList<ModelChange>());
  private Map<SNodeId, SNodeId> myOldToNewMap = MapSequence.fromMap(new HashMap<SNodeId, SNodeId>());
  private StructChangeSetBuilder(SNode oldNode, SNode newNode) {
    this(new StructChangeSetImpl(oldNode, newNode));
  }
  private StructChangeSetBuilder(StructChangeSetImpl changeSet) {
    myChangeSet = changeSet;
  }
  private void buildForProperties(SNode oldNode, SNode newNode) {
    Iterable<SProperty> oldProperties = oldNode.getProperties();
    Iterable<SProperty> newProperties = newNode.getProperties();
    for (SProperty p : Sequence.fromIterable(oldProperties).union(Sequence.fromIterable(newProperties))) {
      buildForProperty(oldNode, newNode, p);
    }
  }
  private void buildForProperty(SNode oldNode, SNode newNode, SProperty property) {
    if (!(equalsProperty(oldNode, newNode, property))) {
      ListSequence.fromList(myNewChanges).addElement(new SetPropertyStructChange(myChangeSet, oldNode.getNodeId(), newNode.getNodeId(), property, newNode.getProperty(property)));
    }
  }
  private void buildForReferences(Map<SNode, SNode> olToNewMap, SNode oldNode, SNode newNode) {
    List<SReference> oldReferences = (List<SReference>) oldNode.getReferences();
    List<SReference> newReferences = (List<SReference>) newNode.getReferences();
    for (SReferenceLink role : ListSequence.fromList(oldReferences).concat(ListSequence.fromList(newReferences)).select(new ISelector<SReference, SReferenceLink>() {
      public SReferenceLink select(SReference r) {
        return r.getLink();
      }
    }).distinct()) {
      buildForReference(olToNewMap, oldNode, newNode, role);
    }
  }
  private void buildForReference(Map<SNode, SNode> oldToNewMap, SNode oldNode, SNode newNode, SReferenceLink role) {
    SReference oldReference = oldNode.getReference(role);
    SReference newReference = newNode.getReference(role);
    if (!(equalsReference(oldReference, newReference, oldToNewMap, false))) {
      SModelReference targetModel = check_okvhpb_a0a0c0i(newReference);
      SNodeId targetId = (newReference instanceof DynamicReference ? null : check_okvhpb_a0a1a2a8(newReference));
      ListSequence.fromList(myNewChanges).addElement(new SetReferenceStructChange(myChangeSet, oldNode.getNodeId(), newNode.getNodeId(), role, targetModel, targetId, check_okvhpb_g0a0a2a2a8(((jetbrains.mps.smodel.SReference) newReference))));
    }
  }
  private void buildForNode(final Map<SNode, SNode> oldToNewMap, @NotNull final SNode oldNode, @NotNull final SNode newNode) {
    // updates oldToNewMap with new mappings 
    if (!(Objects.equals(SNodeOperations.getConcept(oldNode), SNodeOperations.getConcept(newNode)))) {
      // todo: should be whole node change instead of going into details... 
    }
    MapSequence.fromMap(oldToNewMap).put(oldNode, newNode);

    buildForProperties(oldNode, newNode);
    buildForReferences(oldToNewMap, oldNode, newNode);

    final Map<SContainmentLink, List<SNode>> roleToOldChildCollection = ChangeSetBuilder.getRoleToChildCollectionMap(oldNode);
    final Map<SContainmentLink, List<SNode>> roleToNewChildCollection = ChangeSetBuilder.getRoleToChildCollectionMap(newNode);

    SetSequence.fromSet(MapSequence.fromMap(roleToOldChildCollection).keySet()).concat(SetSequence.fromSet(MapSequence.fromMap(roleToNewChildCollection).keySet())).distinct().visitAll(new IVisitor<SContainmentLink>() {
      public void visit(SContainmentLink role) {
        buildForNodeRole(oldToNewMap, roleToOldChildCollection.getOrDefault(role, ListSequence.fromList(new ArrayList<SNode>())), roleToNewChildCollection.getOrDefault(role, ListSequence.fromList(new ArrayList<SNode>())), oldNode.getNodeId(), newNode.getNodeId(), role);
      }
    });

  }

  private void buildForNodeRole(Map<SNode, SNode> oldToNewMap, List<SNode> oldChildren, List<SNode> newChildren, SNodeId parentId, SNodeId newParentId, SContainmentLink role) {
    // updates oldToNewMap with new mappings 
    final Map<SNode, Integer> nodeClasses = MapSequence.fromMap(new HashMap<SNode, Integer>());
    int i = 1;
    Map<SNode, SNode> old2NewMap = MapSequence.fromMap(new HashMap<SNode, SNode>());
    MapSequence.fromMap(old2NewMap).putAll(oldToNewMap);
outer:
    for (SNode node : ListSequence.fromList(oldChildren).concat(ListSequence.fromList(newChildren))) {
      for (SNode nodeClass : SetSequence.fromSet(MapSequence.fromMap(nodeClasses).keySet())) {
        if (equalsNodeStructure(node, nodeClass, old2NewMap, false)) {
          MapSequence.fromMap(nodeClasses).put(node, MapSequence.fromMap(nodeClasses).get(nodeClass));
          continue outer;
        }
      }
      MapSequence.fromMap(nodeClasses).put(node, i++);
    }

    List<Integer> oldClasses = ListSequence.fromList(oldChildren).select(new ISelector<SNode, Integer>() {
      public Integer select(SNode n) {
        return MapSequence.fromMap(nodeClasses).get(n);
      }
    }).toListSequence();
    List<Integer> newClasses = ListSequence.fromList(newChildren).select(new ISelector<SNode, Integer>() {
      public Integer select(SNode n) {
        return MapSequence.fromMap(nodeClasses).get(n);
      }
    }).toListSequence();
    LongestCommonSubsequenceFinder<Integer> finder = new LongestCommonSubsequenceFinder<Integer>(oldClasses, newClasses);

    // add matched Nodes 
    List<Tuples._2<Integer, Integer>> commonIndices = finder.getCommonIndices();
    for (Tuples._2<Integer, Integer> ix : ListSequence.fromList(commonIndices)) {
      addMatchedNodes(oldToNewMap, ListSequence.fromList(oldChildren).getElement((int) ix._0()), ListSequence.fromList(newChildren).getElement((int) ix._1()));
    }
    // Finding insertings, deletings and replacings 
    List<Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>>> differentIndices = finder.getDifferentIndices();
    for (Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>> indices : ListSequence.fromList(differentIndices)) {
      Tuples._2<Integer, Integer> oldIndices = indices._0();
      Tuples._2<Integer, Integer> newIndices = indices._1();

      List<SConcept> oldC = ListSequence.fromList(oldChildren).page((int) oldIndices._0(), (int) oldIndices._1()).select(new ISelector<SNode, SConcept>() {
        public SConcept select(SNode n) {
          return n.getConcept();
        }
      }).toListSequence();
      List<SConcept> newC = ListSequence.fromList(newChildren).page((int) newIndices._0(), (int) newIndices._1()).select(new ISelector<SNode, SConcept>() {
        public SConcept select(SNode n) {
          return n.getConcept();
        }
      }).toListSequence();
      LongestCommonSubsequenceFinder<SConcept> finder2 = new LongestCommonSubsequenceFinder<SConcept>(oldC, newC);
      // concepts were not matched: 
      for (Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>> ixs : ListSequence.fromList(finder2.getDifferentIndices())) {
        ListSequence.fromList(myNewChanges).addElement(new NodeGroupStructChange(myChangeSet, parentId, newParentId, role, (int) oldIndices._0() + (int) ixs._0()._0(), (int) oldIndices._0() + (int) ixs._0()._1(), (int) newIndices._0() + (int) ixs._1()._0(), (int) newIndices._0() + (int) ixs._1()._1()));
      }
      // Finding changes for "matched" children 
      for (Tuples._2<Integer, Integer> ixs : ListSequence.fromList(finder2.getCommonIndices())) {
        buildForNode(oldToNewMap, ListSequence.fromList(oldChildren).getElement((int) oldIndices._0() + (int) ixs._0()), ListSequence.fromList(newChildren).getElement((int) newIndices._0() + (int) ixs._1()));
      }
    }
  }
  private void addMatchedNodes(Map<SNode, SNode> oldToNewNodes, SNode oldNode, SNode newNode) {
    MapSequence.fromMap(oldToNewNodes).put(oldNode, newNode);

    Map<SContainmentLink, List<SNode>> roleToOldChildCollection = ChangeSetBuilder.getRoleToChildCollectionMap(oldNode);
    Map<SContainmentLink, List<SNode>> roleToNewChildCollection = ChangeSetBuilder.getRoleToChildCollectionMap(newNode);

    for (SContainmentLink role : SetSequence.fromSet(MapSequence.fromMap(roleToOldChildCollection).keySet()).concat(SetSequence.fromSet(MapSequence.fromMap(roleToNewChildCollection).keySet())).distinct()) {
      List<SNode> ch1List = roleToOldChildCollection.getOrDefault(role, ListSequence.fromList(new ArrayList<SNode>()));
      List<SNode> ch2List = roleToNewChildCollection.getOrDefault(role, ListSequence.fromList(new ArrayList<SNode>()));
      {
        Iterator<SNode> ch1_it = ListSequence.fromList(ch1List).iterator();
        Iterator<SNode> ch2_it = ListSequence.fromList(ch2List).iterator();
        SNode ch1_var;
        SNode ch2_var;
        while (ch1_it.hasNext() && ch2_it.hasNext()) {
          ch1_var = ch1_it.next();
          ch2_var = ch2_it.next();
          addMatchedNodes(oldToNewNodes, ch1_var, ch2_var);
        }
      }
    }
  }
  private SNode getOldNode() {
    return myChangeSet.getOldModel().getNode(myChangeSet.getOldNodeId());
  }
  private SNode getNewNode() {
    return myChangeSet.getNewModel().getNode(myChangeSet.getNewNodeId());
  }

  private void removeMatchedRefChanges() {
    for (SetReferenceStructChange ch : ListSequence.fromList(myNewChanges).ofType(SetReferenceStructChange.class).toListSequence()) {
      SReference oldRef = myChangeSet.getOldModel().getNode(ch.getAffectedNodeId(false)).getReference(ch.getRoleLink());
      if (oldRef == null) {
        continue;
      }
      if (Objects.equals(oldRef.getTargetSModelReference(), SModelOperations.getPointer(myChangeSet.getOldModel())) && Objects.equals(ch.getTargetModelReference(), SModelOperations.getPointer(myChangeSet.getNewModel())) && Objects.equals(MapSequence.fromMap(myOldToNewMap).get(oldRef.getTargetNodeId()), ch.getTargetNodeId())) {
        // ?? should the resolveInfo be the same ?? 
        ListSequence.fromList(myNewChanges).removeElement(ch);
      }
    }
  }
  private void build(boolean withOpposite) {
    Map<SNode, SNode> oldToNewMap = MapSequence.fromMap(new HashMap<SNode, SNode>());
    buildForNode(oldToNewMap, getOldNode(), getNewNode());
    for (IMapping<SNode, SNode> node : MapSequence.fromMap(oldToNewMap)) {
      MapSequence.fromMap(myOldToNewMap).put(node.key().getNodeId(), node.value().getNodeId());
    }
    removeMatchedRefChanges();
    commit();
    if (withOpposite) {
      myChangeSet.buildOppositeChangeSet();
    }
  }
  private void commit() {
    ListSequence.fromList(myNewChanges).visitAll(new IVisitor<ModelChange>() {
      public void visit(ModelChange it) {
        myChangeSet.add(it);
      }
    });
    myChangeSet.buildNodeMaps(myOldToNewMap);
    ListSequence.fromList(myNewChanges).clear();
    MapSequence.fromMap(myOldToNewMap).clear();
  }

  public static StructChangeSet buildChangeSet(SNode oldNode, SNode newNode, boolean withOpposite) {
    StructChangeSetBuilder builder = new StructChangeSetBuilder(oldNode, newNode);
    builder.build(withOpposite);
    return builder.myChangeSet;
  }
  public static void rebuildChangeSet(StructChangeSet changeSet) {
    StructChangeSetImpl impl = (StructChangeSetImpl) changeSet;
    impl.clear();
    impl.clearOppositeChangeSet();
    StructChangeSetBuilder builder = new StructChangeSetBuilder(impl);
    builder.build(true);
  }

  private static boolean equalsProperty(SNode n1, SNode n2, SProperty property) {
    String propValue1 = n1.getProperty(property);
    String propValue2 = n2.getProperty(property);
    SDataType type = property.getType();
    Object value1 = type.fromString(propValue1);
    Object value2 = type.fromString(propValue2);
    if (value1 == SType.NOT_A_VALUE || value2 == SType.NOT_A_VALUE) {
      // NOT_A_VALUE can be when raw string property value is invalid, this doesn't mean that both values are equal 
      //  so we use raw values to compare 
      value1 = propValue1;
      value2 = propValue2;
    }
    return Objects.equals(value1, value2);
  }

  private static boolean equalsReference(SReference ref1, SReference ref2, final Map<SNode, SNode> oldToNewMap, boolean easy) {
    if (ref1 == null || ref2 == null) {
      return false;
    }


    SNode target1 = ref1.getTargetNode();
    SNode target2 = ref2.getTargetNode();
    return target1 == target2 || MapSequence.fromMap(oldToNewMap).get(target1) == target2 || easy && ListSequence.fromList(SNodeOperations.getNodeAncestors(target1, null, true)).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return MapSequence.fromMap(oldToNewMap).get(it);
      }
    }).intersect(ListSequence.fromList(SNodeOperations.getNodeAncestors(target2, null, true))).isNotEmpty();
  }

  private static boolean equalsNodeStructure(@NotNull SNode n1, @NotNull SNode n2, Map<SNode, SNode> oldToNewMap, boolean easyRef) {
    // updates oldToNewMap with new mapping if matched 
    if (!(Objects.equals(SNodeOperations.getConcept(n1), SNodeOperations.getConcept(n2)))) {
      return false;
    }
    Map<SNode, SNode> tempMap = MapSequence.fromMap(new HashMap<SNode, SNode>());
    MapSequence.fromMap(tempMap).putAll(oldToNewMap);
    MapSequence.fromMap(tempMap).put(n1, n2);

    Iterable<SProperty> n1Properties = n1.getProperties();
    Iterable<SProperty> n2Properties = n2.getProperties();
    for (SProperty prop : Sequence.fromIterable(n1Properties).union(Sequence.fromIterable(n2Properties))) {
      if (!((equalsProperty(n1, n2, prop)))) {
        return false;
      }
    }

    List<SReference> n1References = (List<SReference>) n1.getReferences();
    List<SReference> n2References = (List<SReference>) n2.getReferences();
    for (SReferenceLink role : ListSequence.fromList(n1References).concat(ListSequence.fromList(n2References)).select(new ISelector<SReference, SReferenceLink>() {
      public SReferenceLink select(SReference r) {
        return r.getLink();
      }
    }).distinct()) {
      if (!(equalsReference(n1.getReference(role), n2.getReference(role), tempMap, easyRef))) {
        return false;
      }
    }

    Map<SContainmentLink, List<SNode>> roleToN1ChildCollection = ChangeSetBuilder.getRoleToChildCollectionMap(n1);
    Map<SContainmentLink, List<SNode>> roleToN2ChildCollection = ChangeSetBuilder.getRoleToChildCollectionMap(n2);


    for (SContainmentLink role : SetSequence.fromSet(MapSequence.fromMap(roleToN1ChildCollection).keySet()).concat(SetSequence.fromSet(MapSequence.fromMap(roleToN2ChildCollection).keySet())).distinct()) {
      List<SNode> ch1List = roleToN1ChildCollection.getOrDefault(role, ListSequence.fromList(new ArrayList<SNode>()));
      List<SNode> ch2List = roleToN2ChildCollection.getOrDefault(role, ListSequence.fromList(new ArrayList<SNode>()));
      if (ListSequence.fromList(ch1List).count() != ListSequence.fromList(ch2List).count()) {
        return false;
      }
      {
        Iterator<SNode> ch1_it = ListSequence.fromList(ch1List).iterator();
        Iterator<SNode> ch2_it = ListSequence.fromList(ch2List).iterator();
        SNode ch1_var;
        SNode ch2_var;
        while (ch1_it.hasNext() && ch2_it.hasNext()) {
          ch1_var = ch1_it.next();
          ch2_var = ch2_it.next();
          if (!(equalsNodeStructure(ch1_var, ch2_var, tempMap, easyRef))) {
            return false;
          }
        }
      }
    }
    MapSequence.fromMap(oldToNewMap).putAll(tempMap);
    return true;
  }
  private static SModelReference check_okvhpb_a0a0c0i(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getTargetSModelReference();
    }
    return null;
  }
  private static SNodeId check_okvhpb_a0a1a2a8(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getTargetNodeId();
    }
    return null;
  }
  private static String check_okvhpb_g0a0a2a2a8(jetbrains.mps.smodel.SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getResolveInfo();
    }
    return null;
  }
}