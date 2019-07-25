@OnMount static void onMount(final ComponentContext c,EditTextWithEventHandlers editText,@Prop(optional=true,resType=ResType.STRING) CharSequence hint,@Prop(optional=true,resType=ResType.DRAWABLE) Drawable inputBackground,@Prop(optional=true,resType=ResType.DIMEN_OFFSET) float shadowRadius,@Prop(optional=true,resType=ResType.DIMEN_OFFSET) float shadowDx,@Prop(optional=true,resType=ResType.DIMEN_OFFSET) float shadowDy,@Prop(optional=true,resType=ResType.COLOR) int shadowColor,@Prop(optional=true) ColorStateList textColorStateList,@Prop(optional=true) ColorStateList hintColorStateList,@Prop(optional=true,resType=ResType.COLOR) int highlightColor,@Prop(optional=true,resType=ResType.DIMEN_TEXT) int textSize,@Prop(optional=true) Typeface typeface,@Prop(optional=true) int textAlignment,@Prop(optional=true) int gravity,@Prop(optional=true) boolean editable,@Prop(optional=true) int inputType,@Prop(optional=true) int imeOptions,@Prop(optional=true,varArg="inputFilter") List<InputFilter> inputFilters,@Prop(optional=true) boolean multiline,@Prop(optional=true) int minLines,@Prop(optional=true) int maxLines,@Prop(optional=true) TextUtils.TruncateAt ellipsize,@Prop(optional=true) int cursorDrawableRes,@Prop(optional=true) MovementMethod movementMethod,@State AtomicReference<CharSequence> savedText,@State AtomicReference<EditTextWithEventHandlers> mountedView){
  mountedView.set(editText);
  setParams(editText,hint,getBackgroundOrDefault(c,inputBackground),shadowRadius,shadowDx,shadowDy,shadowColor,textColorStateList,hintColorStateList,highlightColor,textSize,typeface,textAlignment,gravity,editable,inputType,imeOptions,inputFilters,multiline,ellipsize,minLines,maxLines,cursorDrawableRes,movementMethod,savedText.get());
  editText.setTextState(savedText);
}