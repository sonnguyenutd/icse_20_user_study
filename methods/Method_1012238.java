/** 
 * ??????? ?? 4.4 ????? MIUI ? Flyme??? 5.0 ??????? Android?
 * @param activity ???????????? Activity?
 */
public static void translucent(Activity activity,@ColorInt int colorOn5x){
  Window window=activity.getWindow();
  translucent(window,colorOn5x);
}