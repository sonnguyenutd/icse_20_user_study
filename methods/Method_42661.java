public static String encode(String password){
  try {
    MessageDigest md5=MessageDigest.getInstance("MD5");
    byte[] byteArray=md5.digest(password.getBytes("utf-8"));
    String passwordMD5=byteArrayToHexString(byteArray);
    return passwordMD5;
  }
 catch (  Exception e) {
    LOG.error(e.toString());
  }
  return password;
}
