/** 
 * Unsafe version of  {@link #Depth(long) Depth}. 
 */
public static void nDepth(long struct,long value){
  memPutAddress(struct + CUDA_MEMCPY3D_PEER.DEPTH,value);
}
