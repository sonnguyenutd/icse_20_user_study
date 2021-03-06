@Override public boolean validate() throws ContractValidateException {
  if (this.contract == null) {
    throw new ContractValidateException("No contract!");
  }
  if (this.dbManager == null) {
    throw new ContractValidateException("No dbManager!");
  }
  if (!contract.is(SellStorageContract.class)) {
    throw new ContractValidateException("contract type error,expected type [SellStorageContract],real type[" + contract.getClass() + "]");
  }
  final SellStorageContract sellStorageContract;
  try {
    sellStorageContract=this.contract.unpack(SellStorageContract.class);
  }
 catch (  InvalidProtocolBufferException e) {
    logger.debug(e.getMessage(),e);
    throw new ContractValidateException(e.getMessage());
  }
  byte[] ownerAddress=sellStorageContract.getOwnerAddress().toByteArray();
  if (!Wallet.addressValid(ownerAddress)) {
    throw new ContractValidateException("Invalid address");
  }
  AccountCapsule accountCapsule=dbManager.getAccountStore().get(ownerAddress);
  if (accountCapsule == null) {
    String readableOwnerAddress=StringUtil.createReadableString(ownerAddress);
    throw new ContractValidateException("Account[" + readableOwnerAddress + "] not exists");
  }
  long bytes=sellStorageContract.getStorageBytes();
  if (bytes <= 0) {
    throw new ContractValidateException("bytes must be positive");
  }
  long currentStorageLimit=accountCapsule.getStorageLimit();
  long currentUnusedStorage=currentStorageLimit - accountCapsule.getStorageUsage();
  if (bytes > currentUnusedStorage) {
    throw new ContractValidateException("bytes must be less than currentUnusedStorage[" + currentUnusedStorage + "]");
  }
  long quantity=storageMarket.trySellStorage(bytes);
  if (quantity <= 1_000_000L) {
    throw new ContractValidateException("quantity must be larger than 1TRX,current quantity[" + quantity + "]");
  }
  return true;
}
