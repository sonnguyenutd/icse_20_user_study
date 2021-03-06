/** 
 * Inserts one element into another <code>double</code> array.
 */
public static double[] insert(double[] dest,double src,int offset){
  double[] temp=new double[dest.length + 1];
  System.arraycopy(dest,0,temp,0,offset);
  temp[offset]=src;
  System.arraycopy(dest,offset,temp,offset + 1,dest.length - offset);
  return temp;
}
