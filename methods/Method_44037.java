@Override public Integer getPageNumber(){
  return (offset == null || pageLength == null) ? null : offset / pageLength;
}
