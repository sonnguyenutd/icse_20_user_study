public static byte[] decode(String hex){
  byte[] res=new byte[hex.length() / 2];
  for (int i=0; i < res.length; i++)   res[i]=(byte)Integer.parseInt(hex.substring(2 * i,2 * i + 2),16);
  return res;
}
