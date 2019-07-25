/** 
 * ?????????????????,???????????????
 * @param destParam ???????,????????????
 */
private static void createDestDirectoryIfNecessary(String destParam){
  File destDir=null;
  if (destParam.endsWith(File.separator)) {
    destDir=new File(destParam);
  }
 else {
    destDir=new File(destParam.substring(0,destParam.lastIndexOf(File.separator)));
  }
  if (!destDir.exists()) {
    destDir.mkdirs();
  }
}