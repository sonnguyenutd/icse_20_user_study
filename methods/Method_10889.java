/** 
 * ??[?????????,??????????????????]?Intent
 */
public static Intent getCameraIntent(Uri saveFileURI){
  Intent mIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
  return mIntent.putExtra(MediaStore.EXTRA_OUTPUT,saveFileURI);
}
