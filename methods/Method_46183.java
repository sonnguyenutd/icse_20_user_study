/** 
 * Add provider
 * @param config       ConsumerConfig
 * @param providerPath Provider path of zookeeper
 * @param data         Event data
 * @param currentData  provider data list
 * @throws UnsupportedEncodingException decode error
 */
public void addProvider(ConsumerConfig config,String providerPath,ChildData data,List<ChildData> currentData) throws UnsupportedEncodingException {
  if (LOGGER.isInfoEnabled(config.getAppName())) {
    LOGGER.infoWithApp(config.getAppName(),"Receive add provider: path=[" + data.getPath() + "]" + ", data=[" + StringSerializer.decode(data.getData()) + "]" + ", stat=[" + data.getStat() + "]" + ", list=[" + currentData.size() + "]");
  }
  notifyListeners(config,providerPath,currentData,true);
}
