/** 
 * Build mongo table name string.
 * @param applicationName the application name
 * @return the string
 */
public static String buildMongoTableName(final String applicationName){
  return CommonConstant.DB_SUFFIX + applicationName.replaceAll("-","_");
}
