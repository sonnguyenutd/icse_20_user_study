package jetbrains.mps.debugger.core;

/*Generated by MPS */

import com.intellij.openapi.fileEditor.FileEditorManager;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import com.intellij.openapi.project.Project;
import jetbrains.mps.nodeEditor.highlighter.EditorComponentCreateListener;
import com.intellij.util.messages.MessageBusConnection;
import jetbrains.mps.smodel.CommandListenerAdapter;
import jetbrains.mps.ide.project.ProjectHelper;
import java.util.Collection;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.nodeEditor.EditorComponent;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.mps.openapi.module.SRepository;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.ide.editor.util.EditorComponentUtil;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.mps.openapi.model.SNodeReference;
import jetbrains.mps.openapi.navigation.NavigationSupport;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.nodeEditor.AdditionalPainter;

public abstract class CurrentLinePositionComponentEx<S> {
  private FileEditorManager myFileEditorManager;
  private final Map<S, CurrentLinePainter> mySessionToContextPainterMap = MapSequence.fromMap(new HashMap<S, CurrentLinePainter>());
  protected final Project myProject;
  private final EditorComponentCreateListener myEditorComponentCreationHandler = new CurrentLinePositionComponentEx.MyEditorComponentCreateListener();
  private MessageBusConnection myMessageBusConnection;
  private final CommandListenerAdapter myCommandListener = new CurrentLinePositionComponentEx.MyRepositoryListener();
  public CurrentLinePositionComponentEx(Project project, FileEditorManager fileEditorManager) {
    myProject = project;
    myFileEditorManager = fileEditorManager;
  }
  protected void init() {
    myMessageBusConnection = myProject.getMessageBus().connect();
    myMessageBusConnection.subscribe(EditorComponentCreateListener.EDITOR_COMPONENT_CREATION, myEditorComponentCreationHandler);
    ProjectHelper.getModelAccess(myProject).addCommandListener(myCommandListener);
  }
  protected void dispose() {
    ProjectHelper.getModelAccess(myProject).removeCommandListener(myCommandListener);
    myMessageBusConnection.disconnect();
  }
  protected abstract S getCurrentSession();
  protected abstract Collection<? extends S> getAllSessions();
  private List<CurrentLinePainter> getAllPainters() {
    synchronized (mySessionToContextPainterMap) {
      List<CurrentLinePainter> painters = ListSequence.fromList(new ArrayList<CurrentLinePainter>());
      ListSequence.fromList(painters).addSequence(Sequence.fromIterable(MapSequence.fromMap(mySessionToContextPainterMap).values()));
      return painters;
    }
  }

  /**
   * Expects EDT and model read access
   */
  /*package*/ void attach(@NotNull final CurrentLinePainter painter, @NotNull final EditorComponent editorComponent) {
    ApplicationManager.getApplication().assertIsDispatchThread();
    final SRepository repo = editorComponent.getEditorContext().getRepository();
    SNode node = (painter.getSNode() == null ? null : painter.getSNode().resolve(repo));
    if (node != null && EditorComponentUtil.isNodeShownInTheComponent(editorComponent, node)) {
      editorComponent.addAdditionalPainter(painter);
      editorComponent.repaintExternalComponent();
    }
  }

  /**
   * Expects EDT and model read access
   */
  /*package*/ void detach(@NotNull final CurrentLinePainter painter, @NotNull final EditorComponent editorComponent) {
    ApplicationManager.getApplication().assertIsDispatchThread();
    final SRepository repo = editorComponent.getEditorContext().getRepository();
    SNode node = (painter.getSNode() == null ? null : painter.getSNode().resolve(repo));
    if (node == null || EditorComponentUtil.isNodeShownInTheComponent(editorComponent, node)) {
      editorComponent.removeAdditionalPainter(painter);
      editorComponent.repaintExternalComponent();
    }
  }

  /**
   * 
   * @return Runnable to execute with model write access and inside EDT
   */
  @Nullable
  /*package*/ Runnable attachPainterRunnable(final S debugSession, final boolean focus) {
    SNodeReference node = getNode(debugSession);
    final CurrentLinePainter newPainter = (node == null ? null : new CurrentLinePainter(node));
    if (newPainter != null) {
      final boolean visible = getCurrentSession() == null || getCurrentSession() == debugSession;
      newPainter.setVisible(visible);
      //  we lock here, since we do not want to acquire read lock inside while having mySessionToContextPainterMap 
      synchronized (mySessionToContextPainterMap) {
        MapSequence.fromMap(mySessionToContextPainterMap).put(debugSession, newPainter);
        return new Runnable() {
          @Override
          public void run() {
            final jetbrains.mps.project.Project mpsProject = ProjectHelper.fromIdeaProject(myProject);
            mpsProject.getModelAccess().checkWriteAccess();
            SNode node = (newPainter.getSNode() == null ? null : newPainter.getSNode().resolve(mpsProject.getRepository()));
            if (node != null) {
              if (visible && focus) {
                jetbrains.mps.openapi.editor.EditorComponent currentEditorComponent = NavigationSupport.getInstance().openNode(mpsProject, node, true, false).getCurrentEditorComponent();
                currentEditorComponent = EditorComponentUtil.scrollToNode(node, currentEditorComponent);
                if (currentEditorComponent instanceof EditorComponent) {
                  attach(newPainter, (EditorComponent) currentEditorComponent);
                }
              }

              List<EditorComponent> components = EditorComponentUtil.findComponentForNode(node, myFileEditorManager);
              for (EditorComponent component : ListSequence.fromList(components)) {
                attach(newPainter, component);
              }
            }
          }
        };
      }
    }
    return null;
  }

  @Nullable
  protected abstract SNodeReference getNode(S session);

  /**
   * 
   * @return Runnable to execute with model read and inside EDT
   */
  @Nullable
  /*package*/ Runnable detachPainterRunnable(S session) {
    final CurrentLinePainter painter;
    synchronized (mySessionToContextPainterMap) {
      painter = MapSequence.fromMap(mySessionToContextPainterMap).get(session);
      MapSequence.fromMap(mySessionToContextPainterMap).removeKey(session);
    }
    if (painter != null) {
      return new Runnable() {
        @Override
        public void run() {
          for (EditorComponent editor : EditorComponentUtil.getAllEditorComponents(myFileEditorManager, true)) {
            detach(painter, editor);
          }
        }
      };
    }
    return null;
  }
  protected void detachPainter(S session) {
    Runnable detachPainterRunnable = detachPainterRunnable(session);
    if (detachPainterRunnable == null) {
      return;
    }
    ProjectHelper.getModelAccess(myProject).runReadInEDT(detachPainterRunnable);
  }

  protected void reAttachPainter(S session, boolean focus) {
    final Runnable detachSession = detachPainterRunnable(session);
    final Runnable attachSession = attachPainterRunnable(session, focus);
    if (detachSession != null || attachSession != null) {
      ProjectHelper.getModelAccess(myProject).runWriteInEDT(new Runnable() {
        @Override
        public void run() {
          if (detachSession != null) {
            detachSession.run();
          }
          if (attachSession != null) {
            attachSession.run();
          }
        }
      });
    }
  }
  protected void currentSessionChanged(S newSession) {
    synchronized (mySessionToContextPainterMap) {
      for (S session : SetSequence.fromSet(MapSequence.fromMap(mySessionToContextPainterMap).keySet())) {
        CurrentLinePainter painter = MapSequence.fromMap(mySessionToContextPainterMap).get(session);
        if (painter != null) {
          painter.setVisible(newSession != null && newSession == session);
        }
      }
    }
    ApplicationManager.getApplication().invokeLater(new Runnable() {
      @Override
      public void run() {
        for (EditorComponent editorComponent : EditorComponentUtil.getAllEditorComponents(myFileEditorManager, true)) {
          editorComponent.repaintExternalComponent();
        }
      }
    });
  }
  private class MyEditorComponentCreateListener implements EditorComponentCreateListener {
    private MyEditorComponentCreateListener() {
    }
    @Override
    public void editorComponentCreated(@NotNull EditorComponent editorComponent) {
      for (CurrentLinePainter p : ListSequence.fromList(getAllPainters())) {
        attach(p, editorComponent);
      }
    }
    @Override
    public void editorComponentDisposed(@NotNull EditorComponent editorComponent) {
      List<AdditionalPainter> additionalPainters = editorComponent.getAdditionalPainters();
      for (AdditionalPainter painter : ListSequence.fromList(additionalPainters)) {
        if (painter instanceof CurrentLinePainter) {
          editorComponent.removeAdditionalPainter(painter);
        }
      }
    }
  }

  /**
   * It used to be SRepositoryListener with commandFinished that has NOT been invoked
   * for couple of releases with no apparent defect (commandFinished of SRepositoryListener was deprecated and not invoked)
   * so I wonder if there's a reason to keep it?
   */
  private class MyRepositoryListener extends CommandListenerAdapter {
    @Override
    public void commandFinished() {
      for (S session : getAllSessions()) {
        reAttachPainter(session, false);
      }
    }
  }
}