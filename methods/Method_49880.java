private static void addLocaleToHttpAcceptLanguage(StringBuilder builder,Locale locale){
  final String language=convertObsoleteLanguageCodeToNew(locale.getLanguage());
  if (language != null) {
    builder.append(language);
    final String country=locale.getCountry();
    if (country != null) {
      builder.append("-");
      builder.append(country);
    }
  }
}
