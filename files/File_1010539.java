package jetbrains.mps.project.persistence;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;
import org.jdom.Element;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.project.ModuleId;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import org.jetbrains.mps.openapi.persistence.PersistenceFacade;
import org.jetbrains.mps.openapi.model.SModelReference;
import org.jetbrains.mps.openapi.module.SModuleReference;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class DevkitDescriptorPersistence {
  public DevkitDescriptorPersistence() {
  }

  @NotNull
  public DevkitDescriptor load(@NotNull final Element root) throws ModuleReadException {
    try {
      DevkitDescriptor descriptor = new _FunctionTypes._return_P0_E0<DevkitDescriptor>() {
        public DevkitDescriptor invoke() {
          final DevkitDescriptor result_raojav_a0a0a0a0c = new DevkitDescriptor();
          final String result_raojav_a0a0a0a0a0c = root.getAttributeValue("name");
          result_raojav_a0a0a0a0c.setNamespace(result_raojav_a0a0a0a0a0c);
          String uuid = root.getAttributeValue("uuid");
          if (uuid != null) {
            final ModuleId result_raojav_a0a2a0a0a0a0c = ModuleId.fromString(uuid);
            result_raojav_a0a0a0a0c.setId(result_raojav_a0a2a0a0a0a0c);
          }
          for (Element exportedLang : ListSequence.fromList((List<Element>) root.getChildren("exported-language"))) {
            result_raojav_a0a0a0a0c.getExportedLanguages().add(PersistenceFacade.getInstance().createModuleReference(exportedLang.getAttributeValue("name")));
          }

          Element extendedDevKits = ListSequence.fromList(((List<Element>) root.getChildren("extendedDevKits"))).first();
          if (extendedDevKits != null) {
            for (Element xde : ListSequence.fromList((List<Element>) extendedDevKits.getChildren("extendedDevKit"))) {
              result_raojav_a0a0a0a0c.getExtendedDevkits().add(PersistenceFacade.getInstance().createModuleReference(xde.getText()));
            }
          }

          Element exportedSolutions = ListSequence.fromList(((List<Element>) root.getChildren("exported-solutions"))).first();
          if (exportedSolutions != null) {
            for (Element xse : ListSequence.fromList((List<Element>) exportedSolutions.getChildren("exported-solution"))) {
              result_raojav_a0a0a0a0c.getExportedSolutions().add(PersistenceFacade.getInstance().createModuleReference(xse.getText()));
            }
          }
          Element genPlanElement;
          if ((genPlanElement = root.getChild("generation-plan")) != null) {
            final SModelReference result_raojav_a0a11a0a0a0a0c = PersistenceFacade.getInstance().createModelReference(genPlanElement.getAttributeValue("model"));
            result_raojav_a0a0a0a0c.setAssociatedPlan(result_raojav_a0a11a0a0a0a0c);
          }
          return result_raojav_a0a0a0a0c;
        }
      }.invoke();
      return descriptor;
    } catch (Exception e) {
      throw new ModuleReadException(e);
    }
  }

  @NotNull
  public Element save(@NotNull final DevkitDescriptor descriptor) {
    Element root = new _FunctionTypes._return_P0_E0<Element>() {
      public Element invoke() {
        final Element result_raojav_a0a0a0e = new Element("dev-kit");
        result_raojav_a0a0a0e.setAttribute("name", descriptor.getNamespace());
        if (descriptor.getId() != null) {
          result_raojav_a0a0a0e.setAttribute("uuid", descriptor.getId().toString());
        }

        for (final SModuleReference lang : SetSequence.fromSet(descriptor.getExportedLanguages())) {
          result_raojav_a0a0a0e.addContent(new _FunctionTypes._return_P0_E0<Element>() {
            public Element invoke() {
              final Element result_raojav_a0a0a0a3a0a0a0e = new Element("exported-language");
              result_raojav_a0a0a0a3a0a0a0e.setAttribute("name", lang.toString());
              return result_raojav_a0a0a0a3a0a0a0e;
            }
          }.invoke());
        }

        if (!(descriptor.getExtendedDevkits().isEmpty())) {
          result_raojav_a0a0a0e.addContent(new _FunctionTypes._return_P0_E0<Element>() {
            public Element invoke() {
              final Element result_raojav_a0a0a0a5a0a0a0e = new Element("extendedDevKits");
              for (final SModuleReference ref : SetSequence.fromSet(descriptor.getExtendedDevkits())) {
                result_raojav_a0a0a0a5a0a0a0e.addContent(new _FunctionTypes._return_P0_E0<Element>() {
                  public Element invoke() {
                    final Element result_raojav_a0a0a0a0a0a0a0a5a0a0a0e = new Element("extendedDevKit");
                    result_raojav_a0a0a0a0a0a0a0a5a0a0a0e.setText(ref.toString());
                    return result_raojav_a0a0a0a0a0a0a0a5a0a0a0e;
                  }
                }.invoke());
              }
              return result_raojav_a0a0a0a5a0a0a0e;
            }
          }.invoke());
        }

        if (!(descriptor.getExportedSolutions().isEmpty())) {
          result_raojav_a0a0a0e.addContent(new _FunctionTypes._return_P0_E0<Element>() {
            public Element invoke() {
              final Element result_raojav_a0a0a0a7a0a0a0e = new Element("exported-solutions");
              for (final SModuleReference ref : SetSequence.fromSet(descriptor.getExportedSolutions())) {
                result_raojav_a0a0a0a7a0a0a0e.addContent(new _FunctionTypes._return_P0_E0<Element>() {
                  public Element invoke() {
                    final Element result_raojav_a0a0a0a0a0a0a0a7a0a0a0e = new Element("exported-solution");
                    result_raojav_a0a0a0a0a0a0a0a7a0a0a0e.setText(ref.toString());
                    return result_raojav_a0a0a0a0a0a0a0a7a0a0a0e;
                  }
                }.invoke());
              }
              return result_raojav_a0a0a0a7a0a0a0e;
            }
          }.invoke());
        }

        if (descriptor.getAssociatedGenPlan() != null) {
          Element genPlanElement = new Element("generation-plan");
          genPlanElement.setAttribute("model", PersistenceFacade.getInstance().asString(descriptor.getAssociatedGenPlan()));
          result_raojav_a0a0a0e.addContent(genPlanElement);
        }

        return result_raojav_a0a0a0e;
      }
    }.invoke();
    return root;
  }
}