public final Value apply(Value arg,int control){
  try {
    throw new WrongInvocationException("It is a TLC bug: Should use the other apply method.");
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
