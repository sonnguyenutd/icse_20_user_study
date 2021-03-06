/** 
 * Inserts one array into another by replacing specified offset.
 */
public static short[] insertAt(short[] dest,short[] src,int offset){
  short[] temp=new short[dest.length + src.length - 1];
  System.arraycopy(dest,0,temp,0,offset);
  System.arraycopy(src,0,temp,offset,src.length);
  System.arraycopy(dest,offset + 1,temp,src.length + offset,dest.length - offset - 1);
  return temp;
}
