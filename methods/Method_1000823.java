/** 
 * ????????????????? <p> ?????????Nutz ?????????????? ?????????????????????????????????????????? <p> ???????????????????????????????????????????? 'TRANSACTION_READ_COMMITTED'?????????????????????????????? 'TRANSACTION_READ_COMMITTED'? ???????? Transaction ????? setLevel ????????? 0 ????????? ????????? <p> ??????? Transaction ????????????????????????????? <p> ?????????????? Trans.setup ??????????? Nutz ????????? Transaction ??
 * @param level ?????? <p> ???????????? <ul> <li>java.sql.Connection.TRANSACTION_NONE <li>java.sql.Connection.TRANSACTION_READ_UNCOMMITTED <li>java.sql.Connection.TRANSACTION_READ_COMMITTED <li>java.sql.Connection.TRANSACTION_REPEATABLE_READ <li>java.sql.Connection.TRANSACTION_SERIALIZABLE </ul> ????????? JDBC ????????????????????????????? ???????????????????
 * @param atoms ??????
 * @see org.nutz.trans.Transaction
 * @see java.sql.Connection
 */
public static void exec(int level,Atom... atoms){
  if (null == atoms)   return;
  int num=count.get() == null ? 0 : count.get();
  try {
    _begain(level);
    for (    Atom atom : atoms)     atom.run();
    _commit();
  }
 catch (  Throwable e) {
    _rollback(num);
    throw Lang.wrapThrow(e);
  }
 finally {
    _depose();
  }
}