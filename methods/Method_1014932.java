/** 
 * Combine two patterns into a new pattern. <p>This implementation simply concatenates the two patterns, unless the first pattern contains a file extension match (e.g.,  {@code *.html}). In that case, the second pattern will be merged into the first. Otherwise, an  {@code IllegalArgumentException} will be thrown.<h3>Examples</h3> <table border="1"> <tr><th>Pattern 1</th><th>Pattern 2</th><th>Result</th></tr> <tr><td> {@code null}</td><td> {@code null}</td><td>&nbsp;</td></tr> <tr><td>/hotels</td><td> {@code null}</td><td>/hotels</td></tr> <tr><td> {@code null}</td><td>/hotels</td><td>/hotels</td></tr> <tr><td>/hotels</td><td>/bookings</td><td>/hotels/bookings</td></tr> <tr><td>/hotels</td><td>bookings</td><td>/hotels/bookings</td></tr> <tr><td>/hotels/*</td><td>/bookings</td><td>/hotels/bookings</td></tr> <tr><td>/hotels/&#42;&#42;</td><td>/bookings</td><td>/hotels/&#42;&#42;/bookings</td></tr> <tr><td>/hotels</td><td>{hotel}</td><td>/hotels/{hotel}</td></tr> <tr><td>/hotels/*</td><td>{hotel}</td><td>/hotels/{hotel}</td></tr> <tr><td>/hotels/&#42;&#42;</td><td>{hotel}</td><td>/hotels/&#42;&#42;/{hotel}</td></tr> <tr><td>/*.html</td><td>/hotels.html</td><td>/hotels.html</td></tr> <tr><td>/*.html</td><td>/hotels</td><td>/hotels.html</td></tr> <tr><td>/*.html</td><td>/*.txt</td><td> {@code IllegalArgumentException}</td></tr> </table>
 * @param pattern1 the first pattern
 * @param pattern2 the second pattern
 * @return the combination of the two patterns
 * @throws IllegalArgumentException if the two patterns cannot be combined
 */
@Override public String combine(String pattern1,String pattern2){
  if (!StringUtils.hasText(pattern1) && !StringUtils.hasText(pattern2)) {
    return "";
  }
  if (!StringUtils.hasText(pattern1)) {
    return pattern2;
  }
  if (!StringUtils.hasText(pattern2)) {
    return pattern1;
  }
  boolean pattern1ContainsUriVar=(pattern1.indexOf('{') != -1);
  if (!pattern1.equals(pattern2) && !pattern1ContainsUriVar && match(pattern1,pattern2)) {
    return pattern2;
  }
  if (pattern1.endsWith(this.pathSeparatorPatternCache.getEndsOnWildCard())) {
    return concat(pattern1.substring(0,pattern1.length() - 2),pattern2);
  }
  if (pattern1.endsWith(this.pathSeparatorPatternCache.getEndsOnDoubleWildCard())) {
    return concat(pattern1,pattern2);
  }
  int starDotPos1=pattern1.indexOf("*.");
  if (pattern1ContainsUriVar || starDotPos1 == -1 || this.pathSeparator.equals(".")) {
    return concat(pattern1,pattern2);
  }
  String ext1=pattern1.substring(starDotPos1 + 1);
  int dotPos2=pattern2.indexOf('.');
  String file2=(dotPos2 == -1 ? pattern2 : pattern2.substring(0,dotPos2));
  String ext2=(dotPos2 == -1 ? "" : pattern2.substring(dotPos2));
  boolean ext1All=(ext1.equals(".*") || ext1.equals(""));
  boolean ext2All=(ext2.equals(".*") || ext2.equals(""));
  if (!ext1All && !ext2All) {
    throw new IllegalArgumentException("Cannot combine patterns: " + pattern1 + " vs " + pattern2);
  }
  String ext=(ext1All ? ext2 : ext1);
  return file2 + ext;
}
