public void build(final DataFlowBuilderContext _context){
  _context.getBuilder().build((SNode)SLinkOperations.getTarget(_context.getNode(),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x11b0d00332cL,0xf8c77f1e99L,"rValue")));
  SNode variable=SLinkOperations.getTarget(_context.getNode(),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x11b0d00332cL,0xf8c77f1e97L,"lValue"));
  if (SNodeOperations.isInstanceOf(variable,MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8c77f1e98L,"jetbrains.mps.baseLanguage.structure.VariableReference"))) {
    if (!((SNodeOperations.isInstanceOf(variable,MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8c77f1e98L,"jetbrains.mps.baseLanguage.structure.VariableReference")) && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(variable,MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8c77f1e98L,"jetbrains.mps.baseLanguage.structure.VariableReference")),MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8c77f1e98L,0xf8cc6bf960L,"variableDeclaration")),MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc67c7efL,"jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration")))) || (boolean)VariableReference__BehaviorDescriptor.isVariableDefinedInThisMethod_idhPiSGi6.invoke(SNodeOperations.cast(variable,MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8c77f1e98L,"jetbrains.mps.baseLanguage.structure.VariableReference")))) {
      _context.getBuilder().emitWrite(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x11b0d00332cL,0xf8c77f1e97L,"lValue")),MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8c77f1e98L,"jetbrains.mps.baseLanguage.structure.VariableReference")),MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8c77f1e98L,0xf8cc6bf960L,"variableDeclaration")),SLinkOperations.getTarget(_context.getNode(),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x11b0d00332cL,0xf8c77f1e99L,"rValue")),"r:00000000-0000-4000-0000-011c895902c2(jetbrains.mps.baseLanguage.dataFlow)/1225456606795");
    }
  }
 else {
    if (SNodeOperations.isInstanceOf(variable,MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x116b46a08c4L,"jetbrains.mps.baseLanguage.structure.DotExpression")) && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(variable,MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x116b46a08c4L,"jetbrains.mps.baseLanguage.structure.DotExpression")),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x116b46a08c4L,0x116b46b36c4L,"operation")),MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x116b483d77aL,"jetbrains.mps.baseLanguage.structure.FieldReferenceOperation"))) {
      _context.getBuilder().emitWrite(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(SNodeOperations.cast(variable,MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x116b46a08c4L,"jetbrains.mps.baseLanguage.structure.DotExpression")),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x116b46a08c4L,0x116b46b36c4L,"operation")),MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x116b483d77aL,"jetbrains.mps.baseLanguage.structure.FieldReferenceOperation")),MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x116b483d77aL,0x116b484a653L,"fieldDeclaration")),SLinkOperations.getTarget(_context.getNode(),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x11b0d00332cL,0xf8c77f1e99L,"rValue")),"r:00000000-0000-4000-0000-011c895902c2(jetbrains.mps.baseLanguage.dataFlow)/2359846675286592328");
    }
 else {
      _context.getBuilder().build((SNode)SLinkOperations.getTarget(_context.getNode(),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x11b0d00332cL,0xf8c77f1e97L,"lValue")));
    }
  }
}