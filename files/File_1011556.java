package jetbrains.mps.debugger.java.runtime.ui.evaluation;

/*Generated by MPS */

import jetbrains.mps.ide.ui.tree.MPSTree;
import com.intellij.openapi.actionSystem.DataProvider;
import com.sun.jdi.ThreadReference;
import java.util.Map;
import jetbrains.mps.debugger.java.runtime.evaluation.container.IEvaluationContainer;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.debugger.java.runtime.state.DebugSession;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.actionSystem.ActionGroup;
import jetbrains.mps.debugger.java.api.state.proxy.JavaValue;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.ui.tree.MPSTreeNode;
import jetbrains.mps.ide.ui.tree.TextTreeNode;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.List;
import javax.swing.tree.TreePath;
import jetbrains.mps.debugger.api.ui.tree.PlaceholderTreeNode;
import java.util.ArrayList;
import jetbrains.mps.smodel.ModelReadRunnable;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.Separator;
import jetbrains.mps.workbench.action.BaseGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import org.jetbrains.annotations.NonNls;
import jetbrains.mps.debugger.api.ui.tree.VariablesTree;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import java.io.StringWriter;
import java.io.PrintWriter;
import jetbrains.mps.debugger.java.api.state.watchables.CalculatedWatchable;
import jetbrains.mps.debugger.api.ui.tree.WatchableNode;
import jetbrains.mps.debug.api.programState.IWatchable;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.awt.Color;
import jetbrains.mps.ide.messages.Icons;

/*package*/ class EvaluationTree extends MPSTree implements DataProvider {
  private ThreadReference myThreadReference;
  private Map<IEvaluationContainer, EvaluationTree.EvaluationState> myStates = MapSequence.fromMap(new HashMap<IEvaluationContainer, EvaluationTree.EvaluationState>());
  private final DebugSession myDebugSession;
  @Nullable
  private ActionGroup myActionGroup = null;
  public EvaluationTree(DebugSession session) {
    super();
    myDebugSession = session;
    setRootVisible(false);
    setShowsRootHandles(true);
    rebuildNow();
  }

  public void updateLocation(ThreadReference threadReference) {
    myThreadReference = threadReference;
  }
  /*package*/ void addModel(IEvaluationContainer model) {
    synchronized (myStates) {
      MapSequence.fromMap(myStates).put(model, new EvaluationTree.InitializedState());
    }
  }
  /*package*/ void removeModel(IEvaluationContainer model) {
    synchronized (myStates) {
      MapSequence.fromMap(myStates).removeKey(model);
    }
  }
  /*package*/ void setResultValue(JavaValue value, IEvaluationContainer model) {
    synchronized (myStates) {
      MapSequence.fromMap(myStates).put(model, new EvaluationTree.ResultState(model.getPresentation(), value, myThreadReference));
    }
  }
  /*package*/ void setError(@NotNull String text, IEvaluationContainer model) {
    synchronized (myStates) {
      MapSequence.fromMap(myStates).put(model, new EvaluationTree.FailureState(text));
    }
  }
  /*package*/ void setError(@NotNull Throwable error, IEvaluationContainer model) {
    synchronized (myStates) {
      MapSequence.fromMap(myStates).put(model, new EvaluationTree.FailureState(error));
    }
  }
  /*package*/ void setEvaluating(IEvaluationContainer model) {
    synchronized (myStates) {
      MapSequence.fromMap(myStates).put(model, new EvaluationTree.EvaluationInProgressState());
    }
  }
  @Override
  protected MPSTreeNode rebuild() {
    MPSTreeNode rootTreeNode = new TextTreeNode("Evaluation Result");
    synchronized (myStates) {
      for (IEvaluationContainer model : SetSequence.fromSet(MapSequence.fromMap(myStates).keySet())) {
        MapSequence.fromMap(myStates).get(model).rebuild(rootTreeNode, model);
      }
    }
    return rootTreeNode;
  }

  @Override
  protected void expandPaths(List<String> paths) {
    for (String path : paths) {
      TreePath treePath = PlaceholderTreeNode.stringToPathWithPlaceholders(getRootNode(), path);
      expandPath(treePath);
    }
  }

  @Override
  protected void selectPaths(List<String> paths) {
    List<TreePath> treePaths = new ArrayList<TreePath>();
    for (String path : paths) {
      TreePath treePath = PlaceholderTreeNode.stringToPathWithPlaceholders(getRootNode(), path);
      treePaths.add(treePath);
    }
    setSelectionPaths(treePaths.toArray(new TreePath[treePaths.size()]));
  }

  @Override
  public void runRebuildAction(Runnable rebuildAction, boolean saveExpansion) {
    super.runRebuildAction(new ModelReadRunnable(myDebugSession.getProject().getModelAccess(), rebuildAction), saveExpansion);
  }

  @Override
  protected ActionGroup createPopupActionGroup(MPSTreeNode node) {
    DefaultActionGroup group = new DefaultActionGroup();
    if (myActionGroup != null) {
      group.add(myActionGroup);
      group.add(new Separator());
    }
    group.add(((BaseGroup) ActionManager.getInstance().getAction("jetbrains.mps.debugger.api.ui.actions.AbstractWatchableNodeActions_ActionGroup")));
    return group;
  }
  @Override
  public void dispose() {
    synchronized (myStates) {
      MapSequence.fromMap(myStates).clear();
    }
    this.clear();
    super.dispose();
  }
  @Nullable
  private MPSTreeNode findSelectedNode() {
    TreePath path = getSelectionPath();
    if (path != null) {
      Object component = path.getLastPathComponent();
      if (component instanceof MPSTreeNode) {
        return (MPSTreeNode) component;
      }
    }
    return null;
  }
  @Nullable
  @Override
  public Object getData(@NonNls String dataId) {
    if (dataId.equals(EvaluationUi.EVALUATION_CONTAINER.getName())) {
      MPSTreeNode node = findSelectedNode();
      if (node != null && node instanceof EvaluationTree.EvaluationModelNode) {
        return ((EvaluationTree.EvaluationModelNode) node).getModel();
      }
    } else if (dataId.equals(EvaluationUi.DEBUG_SESSION.getName())) {
      return myDebugSession;
    } else if (dataId.equals(VariablesTree.MPS_DEBUGGER_VALUE.getName())) {
      MPSTreeNode node = findSelectedNode();
      if (node != null && node instanceof EvaluationTree.ResultState.MyWatchableNode) {
        return ((EvaluationTree.ResultState.MyWatchableNode) node).getValue();
      }
    } else if (dataId.equals(MPSCommonDataKeys.EXCEPTION.getName())) {
      MPSTreeNode node = findSelectedNode();
      if (node != null && node instanceof EvaluationTree.ErrorTreeNode) {
        return ((EvaluationTree.ErrorTreeNode) node).getThrowable();
      }
    }
    return null;
  }
  public void setActionGroup(ActionGroup group) {
    myActionGroup = group;
  }
  public static String[] getStackTrace(Throwable t) {
    StringWriter writer = new StringWriter();
    t.printStackTrace(new PrintWriter(writer));
    return writer.toString().split("\n");
  }
  private static abstract class EvaluationState {
    public EvaluationState() {
    }
    public abstract void rebuild(MPSTreeNode rootTreeNode, IEvaluationContainer model);
  }
  public interface EvaluationModelNode {
    IEvaluationContainer getModel();
  }
  private static class InitializedState extends EvaluationTree.EvaluationState {
    public InitializedState() {
    }
    @Override
    public void rebuild(MPSTreeNode rootTreeNode, IEvaluationContainer model) {
      rootTreeNode.add(new EvaluationTree.InitialTreeNode(model));
      // todo? 
    }
  }
  private static class EvaluationInProgressState extends EvaluationTree.EvaluationState {
    public EvaluationInProgressState() {
    }
    @Override
    public void rebuild(MPSTreeNode rootTreeNode, IEvaluationContainer model) {
      rootTreeNode.add(new EvaluationTree.EvaluatingTreeNode(model));
    }
  }
  private class ResultState extends EvaluationTree.EvaluationState {
    @NotNull
    private final JavaValue myValue;
    private final ThreadReference myThreadReference;
    private final String myPresentation;
    private CalculatedWatchable myCachedWatchable;
    public ResultState(String presentation, JavaValue value, ThreadReference threadReference) {
      myPresentation = presentation;
      myValue = value;
      myThreadReference = threadReference;
    }
    @Override
    public void rebuild(MPSTreeNode rootTreeNode, IEvaluationContainer model) {
      final boolean canEvalaute = myDebugSession.getEvaluationProvider().canEvaluate();
      if (canEvalaute) {
        myCachedWatchable = new CalculatedWatchable(myPresentation, myValue, myThreadReference);
      }
      if (myCachedWatchable != null) {
        WatchableNode watchableNode = new EvaluationTree.ResultState.MyWatchableNode(model, myCachedWatchable) {
          @Override
          public boolean isLeaf() {
            if (canEvalaute) {
              return super.isLeaf();
            }
            return true;
          }
        };
        rootTreeNode.add(watchableNode);
      } else {
        rootTreeNode.add(new EvaluationTree.InitialTreeNode(model));
      }
    }
    private class MyWatchableNode extends WatchableNode implements EvaluationTree.EvaluationModelNode {
      private final IEvaluationContainer myModel;
      public MyWatchableNode(IEvaluationContainer model, @NotNull IWatchable watchable) {
        super(watchable, myDebugSession.getUiState());
        myModel = model;
      }
      @Override
      public IEvaluationContainer getModel() {
        return myModel;
      }
    }
  }
  private class FailureState extends EvaluationTree.EvaluationState {
    @Nullable
    private String myErrorText;
    private Throwable myError;
    public FailureState(String errorText) {
      myErrorText = errorText;
    }
    private FailureState(Throwable error) {
      myError = error;
    }
    @Override
    public void rebuild(MPSTreeNode rootTreeNode, IEvaluationContainer model) {
      if (myError != null) {
        rootTreeNode.add(new EvaluationTree.ErrorTreeNode(model, myError));
      } else {
        rootTreeNode.add(new EvaluationTree.ErrorTreeNode(model, myErrorText));
      }
    }
  }
  private class ErrorTreeNode extends TextTreeNode implements EvaluationTree.EvaluationModelNode {
    private final List<String> myExtendedMessage = ListSequence.fromList(new ArrayList<String>());
    private final IEvaluationContainer myModel;
    private Throwable myThrowable;
    public ErrorTreeNode(IEvaluationContainer model, @NotNull String text, String... extendedMessage) {
      super(model.getPresentation() + " = " + text);
      myModel = model;
      if (extendedMessage != null && extendedMessage.length > 0) {
        for (int i = 0; i < extendedMessage.length; i++) {
          ListSequence.fromList(myExtendedMessage).addElement(extendedMessage[i]);
        }
      }
      setColor(Color.RED);
      setIcon(Icons.ERROR_ICON);

      doInit();
    }
    public ErrorTreeNode(IEvaluationContainer model, Throwable t) {
      this(model, (t.getMessage() == null ? t.toString() : t.getMessage()), EvaluationTree.getStackTrace(t));
      myThrowable = t;
    }
    @Override
    public boolean isLeaf() {
      return ListSequence.fromList(myExtendedMessage).isEmpty();
    }
    @Override
    protected void doInit() {
      for (String messagePart : myExtendedMessage) {
        TextTreeNode node = new TextTreeNode(messagePart);
        node.setIcon(Icons.ERROR_ICON);
        add(node);
      }
    }
    @Override
    public IEvaluationContainer getModel() {
      return myModel;
    }
    public Throwable getThrowable() {
      return myThrowable;
    }
  }
  private static class EvaluatingTreeNode extends TextTreeNode implements EvaluationTree.EvaluationModelNode {
    private final IEvaluationContainer myModel;
    public EvaluatingTreeNode(IEvaluationContainer model) {
      super(model.getPresentation() + " = " + "evaluating...");
      myModel = model;
      setColor(Color.GRAY);
      setIcon(Icons.INFORMATION_ICON);
    }
    @Override
    public IEvaluationContainer getModel() {
      return myModel;
    }
  }
  private static class InitialTreeNode extends TextTreeNode {
    public InitialTreeNode(IEvaluationContainer model) {
      super(model.getPresentation() + " = ");
      setIcon(jetbrains.mps.debugger.java.api.ui.Icons.WATCH);
    }
  }
}