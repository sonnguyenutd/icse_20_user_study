/** 
 * ?????????.
 * @param jobName ????
 * @return ???????
 */
public JobScheduleController getJobScheduleController(final String jobName){
  return schedulerMap.get(jobName);
}
