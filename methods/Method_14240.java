@Override public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
  try {
    Project project=getProject(request);
    AbstractOperation op=new DenormalizeOperation();
    Process process=op.createProcess(project,new Properties());
    performProcessAndRespond(request,response,project,process);
  }
 catch (  Exception e) {
    respondException(response,e);
  }
}
