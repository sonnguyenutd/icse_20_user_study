/** 
 * Returns whether the given point is above the plane the triangle is in.
 * @param pt the point to test
 * @return true if the point is below
 */
public boolean below(Vector3 pt){
  checkNotNull(pt);
  return normal.dot(pt) < b;
}
