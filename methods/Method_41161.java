/** 
 * <p> Get a <code>Date</code> object that represents the given time, on today's date  (equivalent to  {@link #todayAt(int,int,int)}). </p>
 * @param second The value (0-59) to give the seconds field of the date
 * @param minute The value (0-59) to give the minutes field of the date
 * @param hour The value (0-23) to give the hours field of the date
 * @return the new date
 */
public static Date dateOf(int hour,int minute,int second){
  validateSecond(second);
  validateMinute(minute);
  validateHour(hour);
  Date date=new Date();
  Calendar c=Calendar.getInstance();
  c.setTime(date);
  c.setLenient(true);
  c.set(Calendar.HOUR_OF_DAY,hour);
  c.set(Calendar.MINUTE,minute);
  c.set(Calendar.SECOND,second);
  c.set(Calendar.MILLISECOND,0);
  return c.getTime();
}
