package jetbrains.mps.scope;

/*Generated by MPS */

import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Collections;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.smodel.behaviour.BHReflection;
import jetbrains.mps.core.aspects.behaviour.SMethodTrimmedId;

public abstract class ListScope extends Scope {
  private Iterable<SNode> elements;
  public ListScope(Iterable<SNode> elements) {
    if (elements == null) {
      this.elements = Sequence.fromIterable(Collections.<SNode>emptyList());
    } else {
      this.elements = elements;
    }
  }

  @Override
  public SNode resolve(SNode contextNode, @NotNull String refText) {
    SNode result = null;
    for (SNode n : elements) {
      String name = getName(n);
      if (refText.equals(name)) {
        if (result == null) {
          result = n;
        } else {
          return null;
        }
      }
    }
    return result;
  }

  @Override
  public Iterable<SNode> getAvailableElements(@Nullable String prefix) {
    List<SNode> result = new ArrayList<SNode>();
    for (SNode n : elements) {
      String name = getName(n);
      if (name == null) {
        continue;
      }
      if (prefix == null || name.startsWith(prefix)) {
        ListSequence.fromList(result).addElement(n);
      }
    }
    return result;
  }

  @Override
  public String getReferenceText(SNode contextNode, SNode node) {
    if (node == null) {
      return null;
    }

    String result = getName(node);
    for (SNode n : elements) {
      if (n == node) {
        continue;
      }
      String name = getName(n);
      if (name.equals(result)) {
        // ambiguity 
        return null;
      }
    }
    return result;
  }

  public abstract String getName(SNode child);

  public static ListScope forNamedElements(Iterable<SNode> elements) {
    return new ListScope(elements) {
      @Override
      public String getName(SNode child) {
        return SPropertyOperations.getString(SNodeOperations.cast(child, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, "jetbrains.mps.lang.core.structure.INamedConcept")), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name"));
      }
    };
  }

  /**
   * Scope of elements that can be resolved by either IResolveInfo#resolveInfo, INamedConcept#name or BC#getPresentation()
   * 
   * Introduced as a counterpart to returning list of nodes in ConstraintFunction_ReferentSearchScope_Factory
   */
  public static ListScope forResolvableElements(Iterable<SNode> elements) {
    return new ListScope(elements) {
      public String getName(SNode child) {
        String resolveInfo = null;
        if (SNodeOperations.isInstanceOf(child, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x116b17c6e46L, "jetbrains.mps.lang.core.structure.IResolveInfo"))) {
          resolveInfo = SPropertyOperations.getString((SNodeOperations.as(child, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x116b17c6e46L, "jetbrains.mps.lang.core.structure.IResolveInfo"))), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x116b17c6e46L, 0x116b17cd415L, "resolveInfo"));
        }
        if ((resolveInfo != null && resolveInfo.length() > 0)) {
          return resolveInfo;
        }
        if (SNodeOperations.isInstanceOf(child, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, "jetbrains.mps.lang.core.structure.INamedConcept"))) {
          resolveInfo = SPropertyOperations.getString((SNodeOperations.as(child, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, "jetbrains.mps.lang.core.structure.INamedConcept"))), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name"));
        }
        if ((resolveInfo != null && resolveInfo.length() > 0)) {
          return resolveInfo;
        }
        return ((String) (String) BHReflection.invoke0(child, MetaAdapterFactory.getConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, "jetbrains.mps.lang.core.structure.BaseConcept"), SMethodTrimmedId.create("getPresentation", null, "hEwIMiw")));
      }
    };
  }
}
