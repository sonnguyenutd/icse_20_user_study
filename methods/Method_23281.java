static final public String[] str(boolean x[]){
  String s[]=new String[x.length];
  for (int i=0; i < x.length; i++)   s[i]=String.valueOf(x[i]);
  return s;
}
