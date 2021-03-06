/** 
 * Retrieves the Qid allocated to a given new cell
 * @param id:the fake ItemId generated by the cell
 * @return the qid (or null if unallocated yet)
 */
public String getQid(long id){
  return map.get(id);
}
