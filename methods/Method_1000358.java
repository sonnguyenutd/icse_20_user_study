/** 
 * ??????? POJO ???????
 * @param type POJO ??
 * @param matcher ?????
 * @return ??
 */
public FieldFilter set(Class<?> type,FieldMatcher matcher){
  map.put(type,matcher);
  return this;
}
