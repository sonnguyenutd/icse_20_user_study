public void toogleChannelSignatures(int chat_id,boolean enabled){
  TLRPC.TL_channels_toggleSignatures req=new TLRPC.TL_channels_toggleSignatures();
  req.channel=getInputChannel(chat_id);
  req.enabled=enabled;
  ConnectionsManager.getInstance(currentAccount).sendRequest(req,(response,error) -> {
    if (response != null) {
      processUpdates((TLRPC.Updates)response,false);
      AndroidUtilities.runOnUIThread(() -> NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.updateInterfaces,UPDATE_MASK_CHAT));
    }
  }
,ConnectionsManager.RequestFlagInvokeAfter);
}
