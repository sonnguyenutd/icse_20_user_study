public URLStreamHandler getHttpStreamHandler(ProtectedResourceDetails resourceDetails,OAuthConsumerToken accessToken,OAuthConsumerSupport support,String httpMethod,Map<String,String> additionalParameters){
  return new OAuthOverHttpURLStreamHandler(resourceDetails,accessToken,support,httpMethod,additionalParameters);
}
