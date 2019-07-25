package jetbrains.mps.persistence.java.library;

/*Generated by MPS */

import jetbrains.mps.smodel.RegularModelDescriptor;
import jetbrains.mps.extapi.persistence.ModelSourceChangeTracker;
import org.jetbrains.mps.openapi.model.SModelReference;
import jetbrains.mps.extapi.persistence.FolderSetDataSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.module.SRepository;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.smodel.loading.ModelLoadingState;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.baseLanguage.javastub.ASMModelLoader;
import jetbrains.mps.smodel.nodeidmap.MigratingJavaStubRefsNodeIdMap;
import java.util.Collection;
import jetbrains.mps.smodel.loading.PartialModelUpdateFacility;
import jetbrains.mps.smodel.ModelLoadResult;
import org.jetbrains.mps.openapi.language.SLanguage;
import java.util.Set;
import java.util.Collections;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.List;
import org.jetbrains.mps.openapi.module.SModuleReference;
import org.jetbrains.mps.openapi.module.SModule;
import jetbrains.mps.extapi.module.SModuleBase;

public class JavaClassStubModelDescriptor extends RegularModelDescriptor implements ModelSourceChangeTracker.ReloadCallback {
  private final ModelSourceChangeTracker myTimestampTracker;
  private boolean mySkipPrivate;

  /**
   * tracks nested load() calls from within PartialModelUpdateFacility#update
   * XXX would be nice to check update mode in LazySNode and not to demand enforceFullLoad() in this case
   */
  private boolean myIsLoadInProgress;

  public JavaClassStubModelDescriptor(SModelReference modelReference, FolderSetDataSource source) {
    super(modelReference, source);
    myTimestampTracker = new ModelSourceChangeTracker(this);
  }

  @Override
  public void attach(@NotNull SRepository repository) {
    super.attach(repository);
    myTimestampTracker.attach(this);
  }

  @Override
  public void detach() {
    myTimestampTracker.detach(this);
    super.detach();
  }

  /*package*/ void setSkipPrivate(boolean skipPrivateMembers) {
    mySkipPrivate = skipPrivateMembers;
  }

  @NotNull
  @Override
  public FolderSetDataSource getSource() {
    return (FolderSetDataSource) super.getSource();
  }

  @Nullable
  @Override
  public AbstractModule getModule() {
    return (AbstractModule) super.getModule();
  }

  @Override
  public void load() {
    if (getLoadingState() != ModelLoadingState.FULLY_LOADED) {
      final ModelLoadingState oldState;
      synchronized (myLoadLock) {
        if (myIsLoadInProgress) {
          // we are inside nested load() within update 
          // the check shall be inside synchronized block, otherwise any other thread won't block on load 
          return;
        }
        final SModel mi = getSModel();
        oldState = getLoadingState();
        if (oldState == ModelLoadingState.FULLY_LOADED) {
          // another thread succeeded first 
          return;
        }
        myIsLoadInProgress = true;
        ASMModelLoader loader = new ASMModelLoader(getModule(), getSource().getPaths());
        loader.skipPrivateMembers(mySkipPrivate);
        SModel completeModelData = new SModel(getReference(), new MigratingJavaStubRefsNodeIdMap());
        Collection<SModelReference> imports = loader.completeModel(this, completeModelData);
        completeModelData.enterUpdateMode();
        mi.enterUpdateMode();
        new PartialModelUpdateFacility(mi, completeModelData, this).update();
        for (SModelReference mr : imports) {
          mi.addModelImport(new SModel.ImportElement(mr));
        }
        completeModelData.leaveUpdateMode();
        mi.leaveUpdateMode();
        setLoadingState(ModelLoadingState.FULLY_LOADED);
        myIsLoadInProgress = false;
      }
      fireModelStateChanged(oldState, getLoadingState());
    }
  }

  @Override
  @NotNull
  protected ModelLoadResult<SModel> createModel() {
    SModel model = new SModel(getReference(), new MigratingJavaStubRefsNodeIdMap());
    for (SLanguage l : getLanguagesToImport()) {
      model.addLanguage(l);
    }
    ASMModelLoader loader = new ASMModelLoader(getModule(), getSource().getPaths());
    loader.skipPrivateMembers(mySkipPrivate);
    loader.populateRoots(model);
    return new ModelLoadResult<SModel>(model, ModelLoadingState.INTERFACE_LOADED);
  }

  private Set<SLanguage> getLanguagesToImport() {
    return Collections.singleton(MetaAdapterFactory.getLanguage(0xf3061a5392264cc5L, 0xa443f952ceaf5816L, "jetbrains.mps.baseLanguage"));
  }

  @Override
  public Collection<SLanguage> importedLanguageIds() {
    return getLanguagesToImport();
  }

  @Override
  public List<SModuleReference> importedDevkits() {
    return Collections.emptyList();
  }

  @Override
  public void reloadFromDiskSafe() {
    SRepository repo = getRepository();
    if (repo == null) {
      // detached model, don't care to make it up-to-date 
      // XXX same code is in EitableSModelBase, could I refactor to avoid that? 
      return;
    }
    repo.getModelAccess().runWriteAction(new Runnable() {
      public void run() {
        if (getSource().getPaths().isEmpty()) {
          SModule module = getModule();
          if (module instanceof SModuleBase) {
            ((SModuleBase) module).unregisterModel(JavaClassStubModelDescriptor.this);
          }
          return;
        }
        reload();
        myTimestampTracker.updateTimestamp(getSource());
      }
    });
  }

  private void reload() {
    final SModel oldModel = getCurrentModelInternal();
    if (oldModel == null) {
      return;
    }
    // XXX shall I synchronize(myLoadLock) so that unload and subsequent partial load are from the same thread? I'm in the write anyway. 
    replace(createModel());
  }

  @Override
  public String toString() {
    return "JavaClassStubModelDescriptor " + getName();
  }
}