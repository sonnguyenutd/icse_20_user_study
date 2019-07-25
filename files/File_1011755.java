package jetbrains.mps.vcs.changesmanager.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.leftHighlighter.AbstractFoldingAreaPainter;
import java.awt.Color;
import jetbrains.mps.vcs.diff.ui.common.ChangeGroupLayout;
import jetbrains.mps.vcs.diff.ui.common.ChangeGroup;
import jetbrains.mps.vcs.diff.ui.common.ChangeGroupMessages;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.nodeEditor.EditorComponent;
import java.awt.Graphics;
import java.awt.Rectangle;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.vcs.diff.ui.common.Bounds;
import jetbrains.mps.vcs.diff.ui.common.ChangeColors;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.vcs.diff.changes.SetPropertyChange;
import jetbrains.mps.vcs.diff.changes.SetReferenceChange;
import jetbrains.mps.vcs.diff.changes.NodeGroupChange;
import jetbrains.mps.util.NameUtil;
import org.jetbrains.annotations.Nullable;
import java.awt.Point;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.vcs.diff.ui.common.ChangeEditorMessage;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import jetbrains.mps.openapi.editor.cells.EditorCell;

public class ChangeStripsPainter extends AbstractFoldingAreaPainter {
  private static final int AREA_WIDTH = 6;
  private static final int ARROW_HEIGHT = 8;
  private static final Color AREA_FRAME_COLOR = Color.GRAY;
  private EditorHighlighter myEditorHighlighter;
  private ChangeGroupLayout myChangeGroupLayout;
  private ChangeGroup myGroupUnderMouse;
  private PopupPanel myPopupToolbar = null;
  private ChangeGroupMessages myGroupMessages;
  public ChangeStripsPainter(@NotNull EditorHighlighter editorHighlighter) {
    super(editorHighlighter.getLeftEditorHighlighter());
    myEditorHighlighter = editorHighlighter;
    myChangeGroupLayout = new StripsChangeGroupLayout(myEditorHighlighter);
    myGroupMessages = new ChangeGroupMessages(myChangeGroupLayout, true);
    myGroupMessages.startMaintaining();
  }
  @NotNull
  @Override
  protected EditorComponent getEditorComponent() {
    return super.getEditorComponent();
  }
  @Override
  public int getWeight() {
    return 0;
  }
  @Override
  protected void paintInLocalCoordinates(Graphics g) {
    Rectangle clipBounds = g.getClipBounds();
    if (clipBounds.x + clipBounds.width < -AREA_WIDTH - 1 || 0 < clipBounds.x) {
      return;
    }
    for (ChangeGroup changeGroup : ListSequence.fromList(myChangeGroupLayout.getChangeGroups())) {
      Bounds bounds = changeGroup.getBounds(true);
      int y = (int) bounds.start();
      g.setColor(ChangeColors.get(changeGroup.getChangeType()));
      if (bounds.length() <= 1) {
        Graphics2D g2d = ((Graphics2D) g);
        Object oldAntialiasing = g2d.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int[] xPoints = new int[]{-AREA_WIDTH, -AREA_WIDTH, -1};
        int[] yPoints = new int[]{y, y + ChangeStripsPainter.ARROW_HEIGHT, y + ChangeStripsPainter.ARROW_HEIGHT / 2};
        g.fillPolygon(xPoints, yPoints, 3);

        g.setColor(AREA_FRAME_COLOR);
        g.drawPolygon(xPoints, yPoints, 3);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, oldAntialiasing);
        continue;
      }
      int height = bounds.length();
      if (height == 0 || y + height < clipBounds.y) {
        continue;
      }
      if (clipBounds.y + clipBounds.height < y) {
        break;
      }
      g.fillRect(-AREA_WIDTH, y, AREA_WIDTH, height);

      g.setColor(AREA_FRAME_COLOR);
      g.drawLine(-AREA_WIDTH, y, 0, y);
      g.drawLine(-AREA_WIDTH, y + height, 0, y + height);
      g.drawLine(-AREA_WIDTH, y, -AREA_WIDTH, y + height);
    }
  }
  @Override
  public int getLeftAreaWidth() {
    return AREA_WIDTH;
  }
  @Override
  public void relayout() {
    myChangeGroupLayout.invalidate();
  }
  @Override
  public String getToolTipText() {
    if (myGroupUnderMouse == null) {
      return null;
    } else {
      List<ModelChange> changes = myGroupUnderMouse.getChanges();
      if (ListSequence.fromList(changes).count() == 1) {
        ModelChange change = ListSequence.fromList(changes).first();
        if (change instanceof SetPropertyChange) {
          return "Changed " + ((SetPropertyChange) change).getPropertyName();
        } else if (change instanceof SetReferenceChange) {
          return "Changed " + ((SetReferenceChange) change).getRole() + " reference";
        } else if (change instanceof NodeGroupChange) {
          return ((NodeGroupChange) change).getDescription(false);
        }
      }
      return NameUtil.formatNumericalString(ListSequence.fromList(changes).count(), "change");
    }
  }
  @Nullable
  private ChangeGroup findMessageGroupUnder(@NotNull final Point p) {
    double localX = p.getX() - getLeftHighlighter().getFoldingLineX();
    if (localX >= -AREA_WIDTH && localX < 0) {
      return ListSequence.fromList(myChangeGroupLayout.getChangeGroups()).findFirst(new IWhereFilter<ChangeGroup>() {
        public boolean accept(ChangeGroup cg) {
          Bounds b = cg.getBounds(true);
          return (int) b.start() <= p.getY() && p.getY() <= (int) b.end() || b.length() <= 1 && (int) b.start() - ARROW_HEIGHT / 2 <= p.getY() && p.getY() <= (int) b.end() + ARROW_HEIGHT / 2;
        }
      });
    } else {
      return null;
    }
  }
  /*package*/ void setGroupHighlighted(@Nullable ChangeGroup group, final boolean highlighted) {
    if (group != null) {
      ListSequence.fromList(group.getChanges()).translate(new ITranslator2<ModelChange, ChangeEditorMessage>() {
        public Iterable<ChangeEditorMessage> translate(ModelChange ch) {
          return myEditorHighlighter.getMessages(ch);
        }
      }).visitAll(new IVisitor<ChangeEditorMessage>() {
        public void visit(ChangeEditorMessage m) {
          m.setHighlighted(highlighted);
        }
      });
    }
  }
  private void setGroupUnderMouse(@Nullable ChangeGroup group) {
    if (myGroupUnderMouse == group) {
      return;
    }

    setGroupHighlighted(myGroupUnderMouse, false);
    myGroupUnderMouse = group;
    setGroupHighlighted(myGroupUnderMouse, true);
    if (myPopupToolbar != null) {
      setGroupHighlighted(myPopupToolbar.getChangeGroup(), true);
    }
    myEditorHighlighter.getHighlightManager().repaintAndRebuildEditorMessages();
  }
  @Override
  public void mouseMoved(MouseEvent event) {
    ChangeGroup changeGroup = findMessageGroupUnder(event.getPoint());
    if (changeGroup != null) {
      event.consume();
    }
    setGroupUnderMouse(changeGroup);
    if (changeGroup != null) {
      event.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    } else {
      event.getComponent().setCursor(null);
    }
  }
  @Override
  public void mouseExited(MouseEvent event) {
    event.getComponent().setCursor(null);
    setGroupUnderMouse(null);
  }
  @Override
  public void mousePressed(MouseEvent event) {
    if (event.getID() != MouseEvent.MOUSE_CLICKED) {
      return;
    }
    check_h84zmo_a1a02(myPopupToolbar);
    getEditorComponent().requestFocus();
    if (event.getButton() == MouseEvent.BUTTON1) {
      ChangeGroup changeGroup = findMessageGroupUnder(event.getPoint());
      if (changeGroup != null) {
        showPopupForGroup(changeGroup, event.getY());

        event.consume();
      }
    }
  }
  private void showPopupForGroup(@NotNull ChangeGroup changeGroup, int y) {
    int foldingLineX = getEditorComponent().getLeftEditorHighlighter().getFoldingLineX();
    EditorCell cell = getEditorComponent().findCellWeak(foldingLineX, y);
    if (cell != null) {
      getEditorComponent().changeSelection(cell);
    }
    myPopupToolbar = new PopupPanel(this, changeGroup);
    myPopupToolbar.show(0, y);
  }
  /*package*/ void popupClosed() {
    myPopupToolbar = null;
  }
  @Nullable
  /*package*/ ChangeGroup getNeighbourChangeGroup(@Nullable EditorCell contextCell, boolean next) {
    if (contextCell == null) {
      return null;
    }
    if (next) {
      final int bottomY = contextCell.getY() + contextCell.getHeight();
      return ListSequence.fromList(myChangeGroupLayout.getChangeGroups()).findFirst(new IWhereFilter<ChangeGroup>() {
        public boolean accept(ChangeGroup g) {
          return bottomY < (int) g.getBounds(true).start();
        }
      });
    } else {
      final int topY = contextCell.getY();
      return ListSequence.fromList(myChangeGroupLayout.getChangeGroups()).findLast(new IWhereFilter<ChangeGroup>() {
        public boolean accept(ChangeGroup g) {
          return topY > (int) g.getBounds(true).end();
        }
      });
    }
  }
  @Nullable
  /*package*/ ChangeGroup getCurrentChangeGroup() {
    return check_h84zmo_a0a42(myPopupToolbar);
  }
  /*package*/ void showPopupForGroup(@Nullable ChangeGroup group) {
    check_h84zmo_a0a52(myPopupToolbar);
    if (group != null) {
      showPopupForGroup(group, (int) group.getBounds(true).start());
    }
  }
  @Override
  public void dispose() {
    myGroupMessages.dispose();
    super.dispose();
  }
  private static void check_h84zmo_a1a02(PopupPanel checkedDotOperand) {
    if (null != checkedDotOperand) {
      checkedDotOperand.dispose();
    }

  }
  private static ChangeGroup check_h84zmo_a0a42(PopupPanel checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getChangeGroup();
    }
    return null;
  }
  private static void check_h84zmo_a0a52(PopupPanel checkedDotOperand) {
    if (null != checkedDotOperand) {
      checkedDotOperand.dispose();
    }

  }
}