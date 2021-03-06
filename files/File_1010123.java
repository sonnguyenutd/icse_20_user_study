package jetbrains.mps.ide.findusages.findalgorithm.finders;

/*Generated by MPS */

import org.jetbrains.mps.annotations.Immutable;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Collections;
import jetbrains.mps.util.annotation.ToRemove;

@Immutable
public class SearchedObjects<K> {
  private final Set<K> mySearchedNodes;

  public SearchedObjects(@NotNull Collection<K> collection) {
    mySearchedNodes = new LinkedHashSet<K>(collection);
  }

  public Set<K> getElements() {
    return Collections.unmodifiableSet(mySearchedNodes);
  }

  /**
   * 
   * @deprecated mutates
   */
  @ToRemove(version = 2018.3)
  @Deprecated
  public Set<K> getElements0() {
    return mySearchedNodes;
  }

  public boolean contains(K k) {
    return mySearchedNodes.contains(k);
  }

  @NotNull
  public static <K> SearchedObjects<K> union(SearchedObjects<K>... array) {
    Set<K> searchedNodes = new LinkedHashSet<K>();
    for (SearchedObjects<K> element : array) {
      searchedNodes.addAll(element.mySearchedNodes);
    }
    return new SearchedObjects<K>(searchedNodes);
  }
}
