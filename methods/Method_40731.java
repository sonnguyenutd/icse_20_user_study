public void addMapping(Type from,Type to){
  if (arrows.size() < 5) {
    arrows.put(from,to);
    Map<Type,Type> oldArrows=arrows;
    arrows=compressArrows(arrows);
    if (toString().length() > 900) {
      arrows=oldArrows;
    }
  }
}
