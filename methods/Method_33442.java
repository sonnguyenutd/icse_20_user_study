/** 
 * ???? position =  getItemCount() - 1? ??????????????? getItemCount() ?? ???????
 */
private boolean isFooter(int position){
  return position < getItemCount() && position >= getItemCount() - 1;
}
