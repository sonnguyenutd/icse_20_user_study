/** 
 * ???package???package??@Table???Pojo??migration
 * @param dao Dao??
 * @param packageName ???package??
 * @param add ????????
 * @param del ????????
 * @param nameTable ???????
 */
public static void migration(Dao dao,String packageName,boolean add,boolean del,Object nameTable){
  migration(dao,packageName,add,del,true,nameTable);
}