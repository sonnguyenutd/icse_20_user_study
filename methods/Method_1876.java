private static boolean isSOFn(int marker){
switch (marker) {
case 0xC0:
case 0xC1:
case 0xC2:
case 0xC3:
case 0xC5:
case 0xC6:
case 0xC7:
case 0xC9:
case 0xCA:
case 0xCB:
case 0xCD:
case 0xCE:
case 0xCF:
    return true;
default :
  return false;
}
}