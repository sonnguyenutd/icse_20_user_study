/** 
 * This is really inefficient and not a good idea in OpenGL. Use get() and set() with a smaller image area, or call the filter on an image instead, and then draw that.
 */
@Override public void filter(int kind,float param){
  PImage temp=get();
  temp.filter(kind,param);
  set(0,0,temp);
}
