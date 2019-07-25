package jetbrains.mps.lang.smodel.generator.baseLanguage.template.main;

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
import java.util.Collection;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.runtime.TemplateUtil;
import org.jetbrains.mps.openapi.model.SNodeAccessUtil;
import jetbrains.mps.generator.template.PropertyMacroContext;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.generator.runtime.NodeWeaveFacility;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.language.SProperty;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import org.jetbrains.mps.openapi.language.SContainmentLink;

@Generated
public class Template_reduce_GetDescendants_noConceptsList extends TemplateDeclarationBase implements TemplateDeclaration2 {

  public Template_reduce_GetDescendants_noConceptsList() {
  }

  public SNodeReference getTemplateNode() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c89590303(jetbrains.mps.lang.smodel.generator.baseLanguage.template.main@generator)", "1171307696664");
  }


  protected FragmentResult applyPart0(@NotNull final TemplateContext context) throws GenerationException {
    final TemplateExecutionEnvironment environment = context.getEnvironment();
    final SNode tnode1 = environment.createOutputNode(myConcepts[0]);
    try {
      tnode1.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode1, PersistenceFacade.getInstance().createModelReference("r:c3548bac-30eb-4a2a-937c-0111d5697309(jetbrains.mps.lang.smodel.generator.smodelAdapter)"), PersistenceFacade.getInstance().createNodeId("6599163591527286941")));
      tnode1.setReference(myAssociationLinks[1], SReference.create(myAssociationLinks[1], tnode1, PersistenceFacade.getInstance().createModelReference("r:c3548bac-30eb-4a2a-937c-0111d5697309(jetbrains.mps.lang.smodel.generator.smodelAdapter)"), PersistenceFacade.getInstance().createNodeId("6599163591527293712")));
      TemplateContext context1 = context.subContext();
      {
        Collection<SNode> tlist2 = null;
        final SNode copySrcInput2 = QueriesGenerated.sourceNodeQuery_22_0(new SourceSubstituteMacroNodeContext(context1, copySrcMacro_btzevu_b0a0c0d0c0g));
        tlist2 = environment.copyNodes(TemplateUtil.singletonList(copySrcInput2), copySrcMacro_btzevu_b0a0c0d0c0g, "tpl/r:00000000-0000-4000-0000-011c89590303/1171307696666", context1);
        for (SNode child3 : TemplateUtil.asNotNull(tlist2)) {
          tnode1.addChild(myAggregationLinks[0], child3);
        }
        // TODO validate child 
      }
      {
        Collection<SNode> tlist4 = null;
        tlist4 = new Template_reduce_OperationParamConcept().apply(environment, context1);
        for (SNode child5 : TemplateUtil.asNotNull(tlist4)) {
          tnode1.addChild(myAggregationLinks[0], child5);
        }
        // TODO validate child 
      }
      {
        final SNode tnode6 = environment.createOutputNode(myConcepts[1]);
        try {
          SNodeAccessUtil.setProperty(tnode6, myProperties[0], TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_22_0(new PropertyMacroContext(context1, null, propertyMacro_btzevu_c0a0c0a0b0f0c0g))));
        } finally {
        }
        tnode1.addChild(myAggregationLinks[0], tnode6);
        // TODO validate child 
      }
      {
        final SNode tnode7 = environment.createOutputNode(myConcepts[2]);
        try {
          TemplateContext context2 = context1.subContext();
          {
            final SNode tnode8 = environment.createOutputNode(myConcepts[3]);
            try {
              TemplateContext context3 = context2.subContext();
              {
                final SNode tnode9 = environment.createOutputNode(myConcepts[4]);
                try {
                  tnode9.setReference(myAssociationLinks[2], SReference.create(myAssociationLinks[2], tnode9, PersistenceFacade.getInstance().createModelReference("8865b7a8-5271-43d3-884c-6fd1d9cfdd34/java:org.jetbrains.mps.openapi.language(MPS.OpenAPI/)"), PersistenceFacade.getInstance().createNodeId("~SAbstractConcept")));
                } finally {
                }
                tnode8.addChild(myAggregationLinks[1], tnode9);
                // TODO validate child 
              }
              {
                final List<SNode> tlist10 = new ArrayList<SNode>();
                final Iterable<SNode> loopList10 = QueriesGenerated.sourceNodesQuery_22_0(new SourceSubstituteMacroNodesContext(context3, loopMacroRef_btzevu_b0a0a1a2a1a1a1a6a2a6));
                for (SNode itnode10 : loopList10) {
                  if (itnode10 == null) {
                    continue;
                  }
                  TemplateContext context4 = context3.subContext(itnode10);
                  Collection<SNode> tlist11 = null;
                  SNode callInputNode11 = QueriesGenerated.sourceNodeQuery_22_1(new SourceSubstituteMacroNodeContext(context4, callMacro_btzevu_b0a0a3a2a2a1a1a1a6a2a6));
                  TemplateContext context5;
                  context5 = context4.subContext(null, callInputNode11);
                  if (callInputNode11 != null) {
                    tlist11 = new Template_reduce_ConceptDeclaration2SAbstractConcept().apply(environment, context5);
                  }
                  if (tlist11 != null) {
                    tlist10.addAll(tlist11);
                  }
                }
                for (SNode child12 : TemplateUtil.asNotNull(tlist10)) {
                  tnode8.addChild(myAggregationLinks[2], child12);
                }
                // TODO validate child 
              }
            } finally {
            }
            tnode7.addChild(myAggregationLinks[3], tnode8);
            // TODO validate child 
          }
        } finally {
        }
        tnode1.addChild(myAggregationLinks[0], tnode7);
        // TODO validate child 
      }
    } finally {
    }
    FragmentResult rv = nodeFragment(4, tnode1);
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
    SConcept[] rv = new SConcept[5];
    rv[0] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xfbbebabf09L, "StaticMethodCall");
    rv[1] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc56b201L, "BooleanConstant");
    rv[2] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x10ab8473cc5L, "GenericNewExpression");
    rv[3] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x10cd01b77ddL, "ArrayCreatorWithInitializer");
    rv[4] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0x101de48bf9eL, "ClassifierType");
    return rv;
  }
  @Override
  protected SProperty[] initProperties() {
    SProperty[] rv = new SProperty[1];
    rv[0] = MetaAdapterFactory.getProperty(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xf8cc56b201L, 0xf8cc56b202L, "value");
    return rv;
  }
  @Override
  protected SReferenceLink[] initAssociationLinks() {
    SReferenceLink[] rv = new SReferenceLink[3];
    rv[0] = MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xfbbebabf09L, 0x10a7588b546L, "classConcept");
    rv[1] = MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301adL, "baseMethodDeclaration");
    rv[2] = MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101de48bf9eL, 0x101de490babL, "classifier");
    return rv;
  }
  @Override
  protected SContainmentLink[] initAggregationLinks() {
    SContainmentLink[] rv = new SContainmentLink[5];
    rv[0] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301aeL, "actualArgument");
    rv[1] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x10cd01b77ddL, 0x10cd01cf3c4L, "componentType");
    rv[2] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x10cd01b77ddL, 0x10cd01d19acL, "initValue");
    rv[3] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x10ab8473cc5L, 0x10ab847b486L, "creator");
    rv[4] = MetaAdapterFactory.getContainmentLink(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfe43cb41d0L, 0xfe43de823bL, "contentNode");
    return rv;
  }
  private static SNodePointer copySrcMacro_btzevu_b0a0c0d0c0g = new SNodePointer("r:00000000-0000-4000-0000-011c89590303(jetbrains.mps.lang.smodel.generator.baseLanguage.template.main@generator)", "1171307696667");
  private static SNodePointer propertyMacro_btzevu_c0a0c0a0b0f0c0g = new SNodePointer("r:00000000-0000-4000-0000-011c89590303(jetbrains.mps.lang.smodel.generator.baseLanguage.template.main@generator)", "1176946951444");
  private static SNodePointer loopMacroRef_btzevu_b0a0a1a2a1a1a1a6a2a6 = new SNodePointer("r:00000000-0000-4000-0000-011c89590303(jetbrains.mps.lang.smodel.generator.baseLanguage.template.main@generator)", "3902354333654091547");
  private static SNodePointer callMacro_btzevu_b0a0a3a2a2a1a1a1a6a2a6 = new SNodePointer("r:00000000-0000-4000-0000-011c89590303(jetbrains.mps.lang.smodel.generator.baseLanguage.template.main@generator)", "633481135935145294");
}