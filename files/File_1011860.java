package ref.migration;

/*Generated by MPS */

import jetbrains.mps.lang.migration.runtime.base.MigrationScriptBase;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.module.SModule;
import org.jetbrains.mps.openapi.module.SearchScope;
import jetbrains.mps.scope.ConditionalScope;
import jetbrains.mps.ide.findusages.model.scopes.ModulesScope;
import org.jetbrains.mps.util.Condition;
import org.jetbrains.mps.openapi.model.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModuleOperations;
import jetbrains.mps.lang.smodel.query.runtime.CommandUtil;
import jetbrains.mps.project.EditableFilteringScope;
import jetbrains.mps.lang.smodel.query.runtime.QueryExecutionContext;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import org.jetbrains.mps.openapi.model.SReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.migration.runtime.base.Problem;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.migration.runtime.base.NotMigratedNode;
import jetbrains.mps.lang.migration.runtime.base.MigrationScriptReference;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Objects;

public class SampleRefMigration extends MigrationScriptBase {
  public String getCaption() {
    return "migrate the references using smodel API";
  }
  @Override
  public boolean isRerunnable() {
    return false;
  }
  public SNode execute(final SModule m) {
    doExecute(m);
    return null;
  }
  public void doExecute(final SModule m) {
    // migrate everything except migration aspects 
    SearchScope searchScope = new ConditionalScope(new ModulesScope(m), null, new Condition<SModel>() {
      public boolean met(SModel it) {
        return !(SModuleOperations.isAspect(it, "migration"));
      }
    });

    {
      SearchScope scope_u457zm_d0d = CommandUtil.createScope(searchScope);
      final SearchScope scope_u457zm_d0d_0 = new EditableFilteringScope(scope_u457zm_d0d);
      QueryExecutionContext context = new QueryExecutionContext() {
        public SearchScope getDefaultSearchScope() {
          return scope_u457zm_d0d_0;
        }
      };

      // get all old references in all models of this module 
      List<SNode> references = CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0xd3d2b6e3a4b343d5L, 0xbb29420d39fa86abL, 0x6aff2c104931574dL, "ref.structure.OldComponentRef"), true)).toListSequence();

      // cache for reading data annotations 
      final Map<SModule, Map<String, String>> idMaps = MapSequence.fromMap(new HashMap<SModule, Map<String, String>>());

      // for each found old reference 
      ListSequence.fromList(references).visitAll(new IVisitor<SNode>() {
        public void visit(SNode oldNode) {
          // create a new one, leave the reference target empty 
          SNode newNode = SConceptOperations.createNewNode(MetaAdapterFactory.getConcept(0xd3d2b6e3a4b343d5L, 0xbb29420d39fa86abL, 0x6aff2c104932a6c9L, "ref.structure.NewComponentRef"));

          // find the target of the old reference and its containing model 
          SReference oldRef = oldNode.getReference(MetaAdapterFactory.getReferenceLink(0xd3d2b6e3a4b343d5L, 0xbb29420d39fa86abL, 0x6aff2c104931574dL, 0x6aff2c104932a69aL, "target"));
          SModel targetModel = oldRef.getTargetSModelReference().resolve(m.getRepository());
          SModule targetModule = targetModel.getModule();

          // get the id of the component that the old component has been migrated into 
          if (MapSequence.fromMap(idMaps).get(targetModule) == null) {
            Map<String, String> idMap = MapSequence.fromMap(new HashMap<String, String>());
            for (SNode dataAnnotation : ListSequence.fromList(getDeclData(targetModule))) {
              MapSequence.fromMap(idMap).put(SPropertyOperations.getString(dataAnnotation, MetaAdapterFactory.getProperty(0x9de7c5ceea6f4fb4L, 0xa7ba45e62b53cbadL, 0x2274019e61e234c9L, 0x3abe707a89857bdeL, "oldId")), SPropertyOperations.getString(dataAnnotation, MetaAdapterFactory.getProperty(0x9de7c5ceea6f4fb4L, 0xa7ba45e62b53cbadL, 0x2274019e61e234c9L, 0x3abe707a89857bdfL, "newId")));
            }
            MapSequence.fromMap(idMaps).put(targetModule, idMap);
          }
          String newId = MapSequence.fromMap(MapSequence.fromMap(idMaps).get(targetModule)).get(oldRef.getTargetNodeId().toString());
          if (newId == null) {
            return;
          }

          // get the new component instance 
          SNode newTarget = targetModel.getNode(PersistenceFacade.getInstance().createNodeId(newId));

          // set the reference to point to it 
          SLinkOperations.setTarget(newNode, MetaAdapterFactory.getReferenceLink(0xd3d2b6e3a4b343d5L, 0xbb29420d39fa86abL, 0x6aff2c104932a6c9L, 0x6aff2c104932a6caL, "target"), (SNode) newTarget);

          // replace the old reference in the model with the newly created one 
          SNodeOperations.replaceWithAnother(oldNode, newNode);
        }
      });
    }
  }
  @Override
  public Iterable<Problem> check(SModule m) {
    {
      SearchScope scope_u457zm_a0e = CommandUtil.createScope(m);
      final SearchScope scope_u457zm_a0e_0 = new EditableFilteringScope(scope_u457zm_a0e);
      QueryExecutionContext context = new QueryExecutionContext() {
        public SearchScope getDefaultSearchScope() {
          return scope_u457zm_a0e_0;
        }
      };
      return CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0xd3d2b6e3a4b343d5L, 0xbb29420d39fa86abL, 0x6aff2c104931574dL, "ref.structure.OldComponentRef"), false)).select(new ISelector<SNode, NotMigratedNode>() {
        public NotMigratedNode select(SNode it) {
          return new NotMigratedNode(it) {
            public String getMessage() {
              return "old references should be replaced by a new one";
            }
          };
        }
      });
    }
  }
  public Iterable<MigrationScriptReference> requiresData() {
    return ListSequence.fromListAndArray(new ArrayList<MigrationScriptReference>(), new MigrationScriptReference(MetaAdapterFactory.getLanguage(0x9de7c5ceea6f4fb4L, 0xa7ba45e62b53cbadL, "decl"), 1));
  }
  public List<SNode> getDeclData(SModule m) {
    {
      SearchScope scope_u457zm_a0g = CommandUtil.createScope(m);
      final SearchScope scope_u457zm_a0g_0 = scope_u457zm_a0g;
      QueryExecutionContext context = new QueryExecutionContext() {
        public SearchScope getDefaultSearchScope() {
          return scope_u457zm_a0g_0;
        }
      };
      return CollectionSequence.fromCollection(CommandUtil.instances(CommandUtil.selectScope(null, context), MetaAdapterFactory.getConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x78c7e79625990591L, "jetbrains.mps.lang.core.structure.MigrationDataAnnotation"), false)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return Objects.equals(MigrationScriptReference.deserialize(SPropertyOperations.getString(it, MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x78c7e79625a38e13L, 0x78c7e79625a38e14L, "createdByScript"))), new MigrationScriptReference(MetaAdapterFactory.getLanguage(0x9de7c5ceea6f4fb4L, 0xa7ba45e62b53cbadL, "decl"), 1));
        }
      }).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, MetaAdapterFactory.getContainmentLink(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x78c7e79625990591L, 0x5e7aa366c292fcceL, "dataNode"));
        }
      }).toListSequence();
    }
  }
  public MigrationScriptReference getDescriptor() {
    return new MigrationScriptReference(MetaAdapterFactory.getLanguage(0xd3d2b6e3a4b343d5L, 0xbb29420d39fa86abL, "ref"), 1);
  }



}
