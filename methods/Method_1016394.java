public boolean HELP(){
  Data.logger.info("---- ftp HELP ----");
  Data.logger.info("");
  Data.logger.info("This ftp client shell can act as command shell for the local host as well for the");
  Data.logger.info("remote host. Commands that point to the local host are preceded by 'L'.");
  Data.logger.info("");
  Data.logger.info("Supported Commands:");
  Data.logger.info("ASCII");
  Data.logger.info("   switch remote server to ASCII transfer mode");
  Data.logger.info("BINARY");
  Data.logger.info("   switch remote server to BINARY transfer mode");
  Data.logger.info("BYE");
  Data.logger.info("   quit the command shell (same as EXIT)");
  Data.logger.info("CD <path>");
  Data.logger.info("   change remote path");
  Data.logger.info("CLOSE");
  Data.logger.info("   close connection to remote host (same as DISCONNECT)");
  Data.logger.info("DEL <file>");
  Data.logger.info("   delete file on remote server (same as RM)");
  Data.logger.info("RM <file>");
  Data.logger.info("   remove file from remote server (same as DEL)");
  Data.logger.info("DIR [<path>|<file>] ");
  Data.logger.info("   print file information for remote directory or file");
  Data.logger.info("DISCONNECT");
  Data.logger.info("   disconnect from remote server (same as CLOSE)");
  Data.logger.info("EXIT");
  Data.logger.info("   quit the command shell (same as BYE)");
  Data.logger.info("GET <remote-file> [<local-file>]");
  Data.logger.info("   load <remote-file> from remote server and store it locally,");
  Data.logger.info("   optionally to <local-file>. if the <remote-file> is a directory,");
  Data.logger.info("   then all files in that directory are retrieved,");
  Data.logger.info("   including recursively all subdirectories.");
  Data.logger.info("GLOB");
  Data.logger.info("   toggles globbing: matching with wild cards or not");
  Data.logger.info("COPY");
  Data.logger.info("   copies local files");
  Data.logger.info("LCD <path>");
  Data.logger.info("   local directory change");
  Data.logger.info("LDEL <file>");
  Data.logger.info("   local file delete");
  Data.logger.info("LDIR");
  Data.logger.info("   shows local directory content");
  Data.logger.info("LITERAL <ftp-command> [<command-argument>]");
  Data.logger.info("   Sends FTP commands as documented in RFC959");
  Data.logger.info("LLS");
  Data.logger.info("   as LDIR");
  Data.logger.info("LMD");
  Data.logger.info("   as LMKDIR");
  Data.logger.info("LMV <local-from> <local-to>");
  Data.logger.info("   copies local files");
  Data.logger.info("LPWD");
  Data.logger.info("   prints local path");
  Data.logger.info("LRD");
  Data.logger.info("   as LMKDIR");
  Data.logger.info("LRMD <folder-name>");
  Data.logger.info("   deletes local directory <folder-name>");
  Data.logger.info("LRM <file-name>");
  Data.logger.info("   deletes local file <file-name>");
  Data.logger.info("LS [<path>|<file>]");
  Data.logger.info("   prints list of remote directory <path> or information of file <file>");
  Data.logger.info("MDIR");
  Data.logger.info("   as MKDIR");
  Data.logger.info("MGET <file-pattern>");
  Data.logger.info("   copies files from remote server that fits into the");
  Data.logger.info("   pattern <file-pattern> to the local path.");
  Data.logger.info("MOVEDOWN <file-pattern>");
  Data.logger.info("   copies files from remote server as with MGET");
  Data.logger.info("   and deletes them afterwards on the remote server");
  Data.logger.info("MV <from> <to>");
  Data.logger.info("   moves or renames files on the local host");
  Data.logger.info("NOOP");
  Data.logger.info("   sends the NOOP command to the remote server (which does nothing)");
  Data.logger.info("   This command is usually used to measure the speed of the remote server.");
  Data.logger.info("OPEN <host[':'port]> [<port>]");
  Data.logger.info("   connects the ftp shell to the remote server <host>. Optionally,");
  Data.logger.info("   a port number can be given, the default port number is 21.");
  Data.logger.info("   Example: OPEN localhost:2121 or OPEN 192.168.0.1 2121");
  Data.logger.info("PROMPT");
  Data.logger.info("   compatibility command, that usually toggles beween prompting on or off.");
  Data.logger.info("   ftp has prompting switched off by default and cannot switched on.");
  Data.logger.info("PUT <local-file> [<remote-file>]");
  Data.logger.info("   copies the <local-file> to the remote server to the current remote path or");
  Data.logger.info("   optionally to the given <remote-file> path.");
  Data.logger.info("PWD");
  Data.logger.info("   prints current path on the remote server.");
  Data.logger.info("REMOTEHELP");
  Data.logger.info("   asks the remote server to print the help text of the remote server");
  Data.logger.info("RMDIR <folder-name>");
  Data.logger.info("   removes the directory <folder-name> on the remote server");
  Data.logger.info("QUIT");
  Data.logger.info("   exits the ftp application");
  Data.logger.info("RECV");
  Data.logger.info("   as GET");
  Data.logger.info("USER <user-name> <password>");
  Data.logger.info("   logs into the remote server with the user <user-name>");
  Data.logger.info("   and the password <password>");
  Data.logger.info("");
  Data.logger.info("");
  Data.logger.info("EXAMPLE:");
  Data.logger.info("a standard sessions looks like this");
  Data.logger.info(">open 192.168.0.1:2121");
  Data.logger.info(">user anonymous bob");
  Data.logger.info(">pwd");
  Data.logger.info(">ls");
  Data.logger.info(">.....");
  Data.logger.info("");
  Data.logger.info("");
  return true;
}
