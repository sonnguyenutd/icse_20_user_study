/** 
 * Creates a vector-6 from a head and a tail.
 * @param head The value to put as the first element of the vector.
 * @param tail The vector representing all but the first element of the new vector.
 * @return The new vector.
 */
public static <A>V6<A> cons(final P1<A> head,final V5<A> tail){
  return new V6<>(head,tail);
}
