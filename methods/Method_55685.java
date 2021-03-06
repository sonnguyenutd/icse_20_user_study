/** 
 * Like  {@link #memByteBufferNT1(long,int) memByteBufferNT1}, but returns  {@code null} if {@code address} is {@link #NULL}. 
 */
@Nullable public static ByteBuffer memByteBufferNT1Safe(long address,int maxLength){
  return address == NULL ? null : memByteBuffer(address,memLengthNT1(address,maxLength));
}
