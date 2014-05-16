/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic.file;

public class PathNameSanitization {
    private String userPath=" ";
    private PathNameSanitization(){} ;
    protected PathNameSanitization(String userPath) {
        this.userPath=userPath;
        System.out.println("Entered");
    }
    protected String getDrive() {
        return(getOnlyLetter()+":"+"\\");
    }
    protected String getDirectoryName() {
        return(this.userPath);
    }
    protected String getOnlyLetter() {
        String driveLetter = this.userPath.substring(0, 1).toUpperCase();
        System.out.println("Entered");
        System.out.printf("ss\n");
     //   if(Character.isLowerCase(driveLetter.charAt(0))) return(driveLetter.toUpperCase());
    //    else return(this.userPath.substring(0, 1));
      //  driveLetter = driveLetter.toUpperCase();
        return(userPath.substring(0, 1).toUpperCase());
    }
    protected String getFullPath(String path) {
        userPath+=path;
        return(userPath);
    }
    protected String getFullPath() {        
        return(userPath);
    }
    
}
