/** 
 * ?????????????????? //	 * @param lexeme
 * @param l
 */
private void backPath(Lexeme l,LexemePath option){
  while (option.checkCross(l)) {
    option.removeTail();
  }
}
