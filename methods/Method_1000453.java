/** 
 * ???????ValueAdaptor,?adaptor?null,?????
 * @param className ??
 * @param adaptor ??????,??null,?????
 * @return ???????
 */
public static ValueAdaptor register(String className,ValueAdaptor adaptor){
  if (adaptor == null)   return customValueAdaptorMap.remove(className);
  return customValueAdaptorMap.put(className,adaptor);
}