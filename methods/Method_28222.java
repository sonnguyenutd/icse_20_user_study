@Override public void onFragmentCreated(@NonNull Bundle bundle){
  repoId=bundle.getString(BundleConstant.ID);
  login=bundle.getString(BundleConstant.EXTRA);
  number=bundle.getLong(BundleConstant.EXTRA_TWO);
  if (!InputHelper.isEmpty(login) && !InputHelper.isEmpty(repoId)) {
    onCallApi(1,null);
  }
}
