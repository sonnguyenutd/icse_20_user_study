/** 
 * ???????Key
 * @param config   ??
 * @param protocol ??
 * @return ???
 */
static String buildListDataId(AbstractInterfaceConfig config,String protocol){
  if (RpcConstants.PROTOCOL_TYPE_BOLT.equals(protocol) || RpcConstants.PROTOCOL_TYPE_TR.equals(protocol)) {
    return ConfigUniqueNameGenerator.getUniqueName(config) + "@DEFAULT";
  }
 else {
    return ConfigUniqueNameGenerator.getUniqueName(config) + "@" + protocol;
  }
}
