package jetbrains.mps.regex.samples;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.regexp.runtime.Replacer;
import java.util.regex.Matcher;

public class _Replacer_90k4hu_a0a0b0c implements Replacer {
  public String replace(Matcher matcher) {
    return matcher.group(1) + " at " + matcher.group(2);
  }
  /*package*/ PredefinedRegexps _enclosingClass;
  /*package*/ Object _closureContext;
  public _Replacer_90k4hu_a0a0b0c(PredefinedRegexps enclosingClass, Object closureContext) {
    this._enclosingClass = enclosingClass;
    this._closureContext = (Object) closureContext;
  }
  public _Replacer_90k4hu_a0a0b0c(PredefinedRegexps enclosingClass) {
    this._enclosingClass = enclosingClass;
    this._closureContext = null;
  }
}