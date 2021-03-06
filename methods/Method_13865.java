@Override public DatabaseInfo testQuery(DatabaseConfiguration dbConfig,String query) throws DatabaseServiceException {
  Statement statement=null;
  ResultSet queryResult=null;
  try {
    Connection connection=MySQLConnectionManager.getInstance().getConnection(dbConfig,true);
    statement=connection.createStatement();
    queryResult=statement.executeQuery(query);
    DatabaseInfo dbInfo=new DatabaseInfo();
    return dbInfo;
  }
 catch (  SQLException e) {
    logger.error("SQLException::",e);
    throw new DatabaseServiceException(true,e.getSQLState(),e.getErrorCode(),e.getMessage());
  }
 finally {
    try {
      if (queryResult != null) {
        queryResult.close();
      }
      if (statement != null) {
        statement.close();
      }
    }
 catch (    SQLException e) {
      e.printStackTrace();
    }
    MySQLConnectionManager.getInstance().shutdown();
  }
}
