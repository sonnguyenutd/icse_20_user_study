/** 
 * <p> Select all of the triggers for jobs that are requesting recovery. The returned trigger objects will have unique "recoverXXX" trigger names and will be in the <code> {@link org.quartz.Scheduler}.DEFAULT_RECOVERY_GROUP</code> trigger group. </p> <p> In order to preserve the ordering of the triggers, the fire time will be set from the <code>COL_FIRED_TIME</code> column in the <code>TABLE_FIRED_TRIGGERS</code> table. The caller is responsible for calling <code>computeFirstFireTime</code> on each returned trigger. It is also up to the caller to insert the returned triggers to ensure that they are fired. </p>
 * @param conn the DB Connection
 * @return an array of <code>{@link org.quartz.Trigger}</code> objects
 */
public List<OperableTrigger> selectTriggersForRecoveringJobs(Connection conn) throws SQLException, IOException, ClassNotFoundException {
  PreparedStatement ps=null;
  ResultSet rs=null;
  try {
    ps=conn.prepareStatement(rtp(SELECT_INSTANCES_RECOVERABLE_FIRED_TRIGGERS));
    ps.setString(1,instanceId);
    setBoolean(ps,2,true);
    rs=ps.executeQuery();
    long dumId=System.currentTimeMillis();
    LinkedList<OperableTrigger> list=new LinkedList<OperableTrigger>();
    while (rs.next()) {
      String jobName=rs.getString(COL_JOB_NAME);
      String jobGroup=rs.getString(COL_JOB_GROUP);
      String trigName=rs.getString(COL_TRIGGER_NAME);
      String trigGroup=rs.getString(COL_TRIGGER_GROUP);
      long firedTime=rs.getLong(COL_FIRED_TIME);
      long scheduledTime=rs.getLong(COL_SCHED_TIME);
      int priority=rs.getInt(COL_PRIORITY);
      @SuppressWarnings("deprecation") SimpleTriggerImpl rcvryTrig=new SimpleTriggerImpl("recover_" + instanceId + "_" + String.valueOf(dumId++),Scheduler.DEFAULT_RECOVERY_GROUP,new Date(scheduledTime));
      rcvryTrig.setJobName(jobName);
      rcvryTrig.setJobGroup(jobGroup);
      rcvryTrig.setPriority(priority);
      rcvryTrig.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY);
      JobDataMap jd=selectTriggerJobDataMap(conn,trigName,trigGroup);
      jd.put(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_NAME,trigName);
      jd.put(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_GROUP,trigGroup);
      jd.put(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_FIRETIME_IN_MILLISECONDS,String.valueOf(firedTime));
      jd.put(Scheduler.FAILED_JOB_ORIGINAL_TRIGGER_SCHEDULED_FIRETIME_IN_MILLISECONDS,String.valueOf(scheduledTime));
      rcvryTrig.setJobDataMap(jd);
      list.add(rcvryTrig);
    }
    return list;
  }
  finally {
    closeResultSet(rs);
    closeStatement(ps);
  }
}
