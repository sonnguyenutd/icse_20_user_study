package jetbrains.mps.baseLanguage.collections.trove.runtime;

/*Generated by MPS */

import java.util.AbstractList;
import java.util.List;
import java.io.Serializable;
import gnu.trove.TFloatArrayList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;

public class TFloatArrayListDecorator extends AbstractList<Float> implements List<Float>, Serializable {
  private static final long serialVersionUID = -2243271180253209272L;
  private TFloatArrayList primList;
  public TFloatArrayListDecorator() {
  }
  public TFloatArrayListDecorator(TFloatArrayList prim) {
    this.primList = prim;
  }
  @Override
  protected void removeRange(int fromIdx, int toIdx) {
    this.primList.remove(fromIdx, toIdx - fromIdx);
  }
  @Override
  public int hashCode() {
    return super.hashCode();
  }
  @Override
  public boolean equals(Object that) {
    if (that instanceof TFloatArrayListDecorator && this.primList == ((TFloatArrayListDecorator) that).primList) {
      return true;
    }
    return super.equals(that);
  }
  @Override
  public List<Float> subList(int fromIdx, int toIdx) {
    return new TFloatArrayListDecorator(this.primList.subList(fromIdx, toIdx));
  }
  @Override
  public ListIterator<Float> listIterator() {
    return new TFloatArrayListDecorator.TFloatListIterator(0);
  }
  @Override
  public void clear() {
    this.primList.clear();
  }
  @Override
  public int lastIndexOf(Object e) {
    return this.primList.lastIndexOf(this.unwrap(e));
  }
  @Override
  public int indexOf(Object e) {
    return this.primList.indexOf(this.unwrap(e));
  }
  @Override
  public boolean add(Float e) {
    this.primList.add(this.unwrap(e));
    return true;
  }
  @Override
  public Iterator<Float> iterator() {
    return this.listIterator();
  }
  @Override
  public boolean addAll(int idx, Collection<? extends Float> that) {
    return super.addAll(idx, that);
  }
  @Override
  public Float remove(int e) {
    return this.primList.remove(e);
  }
  @Override
  public void add(int index, Float e) {
    this.primList.insert(index, this.unwrap(e));
  }
  @Override
  public Float set(int p0, Float p1) {
    return super.set(p0, p1);
  }
  @Override
  public Float get(int index) {
    return this.wrap(this.primList.get(index));
  }
  @Override
  public String toString() {
    return this.primList.toString();
  }
  @Override
  public boolean retainAll(Collection<?> that) {
    return super.retainAll(that);
  }
  @Override
  public boolean removeAll(Collection<?> that) {
    return super.removeAll(that);
  }
  @Override
  public boolean addAll(Collection<? extends Float> that) {
    return super.addAll(that);
  }
  @Override
  public boolean containsAll(Collection<?> that) {
    return super.containsAll(that);
  }
  @Override
  public boolean remove(Object e) {
    return (e instanceof Float ? this.removePrim(this.unwrap(e)) : false);
  }
  @Override
  public <T extends Object> T[] toArray(T[] array) {
    return super.toArray(array);
  }
  @Override
  public Object[] toArray() {
    return super.toArray();
  }
  @Override
  public boolean contains(Object e) {
    return (e instanceof Float ? this.primList.contains(this.unwrap(e)) : false);
  }
  @Override
  public boolean isEmpty() {
    return this.primList.isEmpty();
  }
  public int size() {
    return this.primList.size();
  }
  public ListIterator<Float> listIterator(int index) {
    return new TFloatArrayListDecorator.TFloatListIterator(index);
  }
  protected boolean removePrim(float primValue) {
    int idx = this.primList.indexOf(primValue);
    if (idx >= 0) {
      this.primList.remove(idx);
      return true;
    }
    return false;
  }
  protected Float wrap(float primValue) {
    return Float.valueOf(primValue);
  }
  protected float unwrap(Object value) {
    return ((Float) value).floatValue();
  }
  public class TFloatListIterator implements ListIterator<Float> {
    private int nextIdx;
    public TFloatListIterator(int startAt) {
      this.nextIdx = startAt;
    }
    public void add(Float e) {
      throw new UnsupportedOperationException();
    }
    public void set(Float e) {
      throw new UnsupportedOperationException();
    }
    public void remove() {
      TFloatArrayListDecorator.this.primList.remove(this.nextIdx);
    }
    public int previousIndex() {
      return this.nextIdx - 1;
    }
    public int nextIndex() {
      return this.nextIdx;
    }
    public Float previous() {
      if (this.nextIdx > 0 && this.nextIdx <= TFloatArrayListDecorator.this.primList.size()) {
        return TFloatArrayListDecorator.this.wrap(TFloatArrayListDecorator.this.primList.get(--this.nextIdx));
      }
      throw new NoSuchElementException();
    }
    public boolean hasPrevious() {
      return this.nextIdx > 0 && this.nextIdx <= TFloatArrayListDecorator.this.primList.size();
    }
    public Float next() {
      if (this.nextIdx >= 0 && this.nextIdx < TFloatArrayListDecorator.this.primList.size()) {
        return TFloatArrayListDecorator.this.wrap(TFloatArrayListDecorator.this.primList.get(this.nextIdx++));
      }
      throw new NoSuchElementException();
    }
    public boolean hasNext() {
      return this.nextIdx >= 0 && this.nextIdx < TFloatArrayListDecorator.this.primList.size();
    }
  }
}