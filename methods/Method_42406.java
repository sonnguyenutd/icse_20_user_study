/** 
 * ?????????????????????????????? ??????????????????????90?
 * @param startDate ????
 * @param endDate ?????
 * @param interval ???
 * @param dateUnit ??(?????),??Calendar?????
 * @return
 */
public static boolean isOverIntervalLimit(Date startDate,Date endDate,int interval,int dateUnit){
  Calendar cal=Calendar.getInstance();
  cal.setTime(new Date());
  cal.add(dateUnit,interval * (-1));
  Date curDate=getDayStart(cal.getTime());
  if (getDayStart(startDate).compareTo(curDate) < 0 || getDayStart(endDate).compareTo(curDate) < 0) {
    return true;
  }
  return false;
}
