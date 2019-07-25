package jetbrains.mps.nodeEditor.cells.jetpad;

/*Generated by MPS */

import jetbrains.jetpad.model.property.Property;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.jetpad.model.event.EventHandler;
import jetbrains.jetpad.model.property.PropertyChangeEvent;
import jetbrains.mps.nodeEditor.cells.ChangePropertyEditorCommand;

public abstract class WritableModelProperty<T> extends ReadableModelProperty<T> implements Property<T> {
  private final String myCommandId;

  public WritableModelProperty(String commandId, EditorContext context) {
    super(context);
    myCommandId = commandId;
  }

  @Override
  public WritableModelProperty init() {
    super.init();
    addHandler(new EventHandler<PropertyChangeEvent<T>>() {
      public void onEvent(PropertyChangeEvent<T> event) {
        safeSetModelPropertyValue(event.getNewValue());
      }
    });
    return this;
  }

  protected void safeSetModelPropertyValue(final T t) {
    myEditorContext.getRepository().getModelAccess().executeCommand(new ChangePropertyEditorCommand(myEditorContext, myCommandId) {
      protected void doExecute() {
        setModelPropertyValue(t);
      }
    });
  }
  protected abstract void setModelPropertyValue(T value);
}