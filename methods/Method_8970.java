private void updateAnimation(boolean progress){
  long newTime=System.currentTimeMillis();
  long dt=newTime - lastUpdateTime;
  lastUpdateTime=newTime;
  if (checkBackgroundDrawable != null && (currentDrawable == checkBackgroundDrawable || previousDrawable == checkBackgroundDrawable)) {
    if (checkDrawable.updateAnimation(dt)) {
      invalidateParent();
    }
  }
  if (progress) {
    if (animatedProgressValue != 1) {
      radOffset+=360 * dt / 3000.0f;
      float progressDiff=currentProgress - animationProgressStart;
      if (progressDiff > 0) {
        currentProgressTime+=dt;
        if (currentProgressTime >= 300) {
          animatedProgressValue=currentProgress;
          animationProgressStart=currentProgress;
          currentProgressTime=0;
        }
 else {
          animatedProgressValue=animationProgressStart + progressDiff * decelerateInterpolator.getInterpolation(currentProgressTime / 300.0f);
        }
      }
      invalidateParent();
    }
    if (drawMiniProgress) {
      if (animatedProgressValue >= 1 && previousMiniDrawable != null) {
        animatedAlphaValue-=dt / 200.0f;
        if (animatedAlphaValue <= 0) {
          animatedAlphaValue=0.0f;
          previousMiniDrawable=null;
          drawMiniProgress=currentMiniDrawable != null;
        }
        invalidateParent();
      }
    }
 else {
      if (animatedProgressValue >= 1 && previousDrawable != null) {
        animatedAlphaValue-=dt / 200.0f;
        if (animatedAlphaValue <= 0) {
          animatedAlphaValue=0.0f;
          previousDrawable=null;
        }
        invalidateParent();
      }
    }
  }
 else {
    if (drawMiniProgress) {
      if (previousMiniDrawable != null) {
        animatedAlphaValue-=dt / 200.0f;
        if (animatedAlphaValue <= 0) {
          animatedAlphaValue=0.0f;
          previousMiniDrawable=null;
          drawMiniProgress=currentMiniDrawable != null;
        }
        invalidateParent();
      }
    }
 else {
      if (previousDrawable != null) {
        animatedAlphaValue-=dt / 200.0f;
        if (animatedAlphaValue <= 0) {
          animatedAlphaValue=0.0f;
          previousDrawable=null;
        }
        invalidateParent();
      }
    }
  }
}
