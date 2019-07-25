package jetbrains.mps.ide.newSolutionDialog;

/*Generated by MPS */

import jetbrains.mps.util.annotation.ToRemove;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.project.MPSProject;
import java.io.IOException;
import java.io.File;
import org.jetbrains.mps.openapi.model.EditableSModel;
import jetbrains.mps.lang.migration.runtime.base.VersionFixer;
import jetbrains.mps.smodel.SModelInternal;
import org.jetbrains.mps.openapi.language.SLanguage;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.project.MPSExtentions;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.library.ModulesMiner;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;
import jetbrains.mps.project.Project;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.mps.openapi.module.SRepository;
import javax.lang.model.SourceVersion;
import jetbrains.mps.ide.NewModuleCheckUtil;
import jetbrains.mps.smodel.ModelAccessHelper;
import jetbrains.mps.util.Computable;
import jetbrains.mps.util.NameUtil;
import org.jetbrains.mps.openapi.model.SModel;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.project.SModuleOperations;
import org.jetbrains.mps.openapi.model.SModelName;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.LanguageAspect;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.persistence.DefaultModelRoot;
import jetbrains.mps.project.ProjectPathUtil;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.project.ModuleId;
import org.jetbrains.mps.openapi.module.SModule;
import org.jetbrains.mps.openapi.persistence.ModelRoot;

@ToRemove(version = 3.5)
public class NewModuleUtil {
  public static Solution createRuntimeSolution(Language language, String languageRootPath, MPSProject project) throws IOException {
    String basePath = languageRootPath + File.separator + "runtime";
    String namespace = language.getModuleName() + ".runtime";

    Solution runtime = NewModuleUtil.createSolution(namespace, basePath, project);
    EditableSModel runtimeModel = createModel(runtime, namespace);
    runtimeModel.save();

    new VersionFixer(project, runtime, false).updateImportVersions();
    runtime.save();
    return runtime;
  }

  public static Solution createSandboxSolution(Language language, String languageRootPath, MPSProject project) throws IOException {
    String basePath = languageRootPath + File.separator + "sandbox";
    String namespace = language.getModuleName() + ".sandbox";

    Solution sandbox = NewModuleUtil.createSolution(namespace, basePath, project);
    SModelInternal sandboxModel = (SModelInternal) createModel(sandbox, namespace);
    SLanguage l = MetaAdapterFactory.getLanguage(language.getModuleReference());
    sandboxModel.addLanguage(l);
    sandboxModel.setLanguageImportVersion(l, language.getLanguageVersion());
    ((EditableSModel) sandboxModel).save();

    VersionFixer fixer = new VersionFixer(project, sandbox, false);
    {
      Iterator<Language> extLang_it = SetSequence.fromSet(language.getAllExtendedLanguages()).iterator();
      Language extLang_var;
      while (extLang_it.hasNext()) {
        extLang_var = extLang_it.next();
        SLanguage extSLang = MetaAdapterFactory.getLanguage(extLang_var.getModuleReference());
        fixer.addJustCreatedLanguageVersion(extSLang, (extSLang.isValid() ? extSLang.getLanguageVersion() : extLang_var.getLanguageVersion()));
      }
    }
    fixer.updateImportVersions();

    sandbox.save();
    return sandbox;
  }

  /**
   * create new solution module and register it with the project
   */
  public static Solution createSolution(String namespace, String rootPath, MPSProject project) {
    IFile descriptorFile = NewModuleUtil.getModuleFile(namespace, rootPath, MPSExtentions.DOT_SOLUTION);
    assert !(descriptorFile.exists());
    SolutionDescriptor descriptor = createNewSolutionDescriptor(namespace, descriptorFile);
    Solution module = (Solution) new ModuleRepositoryFacade(project).instantiateModule(new ModulesMiner.ModuleHandle(descriptorFile, descriptor), project);
    new VersionFixer(project, module, false).updateImportVersions();
    module.save();

    project.addModule(module);
    return module;
  }

  public static Language createLanguage(String namespace, String rootPath, MPSProject project, boolean saveProject) {
    IFile descriptorFile = NewModuleUtil.getModuleFile(namespace, rootPath, MPSExtentions.DOT_LANGUAGE);

    if (descriptorFile.exists()) {
      throw new IllegalArgumentException("Descriptor file " + descriptorFile + " already exists");
    }
    LanguageDescriptor languageDescriptor = createNewLanguageDescriptor(namespace, descriptorFile);

    IFile generatorLocation = descriptorFile.getParent().findChild("generator");
    IFile templateModelsLocation = generatorLocation.findChild("template");
    templateModelsLocation.mkdirs();

    //  it's the first and only generator in the language, no need to generate some unique long value 
    final GeneratorDescriptor generatorDescriptor = createGeneratorDescriptor(languageDescriptor.getNamespace() + "#01", generatorLocation, templateModelsLocation);
    generatorDescriptor.setSourceLanguage(languageDescriptor.getModuleReference());
    languageDescriptor.getGenerators().add(generatorDescriptor);

    ModuleRepositoryFacade projectRepoFacade = new ModuleRepositoryFacade(project);
    Language language = (Language) projectRepoFacade.instantiateModule(new ModulesMiner.ModuleHandle(descriptorFile, languageDescriptor), project);
    Generator generator = (Generator) projectRepoFacade.instantiateModule(new ModulesMiner.ModuleHandle(descriptorFile, generatorDescriptor), project);

    try {
      createMainLanguageAspects(language);
    } catch (IOException e) {
      // todo: ??? 
      throw new RuntimeException(e);
    }

    createTemplateModelIfNoneYet(generator);

    project.addModule(language);
    // as long as generator lives under the language, and Project doesn't support standalone generators, no need for project.addModule(generator) 
    new VersionFixer(project, language, false).updateImportVersions();
    new VersionFixer(project, generator, false).updateImportVersions();
    language.save();
    generator.save();
    if (saveProject) {
      project.save();
    }
    return language;
  }

  /**
   * create new language module with nested generator and register both with the project
   */
  public static Language createLanguage(String namespace, String rootPath, MPSProject project) {
    return createLanguage(namespace, rootPath, project, true);
  }

  /**
   * create new devkit module and register it with the project
   */
  public static DevKit createDevKit(String namespace, String rootPath, MPSProject project) {
    IFile descriptorFile = NewModuleUtil.getModuleFile(namespace, rootPath, MPSExtentions.DOT_DEVKIT);
    assert !(descriptorFile.exists());
    DevkitDescriptor descriptor = createNewDevkitDescriptor(namespace);
    DevKit module = (DevKit) new ModuleRepositoryFacade(project).instantiateModule(new ModulesMiner.ModuleHandle(descriptorFile, descriptor), project);
    module.save();

    project.addModule(module);
    project.save();
    return module;
  }

  public static void runModuleCreation(Project p, final _FunctionTypes._void_P0_E0 r) {
    p.getRepository().getModelAccess().executeCommand(new Runnable() {
      public void run() {
        ApplicationManager.getApplication().assertWriteAccessAllowed();
        r.invoke();
      }
    });
  }

  public static String check(@Nullable final SRepository repo, String extension, final String namespace, String rootPath) {
    if (MPSExtentions.DOT_LANGUAGE.equals(extension) && !(SourceVersion.isName(namespace))) {
      return "Language namespace should be valid Java package";
    }
    if (rootPath.length() == 0) {
      return "Path should be specified";
    }
    String message = NewModuleCheckUtil.checkModuleDirectory(new File(rootPath), extension, "Module");
    if (message != null) {
      return message;
    }
    if (namespace.length() == 0) {
      return "Namespace should be specified";
    }
    // If don't have repository then there are no duplicated module name 
    boolean duplicateName = (repo == null ? false : new ModelAccessHelper(repo).runReadAction(new Computable<Boolean>() {
      public Boolean compute() {
        return !(new ModuleRepositoryFacade(repo).getModulesByName(namespace).isEmpty());
      }
    }));
    if (duplicateName) {
      return "Module namespace already exists";
    }
    if (NameUtil.shortNameFromLongName(namespace).length() == 0) {
      return "Enter valid namespace";
    }
    IFile moduleDir = getModuleFile(namespace, rootPath, extension).getParent();
    // FIXME it's suspicious to check existence of a model directory to tell existence of a module 
    // E.g. it might be empty, or named differently. Left intact for now, although deserves a refactoring 
    if (moduleDir.findChild(Language.LANGUAGE_MODELS).exists() || moduleDir.findChild(Language.LEGACY_LANGUAGE_MODELS).exists() || moduleDir.findChild(Solution.SOLUTION_MODELS).exists()) {
      return "Module already exists in this folder";
    }

    return null;
  }

  public static void createTemplateModelIfNoneYet(Generator newGenerator) {
    boolean alreadyOwnsTemplateModel = false;
    for (SModel modelDescriptor : newGenerator.getModels()) {
      if (SModelStereotype.isGeneratorModel(modelDescriptor)) {
        alreadyOwnsTemplateModel = true;
        break;
      }
    }
    if (!(alreadyOwnsTemplateModel)) {
      SModel templateModel = SModuleOperations.createModelWithAdjustments(new SModelName(null, "main", SModelStereotype.GENERATOR).getValue(), newGenerator.getModelRoots().iterator().next());
      SNode mappingConfiguration = SModelOperations.createNewNode(templateModel, null, MetaAdapterFactory.getConcept(0xb401a68083254110L, 0x8fd384331ff25befL, 0xff0bea0475L, "jetbrains.mps.lang.generator.structure.MappingConfiguration"));
      // both model and MC named 'main' is a bit confusing 
      SPropertyOperations.assign(mappingConfiguration, MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name"), "main");
      SModelOperations.addRootNode(templateModel, mappingConfiguration);
      ((EditableSModel) templateModel).save();
    }
  }

  public static void createMainLanguageAspects(Language language) throws IOException {
    assert language.getModelRoots().iterator().hasNext();
    ((EditableSModel) LanguageAspect.STRUCTURE.createNew(language)).save();
    ((EditableSModel) LanguageAspect.EDITOR.createNew(language)).save();
    ((EditableSModel) LanguageAspect.CONSTRAINTS.createNew(language)).save();
    ((EditableSModel) LanguageAspect.BEHAVIOR.createNew(language)).save();
    ((EditableSModel) LanguageAspect.TYPESYSTEM.createNew(language)).save();
  }

  /**
   * Fill in new descriptor of Generator module with defaults.
   * This code is shared with NewGeneratorDialog. Please refactor this class, full of static, to something that 
   * an ocassional OOP stroller would admire.
   * 
   * 
   * @param generatorModuleLocation base root for generator module. This method doesn't care if location exist, nor ensures its existence.
   * @param templateModelsLocation generally a location under generator module root to keem template models. May be the same as {@code generatorModuleLocation}. Use {@code null} to use default ('templates').
   */
  @NotNull
  public static GeneratorDescriptor createGeneratorDescriptor(String namespace, @NotNull IFile generatorModuleLocation, @Nullable IFile templateModelsLocation) {
    final GeneratorDescriptor generatorDescriptor = new GeneratorDescriptor();
    generatorDescriptor.setNamespace(namespace);
    // unlike other modules, in outburst of pure antagonism, namespace in generator used to mean alias. Now, it's the way it has to be. 
    generatorDescriptor.setAlias("main");
    IFile modelsDir = (templateModelsLocation == null ? generatorModuleLocation.findChild("template") : templateModelsLocation);
    // there used to be 2 approaches, contentRoot = moduleRoot + sourceRoot descendant, and the one with both pointing to the same location 
    // no idea how to reason to pick one, go ahead and change if you're brave to prove. 
    generatorDescriptor.getModelRootDescriptors().add(DefaultModelRoot.createSingleFolderDescriptor(modelsDir));
    ProjectPathUtil.setGeneratorOutputPath(generatorDescriptor, generatorModuleLocation.findChild("source_gen").getPath());
    return generatorDescriptor;
  }

  private static IFile getModuleFile(String namespace, String rootPath, String extension) {
    String path = rootPath + File.separator + namespace + extension;
    return FileSystem.getInstance().getFile(path);
  }

  private static SolutionDescriptor createNewSolutionDescriptor(String namespace, IFile descriptorFile) {
    SolutionDescriptor descriptor = new SolutionDescriptor();
    descriptor.setNamespace(namespace);
    descriptor.setId(ModuleId.regular());
    IFile moduleLocation = descriptorFile.getParent();
    final IFile modelsDir = moduleLocation.findChild(Solution.SOLUTION_MODELS);
    if (modelsDir.exists() && modelsDir.getChildren().size() != 0) {
      throw new IllegalStateException("Trying to create a solution in an existing solution's directory: " + moduleLocation);
    } else {
      // we assume create happens under proper application write lock, would be odd to manage locks here 
      modelsDir.mkdirs();
    }

    descriptor.getModelRootDescriptors().add(DefaultModelRoot.createDescriptor(modelsDir.getParent(), modelsDir));
    ProjectPathUtil.setGeneratorOutputPath(descriptor, moduleLocation.findChild("source_gen").getPath());
    return descriptor;
  }

  private static LanguageDescriptor createNewLanguageDescriptor(String languageNamespace, IFile descriptorFile) {
    LanguageDescriptor languageDescriptor = new LanguageDescriptor();
    languageDescriptor.setNamespace(languageNamespace);
    languageDescriptor.setId(ModuleId.regular());
    IFile moduleLocation = descriptorFile.getParent();
    IFile languageModels = moduleLocation.findChild(Language.LANGUAGE_MODELS);
    if (languageModels.exists()) {
      throw new IllegalStateException("Trying to create a language in an existing language's directory " + languageModels);
    }
    languageDescriptor.getModelRootDescriptors().add(DefaultModelRoot.createDescriptor(languageModels.getParent(), languageModels));
    ProjectPathUtil.setGeneratorOutputPath(languageDescriptor, moduleLocation.findChild("source_gen").getPath());
    return languageDescriptor;
  }

  private static DevkitDescriptor createNewDevkitDescriptor(String namespace) {
    DevkitDescriptor d = new DevkitDescriptor();
    d.setNamespace(namespace);
    d.setId(ModuleId.regular());
    return d;
  }

  private static EditableSModel createModel(SModule module, String modelName) {
    for (ModelRoot root : module.getModelRoots()) {
      if (root.canCreateModels() && root.canCreateModel(modelName)) {
        EditableSModel model = (EditableSModel) root.createModel(modelName);
        // todo: ??? 
        // this is strict model loading. without it save() not working - isLoaded() returns false in save method 
        // model.getSModel() 
        model.save();
        return model;
      }
    }
    throw new IllegalStateException("can't create model with " + modelName + " in module " + module.getModuleName());
  }
}