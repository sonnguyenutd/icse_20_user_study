private static AsciiString create(String name){
  return AsciiString.cached(Ascii.toLowerCase(name));
}
