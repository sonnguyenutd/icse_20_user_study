/** 
 * Unsafe version of  {@link #NumChannels}. 
 */
public static int nNumChannels(long struct){
  return UNSAFE.getInt(null,struct + CUDA_ARRAY3D_DESCRIPTOR.NUMCHANNELS);
}
