public void jobWasExecuted(JobExecutionContext inContext,JobExecutionException inException){
  _log.info("Job1Listener says: Job was executed.");
  JobDetail job2=newJob(SimpleJob2.class).withIdentity("job2").build();
  Trigger trigger=newTrigger().withIdentity("job2Trigger").startNow().build();
  try {
    inContext.getScheduler().scheduleJob(job2,trigger);
  }
 catch (  SchedulerException e) {
    _log.warn("Unable to schedule job2!");
    e.printStackTrace();
  }
}
