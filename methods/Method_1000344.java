/** 
 * ??????????????
 * @param str sql??
 * @return ????
 */
public static Condition wrap(String str){
  return Strings.isBlank(str) ? null : new SimpleCondition((Object)str);
}