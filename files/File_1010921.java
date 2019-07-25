package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.analyzers.runtime.framework.GeneratedInstruction;
import org.jetbrains.mps.openapi.model.SNode;

public class notNullInstruction extends GeneratedInstruction {
  private SNode myexpression;
  private String myPresentation;
  public notNullInstruction(SNode expression) {
    StringBuilder sb = new StringBuilder();
    sb.append("notNull");
    myexpression = expression;
    putUserObject("expression", expression);
    addParameter(expression);
    sb.append(" " + expression);
    myPresentation = sb.toString();
  }
  @Override
  public String commandPresentation() {
    return myPresentation;
  }
  public SNode getexpression() {
    return myexpression;
  }
}