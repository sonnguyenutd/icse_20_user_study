/** 
 * Resolves singletons.
 * @return the singleton instance
 */
private Object readResolve(){
  return Weeks.weeks(getValue());
}
