/** 
 * e.g.: Dec 17, 2015 6:35:05 PM.
 */
public static @NonNull String mediumDateTime(final @NonNull DateTime dateTime){
  return mediumDateTime(dateTime,DateTimeZone.getDefault());
}
