public void execute(SNode node){
  SLinkOperations.setTarget(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1fdL,"returnType"),SNodeOperations.copyNode(SLinkOperations.getTarget(SLinkOperations.getTarget(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getReferenceLink(0xaf65afd8f0dd4942L,0x87d963a55f2a9db1L,0x11d4348057eL,0x11d4348057fL,"overriddenMethod")),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1fdL,"returnType"))));
  int paramCount=ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getReferenceLink(0xaf65afd8f0dd4942L,0x87d963a55f2a9db1L,0x11d4348057eL,0x11d4348057fL,"overriddenMethod")),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1feL,"parameter"))).count();
  int currentParamCount=ListSequence.fromList(SLinkOperations.getChildren(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1feL,"parameter"))).count();
  for (int i=0; i < Math.max(paramCount,currentParamCount); i++) {
    if (i < paramCount && i < currentParamCount) {
      SLinkOperations.setTarget(ListSequence.fromList(SLinkOperations.getChildren(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1feL,"parameter"))).getElement(i),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x450368d90ce15bc3L,0x4ed4d318133c80ceL,"type"),SNodeOperations.copyNode(SLinkOperations.getTarget(ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getReferenceLink(0xaf65afd8f0dd4942L,0x87d963a55f2a9db1L,0x11d4348057eL,0x11d4348057fL,"overriddenMethod")),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1feL,"parameter"))).getElement(i),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x450368d90ce15bc3L,0x4ed4d318133c80ceL,"type"))));
    }
    if (i >= currentParamCount) {
      ListSequence.fromList(SLinkOperations.getChildren(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1feL,"parameter"))).addElement(SNodeOperations.copyNode(ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getReferenceLink(0xaf65afd8f0dd4942L,0x87d963a55f2a9db1L,0x11d4348057eL,0x11d4348057fL,"overriddenMethod")),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1feL,"parameter"))).getElement(i)));
    }
    if (i >= paramCount) {
      for (int j=0; j < currentParamCount - paramCount; j++) {
        SNodeOperations.deleteNode(ListSequence.fromList(SLinkOperations.getChildren(((SNode)FixMethodSignature_QuickFix.this.getField("conceptMethod")[0]),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1feL,"parameter"))).getElement(i));
      }
      break;
    }
  }
}
