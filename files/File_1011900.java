package jetbrains.mps.samples.KajaSceneConstruction.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.generator.runtime.Generated;
import jetbrains.mps.generator.runtime.TemplateDeclarationBase;
import jetbrains.mps.generator.runtime.TemplateDeclaration2;
import org.jetbrains.mps.openapi.model.SNodeReference;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.generator.runtime.FragmentResult;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.generator.runtime.TemplateContext;
import jetbrains.mps.generator.runtime.GenerationException;
import jetbrains.mps.generator.runtime.TemplateExecutionEnvironment;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.smodel.SReference;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import org.jetbrains.mps.openapi.model.SNodeAccessUtil;
import jetbrains.mps.generator.runtime.TemplateUtil;
import jetbrains.mps.generator.template.PropertyMacroContext;
import java.util.Collection;
import java.util.ArrayList;
import jetbrains.mps.generator.runtime.NodeWeaveFacility;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.language.SProperty;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import org.jetbrains.mps.openapi.language.SContainmentLink;

@Generated
public class Template_reduce_PickMark extends TemplateDeclarationBase implements TemplateDeclaration2 {

  public Template_reduce_PickMark() {
  }

  public SNodeReference getTemplateNode() {
    return new SNodePointer("r:262b93f0-fe86-497c-93c5-efd684d05bc6(jetbrains.mps.samples.KajaSceneConstruction.generator.template.main@generator)", "3210697320273614443");
  }


  protected FragmentResult applyPart0(@NotNull final TemplateContext context) throws GenerationException {
    final TemplateExecutionEnvironment environment = context.getEnvironment();
    final SNode tnode1 = environment.createOutputNode(myConcepts[0]);
    try {
      TemplateContext context1 = context.subContext();
      {
        final SNode tnode2 = environment.createOutputNode(myConcepts[1]);
        try {
          TemplateContext context2 = context1.subContext();
          {
            final SNode tnode3 = environment.createOutputNode(myConcepts[2]);
            try {
              TemplateContext context3 = context2.subContext();
              {
                final SNode tnode4 = environment.createOutputNode(myConcepts[1]);
                try {
                  TemplateContext context4 = context3.subContext();
                  {
                    final SNode tnode5 = environment.createOutputNode(myConcepts[2]);
                    try {
                      TemplateContext context5 = context4.subContext();
                      {
                        final SNode tnode6 = environment.createOutputNode(myConcepts[3]);
                        try {
                          tnode6.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode6, PersistenceFacade.getInstance().createModelReference("r:f5e9b11f-5073-4786-8ed1-a9e42307c3f8(JavaKaja.runtime)"), PersistenceFacade.getInstance().createNodeId("3210697320273614306")));
                          TemplateContext context6 = context5.subContext();
                          {
                            final SNode tnode7 = environment.createOutputNode(myConcepts[4]);
                            try {
                              SNodeAccessUtil.setProperty(tnode7, myProperties[0], TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_4_0(new PropertyMacroContext(context6, "0", propertyMacro_mi0eld_c0a0c0a0b0c0b0b0b0b0b0b0b0b0b0b0c0g))));
                            } finally {
                            }
                            tnode6.addChild(myAggregationLinks[0], tnode7);
                            // TODO validate child 
                          }
                          {
                            final SNode tnode8 = environment.createOutputNode(myConcepts[4]);
                            try {
                              SNodeAccessUtil.setProperty(tnode8, myProperties[0], TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_4_1(new PropertyMacroContext(context6, "0", propertyMacro_mi0eld_c0a0c0a0b0d0b0b0b0b0b0b0b0b0b0b0c0g))));
                            } finally {
                            }
                            tnode6.addChild(myAggregationLinks[0], tnode8);
                            // TODO validate child 
                          }
                        } finally {
                        }
                        tnode5.addChild(myAggregationLinks[1], tnode6);
                        // TODO validate child 
                      }
                      {
                        final SNode tnode9 = environment.createOutputNode(myConcepts[1]);
                        try {
                          TemplateContext context7 = context5.subContext();
                          {
                            final SNode tnode10 = environment.createOutputNode(myConcepts[5]);
                            try {
                              TemplateContext context8 = context7.subContext();
                              {
                                final SNode tnode11 = environment.createOutputNode(myConcepts[3]);
                                try {
                                  tnode11.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode11, PersistenceFacade.getInstance().createModelReference("r:f5e9b11f-5073-4786-8ed1-a9e42307c3f8(JavaKaja.runtime)"), PersistenceFacade.getInstance().createNodeId("3210697320273550663")));
                                  TemplateContext context9 = context8.subContext();
                                  {
                                    final SNode tnode12 = environment.createOutputNode(myConcepts[4]);
                                    try {
                                      SNodeAccessUtil.setProperty(tnode12, myProperties[0], TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_4_2(new PropertyMacroContext(context9, "0", propertyMacro_mi0eld_c0a0c0a0b0c0b0b0b0b0b0c0b0b0b0b0b0b0b0b0c0g))));
                                    } finally {
                                    }
                                    tnode11.addChild(myAggregationLinks[0], tnode12);
                                    // TODO validate child 
                                  }
                                  {
                                    final SNode tnode13 = environment.createOutputNode(myConcepts[4]);
                                    try {
                                      SNodeAccessUtil.setProperty(tnode13, myProperties[0], TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_4_3(new PropertyMacroContext(context9, "0", propertyMacro_mi0eld_c0a0c0a0b0d0b0b0b0b0b0c0b0b0b0b0b0b0b0b0c0g))));
                                    } finally {
                                    }
                                    tnode11.addChild(myAggregationLinks[0], tnode13);
                                    // TODO validate child 
                                  }
                                } finally {
                                }
                                tnode10.addChild(myAggregationLinks[2], tnode11);
                                // TODO validate child 
                              }
                            } finally {
                            }
                            tnode9.addChild(myAggregationLinks[3], tnode10);
                            // TODO validate child 
                          }
                          {
                            final SNode tnode14 = environment.createOutputNode(myConcepts[5]);
                            try {
                              TemplateContext context10 = context7.subContext();
                              {
                                final SNode tnode15 = environment.createOutputNode(myConcepts[3]);
                                try {
                                  tnode15.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode15, PersistenceFacade.getInstance().createModelReference("r:f5e9b11f-5073-4786-8ed1-a9e42307c3f8(JavaKaja.runtime)"), PersistenceFacade.getInstance().createNodeId("3210697320273550615")));
                                } finally {
                                }
                                tnode14.addChild(myAggregationLinks[2], tnode15);
                                // TODO validate child 
                              }
                            } finally {
                            }
                            tnode9.addChild(myAggregationLinks[3], tnode14);
                            // TODO validate child 
                          }
                        } finally {
                        }
                        tnode5.addChild(myAggregationLinks[4], tnode9);
                        // TODO validate child 
                      }
                      {
                        final SNode tnode16 = environment.createOutputNode(myConcepts[0]);
                        try {
                          TemplateContext context11 = context5.subContext();
                          {
                            final SNode tnode17 = environment.createOutputNode(myConcepts[1]);
                            try {
                              TemplateContext context12 = context11.subContext();
                              {
                                final SNode tnode18 = environment.createOutputNode(myConcepts[5]);
                                try {
                                  TemplateContext context13 = context12.subContext();
                                  {
                                    final SNode tnode19 = environment.createOutputNode(myConcepts[3]);
                                    try {
                                      tnode19.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode19, PersistenceFacade.getInstance().createModelReference("r:f5e9b11f-5073-4786-8ed1-a9e42307c3f8(JavaKaja.runtime)"), PersistenceFacade.getInstance().createNodeId("3308300503039580739")));
                                      TemplateContext context14 = context13.subContext();
                                      {
                                        final SNode tnode20 = environment.createOutputNode(myConcepts[6]);
                                        try {
                                          SNodeAccessUtil.setProperty(tnode20, myProperties[1], "Nothing to pick. The cell is empty.");
                                        } finally {
                                        }
                                        tnode19.addChild(myAggregationLinks[0], tnode20);
                                        // TODO validate child 
                                      }
                                    } finally {
                                    }
                                    tnode18.addChild(myAggregationLinks[2], tnode19);
                                    // TODO validate child 
                                  }
                                } finally {
                                }
                                tnode17.addChild(myAggregationLinks[3], tnode18);
                                // TODO validate child 
                              }
                              {
                                final SNode tnode21 = environment.createOutputNode(myConcepts[7]);
                                try {
                                } finally {
                                }
                                tnode17.addChild(myAggregationLinks[3], tnode21);
                                // TODO validate child 
                              }
                            } finally {
                            }
                            tnode16.addChild(myAggregationLinks[5], tnode17);
                            // TODO validate child 
                          }
                        } finally {
                        }
                        tnode5.addChild(myAggregationLinks[6], tnode16);
                        // TODO validate child 
                      }
                    } finally {
                    }
                    tnode4.addChild(myAggregationLinks[3], tnode5);
                    // TODO validate child 
                  }
                } finally {
                }
                tnode3.addChild(myAggregationLinks[4], tnode4);
                // TODO validate child 
              }
              {
                final SNode tnode22 = environment.createOutputNode(myConcepts[8]);
                try {
                  TemplateContext context15 = context3.subContext();
                  {
                    final SNode tnode23 = environment.createOutputNode(myConcepts[3]);
                    try {
                      tnode23.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode23, PersistenceFacade.getInstance().createModelReference("r:f5e9b11f-5073-4786-8ed1-a9e42307c3f8(JavaKaja.runtime)"), PersistenceFacade.getInstance().createNodeId("3210697320273648281")));
                      TemplateContext context16 = context15.subContext();
                      {
                        final SNode tnode24 = environment.createOutputNode(myConcepts[4]);
                        try {
                          SNodeAccessUtil.setProperty(tnode24, myProperties[0], TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_4_4(new PropertyMacroContext(context16, "0", propertyMacro_mi0eld_c0a0c0a0b0c0b0b0b0c0b0b0b0b0c0g))));
                        } finally {
                        }
                        tnode23.addChild(myAggregationLinks[0], tnode24);
                        // TODO validate child 
                      }
                    } finally {
                    }
                    tnode22.addChild(myAggregationLinks[7], tnode23);
                    // TODO validate child 
                  }
                  {
                    final SNode tnode25 = environment.createOutputNode(myConcepts[3]);
                    try {
                      tnode25.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode25, PersistenceFacade.getInstance().createModelReference("r:f5e9b11f-5073-4786-8ed1-a9e42307c3f8(JavaKaja.runtime)"), PersistenceFacade.getInstance().createNodeId("3210697320273648203")));
                      TemplateContext context17 = context15.subContext();
                      {
                        final SNode tnode26 = environment.createOutputNode(myConcepts[4]);
                        try {
                          SNodeAccessUtil.setProperty(tnode26, myProperties[0], TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_4_5(new PropertyMacroContext(context17, "0", propertyMacro_mi0eld_c0a0c0a0b0c0b0c0b0c0b0b0b0b0c0g))));
                        } finally {
                        }
                        tnode25.addChild(myAggregationLinks[0], tnode26);
                        // TODO validate child 
                      }
                    } finally {
                    }
                    tnode22.addChild(myAggregationLinks[8], tnode25);
                    // TODO validate child 
                  }
                } finally {
                }
                tnode3.addChild(myAggregationLinks[1], tnode22);
                // TODO validate child 
              }
              {
                final SNode tnode27 = environment.createOutputNode(myConcepts[0]);
                try {
                  TemplateContext context18 = context3.subContext();
                  {
                    final SNode tnode28 = environment.createOutputNode(myConcepts[1]);
                    try {
                      TemplateContext context19 = context18.subContext();
                      {
                        final SNode tnode29 = environment.createOutputNode(myConcepts[5]);
                        try {
                          TemplateContext context20 = context19.subContext();
                          {
                            final SNode tnode30 = environment.createOutputNode(myConcepts[3]);
                            try {
                              tnode30.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode30, PersistenceFacade.getInstance().createModelReference("r:f5e9b11f-5073-4786-8ed1-a9e42307c3f8(JavaKaja.runtime)"), PersistenceFacade.getInstance().createNodeId("3308300503039580739")));
                              TemplateContext context21 = context20.subContext();
                              {
                                final SNode tnode31 = environment.createOutputNode(myConcepts[6]);
                                try {
                                  SNodeAccessUtil.setProperty(tnode31, myProperties[1], "Attempted to pick marks outside of the playground!");
                                } finally {
                                }
                                tnode30.addChild(myAggregationLinks[0], tnode31);
                                // TODO validate child 
                              }
                            } finally {
                            }
                            tnode29.addChild(myAggregationLinks[2], tnode30);
                            // TODO validate child 
                          }
                        } finally {
                        }
                        tnode28.addChild(myAggregationLinks[3], tnode29);
                        // TODO validate child 
                      }
                    } finally {
                    }
                    tnode27.addChild(myAggregationLinks[5], tnode28);
                    // TODO validate child 
                  }
                } finally {
                }
                tnode3.addChild(myAggregationLinks[6], tnode27);
                // TODO validate child 
              }
            } finally {
            }
            tnode2.addChild(myAggregationLinks[3], tnode3);
            // TODO validate child 
          }
          {
            final SNode tnode32 = environment.createOutputNode(myConcepts[9]);
            try {
            } finally {
            }
            tnode2.addChild(myAggregationLinks[3], tnode32);
            // TODO validate child 
          }
        } finally {
        }
        tnode1.addChild(myAggregationLinks[5], tnode2);
        // TODO validate child 
      }
    } finally {
    }
    FragmentResult rv = nodeFragment(3, tnode1);
    return rv;
  }
  @Override
  public Collection<SNode> apply(@NotNull TemplateExecutionEnvironment environment, @NotNull TemplateContext context) throws GenerationException {
    ArrayList<SNode> rv = new ArrayList<SNode>();
    applyPart0(context).reportTo(rv);
    return rv;
  }

  @Override
  public Collection<SNode> weave(@NotNull NodeWeaveFacility.WeaveContext weaveContext, @NotNull NodeWeaveFacility weaveSupport) throws GenerationException {
    ArrayList<SNode> rv = new ArrayList<SNode>();
    applyPart0(weaveSupport.getTemplateContext()).weaveWith(weaveSupport).reportTo(rv);
    return rv;
  }
  @Override
  protected SConcept[] initConcepts() {
    SConcept[] rv = new SConcept[10];
    rv[0] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xfc092b6b77L, "BlockStatement");
    rv[1] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc56b200L, "StatementList");
    rv[2] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc56b217L, "IfStatement");
    rv[3] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x6c6b6a1e379f9404L, "LocalMethodCall");
    rv[4] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc59b314L, "IntegerConstant");
    rv[5] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc56b213L, "ExpressionStatement");
    rv[6] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf93d565d10L, "StringLiteral");
    rv[7] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc67c7feL, "ReturnStatement");
    rv[8] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xfb7c3070eeL, "AndExpression");
    rv[9] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc56b215L, "Statement");
    return rv;
  }
  @Override
  protected SProperty[] initProperties() {
    SProperty[] rv = new SProperty[2];
    rv[0] = MetaAdapterFactory.getProperty(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc59b314L, 0xf8cc59b315L, "value");
    rv[1] = MetaAdapterFactory.getProperty(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf93d565d10L, 0xf93d565d11L, "value");
    return rv;
  }
  @Override
  protected SReferenceLink[] initAssociationLinks() {
    SReferenceLink[] rv = new SReferenceLink[1];
    rv[0] = MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301adL, "baseMethodDeclaration");
    return rv;
  }
  @Override
  protected SContainmentLink[] initAggregationLinks() {
    SContainmentLink[] rv = new SContainmentLink[9];
    rv[0] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301aeL, "actualArgument");
    rv[1] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b217L, 0xf8cc56b218L, "condition");
    rv[2] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b213L, 0xf8cc56b214L, "expression");
    rv[3] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b200L, 0xf8cc6bf961L, "statement");
    rv[4] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b217L, 0xf8cc56b219L, "ifTrue");
    rv[5] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xfc092b6b77L, 0xfc092b6b78L, "statements");
    rv[6] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b217L, 0xfc092b6b76L, "ifFalseStatement");
    rv[7] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xfbdeb6fecfL, 0xfbdeb7a11bL, "rightExpression");
    rv[8] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xfbdeb6fecfL, 0xfbdeb7a11cL, "leftExpression");
    return rv;
  }
  private static SNodePointer propertyMacro_mi0eld_c0a0c0a0b0c0b0b0b0b0b0b0b0b0b0b0c0g = new SNodePointer("r:262b93f0-fe86-497c-93c5-efd684d05bc6(jetbrains.mps.samples.KajaSceneConstruction.generator.template.main@generator)", "3210697320273614490");
  private static SNodePointer propertyMacro_mi0eld_c0a0c0a0b0d0b0b0b0b0b0b0b0b0b0b0c0g = new SNodePointer("r:262b93f0-fe86-497c-93c5-efd684d05bc6(jetbrains.mps.samples.KajaSceneConstruction.generator.template.main@generator)", "3210697320273614499");
  private static SNodePointer propertyMacro_mi0eld_c0a0c0a0b0c0b0b0b0b0b0c0b0b0b0b0b0b0b0b0c0g = new SNodePointer("r:262b93f0-fe86-497c-93c5-efd684d05bc6(jetbrains.mps.samples.KajaSceneConstruction.generator.template.main@generator)", "3210697320273614510");
  private static SNodePointer propertyMacro_mi0eld_c0a0c0a0b0d0b0b0b0b0b0c0b0b0b0b0b0b0b0b0c0g = new SNodePointer("r:262b93f0-fe86-497c-93c5-efd684d05bc6(jetbrains.mps.samples.KajaSceneConstruction.generator.template.main@generator)", "3210697320273614521");
  private static SNodePointer propertyMacro_mi0eld_c0a0c0a0b0c0b0b0b0c0b0b0b0b0c0g = new SNodePointer("r:262b93f0-fe86-497c-93c5-efd684d05bc6(jetbrains.mps.samples.KajaSceneConstruction.generator.template.main@generator)", "3210697320273648469");
  private static SNodePointer propertyMacro_mi0eld_c0a0c0a0b0c0b0c0b0c0b0b0b0b0c0g = new SNodePointer("r:262b93f0-fe86-497c-93c5-efd684d05bc6(jetbrains.mps.samples.KajaSceneConstruction.generator.template.main@generator)", "3210697320273648478");
}