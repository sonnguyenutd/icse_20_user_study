public void run(){
  final Wrappers._T<SNode> contextClass=new Wrappers._T<SNode>();
  final Wrappers._T<SNode> contextMethod=new Wrappers._T<SNode>();
  final Wrappers._T<SNodeReference[]> methods=new Wrappers._T<SNodeReference[]>();
  myProject.getModelAccess().runReadAction(new Runnable(){
    public void run(){
      contextClass.value=SNodeOperations.getNodeAncestor(mySelectedNode,MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L,0x87d963a55f2a9db1L,0x11d43447b1aL,"jetbrains.mps.lang.behavior.structure.ConceptBehavior"),true,false);
      contextMethod.value=SNodeOperations.getNodeAncestor(mySelectedNode,MetaAdapterFactory.getConcept(0xaf65afd8f0dd4942L,0x87d963a55f2a9db1L,0x11d4348057eL,"jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"),true,false);
      List<SNode> methodsToOverride=((List<SNode>)BHReflection.invoke0(contextClass.value,MetaAdapterFactory.getInterfaceConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x11638b31955L,"jetbrains.mps.baseLanguage.structure.IMemberContainer"),SMethodTrimmedId.create("getMethodsToImplement",null,"4GM03FJm5q2")));
      if (myIsOverride) {
        ListSequence.fromList(methodsToOverride).addSequence(ListSequence.fromList(((List<SNode>)BHReflection.invoke0(contextClass.value,MetaAdapterFactory.getInterfaceConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0x11638b31955L,"jetbrains.mps.baseLanguage.structure.IMemberContainer"),SMethodTrimmedId.create("getMethodsToOverride",null,"4GM03FJm3zL")))));
      }
      methods.value=OverrideConceptMethodsDialog.toNodePointers(OverrideConceptMethodsDialog.sortMethods(contextClass.value,methodsToOverride));
    }
  }
);
  final OverrideConceptMethodsDialog dialog=new OverrideConceptMethodsDialog(methods.value,ProjectHelper.toIdeaProject(myProject)){
    @Override protected boolean showInsertOverride(){
      return myIsOverride;
    }
  }
;
  dialog.setTitle((myIsOverride ? "Select Behavior Methods to Override/Implement" : "Select Behavior Methods to Implement"));
  dialog.show();
  if (dialog.isOK()) {
    final Iterable<SNodeReference> selectedElements=(Iterable<SNodeReference>)dialog.getSelectedElements();
    myProject.getModelAccess().executeCommandInEDT(new Runnable(){
      public void run(){
        List<SNode> selection=Sequence.fromIterable(selectedElements).select(new ISelector<SNodeReference,SNode>(){
          public SNode select(          SNodeReference it){
            return SNodeOperations.cast(it.resolve(myProject.getRepository()),MetaAdapterFactory.getConcept(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,"jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"));
          }
        }
).toListSequence();
        OverrideConceptMethodsHelper helper=new OverrideConceptMethodsHelper(myProject,contextClass.value,contextMethod.value,dialog.isRemoveAttributes(),dialog.isAddReturn());
        List<SNode> insertedMethods=helper.insertMethods(selection);
        if (insertedMethods.isEmpty()) {
          return;
        }
        MoveRefactoringUtils.fixImportsFromNode(contextClass.value);
        SNode firstMethod=ListSequence.fromList(insertedMethods).first();
        SNode nodeToSelect;
        if (ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(firstMethod,MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1ffL,"body")),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b200L,0xf8cc6bf961L,"statement"))).isNotEmpty()) {
          nodeToSelect=ListSequence.fromList(SLinkOperations.getChildren(SLinkOperations.getTarget(firstMethod,MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b1fcL,0xf8cc56b1ffL,"body")),MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L,0xa443f952ceaf5816L,0xf8cc56b200L,0xf8cc6bf961L,"statement"))).first();
        }
 else {
          nodeToSelect=firstMethod;
        }
        myEditorContext.flushEvents();
        myEditorContext.getSelectionManager().setSelection(nodeToSelect);
      }
    }
);
  }
}
