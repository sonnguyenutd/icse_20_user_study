/** 
 * Checks whether the condition is true. Throws an unchecked exception if otherwise
 * @param condition condition the condition to check
 * @param errorCode error code of explanation
 * @param parameters parameters for the message
 * @throws RuntimeException
 */
public static void check(boolean condition,int errorCode,String parameter) throws RuntimeException {
  if (!condition) {
    throw new TLCRuntimeException(errorCode,new String[]{parameter},MP.getMessage(errorCode,parameter));
  }
}
