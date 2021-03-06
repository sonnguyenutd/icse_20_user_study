@NonNull @Override public List<EditToken> format(@NonNull Editable editable){
  List<EditToken> editTokenList=new ArrayList<>();
  editTokenList.addAll(SyntaxUtils.parse(editable,PATTERN_ASTERISK,this));
  editTokenList.addAll(SyntaxUtils.parse(editable,PATTERN_HYPHEN,this));
  return editTokenList;
}
