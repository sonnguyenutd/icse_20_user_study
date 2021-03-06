/** 
 * Generate the statements for dropping all the objects of this type in this schema.
 * @param objectType  The type of object to drop (Sequence, constant, ...)
 * @param objectNames The names of the objects to drop.
 * @return The list of statements.
 */
private List<String> generateDropStatements(String objectType,List<String> objectNames){
  List<String> statements=new ArrayList<>();
  for (  String objectName : objectNames) {
    String dropStatement="DROP " + objectType + database.quote(name,objectName);
    statements.add(dropStatement);
  }
  return statements;
}
