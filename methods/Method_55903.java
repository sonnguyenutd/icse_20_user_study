/** 
 * Unsafe version of  {@link #NumChannels(int) NumChannels}. 
 */
public static void nNumChannels(long struct,int value){
  UNSAFE.putInt(null,struct + CUDA_ARRAY_DESCRIPTOR.NUMCHANNELS,value);
}
