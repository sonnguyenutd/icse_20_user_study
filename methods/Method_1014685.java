/** 
 * ?byte[]?????????? 
 * @param bytes byte[] 
 * @param radix ???????????Character.MIN_RADIX?Character.MAX_RADIX????????10?? 
 * @return ???????
 */
public static String binary(byte[] bytes,int radix){
  return new BigInteger(1,bytes).toString(radix);
}
