@Override public P2<Integer,A> lookup(final F<V,Integer> o,final int i){
  final F<A,V> m=measured().measure();
  final int s1=o.f(m.f(as._1()));
  if (i < s1) {
    return P.p(i,as._1());
  }
 else {
    final int s2=s1 + o.f(m.f(as._2()));
    if (i < s2) {
      return P.p(i - s1,as._2());
    }
 else {
      final int s3=s2 + o.f(m.f(as._3()));
      if (i < s3) {
        return P.p(i - s2,as._3());
      }
 else {
        return P.p(i - s3,as._4());
      }
    }
  }
}
