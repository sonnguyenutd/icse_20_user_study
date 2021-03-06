/** 
 * Returns the size of the Module, ModulePackages and ModuleMainClass attributes generated by this ModuleWriter. Also add the names of these attributes in the constant pool.
 * @return the size in bytes of the Module, ModulePackages and ModuleMainClass attributes.
 */
int computeAttributesSize(){
  symbolTable.addConstantUtf8(Constants.MODULE);
  int size=22 + requires.length + exports.length + opens.length + usesIndex.length + provides.length;
  if (packageCount > 0) {
    symbolTable.addConstantUtf8(Constants.MODULE_PACKAGES);
    size+=8 + packageIndex.length;
  }
  if (mainClassIndex > 0) {
    symbolTable.addConstantUtf8(Constants.MODULE_MAIN_CLASS);
    size+=8;
  }
  return size;
}
