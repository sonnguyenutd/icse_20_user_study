/** 
 * ??????
 * @param blankSpace ???????????\t?\n?\r?\f?\x0B
 * @return ??????true???????false
 */
public static boolean checkBlankSpace(String blankSpace){
  String regex="\\s+";
  return Pattern.matches(regex,blankSpace);
}
