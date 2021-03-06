package jetbrains.mps.lang.smodel.generator.smodelAdapter;

/*Generated by MPS */

import java.util.AbstractList;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.util.IterableUtil;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import java.util.Set;
import java.util.HashSet;
import java.util.NoSuchElementException;
import org.jetbrains.mps.openapi.model.SNodeUtil;
import java.util.ListIterator;

public abstract class AbstractMutableChildrenList extends AbstractList<SNode> {
  @Override
  public int size() {
    return IterableUtil.asCollection(children()).size();
  }

  public boolean isEmpty() {
    return !(childrenIterator().hasNext());
  }

  @Override
  public Iterator<SNode> iterator() {
    // TODO this is not fair, since there's no guarantee any iterator will work after we remove an element already returned by next() 
    // TODO it's better to somehow provide "remove" method for the result of SNode.getChildren(role), e.g. removing the "non-modifiable" contract 
    return new Iterator<SNode>() {
      private SNode last = null;
      private Iterator<SNode> ci = childrenIterator();

      @Override
      public boolean hasNext() {
        return ci.hasNext();
      }

      @Override
      public SNode next() {
        last = ci.next();
        return last;
      }

      @Override
      public void remove() {
        AbstractMutableChildrenList.this.remove(last);
      }
    };
  }

  @Override
  public abstract boolean add(SNode node);

  @Override
  public abstract boolean remove(Object o);

  @Override
  public boolean addAll(int index, Collection<? extends SNode> c) {
    if (index == 0) {
      ArrayList<SNode> toAdd = new ArrayList<SNode>();
      toAdd.addAll(c);
      for (int i = toAdd.size() - 1; i >= 0; i--) {
        addFirst(toAdd.get(i));
      }
      return true;
    }

    Iterator<SNode> iter = childrenIteratorShifted(index);
    if (iter.hasNext()) {
      SNode anchor = iter.next();
      for (SNode node : CollectionSequence.fromCollection(c)) {
        insertBefore(node, anchor);
      }
    } else {
      addAll(c);
    }
    return true;
  }

  @Override
  public boolean removeAll(Collection<?> collection) {
    boolean removed = false;
    for (Object obj : CollectionSequence.fromCollection(collection)) {
      removed |= remove(obj);
    }
    return removed;
  }

  @Override
  public boolean retainAll(Collection<?> collection) {
    Set<SNode> toRemove = new HashSet<SNode>(this);
    toRemove.removeAll(collection);
    return removeAll(toRemove);
  }

  @Override
  public void clear() {
    ArrayList<SNode> list = new ArrayList<SNode>(this);
    removeAll(list);
  }

  @Override
  public SNode get(int index) {
    try {
      return childrenIteratorShifted(index).next();
    } catch (NoSuchElementException e) {
      throw new IndexOutOfBoundsException("" + index);
    }
  }

  @Override
  public SNode set(int index, SNode node) {
    return SNodeUtil.replaceWithAnother(get(index), node);
  }

  @Override
  public void add(int index, SNode node) {
    if (index == 0) {
      addFirst(node);
      return;
    }
    Iterator<SNode> iter = childrenIteratorShifted(index);
    if (iter.hasNext()) {
      SNode anchor = iter.next();
      insertBefore(node, anchor);
    } else {
      add(node);
    }
  }

  @Override
  public SNode remove(int i) {
    SNode n = get(i);
    remove(n);
    return n;
  }

  @Override
  public int lastIndexOf(Object o) {
    if (!((o instanceof SNode))) {
      return -1;
    }
    SNode n = (SNode) o;

    int result = -1;
    Iterator<SNode> iter = childrenIterator();
    int i = -1;
    while (iter.hasNext()) {
      i++;
      SNode next = iter.next();
      if (o.equals(next)) {
        result = i;
      }
    }

    return result;
  }

  @Override
  public ListIterator<SNode> listIterator(int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
    return new AbstractMutableChildrenList.ForwardOnlyImmutableListIterator(childrenIteratorShifted(index), index);
  }

  private class ForwardOnlyImmutableListIterator implements ListIterator<SNode> {
    private Iterator<SNode> myChildIter;
    private int myIndex;

    private ForwardOnlyImmutableListIterator(Iterator<SNode> childIter, int index) {
      myChildIter = childIter;
      myIndex = index;
    }

    @Override
    public boolean hasPrevious() {
      throw new UnsupportedOperationException();
    }
    @Override
    public SNode previous() {
      throw new UnsupportedOperationException();
    }
    @Override
    public int nextIndex() {
      return myIndex;
    }
    @Override
    public int previousIndex() {
      return myIndex - 1;
    }
    @Override
    public void set(SNode object) {
      throw new UnsupportedOperationException();
    }
    @Override
    public void add(SNode object) {
      throw new UnsupportedOperationException();
    }
    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
    @Override
    public boolean hasNext() {
      return myChildIter.hasNext();
    }
    @Override
    public SNode next() {
      myIndex++;
      return myChildIter.next();
    }
  }

  private Iterator<SNode> childrenIteratorShifted(int index) throws IndexOutOfBoundsException {
    Iterator<SNode> iter = childrenIterator();
    try {
      for (int i = 0; i < index; i++) {
        iter.next();
      }
    } catch (NoSuchElementException e) {
      throw new IndexOutOfBoundsException("" + index);
    }
    return iter;
  }

  private Iterator<SNode> childrenIterator() {
    return (Iterator<SNode>) children().iterator();
  }

  protected abstract Iterable<? extends SNode> children();

  protected abstract void insertBefore(SNode node, SNode anchor);

  protected abstract void addFirst(SNode node);
}
