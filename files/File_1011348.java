package jetbrains.mps.lang.scopes.runtime;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import java.util.List;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Collections;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

public abstract class SimpleScope extends Scope {
  private final List<SNode> nodes;
  public SimpleScope(Iterable<SNode> nodes) {
    this.nodes = ListSequence.fromList(new ArrayList<SNode>());

    // Checking nodes var for null first because null value can be easily passed here as a result of the combination of 
    // smodel language calls & bahaviour method calls on top of it like: 
    //     sNodeType.concept.getPropertyDeclarations() 
    // in this case, if conept (reference inside sNodeType) is null (not specified yet) then the result of 
    // .getPropertyDeclarations() method call will be null despite null-safety inside any of smodel/collection 
    // languages returning empty collections in similar cases. 
    if (nodes != null) {
      for (SNode node : nodes) {
        if ((node != null)) {
          this.nodes.add(node);
        }
      }
    }
  }
  public SimpleScope(SNode node) {
    if ((node != null)) {
      nodes = Collections.singletonList(node);
    } else {
      nodes = Collections.emptyList();
    }
  }
  @Override
  public Iterable<SNode> getAvailableElements(@Nullable String prefix) {
    if (prefix == null) {
      // todo: copy nodes? immutable list? 
      return nodes;
    }

    List<SNode> result = new ArrayList<SNode>();
    for (SNode node : nodes) {
      if ((node != null) && getReferenceText(node) != null) {
        String refText = getReferenceText(node);
        if (refText != null && refText.startsWith(prefix)) {
          ListSequence.fromList(result).addElement(node);
        }
      }
    }
    return result;
  }
  @Nullable
  @Override
  public SNode resolve(SNode contextNode, @NotNull String refText) {
    // todo: maybe map name -> node? 
    SNode result = null;
    for (SNode node : nodes) {
      if (refText.equals(getReferenceText(node))) {
        if (result == null) {
          result = node;
        } else {
          // ambiguity 
          return null;
        }
      }
    }
    return result;
  }
  @Nullable
  public abstract String getReferenceText(@NotNull SNode target);
  @Nullable
  @Override
  public String getReferenceText(SNode contextNode, @NotNull SNode target) {
    return getReferenceText(target);
  }
}