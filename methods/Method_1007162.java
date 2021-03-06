/** 
 * Creates a vector-7 from a head and a tail.
 * @param head The value to put as the first element of the vector.
 * @param tail The vector representing all but the first element of the new vector.
 * @return The new vector.
 */
public static <A>V7<A> cons(final P1<A> head,final V6<A> tail){
  return new V7<>(head,tail);
}
