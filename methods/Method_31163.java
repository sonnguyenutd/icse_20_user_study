/** 
 * Whether Flyway should issue a warning instead of an error whenever it encounters an Oracle SQL*Plus statement it doesn't yet support. <p><i>Flyway Pro and Flyway Enterprise only</i></p>
 * @param oracleSqlplusWarn  {@code true} to issue a warning. {@code false} to fail fast instead. (default: {@code false})
 */
public void setOracleSqlplusWarn(boolean oracleSqlplusWarn){
  throw new org.flywaydb.core.internal.license.FlywayProUpgradeRequiredException("oracle.sqlplusWarn");
}
