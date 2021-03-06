public static List<Map<String,String>> parseDBXML(String xml) throws Exception {
  Document document=DocumentHelper.parseText(xml);
  Element rootElement=document.getRootElement();
  Iterator<Element> resultIterator=rootElement.elementIterator("Result");
  if (!resultIterator.hasNext()) {
    return null;
  }
  Element resultElement=resultIterator.next();
  Iterator<Element> docIterator=resultElement.elementIterator("Document");
  if (!docIterator.hasNext()) {
    return null;
  }
  List<Map<String,String>> docInfos=new ArrayList<Map<String,String>>();
  while (docIterator.hasNext()) {
    Element docElement=docIterator.next();
    Iterator<Element> childIter=docElement.elementIterator();
    Map<String,String> map=new HashMap<String,String>();
    while (childIter.hasNext()) {
      Element attr=childIter.next();
      map.put(attr.getName().trim(),attr.getText().trim());
    }
    docInfos.add(map);
  }
  return docInfos;
}
