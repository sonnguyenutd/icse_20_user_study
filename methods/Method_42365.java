/** 
 * ?????? ? ??Mapper????. ?????? Along ????? 2016-1-8 ?????
 * @throws
     * @???@param sqlId
 * @???@return
 * @return?String
 */
public String getStatement(String sqlId){
  String name=this.getClass().getName();
  StringBuilder sb=new StringBuilder();
  sb.append(name).append(".").append(sqlId);
  return sb.toString();
}
