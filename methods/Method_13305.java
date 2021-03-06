protected void openHyperlink(int x,int y,HyperlinkData hyperlinkData){
  TypeHyperlinkData data=(TypeHyperlinkData)hyperlinkData;
  if (data.enabled) {
    try {
      Point location=textArea.getLocationOnScreen();
      int offset=textArea.viewToModel(new Point(x - location.x,y - location.y));
      URI uri=entry.getUri();
      api.addURI(new URI(uri.getScheme(),uri.getAuthority(),uri.getPath(),"position=" + offset,null));
      String internalTypeName=data.internalTypeName;
      List<Container.Entry> entries=IndexesUtil.findInternalTypeName(collectionOfFutureIndexes,internalTypeName);
      String rootUri=entry.getContainer().getRoot().getUri().toString();
      ArrayList<Container.Entry> sameContainerEntries=new ArrayList<>();
      for (      Container.Entry entry : entries) {
        if (entry.getUri().toString().startsWith(rootUri)) {
          sameContainerEntries.add(entry);
        }
      }
      if (sameContainerEntries.size() > 0) {
        api.openURI(x,y,sameContainerEntries,null,data.internalTypeName);
      }
 else       if (entries.size() > 0) {
        api.openURI(x,y,entries,null,data.internalTypeName);
      }
    }
 catch (    URISyntaxException e) {
      assert ExceptionUtil.printStackTrace(e);
    }
  }
}
