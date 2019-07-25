package formulaAdapter;

/*Generated by MPS */

import jetbrains.mps.samples.formulaLanguage.api.Function;
import mf.Money;
import postingrules.MonetaryEvent;

public class FeeMoney implements Function<Money> {
  public FeeMoney() {
  }
  @Override
  public Money compute(Object parm) {
    MonetaryEvent monetaryEvent = (MonetaryEvent) parm;
    return monetaryEvent.getAmount();
  }
}