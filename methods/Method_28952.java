public static InetSocketAddress toAddress(String address){
  int i=address.indexOf(':');
  String host;
  int port;
  if (i > -1) {
    host=address.substring(0,i);
    port=Integer.parseInt(address.substring(i + 1));
  }
 else {
    host=address;
    port=0;
  }
  return new InetSocketAddress(host,port);
}
