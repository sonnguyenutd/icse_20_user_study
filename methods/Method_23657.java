/** 
 * Construct a JSONArray from a source JSON text.
 * @param source     A string that begins with<code>[</code>&nbsp;<small>(left bracket)</small> and ends with <code>]</code>&nbsp;<small>(right bracket)</small>.
 * @return {@code null} if there is a syntax error.
 */
static public JSONArray parse(String source){
  try {
    return new JSONArray(new JSONTokener(source));
  }
 catch (  Exception e) {
    return null;
  }
}
