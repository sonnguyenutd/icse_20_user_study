@Override public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
  respondJSON(response,new ConfigurationResponse());
}
