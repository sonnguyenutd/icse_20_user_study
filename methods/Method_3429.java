/** 
 * ????
 * @param words ??????
 * @return ??????????????????
 */
public boolean learn(String... words){
  return learn(new CWSInstance(words,model.featureMap));
}