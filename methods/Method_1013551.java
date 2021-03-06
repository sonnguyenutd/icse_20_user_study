public final boolean assignable(Value val){
  try {
    return ((val instanceof StringValue) && this.equals(val));
  }
 catch (  RuntimeException|OutOfMemoryError e) {
    if (hasSource()) {
      throw FingerprintException.getNewHead(this,e);
    }
 else {
      throw e;
    }
  }
}
