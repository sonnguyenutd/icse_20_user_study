@Override public KeyMaker createKeyMaker(){
  return new KeyMaker(){
    @Override protected Object makeKey(    Object value){
      if (ExpressionUtils.isNonBlankData(value)) {
        if (value instanceof Boolean) {
          return value;
        }
 else         if (value instanceof String) {
          return Boolean.parseBoolean((String)value);
        }
 else {
          return s_error;
        }
      }
      return null;
    }
    @Override public int compareKeys(    Object key1,    Object key2){
      return ((Boolean)key1).compareTo((Boolean)key2);
    }
  }
;
}
