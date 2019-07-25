@Override public String apply(HystrixCollapserMetrics collapserMetrics) throws Exception {
  HystrixCollapserKey key=collapserMetrics.getCollapserKey();
  StringWriter jsonString=new StringWriter();
  JsonGenerator json=jsonFactory.createGenerator(jsonString);
  json.writeStartObject();
  json.writeStringField("type","HystrixCollapser");
  json.writeStringField("name",key.name());
  json.writeNumberField("currentTime",System.currentTimeMillis());
  json.writeNumberField("rollingCountRequestsBatched",collapserMetrics.getRollingCount(HystrixRollingNumberEvent.COLLAPSER_REQUEST_BATCHED));
  json.writeNumberField("rollingCountBatches",collapserMetrics.getRollingCount(HystrixRollingNumberEvent.COLLAPSER_BATCH));
  json.writeNumberField("rollingCountResponsesFromCache",collapserMetrics.getRollingCount(HystrixRollingNumberEvent.RESPONSE_FROM_CACHE));
  json.writeNumberField("batchSize_mean",collapserMetrics.getBatchSizeMean());
  json.writeObjectFieldStart("batchSize");
  json.writeNumberField("25",collapserMetrics.getBatchSizePercentile(25));
  json.writeNumberField("50",collapserMetrics.getBatchSizePercentile(50));
  json.writeNumberField("75",collapserMetrics.getBatchSizePercentile(75));
  json.writeNumberField("90",collapserMetrics.getBatchSizePercentile(90));
  json.writeNumberField("95",collapserMetrics.getBatchSizePercentile(95));
  json.writeNumberField("99",collapserMetrics.getBatchSizePercentile(99));
  json.writeNumberField("99.5",collapserMetrics.getBatchSizePercentile(99.5));
  json.writeNumberField("100",collapserMetrics.getBatchSizePercentile(100));
  json.writeEndObject();
  json.writeBooleanField("propertyValue_requestCacheEnabled",collapserMetrics.getProperties().requestCacheEnabled().get());
  json.writeNumberField("propertyValue_maxRequestsInBatch",collapserMetrics.getProperties().maxRequestsInBatch().get());
  json.writeNumberField("propertyValue_timerDelayInMilliseconds",collapserMetrics.getProperties().timerDelayInMilliseconds().get());
  json.writeNumberField("reportingHosts",1);
  json.writeEndObject();
  json.close();
  return jsonString.getBuffer().toString();
}