package jetbrains.mps.baseLanguage.math.runtime;

/*Generated by MPS */

import java.math.MathContext;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalScalarOperations implements MatrixScalarOperations {
  /*package*/ MathContext myContext = null;
  public BigDecimalScalarOperations() {
  }
  public BigDecimalScalarOperations(MathContext context) {
    myContext = context;
  }
  @Override
  public BigDecimal cast(Object o) {
    if (o instanceof BigDecimal) {
      return (BigDecimal) o;
    }
    if (o instanceof BigInteger) {
      return new BigDecimal((BigInteger) o);
    }
    if (o instanceof Number) {
      return BigDecimal.valueOf(((Number) o).doubleValue());
    }
    throw new ClassCastException();
  }
  @Override
  public BigDecimal add(Object o1, Object o2) {
    if (myContext == null) {
      return cast(o1).add(cast(o2));
    } else
    return cast(o1).add(cast(o2), myContext);
  }
  @Override
  public BigDecimal mul(Object i1, Object o2) {
    if (myContext == null) {
      return cast(i1).multiply(cast(o2));
    } else
    return cast(i1).multiply(cast(o2), myContext);
  }
  @Override
  public BigDecimal neg(Object i) {
    return cast(i).negate();
  }
  @Override
  public BigDecimal inv(Object d) {
    if (myContext == null) {
      return BigDecimal.valueOf(1.0).divide(cast(d));
    } else
    return BigDecimal.valueOf(1.0).divide(cast(d), myContext);
  }
  @Override
  public BigDecimal conj(Object o) {
    return cast(o);
  }
  @Override
  public Object abs(Object o) {
    return cast(o).abs();
  }
}