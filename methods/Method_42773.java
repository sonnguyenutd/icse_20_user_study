/** 
 * ????????????????.
 * @param str ??????
 * @return ?????true,????false capital
 */
public static boolean isAlphanumeric(String str){
  Pattern pattern=Pattern.compile("^[A-Za-z0-9]+$");
  return pattern.matcher(str).matches();
}
