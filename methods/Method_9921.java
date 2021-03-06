/** 
 * Did collect 1A0001 today?
 * @param userId the specified user id
 * @return {@code true} if collected, returns {@code false} otherwise
 */
public synchronized boolean isCollected1A0001Today(final String userId){
  final Date now=new Date();
  final List<JSONObject> records=pointtransferQueryService.getLatestPointtransfers(userId,Pointtransfer.TRANSFER_TYPE_C_ACTIVITY_1A0001_COLLECT,1);
  if (records.isEmpty()) {
    return false;
  }
  final JSONObject maybeToday=records.get(0);
  final long time=maybeToday.optLong(Pointtransfer.TIME);
  return DateUtils.isSameDay(now,new Date(time));
}
