/** 
 * Verify the order against the exchange meta data. Most implementations will require that  {@link org.knowm.xchange.Exchange#remoteInit()} be called before this method
 */
default void verifyOrder(MarketOrder marketOrder){
  throw new NotYetImplementedForExchangeException();
}
