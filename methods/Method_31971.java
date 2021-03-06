/** 
 * Get the textual value of the specified time instant.
 * @param fieldValue  the field value to query
 * @param locale  the locale to use
 * @return the day of the week, such as 'Monday'
 */
public String getAsText(int fieldValue,Locale locale){
  return GJLocaleSymbols.forLocale(locale).dayOfWeekValueToText(fieldValue);
}
