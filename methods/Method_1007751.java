public static double leq(RValue lhs,RValue rhs) throws EvaluationException {
  return lhs.getValue() <= rhs.getValue() ? 1.0 : 0.0;
}
