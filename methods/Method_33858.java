/** 
 * ???????????? ?????????????????? ?????????????????????? ? setPullRefreshEnabled(false) ????? ????????????????
 */
public void clearHeader(){
  mHeaderViews.clear();
  ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1);
  View view=new View(getContext());
  view.setLayoutParams(params);
  mHeaderViews.put(0,view);
}