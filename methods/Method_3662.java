/** 
 * ?HanLP??????????????????????????
 * @param word ??
 * @return ??????????
 */
public static CoreDictionary.Attribute getAttribute(String word){
  CoreDictionary.Attribute attribute=CoreDictionary.get(word);
  if (attribute != null)   return attribute;
  return CustomDictionary.get(word);
}
