@Override public String apply(HystrixCommandMetrics commandMetrics) throws Exception {
  HystrixCommandKey key=commandMetrics.getCommandKey();
  HystrixCircuitBreaker circuitBreaker=HystrixCircuitBreaker.Factory.getInstance(key);
  StringWriter jsonString=new StringWriter();
  JsonGenerator json=jsonFactory.createGenerator(jsonString);
  json.writeStartObject();
  json.writeStringField("type","HystrixCommand");
  json.writeStringField("name",key.name());
  json.writeStringField("group",commandMetrics.getCommandGroup().name());
  json.writeNumberField("currentTime",System.currentTimeMillis());
  if (circuitBreaker == null) {
    json.writeBooleanField("isCircuitBreakerOpen",false);
  }
 else {
    json.writeBooleanField("isCircuitBreakerOpen",circuitBreaker.isOpen());
  }
  HystrixCommandMetrics.HealthCounts healthCounts=commandMetrics.getHealthCounts();
  json.writeNumberField("errorPercentage",healthCounts.getErrorPercentage());
  json.writeNumberField("errorCount",healthCounts.getErrorCount());
  json.writeNumberField("requestCount",healthCounts.getTotalRequests());
  json.writeNumberField("rollingCountBadRequests",commandMetrics.getRollingCount(HystrixRollingNumberEvent.BAD_REQUEST));
  json.writeNumberField("rollingCountCollapsedRequests",commandMetrics.getRollingCount(HystrixRollingNumberEvent.COLLAPSED));
  json.writeNumberField("rollingCountEmit",commandMetrics.getRollingCount(HystrixRollingNumberEvent.EMIT));
  json.writeNumberField("rollingCountExceptionsThrown",commandMetrics.getRollingCount(HystrixRollingNumberEvent.EXCEPTION_THROWN));
  json.writeNumberField("rollingCountFailure",commandMetrics.getRollingCount(HystrixRollingNumberEvent.FAILURE));
  json.writeNumberField("rollingCountEmit",commandMetrics.getRollingCount(HystrixRollingNumberEvent.FALLBACK_EMIT));
  json.writeNumberField("rollingCountFallbackFailure",commandMetrics.getRollingCount(HystrixRollingNumberEvent.FALLBACK_FAILURE));
  json.writeNumberField("rollingCountFallbackRejection",commandMetrics.getRollingCount(HystrixRollingNumberEvent.FALLBACK_REJECTION));
  json.writeNumberField("rollingCountFallbackSuccess",commandMetrics.getRollingCount(HystrixRollingNumberEvent.FALLBACK_SUCCESS));
  json.writeNumberField("rollingCountResponsesFromCache",commandMetrics.getRollingCount(HystrixRollingNumberEvent.RESPONSE_FROM_CACHE));
  json.writeNumberField("rollingCountSemaphoreRejected",commandMetrics.getRollingCount(HystrixRollingNumberEvent.SEMAPHORE_REJECTED));
  json.writeNumberField("rollingCountShortCircuited",commandMetrics.getRollingCount(HystrixRollingNumberEvent.SHORT_CIRCUITED));
  json.writeNumberField("rollingCountSuccess",commandMetrics.getRollingCount(HystrixRollingNumberEvent.SUCCESS));
  json.writeNumberField("rollingCountThreadPoolRejected",commandMetrics.getRollingCount(HystrixRollingNumberEvent.THREAD_POOL_REJECTED));
  json.writeNumberField("rollingCountTimeout",commandMetrics.getRollingCount(HystrixRollingNumberEvent.TIMEOUT));
  json.writeNumberField("currentConcurrentExecutionCount",commandMetrics.getCurrentConcurrentExecutionCount());
  json.writeNumberField("rollingMaxConcurrentExecutionCount",commandMetrics.getRollingMaxConcurrentExecutions());
  json.writeNumberField("latencyExecute_mean",commandMetrics.getExecutionTimeMean());
  json.writeObjectFieldStart("latencyExecute");
  json.writeNumberField("0",commandMetrics.getExecutionTimePercentile(0));
  json.writeNumberField("25",commandMetrics.getExecutionTimePercentile(25));
  json.writeNumberField("50",commandMetrics.getExecutionTimePercentile(50));
  json.writeNumberField("75",commandMetrics.getExecutionTimePercentile(75));
  json.writeNumberField("90",commandMetrics.getExecutionTimePercentile(90));
  json.writeNumberField("95",commandMetrics.getExecutionTimePercentile(95));
  json.writeNumberField("99",commandMetrics.getExecutionTimePercentile(99));
  json.writeNumberField("99.5",commandMetrics.getExecutionTimePercentile(99.5));
  json.writeNumberField("100",commandMetrics.getExecutionTimePercentile(100));
  json.writeEndObject();
  json.writeNumberField("latencyTotal_mean",commandMetrics.getTotalTimeMean());
  json.writeObjectFieldStart("latencyTotal");
  json.writeNumberField("0",commandMetrics.getTotalTimePercentile(0));
  json.writeNumberField("25",commandMetrics.getTotalTimePercentile(25));
  json.writeNumberField("50",commandMetrics.getTotalTimePercentile(50));
  json.writeNumberField("75",commandMetrics.getTotalTimePercentile(75));
  json.writeNumberField("90",commandMetrics.getTotalTimePercentile(90));
  json.writeNumberField("95",commandMetrics.getTotalTimePercentile(95));
  json.writeNumberField("99",commandMetrics.getTotalTimePercentile(99));
  json.writeNumberField("99.5",commandMetrics.getTotalTimePercentile(99.5));
  json.writeNumberField("100",commandMetrics.getTotalTimePercentile(100));
  json.writeEndObject();
  HystrixCommandProperties commandProperties=commandMetrics.getProperties();
  json.writeNumberField("propertyValue_circuitBreakerRequestVolumeThreshold",commandProperties.circuitBreakerRequestVolumeThreshold().get());
  json.writeNumberField("propertyValue_circuitBreakerSleepWindowInMilliseconds",commandProperties.circuitBreakerSleepWindowInMilliseconds().get());
  json.writeNumberField("propertyValue_circuitBreakerErrorThresholdPercentage",commandProperties.circuitBreakerErrorThresholdPercentage().get());
  json.writeBooleanField("propertyValue_circuitBreakerForceOpen",commandProperties.circuitBreakerForceOpen().get());
  json.writeBooleanField("propertyValue_circuitBreakerForceClosed",commandProperties.circuitBreakerForceClosed().get());
  json.writeBooleanField("propertyValue_circuitBreakerEnabled",commandProperties.circuitBreakerEnabled().get());
  json.writeStringField("propertyValue_executionIsolationStrategy",commandProperties.executionIsolationStrategy().get().name());
  json.writeNumberField("propertyValue_executionIsolationThreadTimeoutInMilliseconds",commandProperties.executionTimeoutInMilliseconds().get());
  json.writeNumberField("propertyValue_executionTimeoutInMilliseconds",commandProperties.executionTimeoutInMilliseconds().get());
  json.writeBooleanField("propertyValue_executionIsolationThreadInterruptOnTimeout",commandProperties.executionIsolationThreadInterruptOnTimeout().get());
  json.writeStringField("propertyValue_executionIsolationThreadPoolKeyOverride",commandProperties.executionIsolationThreadPoolKeyOverride().get());
  json.writeNumberField("propertyValue_executionIsolationSemaphoreMaxConcurrentRequests",commandProperties.executionIsolationSemaphoreMaxConcurrentRequests().get());
  json.writeNumberField("propertyValue_fallbackIsolationSemaphoreMaxConcurrentRequests",commandProperties.fallbackIsolationSemaphoreMaxConcurrentRequests().get());
  json.writeNumberField("propertyValue_metricsRollingStatisticalWindowInMilliseconds",commandProperties.metricsRollingStatisticalWindowInMilliseconds().get());
  json.writeBooleanField("propertyValue_requestCacheEnabled",commandProperties.requestCacheEnabled().get());
  json.writeBooleanField("propertyValue_requestLogEnabled",commandProperties.requestLogEnabled().get());
  json.writeNumberField("reportingHosts",1);
  json.writeEndObject();
  json.close();
  return jsonString.getBuffer().toString();
}