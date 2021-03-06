@Override public long getStartDelay(@NonNull ViewGroup sceneRoot,@NonNull Transition transition,@Nullable TransitionValues startValues,@Nullable TransitionValues endValues){
  if (startValues == null && endValues == null) {
    return 0;
  }
  int directionMultiplier=1;
  TransitionValues positionValues;
  if (endValues == null || getViewVisibility(startValues) == View.VISIBLE) {
    positionValues=startValues;
    directionMultiplier=-1;
  }
 else {
    positionValues=endValues;
  }
  int viewCenterX=getViewX(positionValues);
  int viewCenterY=getViewY(positionValues);
  Rect epicenter=transition.getEpicenter();
  int epicenterX;
  int epicenterY;
  if (epicenter != null) {
    epicenterX=epicenter.centerX();
    epicenterY=epicenter.centerY();
  }
 else {
    int[] loc=new int[2];
    sceneRoot.getLocationOnScreen(loc);
    epicenterX=Math.round(loc[0] + (sceneRoot.getWidth() / 2) + sceneRoot.getTranslationX());
    epicenterY=Math.round(loc[1] + (sceneRoot.getHeight() / 2) + sceneRoot.getTranslationY());
  }
  double distance=distance(viewCenterX,viewCenterY,epicenterX,epicenterY);
  double maxDistance=distance(0,0,sceneRoot.getWidth(),sceneRoot.getHeight());
  double distanceFraction=distance / maxDistance;
  long duration=transition.getDuration();
  if (duration < 0) {
    duration=300;
  }
  return Math.round(duration * directionMultiplier / mPropagationSpeed * distanceFraction);
}
