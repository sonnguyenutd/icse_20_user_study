public void process(Version indexCreatedVersion,@Nullable MappingMetaData mappingMd,String concreteIndex){
  if (mappingMd != null) {
    if (mappingMd.routing().required() && routing == null) {
      throw new RoutingMissingException(concreteIndex,type,id);
    }
    if (parent != null && !mappingMd.hasParentField()) {
      throw new IllegalArgumentException("can't specify parent if no parent field has been configured");
    }
  }
 else {
    if (parent != null) {
      throw new IllegalArgumentException("can't specify parent if no parent field has been configured");
    }
  }
  if ("".equals(id)) {
    throw new IllegalArgumentException("if _id is specified it must not be empty");
  }
  if (id == null) {
    assert autoGeneratedTimestamp == -1 : "timestamp has already been generated!";
    autoGeneratedTimestamp=Math.max(0,System.currentTimeMillis());
    String uid;
    if (indexCreatedVersion.onOrAfter(Version.V_6_0_0_beta1)) {
      uid=UUIDs.base64UUID();
    }
 else {
      uid=UUIDs.legacyBase64UUID();
    }
    id(uid);
  }
}