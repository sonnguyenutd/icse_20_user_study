package jetbrains.mps.execution.lib.ui;

/*Generated by MPS */

import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBList;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.ide.project.ProjectHelper;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.ui.components.JBLabel;
import jetbrains.mps.ide.common.LayoutUtil;
import org.jetbrains.mps.openapi.model.SNode;
import org.jetbrains.mps.openapi.model.SNodeReference;
import org.jetbrains.mps.openapi.util.ProgressMonitor;
import com.intellij.openapi.progress.ProgressManager;
import jetbrains.mps.progress.ProgressMonitorAdapter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.ide.platform.dialogs.choosers.NodeChooserDialog;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;

/**
 * This class was split up without thinking, just to make something work quickly.
 * TODO: refactor
 */
public abstract class ListPanel<T> extends JBPanel {
  private final Object myLock = new Object();
  private final JBList myListComponent;
  protected final List<T> myValues = ListSequence.fromList(new ArrayList<T>());
  protected final List<T> myCandidates = ListSequence.fromList(new ArrayList<T>());
  private ActionListener myListener;
  private final ListPanel.MyAbstractListModel myListModel;
  protected Project myProject;
  @Nullable
  private final MPSProject myMpsProject;
  private final String myTitle;
  private boolean isEditable = true;

  public ListPanel(Project p, String title) {
    myProject = p;
    myMpsProject = ProjectHelper.fromIdeaProject(p);
    myTitle = title;

    setLayout(new GridBagLayout());
    JBPanel mainPanel = new JBPanel(new BorderLayout());

    myListModel = new ListPanel.MyAbstractListModel();
    myListComponent = new JBList(myListModel);
    JScrollPane scrolledListComponent = ScrollPaneFactory.createScrollPane(myListComponent);
    scrolledListComponent.doLayout();
    mainPanel.add(scrolledListComponent, BorderLayout.CENTER);

    AnAction add = new ListPanel.MyListAddAction(myListComponent);
    AnAction remove = new ListPanel.MyListRemoveAction(this.myListComponent);
    DefaultActionGroup group = ActionUtils.groupFromActions(add, remove);
    ActionToolbar toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.RUN_CONFIGURATIONS_COMBOBOX, group, false);
    mainPanel.add(toolbar.getComponent(), BorderLayout.EAST);

    this.add(new JBLabel(myTitle + ":"), LayoutUtil.createLabelConstraints(0));
    this.add(mainPanel, LayoutUtil.createPanelConstraints(1));
  }

  protected abstract T wrap(SNode node);

  protected abstract SNodeReference unwrap(T element);

  protected abstract String getFqName(T element);

  protected abstract List<T> collectCandidates(ProgressMonitor progress);

  public void addItem(T item) {
    ListSequence.fromList(myValues).addElement(item);
    myListComponent.updateUI();
  }

  public void addActionListener(ActionListener listener) {
    myListener = listener;
  }

  public List<T> getItems() {
    return myValues;
  }

  public void clear() {
    ListSequence.fromList(myValues).clear();
    myListComponent.updateUI();
  }

  public void setData(List<? extends T> data) {
    ListSequence.fromList(myValues).clear();
    ListSequence.fromList(myValues).addSequence(ListSequence.fromList(data));
    myListComponent.updateUI();
  }

  private List<SNodeReference> getCandidates() {
    boolean needsUpdate;
    synchronized (myLock) {
      needsUpdate = ListSequence.fromList(this.myCandidates).isEmpty();
    }

    if (needsUpdate) {
      ProgressManager.getInstance().runProcessWithProgressSynchronously(new Runnable() {
        @Override
        public void run() {
          List<T> candidates = collectCandidates(new ProgressMonitorAdapter(ProgressManager.getInstance().getProgressIndicator()));
          synchronized (myLock) {
            ListSequence.fromList(myCandidates).clear();
            ListSequence.fromList(myCandidates).addSequence(ListSequence.fromList(candidates));
          }
        }
      }, "Searching for nodes", false, myProject);
    }

    synchronized (myLock) {
      ListSequence.fromList(this.myCandidates).removeSequence(ListSequence.fromList(this.myValues));
      return ListSequence.fromList(this.myCandidates).select(new ISelector<T, SNodeReference>() {
        public SNodeReference select(T it) {
          return unwrap(it);
        }
      }).toListSequence();
    }
  }

  public void setEditable(boolean editable) {
    isEditable = editable;
  }

  public NodeChooserDialog createNodeChooserDialog(List<SNodeReference> nodesList) {
    return new NodeChooserDialog(myProject, nodesList);
  }

  private class MyAbstractListModel extends AbstractListModel {
    public MyAbstractListModel() {
    }

    @Override
    public Object getElementAt(int p0) {
      return getFqName(ListSequence.fromList(ListPanel.this.myValues).getElement(p0));
    }

    @Override
    public int getSize() {
      return ListSequence.fromList(ListPanel.this.myValues).count();
    }

    public void fireSomethingChanged() {
      fireContentsChanged(this, 0, ListSequence.fromList(myValues).count());
    }
  }

  private class MyListAddAction extends AnAction {
    private final JList myList;

    public MyListAddAction(JList list) {
      super("Add", "Add", AllIcons.General.Add);
      myList = list;
    }


    @Override
    public void actionPerformed(AnActionEvent event) {
      if (myMpsProject == null) {
        return;
      }
      List<SNodeReference> nodesList = getCandidates();

      NodeChooserDialog chooserDialog = ListPanel.this.createNodeChooserDialog(nodesList);
      chooserDialog.show();
      final SNodeReference resultNode = chooserDialog.getResult();

      // FIXME please refactor this, please, please!!! 
      if (resultNode == null) {
        return;
      }
      final Wrappers._T<T> wrapper = new Wrappers._T<T>();
      myMpsProject.getModelAccess().runReadAction(new Runnable() {
        public void run() {
          wrapper.value = wrap(resultNode.resolve(myMpsProject.getRepository()));
        }
      });
      if (wrapper.value == null) {
        return;
      }
      ListSequence.fromList(ListPanel.this.myValues).addElement(wrapper.value);
      if (ListPanel.this.myListener != null) {
        ListPanel.this.myListener.actionPerformed(null);
      }
      ListPanel.this.myListComponent.updateUI();
      ListPanel.this.myListModel.fireSomethingChanged();
      // return value used to be an index to select (though, in a bit cryptic manner, see BaseAddAction) 
      myList.setSelectedIndex(ListSequence.fromList(ListPanel.this.myValues).indexOf(wrapper.value));
    }

    @Override
    public void update(AnActionEvent event) {
      super.update(event);
      event.getPresentation().setEnabled(isEditable && myMpsProject != null);
    }
  }

  private class MyListRemoveAction extends AnAction {
    private final JList myList;

    public MyListRemoveAction(JList list) {
      super("Remove", "Remove", AllIcons.General.Remove);
      myList = list;
    }


    @Override
    public void actionPerformed(AnActionEvent event) {
      if (myMpsProject == null) {
        return;
      }
      int minSelectionIndex = myList.getMinSelectionIndex();
      // XXX I cried with blood tears over the code below. 
      //  ListPanel.this.myListComponent == myList, 
      // and access to myListModel is mind-blowing. Need to find enough courage to refactor this mess. 
      for (Object value : ListPanel.this.myListComponent.getSelectedValuesList()) {
        for (final T node : ListPanel.this.myValues) {
          final Wrappers._T<String> fqName = new Wrappers._T<String>();
          myMpsProject.getModelAccess().runReadAction(new Runnable() {
            public void run() {
              fqName.value = getFqName(node);
            }
          });
          if (fqName.value.equals(value)) {
            ListSequence.fromList(ListPanel.this.myValues).removeElement(node);
            break;
          }
        }
      }
      if (ListPanel.this.myListener != null) {
        ListPanel.this.myListener.actionPerformed(null);
      }
      ListPanel.this.myListComponent.updateUI();
      ListPanel.this.myListModel.fireSomethingChanged();
      // index restore code came from base ListRemoveAction 
      myList.setSelectedIndex(Math.min(myList.getModel().getSize() - 1, minSelectionIndex));
    }

    @Override
    public void update(AnActionEvent event) {
      super.update(event);
      event.getPresentation().setEnabled(isEditable && myMpsProject != null && myList.getSelectedIndices().length != 0);
    }
  }
}