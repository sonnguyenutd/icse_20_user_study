public static void load(){
  if (metadata != null) {
    return;
  }
  try {
    String source=SpongeCoremod.modFile.toURI().toString();
    boolean isJar=source.endsWith(".jar");
    Enumeration<URL> urls=SpongeModMetadata.class.getClassLoader().getResources(McModInfo.STANDARD_FILENAME);
    while (urls.hasMoreElements()) {
      URL url=urls.nextElement();
      if (isJar) {
        if (!"jar".equals(url.getProtocol())) {
          continue;
        }
        if (!url.getPath().startsWith(source)) {
          continue;
        }
      }
 else       if (!"file".equals(url.getProtocol())) {
        continue;
      }
      try (InputStream in=url.openStream()){
        metadata=MetadataCollection.from(in,url.toString());
        ModMetadata meta=getSpongeForgeMetadata();
        if (!meta.autogenerated) {
          SpongeImpl.getLogger().info("Found mcmod.info at {}",url);
          return;
        }
      }
     }
  }
 catch (  IOException e) {
    SpongeImpl.getLogger().warn("Failed to load metadata",e);
  }
  if (metadata == null) {
    metadata=new MetadataCollection();
  }
}