public Collection<SNode> apply(@NotNull final TemplateExecutionEnvironment environment,@NotNull final TemplateContext context) throws GenerationException {
  final SNode tnode1=environment.createOutputNode(myConcepts[0]);
  try {
    environment.nodeCopied(context,tnode1,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7385785963572922999");
    SNodeAccessUtil.setProperty(tnode1,myProperties[0],"true");
    SNodeAccessUtil.setProperty(tnode1,myProperties[1],"");
    SNodeAccessUtil.setProperty(tnode1,myProperties[2],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_12(new PropertyMacroContext(context,"BehaviorDescriptor",propertyMacro_sy2aw3_c0a0c0d0b0e))));
    TemplateContext context1=context.subContext();
{
      Collection<SNode> tlist2=null;
      TemplateContext context2=context1.subContext("BHClassConceptField");
      final SNode tnode3=environment.createOutputNode(myConcepts[1]);
      try {
        environment.nodeCopied(context2,tnode3,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/4006517209906245669");
        SNodeAccessUtil.setProperty(tnode3,myProperties[3],"false");
        SNodeAccessUtil.setProperty(tnode3,myProperties[4],"false");
        SNodeAccessUtil.setProperty(tnode3,myProperties[2],"CONCEPT");
        SNodeAccessUtil.setProperty(tnode3,myProperties[5],"true");
        TemplateContext context3=context2.subContext();
{
          final SNode tnode4=environment.createOutputNode(myConcepts[2]);
          try {
          }
  finally {
          }
          tnode3.addChild(myAggregationLinks[0],tnode4);
        }
{
          final SNode tnode5=environment.createOutputNode(myConcepts[3]);
          try {
            environment.resolve(new RefResolver(tnode5,myAssociationLinks[0],context3,new SNodePointer("r:229ce18d-2bb0-4d5b-a7cd-cec65841e459(jetbrains.mps.lang.behavior.generator.template.main@generator)","4006517209906256416"),"BaseConcept"){
              @Override public Object resolve(){
                return QueriesGenerated.referenceMacro_GetReferent_6_0(createQueryContext());
              }
            }
);
          }
  finally {
          }
          tnode3.addChild(myAggregationLinks[1],tnode5);
        }
{
          final SNode tnode6=environment.createOutputNode(myConcepts[4]);
          try {
            tnode6.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode6,PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.language(MPS.OpenAPI/)"),PersistenceFacade.getInstance().createNodeId("~SAbstractConcept")));
          }
  finally {
          }
          tnode3.addChild(myAggregationLinks[2],tnode6);
        }
      }
  finally {
      }
      tlist2=TemplateUtil.singletonList(tnode3);
      environment.registerLabel(context1.getInput(),tnode3,"BHClassConceptField");
      for (      SNode child7 : TemplateUtil.asNotNull(tlist2)) {
        tnode1.addChild(myAggregationLinks[3],child7);
      }
    }
{
      final SNode tnode8=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode8);
    }
{
      final List<SNode> tlist9=new ArrayList<SNode>();
      final Iterable<SNode> loopList9=QueriesGenerated.sourceNodesQuery_6_1(new SourceSubstituteMacroNodesContext(context1,loopMacroRef_sy2aw3_b0a0a1a7a1a4));
      int loopIndex_methodCounter_9=0;
      for (      SNode itnode9 : loopList9) {
        if (itnode9 == null) {
          continue;
        }
        TemplateContext context4=context1.subContext("BHMethodInDescriptor",itnode9);
        context4=context4.withVariable("cv:methodCounter",loopIndex_methodCounter_9++);
        final SNode tnode10=environment.createOutputNode(myConcepts[1]);
        try {
          environment.nodeCopied(context4,tnode10,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/3176885412940615040");
          SNodeAccessUtil.setProperty(tnode10,myProperties[5],"true");
          SNodeAccessUtil.setProperty(tnode10,myProperties[2],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_3(new PropertyMacroContext(context4,"BH_METHOD",propertyMacro_sy2aw3_c0a0c0c0e0d0h0b0e))));
          TemplateContext context5=context4.subContext();
{
            final SNode tnode11=environment.createOutputNode(myConcepts[4]);
            try {
              tnode11.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode11,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~SMethod")));
              TemplateContext context6=context5.subContext();
{
                Collection<SNode> tlist12=null;
                final SNode copySrcInput12=QueriesGenerated.sourceNodeQuery_6_0(new SourceSubstituteMacroNodeContext(context6,copySrcMacro_sy2aw3_b0a0c0c0b0e0e0d0h0b0e));
                tlist12=environment.copyNodes(TemplateUtil.singletonList(copySrcInput12),copySrcMacro_sy2aw3_b0a0c0c0b0e0e0d0h0b0e,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/3176885412940615042",context6);
                for (                SNode child13 : TemplateUtil.asNotNull(tlist12)) {
                  tnode11.addChild(myAggregationLinks[4],child13);
                }
              }
            }
  finally {
            }
            tnode10.addChild(myAggregationLinks[2],tnode11);
          }
{
            Collection<SNode> tlist14=null;
            if (QueriesGenerated.ifMacro_Condition_6_0(new IfMacroContext(context5,ifMacroRef_sy2aw3_b0a0b0f0e0d0h0b0e))) {
              final SNode tnode15=environment.createOutputNode(myConcepts[6]);
              try {
              }
  finally {
              }
              tlist14=TemplateUtil.singletonList(tnode15);
            }
            for (            SNode child16 : TemplateUtil.asNotNull(tlist14)) {
              tnode10.addChild(myAggregationLinks[0],child16);
            }
          }
{
            final SNode tnode17=environment.createOutputNode(myConcepts[7]);
            try {
              TemplateContext context7=context5.subContext();
{
                final SNode tnode18=environment.createOutputNode(myConcepts[7]);
                try {
                  TemplateContext context8=context7.subContext();
{
                    final SNode tnode19=environment.createOutputNode(myConcepts[7]);
                    try {
                      TemplateContext context9=context8.subContext();
{
                        final SNode tnode20=environment.createOutputNode(myConcepts[7]);
                        try {
                          TemplateContext context10=context9.subContext();
{
                            final SNode tnode21=environment.createOutputNode(myConcepts[7]);
                            try {
                              TemplateContext context11=context10.subContext();
{
                                final SNode tnode22=environment.createOutputNode(myConcepts[8]);
                                try {
                                  TemplateContext context12=context11.subContext();
{
                                    final SNode tnode23=environment.createOutputNode(myConcepts[9]);
                                    try {
                                      tnode23.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode23,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SMethodBuilder.<init>(jetbrains.mps.core.aspects.behaviour.api.SAbstractType)")));
                                      TemplateContext context13=context12.subContext();
{
                                        final SNode tnode24=environment.createOutputNode(myConcepts[8]);
                                        try {
                                          TemplateContext context14=context13.subContext();
{
                                            final SNode tnode25=environment.createOutputNode(myConcepts[9]);
                                            try {
                                              tnode25.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode25,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SJavaCompoundTypeImpl.<init>(java.lang.Class)")));
                                              TemplateContext context15=context14.subContext();
{
                                                Collection<SNode> tlist26=null;
{
                                                  final SNode switchInput26=QueriesGenerated.sourceNodeQuery_6_1(new SourceSubstituteMacroNodeContext(context15,switchMacroRef_sy2aw3_b0a0a0a1a2a1a1a1a2a1a1a1a1a1a1a1a1a1a1a1a1a1a6a4a3a7a1a4));
                                                  if (switchInput26 == null) {
                                                    tlist26=Collections.emptyList();
                                                  }
 else {
                                                    TemplateContext switchContext26;
                                                    switchContext26=context15.subContext(null,switchInput26);
                                                    tlist26=environment.trySwitch(templateSwitchNode_sy2aw3_a0a0c0a1a1a2a1a1a1a2a1a1a1a1a1a1a1a1a1a1a1a1a1a6a4a3a7a1a4,switchContext26);
                                                    if (tlist26 == null) {
                                                      final SNode tnode27=environment.createOutputNode(myConcepts[10]);
                                                      try {
                                                      }
  finally {
                                                      }
                                                      if (tnode27 != null) {
                                                        tlist26=TemplateUtil.singletonList(tnode27);
                                                      }
                                                    }
                                                  }
                                                }
                                                for (                                                SNode child28 : TemplateUtil.asNotNull(tlist26)) {
                                                  tnode25.addChild(myAggregationLinks[5],child28);
                                                }
                                              }
                                            }
  finally {
                                            }
                                            tnode24.addChild(myAggregationLinks[6],tnode25);
                                          }
                                        }
  finally {
                                        }
                                        tnode23.addChild(myAggregationLinks[5],tnode24);
                                      }
{
                                        Collection<SNode> tlist29=null;
                                        final SNode copySrcInput29=QueriesGenerated.sourceNodeQuery_6_2(new SourceSubstituteMacroNodeContext(context13,copySrcMacro_sy2aw3_b0a0c0d0b0b0b0b0b0b0b0b0b0b0b0b0b0g0e0d0h0b0e));
                                        tlist29=environment.copyNodes(TemplateUtil.singletonList(copySrcInput29),copySrcMacro_sy2aw3_b0a0c0d0b0b0b0b0b0b0b0b0b0b0b0b0b0g0e0d0h0b0e,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7433446194418124032",context13);
                                        for (                                        SNode child30 : TemplateUtil.asNotNull(tlist29)) {
                                          tnode23.addChild(myAggregationLinks[7],child30);
                                        }
                                      }
                                    }
  finally {
                                    }
                                    tnode22.addChild(myAggregationLinks[6],tnode23);
                                  }
                                }
  finally {
                                }
                                tnode21.addChild(myAggregationLinks[8],tnode22);
                              }
{
                                final SNode tnode31=environment.createOutputNode(myConcepts[11]);
                                try {
                                  tnode31.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode31,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SMethodBuilder.name(java.lang.String)")));
                                  TemplateContext context16=context11.subContext();
{
                                    final SNode tnode32=environment.createOutputNode(myConcepts[12]);
                                    try {
                                      SNodeAccessUtil.setProperty(tnode32,myProperties[6],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_0(new PropertyMacroContext(context16,"methodName",propertyMacro_sy2aw3_c0a0c0a0b0c0b0c0b0b0b0b0b0b0b0b0b0g0e0d0h0b0e))));
                                    }
  finally {
                                    }
                                    tnode31.addChild(myAggregationLinks[5],tnode32);
                                  }
                                }
  finally {
                                }
                                tnode21.addChild(myAggregationLinks[9],tnode31);
                              }
                            }
  finally {
                            }
                            tnode20.addChild(myAggregationLinks[8],tnode21);
                          }
{
                            final SNode tnode33=environment.createOutputNode(myConcepts[11]);
                            try {
                              tnode33.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode33,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SMethodBuilder.modifiers(jetbrains.mps.core.aspects.behaviour.SModifiersImpl)")));
                              TemplateContext context17=context10.subContext();
{
                                final SNode tnode34=environment.createOutputNode(myConcepts[13]);
                                try {
                                  tnode34.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode34,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SModifiersImpl.create(int,jetbrains.mps.core.aspects.behaviour.AccessPrivileges)")));
                                  tnode34.setReference(myAssociationLinks[3],SReference.create(myAssociationLinks[3],tnode34,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SModifiersImpl")));
                                  TemplateContext context18=context17.subContext();
{
                                    final SNode tnode35=environment.createOutputNode(myConcepts[14]);
                                    try {
                                      SNodeAccessUtil.setProperty(tnode35,myProperties[7],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_1(new PropertyMacroContext(context18,"0",propertyMacro_sy2aw3_c0a0c0a0b0d0b0c0b0c0b0b0b0b0b0b0b0g0e0d0h0b0e))));
                                    }
  finally {
                                    }
                                    tnode34.addChild(myAggregationLinks[5],tnode35);
                                  }
{
                                    final SNode tnode36=environment.createOutputNode(myConcepts[15]);
                                    try {
                                      tnode36.setReference(myAssociationLinks[4],SReference.create(myAssociationLinks[4],tnode36,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~AccessPrivileges")));
                                      environment.resolve(new RefResolver(tnode36,myAssociationLinks[5],context18,new SNodePointer("r:229ce18d-2bb0-4d5b-a7cd-cec65841e459(jetbrains.mps.lang.behavior.generator.template.main@generator)","2386721254951859759"),"PRIVATE"){
                                        @Override public Object resolve(){
                                          return QueriesGenerated.referenceMacro_GetReferent_6_1(createQueryContext());
                                        }
                                      }
);
                                    }
  finally {
                                    }
                                    tnode34.addChild(myAggregationLinks[5],tnode36);
                                  }
                                }
  finally {
                                }
                                tnode33.addChild(myAggregationLinks[5],tnode34);
                              }
                            }
  finally {
                            }
                            tnode20.addChild(myAggregationLinks[9],tnode33);
                          }
                        }
  finally {
                        }
                        tnode19.addChild(myAggregationLinks[8],tnode20);
                      }
{
                        final SNode tnode37=environment.createOutputNode(myConcepts[11]);
                        try {
                          tnode37.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode37,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SMethodBuilder.concept(org.jetbrains.mps.openapi.language.SAbstractConcept)")));
                          TemplateContext context19=context9.subContext();
{
                            final SNode tnode38=environment.createOutputNode(myConcepts[16]);
                            try {
                              environment.resolveInTemplateLater(tnode38,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a2a1a2a1a1a1a1a1a6a4a3a7a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/4006517209906245669","CONCEPT",context19);
                            }
  finally {
                            }
                            tnode37.addChild(myAggregationLinks[5],tnode38);
                          }
                        }
  finally {
                        }
                        tnode19.addChild(myAggregationLinks[9],tnode37);
                      }
                    }
  finally {
                    }
                    tnode18.addChild(myAggregationLinks[8],tnode19);
                  }
{
                    final SNode tnode39=environment.createOutputNode(myConcepts[11]);
                    try {
                      tnode39.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode39,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SMethodBuilder.id(java.lang.String)")));
                      TemplateContext context20=context8.subContext();
{
                        final SNode tnode40=environment.createOutputNode(myConcepts[12]);
                        try {
                          SNodeAccessUtil.setProperty(tnode40,myProperties[6],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_2(new PropertyMacroContext(context20,"nodeId123",propertyMacro_sy2aw3_c0a0c0a0b0c0b0c0b0b0b0g0e0d0h0b0e))));
                        }
  finally {
                        }
                        tnode39.addChild(myAggregationLinks[5],tnode40);
                      }
                    }
  finally {
                    }
                    tnode18.addChild(myAggregationLinks[9],tnode39);
                  }
                }
  finally {
                }
                tnode17.addChild(myAggregationLinks[8],tnode18);
              }
{
                final SNode tnode41=environment.createOutputNode(myConcepts[11]);
                try {
                  tnode41.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode41,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~SMethodBuilder.build(jetbrains.mps.core.aspects.behaviour.api.SParameter...)")));
                  TemplateContext context21=context7.subContext();
{
                    final List<SNode> tlist42=new ArrayList<SNode>();
                    final Iterable<SNode> loopList42=QueriesGenerated.sourceNodesQuery_6_0(new SourceSubstituteMacroNodesContext(context21,loopMacroRef_sy2aw3_b0a0a1a2a1a2a1a6a4a3a7a1a4));
                    for (                    SNode itnode42 : loopList42) {
                      if (itnode42 == null) {
                        continue;
                      }
                      TemplateContext context22=context21.subContext(itnode42);
                      Collection<SNode> tlist43=null;
                      try {
                        TemplateContext switchContext43;
                        switchContext43=context22;
                        tlist43=environment.trySwitch(templateSwitchNodeNoInput_sy2aw3_a0a0c0d0c0c0b0c0b0g0e0d0h0b0e,switchContext43);
                        if (tlist43 == null) {
                          final SNode tnode44=environment.createOutputNode(myConcepts[10]);
                          try {
                          }
  finally {
                          }
                          if (tnode44 != null) {
                            tlist43=TemplateUtil.singletonList(tnode44);
                          }
                        }
                      }
  finally {
                      }
                      if (tlist43 != null) {
                        tlist42.addAll(tlist43);
                      }
                    }
                    for (                    SNode child45 : TemplateUtil.asNotNull(tlist42)) {
                      tnode41.addChild(myAggregationLinks[5],child45);
                    }
                  }
                }
  finally {
                }
                tnode17.addChild(myAggregationLinks[9],tnode41);
              }
            }
  finally {
            }
            tnode10.addChild(myAggregationLinks[1],tnode17);
          }
        }
  finally {
        }
        if (tnode10 != null) {
          environment.registerLabel(itnode9,tnode10,"BHMethodInDescriptor");
          tlist9.add(tnode10);
        }
      }
      for (      SNode child46 : TemplateUtil.asNotNull(tlist9)) {
        tnode1.addChild(myAggregationLinks[3],child46);
      }
    }
{
      final SNode tnode47=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode47);
    }
{
      final SNode tnode48=environment.createOutputNode(myConcepts[1]);
      try {
        environment.nodeCopied(context1,tnode48,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/6029283687668622501");
        SNodeAccessUtil.setProperty(tnode48,myProperties[2],"BH_METHODS");
        SNodeAccessUtil.setProperty(tnode48,myProperties[5],"true");
        TemplateContext context23=context1.subContext();
{
          final SNode tnode49=environment.createOutputNode(myConcepts[4]);
          try {
            tnode49.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode49,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)"),PersistenceFacade.getInstance().createNodeId("~List")));
            TemplateContext context24=context23.subContext();
{
              final SNode tnode50=environment.createOutputNode(myConcepts[4]);
              try {
                tnode50.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode50,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~SMethod")));
                TemplateContext context25=context24.subContext();
{
                  final SNode tnode51=environment.createOutputNode(myConcepts[17]);
                  try {
                  }
  finally {
                  }
                  tnode50.addChild(myAggregationLinks[4],tnode51);
                }
              }
  finally {
              }
              tnode49.addChild(myAggregationLinks[4],tnode50);
            }
          }
  finally {
          }
          tnode48.addChild(myAggregationLinks[2],tnode49);
        }
{
          final SNode tnode52=environment.createOutputNode(myConcepts[2]);
          try {
          }
  finally {
          }
          tnode48.addChild(myAggregationLinks[0],tnode52);
        }
{
          final SNode tnode53=environment.createOutputNode(myConcepts[13]);
          try {
            tnode53.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode53,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Arrays.asList(java.lang.Object...)")));
            tnode53.setReference(myAssociationLinks[3],SReference.create(myAssociationLinks[3],tnode53,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Arrays")));
            TemplateContext context26=context23.subContext();
{
              final List<SNode> tlist54=new ArrayList<SNode>();
              final Iterable<SNode> loopList54=QueriesGenerated.sourceNodesQuery_6_2(new SourceSubstituteMacroNodesContext(context26,loopMacroRef_sy2aw3_b0a0a1a3a1a6a1a9a1a4));
              for (              SNode itnode54 : loopList54) {
                if (itnode54 == null) {
                  continue;
                }
                TemplateContext context27=context26.subContext(itnode54);
                final SNode tnode55=environment.createOutputNode(myConcepts[16]);
                try {
                  environment.resolve(new RefResolver(tnode55,myAssociationLinks[6],context27,new SNodePointer("r:229ce18d-2bb0-4d5b-a7cd-cec65841e459(jetbrains.mps.lang.behavior.generator.template.main@generator)","737333977598577048"),"BH_METHOD"){
                    @Override public Object resolve(){
                      return QueriesGenerated.referenceMacro_GetReferent_6_2(createQueryContext());
                    }
                  }
);
                }
  finally {
                }
                if (tnode55 != null) {
                  tlist54.add(tnode55);
                }
              }
              for (              SNode child56 : TemplateUtil.asNotNull(tlist54)) {
                tnode53.addChild(myAggregationLinks[5],child56);
              }
            }
{
              final SNode tnode57=environment.createOutputNode(myConcepts[4]);
              try {
                tnode57.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode57,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~SMethod")));
                TemplateContext context28=context26.subContext();
{
                  final SNode tnode58=environment.createOutputNode(myConcepts[17]);
                  try {
                  }
  finally {
                  }
                  tnode57.addChild(myAggregationLinks[4],tnode58);
                }
              }
  finally {
              }
              tnode53.addChild(myAggregationLinks[10],tnode57);
            }
          }
  finally {
          }
          tnode48.addChild(myAggregationLinks[1],tnode53);
        }
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode48);
    }
{
      final SNode tnode59=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode59);
    }
{
      final SNode tnode60=environment.createOutputNode(myConcepts[18]);
      try {
        environment.nodeCopied(context1,tnode60,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/1843690775058889163");
        SNodeAccessUtil.setProperty(tnode60,myProperties[2],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_5(new PropertyMacroContext(context1,"__init__",propertyMacro_sy2aw3_c0a0c0b0b0l0b0e))));
        TemplateContext context29=context1.subContext();
{
          final SNode tnode61=environment.createOutputNode(myConcepts[2]);
          try {
          }
  finally {
          }
          tnode60.addChild(myAggregationLinks[0],tnode61);
        }
{
          final SNode tnode62=environment.createOutputNode(myConcepts[19]);
          try {
          }
  finally {
          }
          tnode60.addChild(myAggregationLinks[11],tnode62);
        }
{
          final SNode tnode63=environment.createOutputNode(myConcepts[20]);
          try {
            TemplateContext context30=context29.subContext();
{
              Collection<SNode> tlist64=null;
              final Iterable<SNode> copyListInput64=QueriesGenerated.sourceNodesQuery_6_3(new SourceSubstituteMacroNodesContext(context30,copySrcListMacro_sy2aw3_b0a0a1a1a1a5a1a11a1a4));
              tlist64=environment.copyNodes(copyListInput64,copySrcListMacro_sy2aw3_b0a0a1a1a1a5a1a11a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/737333977599945405",context30);
              for (              SNode child65 : TemplateUtil.asNotNull(tlist64)) {
                tnode63.addChild(myAggregationLinks[12],child65);
              }
            }
          }
  finally {
          }
          tnode60.addChild(myAggregationLinks[13],tnode63);
        }
{
          final SNode tnode66=environment.createOutputNode(myConcepts[21]);
          try {
            SNodeAccessUtil.setProperty(tnode66,myProperties[2],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_4(new PropertyMacroContext(context29,"thisNode",propertyMacro_sy2aw3_c0a0c0a0b0g0b0l0b0e))));
            TemplateContext context31=context29.subContext();
{
              final SNode tnode67=environment.createOutputNode(myConcepts[4]);
              try {
                tnode67.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode67,PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.model(MPS.OpenAPI/)"),PersistenceFacade.getInstance().createNodeId("~SNode")));
              }
  finally {
              }
              tnode66.addChild(myAggregationLinks[2],tnode67);
            }
{
              final SNode tnode68=environment.createOutputNode(myConcepts[22]);
              try {
                tnode68.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode68,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
              }
  finally {
              }
              tnode66.addChild(myAggregationLinks[14],tnode68);
            }
          }
  finally {
          }
          tnode60.addChild(myAggregationLinks[15],tnode66);
        }
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode60);
    }
{
      final SNode tnode69=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode69);
    }
{
      final List<SNode> tlist70=new ArrayList<SNode>();
      final Iterable<SNode> loopList70=QueriesGenerated.sourceNodesQuery_6_6(new SourceSubstituteMacroNodesContext(context1,loopMacroRef_sy2aw3_b0a0a1a31a1a4));
      int loopIndex_methodCounter_70=0;
      for (      SNode itnode70 : loopList70) {
        if (itnode70 == null) {
          continue;
        }
        TemplateContext context32=context1.subContext("BHMethodImpl",itnode70);
        context32=context32.withVariable("cv:methodCounter",loopIndex_methodCounter_70++);
        final SNode tnode71=environment.createOutputNode(myConcepts[18]);
        try {
          environment.nodeCopied(context32,tnode71,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/1843690775058968398");
          SNodeAccessUtil.setProperty(tnode71,myProperties[2],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_6(new PropertyMacroContext(context32,"bhMethodImpl",propertyMacro_sy2aw3_c0a0c0b0e0d0n0b0e))));
          TemplateContext context33=context32.subContext();
{
            Collection<SNode> tlist72=null;
            final SNode copySrcInput72=QueriesGenerated.sourceNodeQuery_6_3(new SourceSubstituteMacroNodeContext(context33,copySrcMacro_sy2aw3_b0a0c0d0e0d0n0b0e));
            tlist72=environment.copyNodes(TemplateUtil.singletonList(copySrcInput72),copySrcMacro_sy2aw3_b0a0c0d0e0d0n0b0e,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/1843690775058968444",context33);
            for (            SNode child73 : TemplateUtil.asNotNull(tlist72)) {
              tnode71.addChild(myAggregationLinks[11],child73);
            }
          }
{
            Collection<SNode> tlist74=null;
            if (QueriesGenerated.ifMacro_Condition_6_1(new IfMacroContext(context33,ifMacroRef_sy2aw3_b0a0b0e0e0d0n0b0e))) {
              final SNode tnode75=environment.createOutputNode(myConcepts[21]);
              try {
                SNodeAccessUtil.setProperty(tnode75,myProperties[2],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_7(new PropertyMacroContext(context33,"thisNode",propertyMacro_sy2aw3_c0a0c0a0b0b0e0e0d0n0b0e))));
                TemplateContext context34=context33.subContext();
{
                  final SNode tnode76=environment.createOutputNode(myConcepts[4]);
                  try {
                    tnode76.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode76,PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.model(MPS.OpenAPI/)"),PersistenceFacade.getInstance().createNodeId("~SNode")));
                  }
  finally {
                  }
                  tnode75.addChild(myAggregationLinks[2],tnode76);
                }
{
                  final SNode tnode77=environment.createOutputNode(myConcepts[22]);
                  try {
                    tnode77.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode77,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
                  }
  finally {
                  }
                  tnode75.addChild(myAggregationLinks[14],tnode77);
                }
              }
  finally {
              }
              tlist74=TemplateUtil.singletonList(tnode75);
            }
 else {
              final SNode tnode78=environment.createOutputNode(myConcepts[21]);
              try {
                SNodeAccessUtil.setProperty(tnode78,myProperties[2],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_8(new PropertyMacroContext(context33,"thisConcept",propertyMacro_sy2aw3_c0a0c0a0b0a1a4a4a3a31a1a4))));
                TemplateContext context35=context33.subContext();
{
                  final SNode tnode79=environment.createOutputNode(myConcepts[4]);
                  try {
                    tnode79.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode79,PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.language(MPS.OpenAPI/)"),PersistenceFacade.getInstance().createNodeId("~SAbstractConcept")));
                  }
  finally {
                  }
                  tnode78.addChild(myAggregationLinks[2],tnode79);
                }
{
                  final SNode tnode80=environment.createOutputNode(myConcepts[22]);
                  try {
                    tnode80.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode80,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
                  }
  finally {
                  }
                  tnode78.addChild(myAggregationLinks[14],tnode80);
                }
              }
  finally {
              }
              tlist74=TemplateUtil.singletonList(tnode78);
            }
            for (            SNode child81 : TemplateUtil.asNotNull(tlist74)) {
              tnode71.addChild(myAggregationLinks[15],child81);
            }
          }
{
            final List<SNode> tlist82=new ArrayList<SNode>();
            final Iterable<SNode> loopList82=QueriesGenerated.sourceNodesQuery_6_4(new SourceSubstituteMacroNodesContext(context33,loopMacroRef_sy2aw3_b0a0a1a5a4a3a31a1a4));
            for (            SNode itnode82 : loopList82) {
              if (itnode82 == null) {
                continue;
              }
              TemplateContext context36=context33.subContext(itnode82);
              Collection<SNode> tlist83=null;
              final SNode copySrcInput83=QueriesGenerated.sourceNodeQuery_6_4(new SourceSubstituteMacroNodeContext(context36,copySrcMacro_sy2aw3_b0a0e0c0f0e0d0n0b0e));
              tlist83=environment.copyNodes(TemplateUtil.singletonList(copySrcInput83),copySrcMacro_sy2aw3_b0a0e0c0f0e0d0n0b0e,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/163705066662147889",context36);
              if (tlist83 != null) {
                tlist82.addAll(tlist83);
              }
            }
            for (            SNode child84 : TemplateUtil.asNotNull(tlist82)) {
              tnode71.addChild(myAggregationLinks[15],child84);
            }
          }
{
            Collection<SNode> tlist85=null;
            final Iterable<SNode> copyListInput85=QueriesGenerated.sourceNodesQuery_6_5(new SourceSubstituteMacroNodesContext(context33,copySrcListMacro_sy2aw3_b0a0a1a6a4a3a31a1a4));
            tlist85=environment.copyNodes(copyListInput85,copySrcListMacro_sy2aw3_b0a0a1a6a4a3a31a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/1843690775058968474",context33);
            for (            SNode child86 : TemplateUtil.asNotNull(tlist85)) {
              tnode71.addChild(myAggregationLinks[14],child86);
            }
          }
{
            Collection<SNode> tlist87=null;
            final SNode copySrcInput87=QueriesGenerated.sourceNodeQuery_6_5(new SourceSubstituteMacroNodeContext(context33,copySrcMacro_sy2aw3_b0a0c0h0e0d0n0b0e));
            tlist87=environment.copyNodes(TemplateUtil.singletonList(copySrcInput87),copySrcMacro_sy2aw3_b0a0c0h0e0d0n0b0e,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/737333977599628618",context33);
            for (            SNode child88 : TemplateUtil.asNotNull(tlist87)) {
              tnode71.addChild(myAggregationLinks[13],child88);
            }
          }
        }
  finally {
        }
        if (tnode71 != null) {
          environment.registerLabel(itnode70,tnode71,"BHMethodImpl");
          tlist70.add(tnode71);
        }
      }
      for (      SNode child89 : TemplateUtil.asNotNull(tlist70)) {
        tnode1.addChild(myAggregationLinks[3],child89);
      }
    }
{
      final SNode tnode90=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode90);
    }
{
      Collection<SNode> tlist91=null;
      TemplateContext context37=context1.subContext("BHClassConstructor");
      final SNode tnode92=environment.createOutputNode(myConcepts[23]);
      try {
        TemplateContext context38=context37.subContext();
{
          final SNode tnode93=environment.createOutputNode(myConcepts[19]);
          try {
          }
  finally {
          }
          tnode92.addChild(myAggregationLinks[11],tnode93);
        }
{
          final SNode tnode94=environment.createOutputNode(myConcepts[20]);
          try {
          }
  finally {
          }
          tnode92.addChild(myAggregationLinks[13],tnode94);
        }
      }
  finally {
      }
      tlist91=TemplateUtil.singletonList(tnode92);
      environment.registerLabel(context1.getInput(),tnode92,"BHClassConstructor");
      for (      SNode child95 : TemplateUtil.asNotNull(tlist91)) {
        tnode1.addChild(myAggregationLinks[3],child95);
      }
    }
{
      final SNode tnode96=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode96);
    }
{
      final SNode tnode97=environment.createOutputNode(myConcepts[4]);
      try {
        tnode97.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode97,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac4/java:jetbrains.mps.core.aspects.behaviour(jetbrains.mps.lang.behavior.runtime/)"),PersistenceFacade.getInstance().createNodeId("~BaseBHDescriptor")));
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[16],tnode97);
    }
{
      final SNode tnode98=environment.createOutputNode(myConcepts[24]);
      try {
        SNodeAccessUtil.setProperty(tnode98,myProperties[8],"false");
        SNodeAccessUtil.setProperty(tnode98,myProperties[2],"initNode");
        SNodeAccessUtil.setProperty(tnode98,myProperties[9],"false");
        SNodeAccessUtil.setProperty(tnode98,myProperties[10],"false");
        TemplateContext context39=context1.subContext();
{
          final SNode tnode99=environment.createOutputNode(myConcepts[25]);
          try {
          }
  finally {
          }
          tnode98.addChild(myAggregationLinks[0],tnode99);
        }
{
          final SNode tnode100=environment.createOutputNode(myConcepts[19]);
          try {
          }
  finally {
          }
          tnode98.addChild(myAggregationLinks[11],tnode100);
        }
{
          final SNode tnode101=environment.createOutputNode(myConcepts[21]);
          try {
            environment.nodeCopied(context39,tnode101,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843787");
            SNodeAccessUtil.setProperty(tnode101,myProperties[2],"node");
            TemplateContext context40=context39.subContext();
{
              final SNode tnode102=environment.createOutputNode(myConcepts[4]);
              try {
                tnode102.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode102,PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.model(MPS.OpenAPI/)"),PersistenceFacade.getInstance().createNodeId("~SNode")));
              }
  finally {
              }
              tnode101.addChild(myAggregationLinks[2],tnode102);
            }
{
              final SNode tnode103=environment.createOutputNode(myConcepts[22]);
              try {
                tnode103.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode103,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
              }
  finally {
              }
              tnode101.addChild(myAggregationLinks[14],tnode103);
            }
          }
  finally {
          }
          tnode98.addChild(myAggregationLinks[15],tnode101);
        }
{
          final SNode tnode104=environment.createOutputNode(myConcepts[21]);
          try {
            SNodeAccessUtil.setProperty(tnode104,myProperties[2],"constructor");
            TemplateContext context41=context39.subContext();
{
              final SNode tnode105=environment.createOutputNode(myConcepts[4]);
              try {
                tnode105.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode105,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~SConstructor")));
              }
  finally {
              }
              tnode104.addChild(myAggregationLinks[2],tnode105);
            }
{
              final SNode tnode106=environment.createOutputNode(myConcepts[22]);
              try {
                tnode106.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode106,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
              }
  finally {
              }
              tnode104.addChild(myAggregationLinks[14],tnode106);
            }
          }
  finally {
          }
          tnode98.addChild(myAggregationLinks[15],tnode104);
        }
{
          final SNode tnode107=environment.createOutputNode(myConcepts[21]);
          try {
            SNodeAccessUtil.setProperty(tnode107,myProperties[2],"parameters");
            TemplateContext context42=context39.subContext();
{
              final SNode tnode108=environment.createOutputNode(myConcepts[26]);
              try {
                TemplateContext context43=context42.subContext();
{
                  final SNode tnode109=environment.createOutputNode(myConcepts[4]);
                  try {
                    tnode109.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode109,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Object")));
                  }
  finally {
                  }
                  tnode108.addChild(myAggregationLinks[17],tnode109);
                }
              }
  finally {
              }
              tnode107.addChild(myAggregationLinks[2],tnode108);
            }
{
              final SNode tnode110=environment.createOutputNode(myConcepts[22]);
              try {
                tnode110.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode110,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~Nullable")));
              }
  finally {
              }
              tnode107.addChild(myAggregationLinks[14],tnode110);
            }
          }
  finally {
          }
          tnode98.addChild(myAggregationLinks[15],tnode107);
        }
{
          final SNode tnode111=environment.createOutputNode(myConcepts[20]);
          try {
            TemplateContext context44=context39.subContext();
{
              final SNode tnode112=environment.createOutputNode(myConcepts[27]);
              try {
                TemplateContext context45=context44.subContext();
{
                  final SNode tnode113=environment.createOutputNode(myConcepts[28]);
                  try {
                    environment.resolveInTemplateLater(tnode113,myAssociationLinks[2],templateNode_sy2aw3_c0a0a1a1a1a1a1a01a1a81a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/1843690775058889163","__init__",context45);
                    TemplateContext context46=context45.subContext();
{
                      final SNode tnode114=environment.createOutputNode(myConcepts[16]);
                      try {
                        environment.resolveInTemplateLater(tnode114,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a2a1a1a1a1a1a01a1a81a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843787","node",context46);
                      }
  finally {
                      }
                      tnode113.addChild(myAggregationLinks[5],tnode114);
                    }
                  }
  finally {
                  }
                  tnode112.addChild(myAggregationLinks[18],tnode113);
                }
              }
  finally {
              }
              tnode111.addChild(myAggregationLinks[12],tnode112);
            }
          }
  finally {
          }
          tnode98.addChild(myAggregationLinks[13],tnode111);
        }
{
          final SNode tnode115=environment.createOutputNode(myConcepts[22]);
          try {
            tnode115.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode115,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Override")));
          }
  finally {
          }
          tnode98.addChild(myAggregationLinks[14],tnode115);
        }
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode98);
    }
{
      final SNode tnode116=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode116);
    }
{
      final SNode tnode117=environment.createOutputNode(myConcepts[24]);
      try {
        SNodeAccessUtil.setProperty(tnode117,myProperties[8],"false");
        SNodeAccessUtil.setProperty(tnode117,myProperties[2],"invokeSpecial0");
        SNodeAccessUtil.setProperty(tnode117,myProperties[9],"false");
        SNodeAccessUtil.setProperty(tnode117,myProperties[10],"false");
        TemplateContext context47=context1.subContext();
{
          final SNode tnode118=environment.createOutputNode(myConcepts[25]);
          try {
          }
  finally {
          }
          tnode117.addChild(myAggregationLinks[0],tnode118);
        }
{
          final SNode tnode119=environment.createOutputNode(myConcepts[29]);
          try {
            environment.nodeCopied(context47,tnode119,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843801");
            SNodeAccessUtil.setProperty(tnode119,myProperties[2],"T");
          }
  finally {
          }
          tnode117.addChild(myAggregationLinks[19],tnode119);
        }
{
          final SNode tnode120=environment.createOutputNode(myConcepts[30]);
          try {
            environment.resolveInTemplateLater(tnode120,myAssociationLinks[8],templateNode_sy2aw3_c0a0a1a7a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843801","T",context47);
          }
  finally {
          }
          tnode117.addChild(myAggregationLinks[11],tnode120);
        }
{
          final SNode tnode121=environment.createOutputNode(myConcepts[21]);
          try {
            environment.nodeCopied(context47,tnode121,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843803");
            SNodeAccessUtil.setProperty(tnode121,myProperties[2],"node");
            TemplateContext context48=context47.subContext();
{
              final SNode tnode122=environment.createOutputNode(myConcepts[4]);
              try {
                tnode122.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode122,PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.model(MPS.OpenAPI/)"),PersistenceFacade.getInstance().createNodeId("~SNode")));
              }
  finally {
              }
              tnode121.addChild(myAggregationLinks[2],tnode122);
            }
{
              final SNode tnode123=environment.createOutputNode(myConcepts[22]);
              try {
                tnode123.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode123,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
              }
  finally {
              }
              tnode121.addChild(myAggregationLinks[14],tnode123);
            }
          }
  finally {
          }
          tnode117.addChild(myAggregationLinks[15],tnode121);
        }
{
          final SNode tnode124=environment.createOutputNode(myConcepts[21]);
          try {
            environment.nodeCopied(context47,tnode124,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843806");
            SNodeAccessUtil.setProperty(tnode124,myProperties[2],"method");
            TemplateContext context49=context47.subContext();
{
              final SNode tnode125=environment.createOutputNode(myConcepts[4]);
              try {
                tnode125.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode125,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~SMethod")));
                TemplateContext context50=context49.subContext();
{
                  final SNode tnode126=environment.createOutputNode(myConcepts[30]);
                  try {
                    environment.resolveInTemplateLater(tnode126,myAssociationLinks[8],templateNode_sy2aw3_c0a0a1a2a1a3a1a9a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843801","T",context50);
                  }
  finally {
                  }
                  tnode125.addChild(myAggregationLinks[4],tnode126);
                }
              }
  finally {
              }
              tnode124.addChild(myAggregationLinks[2],tnode125);
            }
{
              final SNode tnode127=environment.createOutputNode(myConcepts[22]);
              try {
                tnode127.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode127,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
              }
  finally {
              }
              tnode124.addChild(myAggregationLinks[14],tnode127);
            }
          }
  finally {
          }
          tnode117.addChild(myAggregationLinks[15],tnode124);
        }
{
          final SNode tnode128=environment.createOutputNode(myConcepts[21]);
          try {
            environment.nodeCopied(context47,tnode128,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843810");
            SNodeAccessUtil.setProperty(tnode128,myProperties[2],"parameters");
            TemplateContext context51=context47.subContext();
{
              final SNode tnode129=environment.createOutputNode(myConcepts[26]);
              try {
                TemplateContext context52=context51.subContext();
{
                  final SNode tnode130=environment.createOutputNode(myConcepts[4]);
                  try {
                    tnode130.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode130,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Object")));
                  }
  finally {
                  }
                  tnode129.addChild(myAggregationLinks[17],tnode130);
                }
              }
  finally {
              }
              tnode128.addChild(myAggregationLinks[2],tnode129);
            }
{
              final SNode tnode131=environment.createOutputNode(myConcepts[22]);
              try {
                tnode131.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode131,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~Nullable")));
              }
  finally {
              }
              tnode128.addChild(myAggregationLinks[14],tnode131);
            }
          }
  finally {
          }
          tnode117.addChild(myAggregationLinks[15],tnode128);
        }
{
          final SNode tnode132=environment.createOutputNode(myConcepts[20]);
          try {
            TemplateContext context53=context47.subContext();
{
              final SNode tnode133=environment.createOutputNode(myConcepts[31]);
              try {
                TemplateContext context54=context53.subContext();
{
                  final SNode tnode134=environment.createOutputNode(myConcepts[32]);
                  try {
                    environment.nodeCopied(context54,tnode134,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686911546");
                    SNodeAccessUtil.setProperty(tnode134,myProperties[2],"methodIndex");
                    TemplateContext context55=context54.subContext();
{
                      final SNode tnode135=environment.createOutputNode(myConcepts[33]);
                      try {
                      }
  finally {
                      }
                      tnode134.addChild(myAggregationLinks[2],tnode135);
                    }
{
                      final SNode tnode136=environment.createOutputNode(myConcepts[7]);
                      try {
                        TemplateContext context56=context55.subContext();
{
                          final SNode tnode137=environment.createOutputNode(myConcepts[16]);
                          try {
                            environment.resolveInTemplateLater(tnode137,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a1a1a4a1a1a1a1a1a11a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/6029283687668622501","BH_METHODS",context56);
                          }
  finally {
                          }
                          tnode136.addChild(myAggregationLinks[8],tnode137);
                        }
{
                          final SNode tnode138=environment.createOutputNode(myConcepts[11]);
                          try {
                            tnode138.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode138,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)"),PersistenceFacade.getInstance().createNodeId("~List.indexOf(java.lang.Object)")));
                            TemplateContext context57=context56.subContext();
{
                              final SNode tnode139=environment.createOutputNode(myConcepts[16]);
                              try {
                                environment.resolveInTemplateLater(tnode139,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a2a1a2a1a4a1a1a1a1a1a11a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843806","method",context57);
                              }
  finally {
                              }
                              tnode138.addChild(myAggregationLinks[5],tnode139);
                            }
                          }
  finally {
                          }
                          tnode136.addChild(myAggregationLinks[9],tnode138);
                        }
                      }
  finally {
                      }
                      tnode134.addChild(myAggregationLinks[1],tnode136);
                    }
                  }
  finally {
                  }
                  tnode133.addChild(myAggregationLinks[20],tnode134);
                }
              }
  finally {
              }
              tnode132.addChild(myAggregationLinks[12],tnode133);
            }
{
              final SNode tnode140=environment.createOutputNode(myConcepts[34]);
              try {
                TemplateContext context58=context53.subContext();
{
                  final SNode tnode141=environment.createOutputNode(myConcepts[20]);
                  try {
                    TemplateContext context59=context58.subContext();
{
                      final SNode tnode142=environment.createOutputNode(myConcepts[35]);
                      try {
                        TemplateContext context60=context59.subContext();
{
                          final SNode tnode143=environment.createOutputNode(myConcepts[8]);
                          try {
                            TemplateContext context61=context60.subContext();
{
                              final SNode tnode144=environment.createOutputNode(myConcepts[9]);
                              try {
                                tnode144.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode144,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~BHMethodNotFoundException.<init>(jetbrains.mps.core.aspects.behaviour.api.BHDescriptor,jetbrains.mps.core.aspects.behaviour.api.SMethod)")));
                                TemplateContext context62=context61.subContext();
{
                                  final SNode tnode145=environment.createOutputNode(myConcepts[36]);
                                  try {
                                  }
  finally {
                                  }
                                  tnode144.addChild(myAggregationLinks[5],tnode145);
                                }
{
                                  final SNode tnode146=environment.createOutputNode(myConcepts[16]);
                                  try {
                                    environment.resolveInTemplateLater(tnode146,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a3a1a1a1a1a1a1a1a1a1a2a1a11a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843806","method",context62);
                                  }
  finally {
                                  }
                                  tnode144.addChild(myAggregationLinks[5],tnode146);
                                }
                              }
  finally {
                              }
                              tnode143.addChild(myAggregationLinks[6],tnode144);
                            }
                          }
  finally {
                          }
                          tnode142.addChild(myAggregationLinks[21],tnode143);
                        }
                      }
  finally {
                      }
                      tnode141.addChild(myAggregationLinks[12],tnode142);
                    }
                  }
  finally {
                  }
                  tnode140.addChild(myAggregationLinks[22],tnode141);
                }
{
                  final SNode tnode147=environment.createOutputNode(myConcepts[37]);
                  try {
                    TemplateContext context63=context58.subContext();
{
                      final SNode tnode148=environment.createOutputNode(myConcepts[14]);
                      try {
                        SNodeAccessUtil.setProperty(tnode148,myProperties[7],"0");
                      }
  finally {
                      }
                      tnode147.addChild(myAggregationLinks[23],tnode148);
                    }
{
                      final SNode tnode149=environment.createOutputNode(myConcepts[16]);
                      try {
                        environment.resolveInTemplateLater(tnode149,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a2a1a2a1a2a1a11a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686911546","methodIndex",context63);
                      }
  finally {
                      }
                      tnode147.addChild(myAggregationLinks[24],tnode149);
                    }
                  }
  finally {
                  }
                  tnode140.addChild(myAggregationLinks[25],tnode147);
                }
              }
  finally {
              }
              tnode132.addChild(myAggregationLinks[12],tnode140);
            }
{
              final SNode tnode150=environment.createOutputNode(myConcepts[38]);
              try {
                TemplateContext context64=context53.subContext();
{
                  final List<SNode> tlist151=new ArrayList<SNode>();
                  final Iterable<SNode> loopList151=QueriesGenerated.sourceNodesQuery_6_7(new SourceSubstituteMacroNodesContext(context64,loopMacroRef_sy2aw3_b0a0a1a1a1a3a1a11a1a02a1a4));
                  int loopIndex_methodCounter_151=0;
                  for (                  SNode itnode151 : loopList151) {
                    if (itnode151 == null) {
                      continue;
                    }
                    TemplateContext context65=context64.subContext(itnode151);
                    context65=context65.withVariable("cv:methodCounter",loopIndex_methodCounter_151++);
                    Collection<SNode> tlist152=null;
                    if (QueriesGenerated.ifMacro_Condition_6_4(new IfMacroContext(context65,ifMacroRef_sy2aw3_b0a0e0d0b0b0d0b0l0b0u0b0e))) {
                      final SNode tnode153=environment.createOutputNode(myConcepts[39]);
                      try {
                        TemplateContext context66=context65.subContext();
{
                          final SNode tnode154=environment.createOutputNode(myConcepts[14]);
                          try {
                            SNodeAccessUtil.setProperty(tnode154,myProperties[7],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_10(new PropertyMacroContext(context66,"1",propertyMacro_sy2aw3_c0a0c0a0b0b0b0e0d0b0b0d0b0l0b0u0b0e))));
                          }
  finally {
                          }
                          tnode153.addChild(myAggregationLinks[26],tnode154);
                        }
{
                          final SNode tnode155=environment.createOutputNode(myConcepts[20]);
                          try {
                            TemplateContext context67=context66.subContext();
{
                              Collection<SNode> tlist156=null;
                              if (QueriesGenerated.ifMacro_Condition_6_2(new IfMacroContext(context67,ifMacroRef_sy2aw3_b0a0b0b0b0c0b0e0d0b0b0d0b0l0b0u0b0e))) {
                                final SNode tnode157=environment.createOutputNode(myConcepts[40]);
                                try {
                                  TemplateContext context68=context67.subContext();
{
                                    final SNode tnode158=environment.createOutputNode(myConcepts[41]);
                                    try {
                                      TemplateContext context69=context68.subContext();
{
                                        final SNode tnode159=environment.createOutputNode(myConcepts[42]);
                                        try {
                                          TemplateContext context70=context69.subContext();
{
                                            final SNode tnode160=environment.createOutputNode(myConcepts[41]);
                                            try {
                                              TemplateContext context71=context70.subContext();
{
                                                Collection<SNode> tlist161=null;
                                                tlist161=new Template_reduce_MethodInvocation().apply(environment,context71);
                                                for (                                                SNode child162 : TemplateUtil.asNotNull(tlist161)) {
                                                  tnode160.addChild(myAggregationLinks[27],child162);
                                                }
                                              }
{
                                                Collection<SNode> tlist163=null;
                                                final SNode copySrcInput163=QueriesGenerated.sourceNodeQuery_6_6(new SourceSubstituteMacroNodeContext(context71,copySrcMacro_sy2aw3_b0a0c0c0b0b0b0b0b0b0b0b0b0b0c0b0e0d0b0b0d0b0l0b0u0b0e));
                                                tlist163=environment.copyNodes(TemplateUtil.singletonList(copySrcInput163),copySrcMacro_sy2aw3_b0a0c0c0b0b0b0b0b0b0b0b0b0b0c0b0e0d0b0b0d0b0l0b0u0b0e,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/4547736967711224780",context71);
                                                for (                                                SNode child164 : TemplateUtil.asNotNull(tlist163)) {
                                                  tnode160.addChild(myAggregationLinks[28],child164);
                                                }
                                              }
                                            }
  finally {
                                            }
                                            tnode159.addChild(myAggregationLinks[29],tnode160);
                                          }
                                        }
  finally {
                                        }
                                        tnode158.addChild(myAggregationLinks[27],tnode159);
                                      }
{
                                        final SNode tnode165=environment.createOutputNode(myConcepts[30]);
                                        try {
                                          environment.resolveInTemplateLater(tnode165,myAssociationLinks[8],templateNode_sy2aw3_c0a0a1a2a1a1a1a1a1a1a2a1a4a3a1a1a3a1a11a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843801","T",context69);
                                        }
  finally {
                                        }
                                        tnode158.addChild(myAggregationLinks[28],tnode165);
                                      }
                                    }
  finally {
                                    }
                                    tnode157.addChild(myAggregationLinks[30],tnode158);
                                  }
                                }
  finally {
                                }
                                tlist156=TemplateUtil.singletonList(tnode157);
                              }
 else {
                                final SNode tnode166=environment.createOutputNode(myConcepts[27]);
                                try {
                                  TemplateContext context72=context67.subContext();
{
                                    Collection<SNode> tlist167=null;
                                    tlist167=new Template_reduce_MethodInvocation().apply(environment,context72);
                                    for (                                    SNode child168 : TemplateUtil.asNotNull(tlist167)) {
                                      tnode166.addChild(myAggregationLinks[18],child168);
                                    }
                                  }
                                }
  finally {
                                }
                                tlist156=TemplateUtil.singletonList(tnode166);
                              }
                              for (                              SNode child169 : TemplateUtil.asNotNull(tlist156)) {
                                tnode155.addChild(myAggregationLinks[12],child169);
                              }
                            }
{
                              Collection<SNode> tlist170=null;
                              if (QueriesGenerated.ifMacro_Condition_6_3(new IfMacroContext(context67,ifMacroRef_sy2aw3_b0a0b0c0b0c0b0e0d0b0b0d0b0l0b0u0b0e))) {
                                final SNode tnode171=environment.createOutputNode(myConcepts[40]);
                                try {
                                  TemplateContext context73=context67.subContext();
{
                                    final SNode tnode172=environment.createOutputNode(myConcepts[10]);
                                    try {
                                    }
  finally {
                                    }
                                    tnode171.addChild(myAggregationLinks[30],tnode172);
                                  }
                                }
  finally {
                                }
                                tlist170=TemplateUtil.singletonList(tnode171);
                              }
                              for (                              SNode child173 : TemplateUtil.asNotNull(tlist170)) {
                                tnode155.addChild(myAggregationLinks[12],child173);
                              }
                            }
                          }
  finally {
                          }
                          tnode153.addChild(myAggregationLinks[31],tnode155);
                        }
                      }
  finally {
                      }
                      tlist152=TemplateUtil.singletonList(tnode153);
                    }
                    if (tlist152 != null) {
                      tlist151.addAll(tlist152);
                    }
                  }
                  for (                  SNode child174 : TemplateUtil.asNotNull(tlist151)) {
                    tnode150.addChild(myAggregationLinks[32],child174);
                  }
                }
{
                  final SNode tnode175=environment.createOutputNode(myConcepts[20]);
                  try {
                    TemplateContext context74=context64.subContext();
{
                      final SNode tnode176=environment.createOutputNode(myConcepts[35]);
                      try {
                        TemplateContext context75=context74.subContext();
{
                          final SNode tnode177=environment.createOutputNode(myConcepts[8]);
                          try {
                            TemplateContext context76=context75.subContext();
{
                              final SNode tnode178=environment.createOutputNode(myConcepts[9]);
                              try {
                                tnode178.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode178,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~BHMethodNotFoundException.<init>(jetbrains.mps.core.aspects.behaviour.api.BHDescriptor,jetbrains.mps.core.aspects.behaviour.api.SMethod)")));
                                TemplateContext context77=context76.subContext();
{
                                  final SNode tnode179=environment.createOutputNode(myConcepts[36]);
                                  try {
                                  }
  finally {
                                  }
                                  tnode178.addChild(myAggregationLinks[5],tnode179);
                                }
{
                                  final SNode tnode180=environment.createOutputNode(myConcepts[16]);
                                  try {
                                    environment.resolveInTemplateLater(tnode180,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a3a1a1a1a1a1a1a1a2a1a3a1a11a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843806","method",context77);
                                  }
  finally {
                                  }
                                  tnode178.addChild(myAggregationLinks[5],tnode180);
                                }
                              }
  finally {
                              }
                              tnode177.addChild(myAggregationLinks[6],tnode178);
                            }
                          }
  finally {
                          }
                          tnode176.addChild(myAggregationLinks[21],tnode177);
                        }
                      }
  finally {
                      }
                      tnode175.addChild(myAggregationLinks[12],tnode176);
                    }
                  }
  finally {
                  }
                  tnode150.addChild(myAggregationLinks[33],tnode175);
                }
{
                  final SNode tnode181=environment.createOutputNode(myConcepts[16]);
                  try {
                    environment.resolveInTemplateLater(tnode181,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a3a1a3a1a11a1a02a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686911546","methodIndex",context64);
                  }
  finally {
                  }
                  tnode150.addChild(myAggregationLinks[34],tnode181);
                }
              }
  finally {
              }
              tnode132.addChild(myAggregationLinks[12],tnode150);
            }
          }
  finally {
          }
          tnode117.addChild(myAggregationLinks[13],tnode132);
        }
{
          final SNode tnode182=environment.createOutputNode(myConcepts[22]);
          try {
            tnode182.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode182,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Override")));
          }
  finally {
          }
          tnode117.addChild(myAggregationLinks[14],tnode182);
        }
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode117);
    }
{
      final SNode tnode183=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode183);
    }
{
      final SNode tnode184=environment.createOutputNode(myConcepts[24]);
      try {
        SNodeAccessUtil.setProperty(tnode184,myProperties[8],"false");
        SNodeAccessUtil.setProperty(tnode184,myProperties[2],"invokeSpecial0");
        SNodeAccessUtil.setProperty(tnode184,myProperties[9],"false");
        SNodeAccessUtil.setProperty(tnode184,myProperties[10],"false");
        TemplateContext context78=context1.subContext();
{
          final SNode tnode185=environment.createOutputNode(myConcepts[25]);
          try {
          }
  finally {
          }
          tnode184.addChild(myAggregationLinks[0],tnode185);
        }
{
          final SNode tnode186=environment.createOutputNode(myConcepts[29]);
          try {
            environment.nodeCopied(context78,tnode186,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843818");
            SNodeAccessUtil.setProperty(tnode186,myProperties[2],"T");
          }
  finally {
          }
          tnode184.addChild(myAggregationLinks[19],tnode186);
        }
{
          final SNode tnode187=environment.createOutputNode(myConcepts[30]);
          try {
            environment.resolveInTemplateLater(tnode187,myAssociationLinks[8],templateNode_sy2aw3_c0a0a1a7a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843818","T",context78);
          }
  finally {
          }
          tnode184.addChild(myAggregationLinks[11],tnode187);
        }
{
          final SNode tnode188=environment.createOutputNode(myConcepts[21]);
          try {
            SNodeAccessUtil.setProperty(tnode188,myProperties[2],"concept");
            TemplateContext context79=context78.subContext();
{
              final SNode tnode189=environment.createOutputNode(myConcepts[4]);
              try {
                tnode189.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode189,PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.language(MPS.OpenAPI/)"),PersistenceFacade.getInstance().createNodeId("~SAbstractConcept")));
              }
  finally {
              }
              tnode188.addChild(myAggregationLinks[2],tnode189);
            }
{
              final SNode tnode190=environment.createOutputNode(myConcepts[22]);
              try {
                tnode190.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode190,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
              }
  finally {
              }
              tnode188.addChild(myAggregationLinks[14],tnode190);
            }
          }
  finally {
          }
          tnode184.addChild(myAggregationLinks[15],tnode188);
        }
{
          final SNode tnode191=environment.createOutputNode(myConcepts[21]);
          try {
            environment.nodeCopied(context78,tnode191,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843823");
            SNodeAccessUtil.setProperty(tnode191,myProperties[2],"method");
            TemplateContext context80=context78.subContext();
{
              final SNode tnode192=environment.createOutputNode(myConcepts[4]);
              try {
                tnode192.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode192,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~SMethod")));
                TemplateContext context81=context80.subContext();
{
                  final SNode tnode193=environment.createOutputNode(myConcepts[30]);
                  try {
                    environment.resolveInTemplateLater(tnode193,myAssociationLinks[8],templateNode_sy2aw3_c0a0a1a2a1a3a1a9a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843818","T",context81);
                  }
  finally {
                  }
                  tnode192.addChild(myAggregationLinks[4],tnode193);
                }
              }
  finally {
              }
              tnode191.addChild(myAggregationLinks[2],tnode192);
            }
{
              final SNode tnode194=environment.createOutputNode(myConcepts[22]);
              try {
                tnode194.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode194,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
              }
  finally {
              }
              tnode191.addChild(myAggregationLinks[14],tnode194);
            }
          }
  finally {
          }
          tnode184.addChild(myAggregationLinks[15],tnode191);
        }
{
          final SNode tnode195=environment.createOutputNode(myConcepts[21]);
          try {
            environment.nodeCopied(context78,tnode195,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843827");
            SNodeAccessUtil.setProperty(tnode195,myProperties[2],"parameters");
            TemplateContext context82=context78.subContext();
{
              final SNode tnode196=environment.createOutputNode(myConcepts[26]);
              try {
                TemplateContext context83=context82.subContext();
{
                  final SNode tnode197=environment.createOutputNode(myConcepts[4]);
                  try {
                    tnode197.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode197,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Object")));
                  }
  finally {
                  }
                  tnode196.addChild(myAggregationLinks[17],tnode197);
                }
              }
  finally {
              }
              tnode195.addChild(myAggregationLinks[2],tnode196);
            }
{
              final SNode tnode198=environment.createOutputNode(myConcepts[22]);
              try {
                tnode198.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode198,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~Nullable")));
              }
  finally {
              }
              tnode195.addChild(myAggregationLinks[14],tnode198);
            }
          }
  finally {
          }
          tnode184.addChild(myAggregationLinks[15],tnode195);
        }
{
          final SNode tnode199=environment.createOutputNode(myConcepts[20]);
          try {
            TemplateContext context84=context78.subContext();
{
              final SNode tnode200=environment.createOutputNode(myConcepts[31]);
              try {
                TemplateContext context85=context84.subContext();
{
                  final SNode tnode201=environment.createOutputNode(myConcepts[32]);
                  try {
                    environment.nodeCopied(context85,tnode201,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/6862765979524954332");
                    SNodeAccessUtil.setProperty(tnode201,myProperties[2],"methodIndex");
                    TemplateContext context86=context85.subContext();
{
                      final SNode tnode202=environment.createOutputNode(myConcepts[33]);
                      try {
                      }
  finally {
                      }
                      tnode201.addChild(myAggregationLinks[2],tnode202);
                    }
{
                      final SNode tnode203=environment.createOutputNode(myConcepts[7]);
                      try {
                        TemplateContext context87=context86.subContext();
{
                          final SNode tnode204=environment.createOutputNode(myConcepts[16]);
                          try {
                            environment.resolveInTemplateLater(tnode204,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a1a1a4a1a1a1a1a1a11a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/6029283687668622501","BH_METHODS",context87);
                          }
  finally {
                          }
                          tnode203.addChild(myAggregationLinks[8],tnode204);
                        }
{
                          final SNode tnode205=environment.createOutputNode(myConcepts[11]);
                          try {
                            tnode205.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode205,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)"),PersistenceFacade.getInstance().createNodeId("~List.indexOf(java.lang.Object)")));
                            TemplateContext context88=context87.subContext();
{
                              final SNode tnode206=environment.createOutputNode(myConcepts[16]);
                              try {
                                environment.resolveInTemplateLater(tnode206,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a2a1a2a1a4a1a1a1a1a1a11a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843823","method",context88);
                              }
  finally {
                              }
                              tnode205.addChild(myAggregationLinks[5],tnode206);
                            }
                          }
  finally {
                          }
                          tnode203.addChild(myAggregationLinks[9],tnode205);
                        }
                      }
  finally {
                      }
                      tnode201.addChild(myAggregationLinks[1],tnode203);
                    }
                  }
  finally {
                  }
                  tnode200.addChild(myAggregationLinks[20],tnode201);
                }
              }
  finally {
              }
              tnode199.addChild(myAggregationLinks[12],tnode200);
            }
{
              final SNode tnode207=environment.createOutputNode(myConcepts[34]);
              try {
                TemplateContext context89=context84.subContext();
{
                  final SNode tnode208=environment.createOutputNode(myConcepts[20]);
                  try {
                    TemplateContext context90=context89.subContext();
{
                      final SNode tnode209=environment.createOutputNode(myConcepts[35]);
                      try {
                        TemplateContext context91=context90.subContext();
{
                          final SNode tnode210=environment.createOutputNode(myConcepts[8]);
                          try {
                            TemplateContext context92=context91.subContext();
{
                              final SNode tnode211=environment.createOutputNode(myConcepts[9]);
                              try {
                                tnode211.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode211,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~BHMethodNotFoundException.<init>(jetbrains.mps.core.aspects.behaviour.api.BHDescriptor,jetbrains.mps.core.aspects.behaviour.api.SMethod)")));
                                TemplateContext context93=context92.subContext();
{
                                  final SNode tnode212=environment.createOutputNode(myConcepts[36]);
                                  try {
                                  }
  finally {
                                  }
                                  tnode211.addChild(myAggregationLinks[5],tnode212);
                                }
{
                                  final SNode tnode213=environment.createOutputNode(myConcepts[16]);
                                  try {
                                    environment.resolveInTemplateLater(tnode213,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a3a1a1a1a1a1a1a1a1a1a2a1a11a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843823","method",context93);
                                  }
  finally {
                                  }
                                  tnode211.addChild(myAggregationLinks[5],tnode213);
                                }
                              }
  finally {
                              }
                              tnode210.addChild(myAggregationLinks[6],tnode211);
                            }
                          }
  finally {
                          }
                          tnode209.addChild(myAggregationLinks[21],tnode210);
                        }
                      }
  finally {
                      }
                      tnode208.addChild(myAggregationLinks[12],tnode209);
                    }
                  }
  finally {
                  }
                  tnode207.addChild(myAggregationLinks[22],tnode208);
                }
{
                  final SNode tnode214=environment.createOutputNode(myConcepts[37]);
                  try {
                    TemplateContext context94=context89.subContext();
{
                      final SNode tnode215=environment.createOutputNode(myConcepts[14]);
                      try {
                        SNodeAccessUtil.setProperty(tnode215,myProperties[7],"0");
                      }
  finally {
                      }
                      tnode214.addChild(myAggregationLinks[23],tnode215);
                    }
{
                      final SNode tnode216=environment.createOutputNode(myConcepts[16]);
                      try {
                        environment.resolveInTemplateLater(tnode216,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a2a1a2a1a2a1a11a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/6862765979524954332","methodIndex",context94);
                      }
  finally {
                      }
                      tnode214.addChild(myAggregationLinks[24],tnode216);
                    }
                  }
  finally {
                  }
                  tnode207.addChild(myAggregationLinks[25],tnode214);
                }
              }
  finally {
              }
              tnode199.addChild(myAggregationLinks[12],tnode207);
            }
{
              final SNode tnode217=environment.createOutputNode(myConcepts[38]);
              try {
                TemplateContext context95=context84.subContext();
{
                  final List<SNode> tlist218=new ArrayList<SNode>();
                  final Iterable<SNode> loopList218=QueriesGenerated.sourceNodesQuery_6_8(new SourceSubstituteMacroNodesContext(context95,loopMacroRef_sy2aw3_b0a0a1a1a1a3a1a11a1a22a1a4));
                  int loopIndex_methodCounter_218=0;
                  for (                  SNode itnode218 : loopList218) {
                    if (itnode218 == null) {
                      continue;
                    }
                    TemplateContext context96=context95.subContext(itnode218);
                    context96=context96.withVariable("cv:methodCounter",loopIndex_methodCounter_218++);
                    Collection<SNode> tlist219=null;
                    if (QueriesGenerated.ifMacro_Condition_6_7(new IfMacroContext(context96,ifMacroRef_sy2aw3_b0a0e0d0b0b0d0b0l0b0w0b0e))) {
                      final SNode tnode220=environment.createOutputNode(myConcepts[39]);
                      try {
                        TemplateContext context97=context96.subContext();
{
                          final SNode tnode221=environment.createOutputNode(myConcepts[14]);
                          try {
                            SNodeAccessUtil.setProperty(tnode221,myProperties[7],TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_6_11(new PropertyMacroContext(context97,"1",propertyMacro_sy2aw3_c0a0c0a0b0b0b0e0d0b0b0d0b0l0b0w0b0e))));
                          }
  finally {
                          }
                          tnode220.addChild(myAggregationLinks[26],tnode221);
                        }
{
                          final SNode tnode222=environment.createOutputNode(myConcepts[20]);
                          try {
                            TemplateContext context98=context97.subContext();
{
                              Collection<SNode> tlist223=null;
                              if (QueriesGenerated.ifMacro_Condition_6_5(new IfMacroContext(context98,ifMacroRef_sy2aw3_b0a0b0b0b0c0b0e0d0b0b0d0b0l0b0w0b0e))) {
                                final SNode tnode224=environment.createOutputNode(myConcepts[40]);
                                try {
                                  TemplateContext context99=context98.subContext();
{
                                    final SNode tnode225=environment.createOutputNode(myConcepts[41]);
                                    try {
                                      TemplateContext context100=context99.subContext();
{
                                        final SNode tnode226=environment.createOutputNode(myConcepts[42]);
                                        try {
                                          TemplateContext context101=context100.subContext();
{
                                            final SNode tnode227=environment.createOutputNode(myConcepts[41]);
                                            try {
                                              TemplateContext context102=context101.subContext();
{
                                                Collection<SNode> tlist228=null;
                                                tlist228=new Template_reduce_MethodInvocation().apply(environment,context102);
                                                for (                                                SNode child229 : TemplateUtil.asNotNull(tlist228)) {
                                                  tnode227.addChild(myAggregationLinks[27],child229);
                                                }
                                              }
{
                                                Collection<SNode> tlist230=null;
                                                final SNode copySrcInput230=QueriesGenerated.sourceNodeQuery_6_7(new SourceSubstituteMacroNodeContext(context102,copySrcMacro_sy2aw3_b0a0c0c0b0b0b0b0b0b0b0b0b0b0c0b0e0d0b0b0d0b0l0b0w0b0e));
                                                tlist230=environment.copyNodes(TemplateUtil.singletonList(copySrcInput230),copySrcMacro_sy2aw3_b0a0c0c0b0b0b0b0b0b0b0b0b0b0c0b0e0d0b0b0d0b0l0b0w0b0e,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7830995205626821824",context102);
                                                for (                                                SNode child231 : TemplateUtil.asNotNull(tlist230)) {
                                                  tnode227.addChild(myAggregationLinks[28],child231);
                                                }
                                              }
                                            }
  finally {
                                            }
                                            tnode226.addChild(myAggregationLinks[29],tnode227);
                                          }
                                        }
  finally {
                                        }
                                        tnode225.addChild(myAggregationLinks[27],tnode226);
                                      }
{
                                        final SNode tnode232=environment.createOutputNode(myConcepts[30]);
                                        try {
                                          environment.resolveInTemplateLater(tnode232,myAssociationLinks[8],templateNode_sy2aw3_c0a0a1a2a1a1a1a1a1a1a2a1a4a3a1a1a3a1a11a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843818","T",context100);
                                        }
  finally {
                                        }
                                        tnode225.addChild(myAggregationLinks[28],tnode232);
                                      }
                                    }
  finally {
                                    }
                                    tnode224.addChild(myAggregationLinks[30],tnode225);
                                  }
                                }
  finally {
                                }
                                tlist223=TemplateUtil.singletonList(tnode224);
                              }
 else {
                                final SNode tnode233=environment.createOutputNode(myConcepts[27]);
                                try {
                                  TemplateContext context103=context98.subContext();
{
                                    Collection<SNode> tlist234=null;
                                    tlist234=new Template_reduce_MethodInvocation().apply(environment,context103);
                                    for (                                    SNode child235 : TemplateUtil.asNotNull(tlist234)) {
                                      tnode233.addChild(myAggregationLinks[18],child235);
                                    }
                                  }
                                }
  finally {
                                }
                                tlist223=TemplateUtil.singletonList(tnode233);
                              }
                              for (                              SNode child236 : TemplateUtil.asNotNull(tlist223)) {
                                tnode222.addChild(myAggregationLinks[12],child236);
                              }
                            }
{
                              Collection<SNode> tlist237=null;
                              if (QueriesGenerated.ifMacro_Condition_6_6(new IfMacroContext(context98,ifMacroRef_sy2aw3_b0a0b0c0b0c0b0e0d0b0b0d0b0l0b0w0b0e))) {
                                final SNode tnode238=environment.createOutputNode(myConcepts[40]);
                                try {
                                  TemplateContext context104=context98.subContext();
{
                                    final SNode tnode239=environment.createOutputNode(myConcepts[10]);
                                    try {
                                    }
  finally {
                                    }
                                    tnode238.addChild(myAggregationLinks[30],tnode239);
                                  }
                                }
  finally {
                                }
                                tlist237=TemplateUtil.singletonList(tnode238);
                              }
                              for (                              SNode child240 : TemplateUtil.asNotNull(tlist237)) {
                                tnode222.addChild(myAggregationLinks[12],child240);
                              }
                            }
                          }
  finally {
                          }
                          tnode220.addChild(myAggregationLinks[31],tnode222);
                        }
                      }
  finally {
                      }
                      tlist219=TemplateUtil.singletonList(tnode220);
                    }
                    if (tlist219 != null) {
                      tlist218.addAll(tlist219);
                    }
                  }
                  for (                  SNode child241 : TemplateUtil.asNotNull(tlist218)) {
                    tnode217.addChild(myAggregationLinks[32],child241);
                  }
                }
{
                  final SNode tnode242=environment.createOutputNode(myConcepts[20]);
                  try {
                    TemplateContext context105=context95.subContext();
{
                      final SNode tnode243=environment.createOutputNode(myConcepts[35]);
                      try {
                        TemplateContext context106=context105.subContext();
{
                          final SNode tnode244=environment.createOutputNode(myConcepts[8]);
                          try {
                            TemplateContext context107=context106.subContext();
{
                              final SNode tnode245=environment.createOutputNode(myConcepts[9]);
                              try {
                                tnode245.setReference(myAssociationLinks[2],SReference.create(myAssociationLinks[2],tnode245,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~BHMethodNotFoundException.<init>(jetbrains.mps.core.aspects.behaviour.api.BHDescriptor,jetbrains.mps.core.aspects.behaviour.api.SMethod)")));
                                TemplateContext context108=context107.subContext();
{
                                  final SNode tnode246=environment.createOutputNode(myConcepts[36]);
                                  try {
                                  }
  finally {
                                  }
                                  tnode245.addChild(myAggregationLinks[5],tnode246);
                                }
{
                                  final SNode tnode247=environment.createOutputNode(myConcepts[16]);
                                  try {
                                    environment.resolveInTemplateLater(tnode247,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a3a1a1a1a1a1a1a1a2a1a3a1a11a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/7977232384686843823","method",context108);
                                  }
  finally {
                                  }
                                  tnode245.addChild(myAggregationLinks[5],tnode247);
                                }
                              }
  finally {
                              }
                              tnode244.addChild(myAggregationLinks[6],tnode245);
                            }
                          }
  finally {
                          }
                          tnode243.addChild(myAggregationLinks[21],tnode244);
                        }
                      }
  finally {
                      }
                      tnode242.addChild(myAggregationLinks[12],tnode243);
                    }
                  }
  finally {
                  }
                  tnode217.addChild(myAggregationLinks[33],tnode242);
                }
{
                  final SNode tnode248=environment.createOutputNode(myConcepts[16]);
                  try {
                    environment.resolveInTemplateLater(tnode248,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a3a1a3a1a11a1a22a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/6862765979524954332","methodIndex",context95);
                  }
  finally {
                  }
                  tnode217.addChild(myAggregationLinks[34],tnode248);
                }
              }
  finally {
              }
              tnode199.addChild(myAggregationLinks[12],tnode217);
            }
          }
  finally {
          }
          tnode184.addChild(myAggregationLinks[13],tnode199);
        }
{
          final SNode tnode249=environment.createOutputNode(myConcepts[22]);
          try {
            tnode249.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode249,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Override")));
          }
  finally {
          }
          tnode184.addChild(myAggregationLinks[14],tnode249);
        }
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode184);
    }
{
      final SNode tnode250=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode250);
    }
{
      final SNode tnode251=environment.createOutputNode(myConcepts[24]);
      try {
        SNodeAccessUtil.setProperty(tnode251,myProperties[8],"false");
        SNodeAccessUtil.setProperty(tnode251,myProperties[2],"getDeclaredMethods");
        SNodeAccessUtil.setProperty(tnode251,myProperties[9],"false");
        TemplateContext context109=context1.subContext();
{
          final SNode tnode252=environment.createOutputNode(myConcepts[6]);
          try {
          }
  finally {
          }
          tnode251.addChild(myAggregationLinks[0],tnode252);
        }
{
          final SNode tnode253=environment.createOutputNode(myConcepts[4]);
          try {
            tnode253.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode253,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.util(JDK/)"),PersistenceFacade.getInstance().createNodeId("~List")));
            TemplateContext context110=context109.subContext();
{
              final SNode tnode254=environment.createOutputNode(myConcepts[4]);
              try {
                tnode254.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode254,PersistenceFacade.getInstance().createModelReference("d936855b-48da-4812-a8a0-2bfddd633ac5/java:jetbrains.mps.core.aspects.behaviour.api(jetbrains.mps.lang.behavior.api/)"),PersistenceFacade.getInstance().createNodeId("~SMethod")));
                TemplateContext context111=context110.subContext();
{
                  final SNode tnode255=environment.createOutputNode(myConcepts[17]);
                  try {
                  }
  finally {
                  }
                  tnode254.addChild(myAggregationLinks[4],tnode255);
                }
              }
  finally {
              }
              tnode253.addChild(myAggregationLinks[4],tnode254);
            }
          }
  finally {
          }
          tnode251.addChild(myAggregationLinks[11],tnode253);
        }
{
          final SNode tnode256=environment.createOutputNode(myConcepts[20]);
          try {
            TemplateContext context112=context109.subContext();
{
              final SNode tnode257=environment.createOutputNode(myConcepts[40]);
              try {
                TemplateContext context113=context112.subContext();
{
                  final SNode tnode258=environment.createOutputNode(myConcepts[16]);
                  try {
                    environment.resolveInTemplateLater(tnode258,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a1a1a1a1a6a1a42a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/6029283687668622501","BH_METHODS",context113);
                  }
  finally {
                  }
                  tnode257.addChild(myAggregationLinks[30],tnode258);
                }
              }
  finally {
              }
              tnode256.addChild(myAggregationLinks[12],tnode257);
            }
          }
  finally {
          }
          tnode251.addChild(myAggregationLinks[13],tnode256);
        }
{
          final SNode tnode259=environment.createOutputNode(myConcepts[22]);
          try {
            tnode259.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode259,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
          }
  finally {
          }
          tnode251.addChild(myAggregationLinks[14],tnode259);
        }
{
          final SNode tnode260=environment.createOutputNode(myConcepts[22]);
          try {
            tnode260.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode260,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Override")));
          }
  finally {
          }
          tnode251.addChild(myAggregationLinks[14],tnode260);
        }
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode251);
    }
{
      final SNode tnode261=environment.createOutputNode(myConcepts[5]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode261);
    }
{
      final SNode tnode262=environment.createOutputNode(myConcepts[24]);
      try {
        SNodeAccessUtil.setProperty(tnode262,myProperties[8],"false");
        SNodeAccessUtil.setProperty(tnode262,myProperties[2],"getConcept");
        SNodeAccessUtil.setProperty(tnode262,myProperties[9],"false");
        TemplateContext context114=context1.subContext();
{
          final SNode tnode263=environment.createOutputNode(myConcepts[6]);
          try {
          }
  finally {
          }
          tnode262.addChild(myAggregationLinks[0],tnode263);
        }
{
          final SNode tnode264=environment.createOutputNode(myConcepts[4]);
          try {
            tnode264.setReference(myAssociationLinks[1],SReference.create(myAssociationLinks[1],tnode264,PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.language(MPS.OpenAPI/)"),PersistenceFacade.getInstance().createNodeId("~SAbstractConcept")));
          }
  finally {
          }
          tnode262.addChild(myAggregationLinks[11],tnode264);
        }
{
          final SNode tnode265=environment.createOutputNode(myConcepts[22]);
          try {
            tnode265.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode265,PersistenceFacade.getInstance().createModelReference("3f233e7f-b8a6-46d2-a57f-795d56775243/java:org.jetbrains.annotations(Annotations/)"),PersistenceFacade.getInstance().createNodeId("~NotNull")));
          }
  finally {
          }
          tnode262.addChild(myAggregationLinks[14],tnode265);
        }
{
          final SNode tnode266=environment.createOutputNode(myConcepts[20]);
          try {
            TemplateContext context115=context114.subContext();
{
              final SNode tnode267=environment.createOutputNode(myConcepts[40]);
              try {
                TemplateContext context116=context115.subContext();
{
                  final SNode tnode268=environment.createOutputNode(myConcepts[16]);
                  try {
                    environment.resolveInTemplateLater(tnode268,myAssociationLinks[6],templateNode_sy2aw3_c0a0a1a1a1a1a1a7a1a62a1a4,"tpl/r:229ce18d-2bb0-4d5b-a7cd-cec65841e459/4006517209906245669","CONCEPT",context116);
                  }
  finally {
                  }
                  tnode267.addChild(myAggregationLinks[30],tnode268);
                }
              }
  finally {
              }
              tnode266.addChild(myAggregationLinks[12],tnode267);
            }
          }
  finally {
          }
          tnode262.addChild(myAggregationLinks[13],tnode266);
        }
{
          final SNode tnode269=environment.createOutputNode(myConcepts[22]);
          try {
            tnode269.setReference(myAssociationLinks[7],SReference.create(myAssociationLinks[7],tnode269,PersistenceFacade.getInstance().createModelReference("6354ebe7-c22a-4a0f-ac54-50b52ab9b065/java:java.lang(JDK/)"),PersistenceFacade.getInstance().createNodeId("~Override")));
          }
  finally {
          }
          tnode262.addChild(myAggregationLinks[14],tnode269);
        }
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[3],tnode262);
    }
{
      final SNode tnode270=environment.createOutputNode(myConcepts[6]);
      try {
      }
  finally {
      }
      tnode1.addChild(myAggregationLinks[0],tnode270);
    }
  }
  finally {
  }
  return TemplateUtil.singletonList(tnode1);
}
