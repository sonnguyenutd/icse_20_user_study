private boolean checkUserName(final String name){
  if (name != null && name.length() > 0) {
    checkTextView.setVisibility(View.VISIBLE);
  }
 else {
    checkTextView.setVisibility(View.GONE);
  }
  typeInfoCell.setBackgroundDrawable(checkTextView.getVisibility() == View.VISIBLE ? null : Theme.getThemedDrawable(typeInfoCell.getContext(),R.drawable.greydivider_bottom,Theme.key_windowBackgroundGrayShadow));
  if (checkRunnable != null) {
    AndroidUtilities.cancelRunOnUIThread(checkRunnable);
    checkRunnable=null;
    lastCheckName=null;
    if (checkReqId != 0) {
      ConnectionsManager.getInstance(currentAccount).cancelRequest(checkReqId,true);
    }
  }
  lastNameAvailable=false;
  if (name != null) {
    if (name.startsWith("_") || name.endsWith("_")) {
      checkTextView.setText(LocaleController.getString("LinkInvalid",R.string.LinkInvalid));
      checkTextView.setTextColor(Theme.key_windowBackgroundWhiteRedText4);
      return false;
    }
    for (int a=0; a < name.length(); a++) {
      char ch=name.charAt(a);
      if (a == 0 && ch >= '0' && ch <= '9') {
        if (isChannel) {
          checkTextView.setText(LocaleController.getString("LinkInvalidStartNumber",R.string.LinkInvalidStartNumber));
        }
 else {
          checkTextView.setText(LocaleController.getString("LinkInvalidStartNumberMega",R.string.LinkInvalidStartNumberMega));
        }
        checkTextView.setTextColor(Theme.key_windowBackgroundWhiteRedText4);
        return false;
      }
      if (!(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch == '_')) {
        checkTextView.setText(LocaleController.getString("LinkInvalid",R.string.LinkInvalid));
        checkTextView.setTextColor(Theme.key_windowBackgroundWhiteRedText4);
        return false;
      }
    }
  }
  if (name == null || name.length() < 5) {
    if (isChannel) {
      checkTextView.setText(LocaleController.getString("LinkInvalidShort",R.string.LinkInvalidShort));
    }
 else {
      checkTextView.setText(LocaleController.getString("LinkInvalidShortMega",R.string.LinkInvalidShortMega));
    }
    checkTextView.setTextColor(Theme.key_windowBackgroundWhiteRedText4);
    return false;
  }
  if (name.length() > 32) {
    checkTextView.setText(LocaleController.getString("LinkInvalidLong",R.string.LinkInvalidLong));
    checkTextView.setTextColor(Theme.key_windowBackgroundWhiteRedText4);
    return false;
  }
  checkTextView.setText(LocaleController.getString("LinkChecking",R.string.LinkChecking));
  checkTextView.setTextColor(Theme.key_windowBackgroundWhiteGrayText8);
  lastCheckName=name;
  checkRunnable=() -> {
    TLRPC.TL_channels_checkUsername req=new TLRPC.TL_channels_checkUsername();
    req.username=name;
    req.channel=MessagesController.getInstance(currentAccount).getInputChannel(chatId);
    checkReqId=ConnectionsManager.getInstance(currentAccount).sendRequest(req,(response,error) -> AndroidUtilities.runOnUIThread(() -> {
      checkReqId=0;
      if (lastCheckName != null && lastCheckName.equals(name)) {
        if (error == null && response instanceof TLRPC.TL_boolTrue) {
          checkTextView.setText(LocaleController.formatString("LinkAvailable",R.string.LinkAvailable,name));
          checkTextView.setTextColor(Theme.key_windowBackgroundWhiteGreenText);
          lastNameAvailable=true;
        }
 else {
          if (error != null && error.text.equals("CHANNELS_ADMIN_PUBLIC_TOO_MUCH")) {
            canCreatePublic=false;
            loadAdminedChannels();
          }
 else {
            checkTextView.setText(LocaleController.getString("LinkInUse",R.string.LinkInUse));
          }
          checkTextView.setTextColor(Theme.key_windowBackgroundWhiteRedText4);
          lastNameAvailable=false;
        }
      }
    }
),ConnectionsManager.RequestFlagFailOnServerErrors);
  }
;
  AndroidUtilities.runOnUIThread(checkRunnable,300);
  return true;
}
