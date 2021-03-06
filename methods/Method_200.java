public String reverseString(String s){
  if (s == null || s.length() == 1 || s.length() == 0) {
    return s;
  }
  char[] word=s.toCharArray();
  for (int i=0, j=s.length() - 1; i < j; i++, j--) {
    char temp=word[i];
    word[i]=word[j];
    word[j]=temp;
  }
  return new String(word);
}
