/** 
 * Destructure and apply this product to a function accepting the same number of arguments as this product's slots. This can be thought of as a kind of dual to uncurrying a function and applying a product to it.
 * @param fn  the function to apply
 * @param < R > the return type of the function
 * @return the result of applying the destructured product to the function
 */
default <R>R into(Fn4<? super _1,? super _2,? super _3,? super _4,? extends R> fn){
  return Product3.super.<Fn1<? super _4,? extends R>>into(fn).apply(_4());
}
