public static HystrixCommandCompletion from(ExecutionResult executionResult,HystrixCommandKey commandKey,HystrixThreadPoolKey threadPoolKey,HystrixRequestContext requestContext){
  return new HystrixCommandCompletion(executionResult,commandKey,threadPoolKey,requestContext);
}
