/** 
 * Unsafe version of  {@link #c3(float) c3}. 
 */
public static void nc3(long struct,float value){
  UNSAFE.putFloat(null,struct + AIMatrix4x4.C3,value);
}
