package jetbrains.mps.lang.editor.diagram.runtime.jetpad.palette.ui;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.ToggleAction;
import jetbrains.mps.lang.editor.diagram.runtime.jetpad.palette.openapi.PaletteElement;
import com.intellij.openapi.actionSystem.AnActionEvent;

/*package*/ abstract class DiagramPaletteToggleAction extends ToggleAction {

  private boolean mySelected;
  protected DiagramPalette myPalette;
  private PopupPaletteActionGroupAdapter myParent;
  /*package*/ DiagramPaletteToggleAction(DiagramPalette palette, PaletteElement element) {
    super(element.getText(), element.getText(), element.getIcon());
    myPalette = palette;
  }

  public boolean isSelected(AnActionEvent event) {
    return mySelected;
  }
  public void setSelected(AnActionEvent event, boolean isSelected) {
    if (event != null) {
      if (!(mySelected) && isSelected) {
        select();
      } else if (mySelected && !(isSelected)) {
        unselect();
      }
    }
    mySelected = isSelected;
    check_gh9xft_a2a7(myParent, mySelected, this);
  }
  private void select() {
    myPalette.unselectActionWhichWasSelected(this);
  }
  private void unselect() {
    myPalette.unselectActionWhichWasSelected();
  }
  public void setParentGroup(PopupPaletteActionGroupAdapter group) {
    myParent = group;
  }
  private static void check_gh9xft_a2a7(PopupPaletteActionGroupAdapter checkedDotOperand, Boolean mySelected, DiagramPaletteToggleAction checkedDotThisExpression) {
    if (null != checkedDotOperand) {
      checkedDotOperand.setSelectedAction((mySelected ? checkedDotThisExpression : null));
    }

  }
}