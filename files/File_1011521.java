package jetbrains.mps.baseLnaguage.extensionMethods.sandbox;

/*Generated by MPS */

import java.util.LinkedList;

public class Abc {
  private static final int b = 2;
  public Abc() {
  }
  /*package*/ static void foo(final int _this) {
    int a = b * 2;
  }
  public static int sum(final LinkedList<Integer> _this) {
    int res = 0;
    for (int a : _this) {
      res += a;
    }

    return res;
  }
}
