public static Intent makeIntent(long broadcastId,Context context){
  return new Intent(context,BroadcastActivity.class).putExtra(EXTRA_BROADCAST_ID,broadcastId);
}
