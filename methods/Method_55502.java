public static void checkSafe(@Nullable int[] buf,int size){
  if (buf != null) {
    checkBuffer(buf.length,size);
  }
}
