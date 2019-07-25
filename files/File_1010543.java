package jetbrains.mps.project.persistence;

/*Generated by MPS */

import jetbrains.mps.util.MacroHelper;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import org.jdom.Element;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.project.ModuleId;
import jetbrains.mps.project.structure.modules.SolutionKind;
import jetbrains.mps.util.xml.XmlUtil;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Collection;

/**
 * XML/DOM persistence for a descriptor of Solution module
 */
public class SolutionDescriptorPersistence {
  private final String SOURCE_GEN_DEFAULT = "${module}/source_gen";

  public static final String SOURCE_PATH = "sourcePath";
  public static final String SOURCE_PATH_SOURCE = "source";
  public static final String COMPILE_IN_MPS = "compileInMPS";
  private final MacroHelper myMacroHelper;

  public SolutionDescriptorPersistence(@NotNull MacroHelper macroHelper) {
    myMacroHelper = macroHelper;
  }

  @NotNull
  public SolutionDescriptor load(@NotNull final Element rootElement) throws ModuleReadException {
    SolutionDescriptor descriptor;
    try {
      descriptor = new _FunctionTypes._return_P0_E0<SolutionDescriptor>() {
        public SolutionDescriptor invoke() {
          final SolutionDescriptor result_8ckma3_a0a0a0b0j = new SolutionDescriptor();
          final String result_8ckma3_a0a0a0a0b0j = rootElement.getAttributeValue("name");
          result_8ckma3_a0a0a0b0j.setNamespace(result_8ckma3_a0a0a0a0b0j);

          if (rootElement.getAttributeValue("uuid") != null) {
            final ModuleId result_8ckma3_a0a2a0a0a0b0j = ModuleId.fromString(rootElement.getAttributeValue("uuid"));
            result_8ckma3_a0a0a0b0j.setId(result_8ckma3_a0a2a0a0a0b0j);
          }

          String pluginKind = rootElement.getAttributeValue("pluginKind");
          if (pluginKind != null && pluginKind.length() > 0) {
            final SolutionKind result_8ckma3_a0a5a0a0a0b0j = SolutionKind.valueOf(pluginKind);
            result_8ckma3_a0a0a0b0j.setKind(result_8ckma3_a0a5a0a0a0b0j);
          }

          final boolean result_8ckma3_a7a0a0a0b0j = XmlUtil.booleanWithDefault(rootElement, COMPILE_IN_MPS, false);
          result_8ckma3_a0a0a0b0j.setCompileInMPS(result_8ckma3_a7a0a0a0b0j);

          String moduleVersion = rootElement.getAttributeValue("moduleVersion");
          if (moduleVersion != null) {
            try {
              result_8ckma3_a0a0a0b0j.setModuleVersion(Integer.parseInt(moduleVersion));
            } catch (NumberFormatException ignored) {
            }
          }

          final String result_8ckma3_a21a0a0a0b0j = myMacroHelper.expandPath(XmlUtil.stringWithDefault(rootElement, "generatorOutputPath", SOURCE_GEN_DEFAULT));
          result_8ckma3_a0a0a0b0j.setOutputPath(result_8ckma3_a21a0a0a0b0j);

          result_8ckma3_a0a0a0b0j.getModelRootDescriptors().addAll(ModuleDescriptorPersistence.loadModelRoots(XmlUtil.children(XmlUtil.first(rootElement, "models"), "modelRoot"), myMacroHelper));

          result_8ckma3_a0a0a0b0j.setNeedsExternalIdeaCompile(XmlUtil.first(rootElement, "compileInIDEA") != null);

          Element facets = XmlUtil.first(rootElement, "facets");
          if (facets != null) {
            result_8ckma3_a0a0a0b0j.getModuleFacetDescriptors().addAll(ModuleDescriptorPersistence.loadFacets(XmlUtil.children(facets, "facet"), myMacroHelper));
          }


          Element stubModelEntries = XmlUtil.first(rootElement, "stubModelEntries");
          if (stubModelEntries != null) {
            List<String> roots = ModuleDescriptorPersistence.loadStubModelEntries(stubModelEntries, myMacroHelper);
            result_8ckma3_a0a0a0b0j.getJavaLibs().addAll(roots);
          }

          ModuleDescriptorPersistence.loadDependencies(result_8ckma3_a0a0a0b0j, rootElement);

          for (Element entryElement : Sequence.fromIterable(XmlUtil.children(XmlUtil.first(rootElement, SOURCE_PATH), SOURCE_PATH_SOURCE))) {
            result_8ckma3_a0a0a0b0j.getSourcePaths().add(myMacroHelper.expandPath(entryElement.getAttributeValue("path")));
          }
          return result_8ckma3_a0a0a0b0j;
        }
      }.invoke();
    } catch (Exception ex) {
      throw new ModuleReadException(ex);
    }
    return descriptor;
  }

  @NotNull
  public Element save(SolutionDescriptor descriptor) {
    Element result = new Element("solution");
    if (descriptor.getNamespace() != null) {
      result.setAttribute("name", descriptor.getNamespace());
    }
    if (descriptor.getId() != null) {
      result.setAttribute("uuid", descriptor.getId().toString());
    }
    result.setAttribute("moduleVersion", Integer.toString(descriptor.getModuleVersion()));
    if (descriptor.getKind() != SolutionKind.NONE) {
      result.setAttribute("pluginKind", descriptor.getKind().name());
    }
    result.setAttribute(COMPILE_IN_MPS, Boolean.toString(descriptor.getCompileInMPS()));
    if (descriptor.getOutputPath() != null) {
      String p = myMacroHelper.shrinkPath(descriptor.getOutputPath());
      if (!(SOURCE_GEN_DEFAULT.equals(p))) {
        result.setAttribute("generatorOutputPath", p);
      }
    }
    if (descriptor.needsExternalIdeaCompile()) {
      result.addContent(new Element("compileInIDEA"));
    }

    Element models = new Element("models");
    ModuleDescriptorPersistence.saveModelRoots(models, descriptor.getModelRootDescriptors(), myMacroHelper);
    result.addContent(models);

    if (!(descriptor.getModuleFacetDescriptors().isEmpty())) {
      Element facets = new Element("facets");
      ModuleDescriptorPersistence.saveFacets(facets, descriptor.getModuleFacetDescriptors(), myMacroHelper);
      result.addContent(facets);
    }


    Collection<String> additionalJavaStubPaths = descriptor.getJavaLibs();
    if (!(additionalJavaStubPaths.isEmpty())) {
      Element stubModelEntries = new Element("stubModelEntries");
      ModuleDescriptorPersistence.saveStubModelEntries(stubModelEntries, additionalJavaStubPaths, myMacroHelper);
      result.addContent(stubModelEntries);
    }

    Element sourcePath = new Element(SOURCE_PATH);
    for (String p : descriptor.getSourcePaths()) {
      XmlUtil.tagWithAttribute(sourcePath, SOURCE_PATH_SOURCE, "path", myMacroHelper.shrinkPath(p));
    }
    result.addContent(sourcePath);

    ModuleDescriptorPersistence.saveDependencies(result, descriptor);
    return result;
  }
}