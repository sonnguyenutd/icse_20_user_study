/** 
 * ??????????
 * @param dao Dao??
 * @param klass ??Pojo
 * @param add ????????
 * @param del ????????
 * @param checkIndex ??????
 */
public static void migration(Dao dao,final Class<?> klass,final boolean add,final boolean del,boolean checkIndex){
  migration(dao,klass,add,del,checkIndex,null);
}
