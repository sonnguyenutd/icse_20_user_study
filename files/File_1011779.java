package jetbrains.mps.vcs.diff.ui;

/*Generated by MPS */

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.project.Project;
import jetbrains.mps.vcs.diff.StructChangeSet;
import org.jetbrains.mps.openapi.model.SNodeChangeListener;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.vcs.diff.StructChangeSetBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.event.SPropertyChangeEvent;
import org.jetbrains.mps.openapi.event.SReferenceChangeEvent;
import org.jetbrains.mps.openapi.event.SNodeAddEvent;
import org.jetbrains.mps.openapi.event.SNodeRemoveEvent;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import java.awt.Dimension;
import com.intellij.openapi.util.DimensionService;
import javax.swing.Action;
import org.jetbrains.mps.openapi.model.SModel;
import jetbrains.mps.vcs.diff.ChangeSetBuilder;
import org.jetbrains.annotations.NonNls;

public class StructDifferenceDialog extends DialogWrapper implements DataProvider {
  private Project myProject;
  private StructChangeSet myChangeSet;
  private SNodeChangeListener myChangeListener;

  private JPanel myComponent = new JPanel(new BorderLayout());
  private StructDifferencePane myNodeDifferencePane = null;

  private String[] myContentTitles;

  public StructDifferenceDialog(Project project, SNode oldNode, SNode newNode, String oldTitle, String newTitle) {
    super(project);
    myProject = project;
    if ((oldTitle == null || oldTitle.length() == 0)) {
      oldTitle = "before";
    }
    if ((newTitle == null || newTitle.length() == 0)) {
      newTitle = "after";
    }
    myContentTitles = new String[]{oldTitle, newTitle};

    setTitle("Difference for nodes");

    myChangeSet = StructChangeSetBuilder.buildChangeSet(oldNode, newNode, true);

    myChangeListener = new SNodeChangeListener() {
      public void propertyChanged(@NotNull SPropertyChangeEvent p0) {
        update();
      }
      public void referenceChanged(@NotNull SReferenceChangeEvent p0) {
        update();
      }
      public void nodeAdded(@NotNull SNodeAddEvent p0) {
        update();
      }
      public void nodeRemoved(@NotNull SNodeRemoveEvent p0) {
        update();
      }
      private void update() {
        check_rohu9p_a0a4a0a0k0j(myNodeDifferencePane);
      }
    };
    SNodeOperations.getModel(oldNode).addChangeListener(myChangeListener);
    if (SNodeOperations.getModel(newNode) != SNodeOperations.getModel(oldNode)) {
      SNodeOperations.getModel(newNode).addChangeListener(myChangeListener);
    }

    init();
  }

  @Nullable
  @Override
  protected JComponent createCenterPanel() {
    myNodeDifferencePane = new StructDifferencePane(myProject, myChangeSet, myContentTitles);
    DefaultActionGroup actionGroup = new DefaultActionGroup();
    actionGroup.addAll(myNodeDifferencePane.getActions());
    ActionToolbar toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, actionGroup, true);
    myNodeDifferencePane.registerShortcuts(myComponent);
    myComponent.add(toolbar.getComponent(), BorderLayout.NORTH);
    myComponent.add(myNodeDifferencePane.getPanel(), BorderLayout.CENTER);

    myNodeDifferencePane.navigateInitial(null);

    Dimension size = DimensionService.getInstance().getSize(getDimensionServiceKey());
    if (size == null) {
      myComponent.setPreferredSize(new Dimension(500, 700));
    }

    return myComponent;
  }

  @NotNull
  @Override
  protected Action[] createActions() {
    return new Action[0];
  }
  @Override
  public String getDimensionServiceKey() {
    return getClass().getName();
  }
  @Nullable
  @Override
  protected JComponent createSouthPanel() {
    return null;
  }
  @Override
  protected void dispose() {
    SModel oldModel = myChangeSet.getOldModel();
    SModel newModel = myChangeSet.getNewModel();
    oldModel.removeChangeListener(myChangeListener);
    if (newModel != oldModel) {
      newModel.removeChangeListener(myChangeListener);
    }
    if (myNodeDifferencePane != null) {
      myNodeDifferencePane.dispose();
    }
    super.dispose();
  }

  /*package*/ void rebuildChangeSets() {
    ChangeSetBuilder.rebuildChangeSet(myChangeSet);
  }

  public static void showNodeDifference(Project project, SNode oldNode, SNode newNode, String oldTitle, String newTitile) {
    StructDifferenceDialog dialog = new StructDifferenceDialog(project, oldNode, newNode, oldTitle, newTitile);
    dialog.setModal(false);
    dialog.show();
  }

  @Nullable
  public Object getData(@NonNls String string) {
    return null;
  }


  private static void check_rohu9p_a0a4a0a0k0j(StructDifferencePane checkedDotOperand) {
    if (null != checkedDotOperand) {
      checkedDotOperand.rehighlight();
    }

  }
}