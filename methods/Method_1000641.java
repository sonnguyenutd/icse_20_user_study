/** 
 * ??????????????????
 * @param ss ?????
 * @param s ???
 * @return ????
 */
public static boolean isin(String[] ss,String s){
  if (null == ss || ss.length == 0 || Strings.isBlank(s))   return false;
  for (  String w : ss)   if (s.equals(w))   return true;
  return false;
}
