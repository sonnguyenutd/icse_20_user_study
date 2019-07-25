/** 
 * ??????????????????? '.' ???????
 * @param dir ??
 * @return ?????
 */
public static File[] dirs(File dir){
  return dir.listFiles(new FileFilter(){
    public boolean accept(    File f){
      return !f.isHidden() && f.isDirectory() && !f.getName().startsWith(".");
    }
  }
);
}