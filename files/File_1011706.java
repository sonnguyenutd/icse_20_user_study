package jetbrains.mps.java.platform.actions;

/*Generated by MPS */

import com.intellij.util.Function;
import org.jetbrains.mps.openapi.model.SNodeReference;
import org.jetbrains.mps.openapi.module.SRepository;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.ModelComputeRunnable;
import jetbrains.mps.util.Computable;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPointerOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.behaviour.BHReflection;
import jetbrains.mps.core.aspects.behaviour.SMethodTrimmedId;

public class DefaultBLMethodNameFilter implements Function<SNodeReference, String> {
  private final SRepository myRepo;

  public DefaultBLMethodNameFilter(@NotNull SRepository repository) {
    myRepo = repository;
  }

  @Override
  public String fun(final SNodeReference ptr) {
    String name = new ModelComputeRunnable<String>(new Computable<String>() {
      @Override
      public String compute() {
        SNode node = SPointerOperations.resolveNode(ptr, myRepo);
        if (SNodeOperations.isInstanceOf(node, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x6c6b6a1e379f9408L, "jetbrains.mps.baseLanguage.structure.MethodDeclaration"))) {
          SNode containingClassifier = SNodeOperations.getNodeAncestor(node, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x101d9d3ca30L, "jetbrains.mps.baseLanguage.structure.Classifier"), false, false);
          if (containingClassifier != null) {
            return NameUtil.shortNameFromLongName(((String) BHReflection.invoke0(containingClassifier, MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, "jetbrains.mps.lang.core.structure.INamedConcept"), SMethodTrimmedId.create("getFqName", null, "hEwIO9y"))));
          }
          return ((String) BHReflection.invoke0(SNodeOperations.cast(node, MetaAdapterFactory.getConcept(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, 0x6c6b6a1e379f9408L, "jetbrains.mps.baseLanguage.structure.MethodDeclaration")), MetaAdapterFactory.getInterfaceConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, "jetbrains.mps.lang.core.structure.INamedConcept"), SMethodTrimmedId.create("getFqName", null, "hEwIO9y")));
        } else if (node != null) {
          return ((SNode) node).getName();
        }
        return "";
      }
    }).runRead(myRepo.getModelAccess());
    return name;
  }
}
