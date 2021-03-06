/** 
 * Returns a Caffeine cache wrapped in a Guava  {@link LoadingCache} facade.
 * @param builder the configured cache builder
 * @param loader the cache loader used to obtain new values
 * @return a cache exposed under the Guava APIs
 */
@NonNull public static <K,V,K1 extends K,V1 extends V>LoadingCache<K1,V1> build(@NonNull Caffeine<K,V> builder,@NonNull CacheLoader<? super K1,V1> loader){
  @SuppressWarnings("unchecked") CacheLoader<K1,V1> castedLoader=(CacheLoader<K1,V1>)loader;
  return build(builder,hasLoadAll(castedLoader) ? new BulkLoader<>(castedLoader) : new SingleLoader<>(castedLoader));
}
