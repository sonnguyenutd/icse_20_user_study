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
import java.util.ArrayList;
import jetbrains.mps.generator.runtime.NodeWeaveFacility;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import org.jetbrains.mps.openapi.language.SProperty;
import org.jetbrains.mps.openapi.language.SReferenceLink;
import org.jetbrains.mps.openapi.language.SContainmentLink;

@Generated
public class Template_reduce_GetNextSiblingsOperation extends TemplateDeclarationBase implements TemplateDeclaration2 {

  public Template_reduce_GetNextSiblingsOperation() {
  }

  public SNodeReference getTemplateNode() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c89590303(jetbrains.mps.lang.smodel.generator.baseLanguage.template.main@generator)", "1145572255293");
  }


  protected FragmentResult applyPart0(@NotNull final TemplateContext context) throws GenerationException {
    final TemplateExecutionEnvironment environment = context.getEnvironment();
    final SNode tnode1 = environment.createOutputNode(myConcepts[0]);
    try {
      tnode1.setReference(myAssociationLinks[0], SReference.create(myAssociationLinks[0], tnode1, PersistenceFacade.getInstance().createModelReference("r:c3548bac-30eb-4a2a-937c-0111d5697309(jetbrains.mps.lang.smodel.generator.smodelAdapter)"), PersistenceFacade.getInstance().createNodeId("6599163591527286941")));
      tnode1.setReference(myAssociationLinks[1], SReference.create(myAssociationLinks[1], tnode1, PersistenceFacade.getInstance().createModelReference("r:c3548bac-30eb-4a2a-937c-0111d5697309(jetbrains.mps.lang.smodel.generator.smodelAdapter)"), PersistenceFacade.getInstance().createNodeId("6599163591527294255")));
      TemplateContext context1 = context.subContext();
      {
        Collection<SNode> tlist2 = null;
        final SNode copySrcInput2 = QueriesGenerated.sourceNodeQuery_17_0(new SourceSubstituteMacroNodeContext(context1, copySrcMacro_ckuduo_b0a0c0d0c0g));
        tlist2 = environment.copyNodes(TemplateUtil.singletonList(copySrcInput2), copySrcMacro_ckuduo_b0a0c0d0c0g, "tpl/r:00000000-0000-4000-0000-011c89590303/1145572255296", context1);
        for (SNode child3 : TemplateUtil.asNotNull(tlist2)) {
          tnode1.addChild(myAggregationLinks[0], child3);
        }
        // TODO validate child 
      }
      {
        final SNode tnode4 = environment.createOutputNode(myConcepts[1]);
        try {
          SNodeAccessUtil.setProperty(tnode4, myProperties[0], TemplateUtil.asString(QueriesGenerated.propertyMacro_GetValue_17_0(new PropertyMacroContext(context1, null, propertyMacro_ckuduo_c0a0c0a0b0e0c0g))));
        } finally {
        }
        tnode1.addChild(myAggregationLinks[0], tnode4);
        // TODO validate child 
      }
    } finally {
    }
    FragmentResult rv = nodeFragment(1, tnode1);
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
    SConcept[] rv = new SConcept[2];
    rv[0] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xfbbebabf09L, "StaticMethodCall");
    rv[1] = MetaAdapterFactory.getConcept(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"), 0xf8cc56b201L, "BooleanConstant");
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
    SReferenceLink[] rv = new SReferenceLink[2];
    rv[0] = MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0xfbbebabf09L, 0x10a7588b546L, "classConcept");
    rv[1] = MetaAdapterFactory.getReferenceLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301adL, "baseMethodDeclaration");
    return rv;
  }
  @Override
  protected SContainmentLink[] initAggregationLinks() {
    SContainmentLink[] rv = new SContainmentLink[2];
    rv[0] = MetaAdapterFactory.getContainmentLink(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x11857355952L, 0xf8c78301aeL, "actualArgument");
    rv[1] = MetaAdapterFactory.getContainmentLink(0xb401a68083254110L, 0x8fd384331ff25befL, 0xfe43cb41d0L, 0xfe43de823bL, "contentNode");
    return rv;
  }
  private static SNodePointer copySrcMacro_ckuduo_b0a0c0d0c0g = new SNodePointer("r:00000000-0000-4000-0000-011c89590303(jetbrains.mps.lang.smodel.generator.baseLanguage.template.main@generator)", "1145572255297");
  private static SNodePointer propertyMacro_ckuduo_c0a0c0a0b0e0c0g = new SNodePointer("r:00000000-0000-4000-0000-011c89590303(jetbrains.mps.lang.smodel.generator.baseLanguage.template.main@generator)", "1145572330816");
}
