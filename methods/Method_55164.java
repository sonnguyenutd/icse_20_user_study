/** 
 * Returns the class definition of a specified class. <p>objc_getClass is different from  {@link #objc_lookUpClass} in that if the class is not registered, objc_getClass calls the class handler callback and thenchecks a second time to see whether the class is registered. objc_lookUpClass does not call the class handler callback.</p>
 * @param name the name of the class to look up
 * @return the Class object for the named class, or {@link #nil} if the class is not registered with the Objective-C runtime
 */
@NativeType("Class") public static long objc_getClass(@NativeType("char const *") CharSequence name){
  MemoryStack stack=stackGet();
  int stackPointer=stack.getPointer();
  try {
    stack.nUTF8(name,true);
    long nameEncoded=stack.getPointerAddress();
    return nobjc_getClass(nameEncoded);
  }
  finally {
    stack.setPointer(stackPointer);
  }
}
