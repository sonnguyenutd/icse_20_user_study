/** 
 * Output the date using the specified format pattern. Unsupported fields will appear as special unicode characters.
 * @param pattern  the pattern specification, null means use <code>toString</code>
 * @see org.joda.time.format.DateTimeFormat
 */
public String toString(String pattern){
  if (pattern == null) {
    return toString();
  }
  return DateTimeFormat.forPattern(pattern).print(this);
}
