public void Bind(){
{
    SwitchCompat storeHistory=((SwitchCompat)context.findViewById(R.id.settings_history_storehistory));
    storeHistory.setChecked(SettingValues.storeHistory);
    storeHistory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
      @Override public void onCheckedChanged(      CompoundButton buttonView,      boolean isChecked){
        SettingValues.storeHistory=isChecked;
        SettingValues.prefs.edit().putBoolean(SettingValues.PREF_STORE_HISTORY,isChecked).apply();
        if (isChecked) {
          context.findViewById(R.id.settings_history_scrollseen).setEnabled(true);
          context.findViewById(R.id.settings_history_storensfw).setEnabled(true);
        }
 else {
          ((SwitchCompat)context.findViewById(R.id.settings_history_storensfw)).setChecked(false);
          ((SwitchCompat)context.findViewById(R.id.settings_history_storensfw)).setEnabled(false);
          SettingValues.storeNSFWHistory=false;
          SettingValues.prefs.edit().putBoolean(SettingValues.PREF_STORE_NSFW_HISTORY,false).apply();
          ((SwitchCompat)context.findViewById(R.id.settings_history_scrollseen)).setChecked(false);
          ((SwitchCompat)context.findViewById(R.id.settings_history_scrollseen)).setEnabled(false);
          SettingValues.scrollSeen=false;
          SettingValues.prefs.edit().putBoolean(SettingValues.PREF_SCROLL_SEEN,false).apply();
        }
      }
    }
);
  }
  context.findViewById(R.id.settings_history_clearposts).setOnClickListener(new View.OnClickListener(){
    @Override public void onClick(    View v){
      KVStore.getInstance().clearTable();
      new AlertDialogWrapper.Builder(context).setTitle(R.string.alert_history_cleared).setPositiveButton(R.string.btn_ok,null).show();
    }
  }
);
  context.findViewById(R.id.settings_history_clearsubs).setOnClickListener(new View.OnClickListener(){
    @Override public void onClick(    View v){
      UserSubscriptions.subscriptions.edit().remove("subhistory").apply();
      new AlertDialogWrapper.Builder(context).setTitle(R.string.alert_history_cleared).setPositiveButton(R.string.btn_ok,null).show();
    }
  }
);
{
    SwitchCompat nsfw=((SwitchCompat)context.findViewById(R.id.settings_history_storensfw));
    nsfw.setChecked(SettingValues.storeNSFWHistory);
    nsfw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
      @Override public void onCheckedChanged(      CompoundButton buttonView,      boolean isChecked){
        SettingValues.storeNSFWHistory=isChecked;
        SettingValues.prefs.edit().putBoolean(SettingValues.PREF_STORE_NSFW_HISTORY,isChecked).apply();
      }
    }
);
  }
{
    SwitchCompat single=(SwitchCompat)context.findViewById(R.id.settings_history_scrollseen);
    single.setChecked(SettingValues.scrollSeen);
    single.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
      @Override public void onCheckedChanged(      CompoundButton buttonView,      boolean isChecked){
        SettingValues.scrollSeen=isChecked;
        SettingValues.prefs.edit().putBoolean(SettingValues.PREF_SCROLL_SEEN,isChecked).apply();
      }
    }
);
  }
}
