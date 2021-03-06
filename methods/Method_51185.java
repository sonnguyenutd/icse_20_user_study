@Override public double computeForOperation(MetricKey<O> key,O node,boolean force,MetricOptions options,MetricMemoizer<O> memoizer){
  ParameterizedMetricKey<O> paramKey=ParameterizedMetricKey.getInstance(key,options);
  Double prev=memoizer.getMemo(paramKey);
  if (!force && prev != null) {
    return prev;
  }
  double val=key.getCalculator().computeFor(node,options);
  memoizer.memoize(paramKey,val);
  return val;
}
