private void bindHeaderView(BaseCell cell){
  if (cell.isValid()) {
    View header=getHeaderViewFromRecycler(cell);
    if (header != null) {
      ViewGroup.LayoutParams lp=header.getLayoutParams();
      if (lp == null || !(lp instanceof LayoutParams)) {
        lp=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
      }
      ((LayoutParams)lp).topMargin=cell.style.margin[Style.MARGIN_TOP_INDEX];
      ((LayoutParams)lp).leftMargin=cell.style.margin[Style.MARGIN_LEFT_INDEX];
      ((LayoutParams)lp).bottomMargin=cell.style.margin[Style.MARGIN_BOTTOM_INDEX];
      ((LayoutParams)lp).rightMargin=cell.style.margin[Style.MARGIN_RIGHT_INDEX];
      addView(header,lp);
    }
  }
}
