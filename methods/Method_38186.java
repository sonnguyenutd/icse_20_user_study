public AutomagicDbOomConfigurator withScanner(final Consumer<ClassScanner> scannerConsumer){
  classScannerConsumers.add(scannerConsumer);
  return this;
}
