/** 
 * String?int?? ????? ?????????????????????byte??????? unicode???? ????u+4E00?u+4E00?4E00
 * @param data
 * @param isUnsignedInt ?????????int??
 * @return int<p> {@link #string2Int(String)}</p> <p> {@link #string2IntBinary(String,boolean)}</p> <p> {@link #string2IntOctal(String,boolean)}</p> <p> {@link #string2IntHexadecimal(String,boolean)}</p> <p> {@link #string2Int2(String)}</p>
 */
public static int string2Int(@NotNull String data,@NotNull boolean isUnsignedInt){
  return string2Int(data,isUnsignedInt,10);
}