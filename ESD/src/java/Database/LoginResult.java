/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author t2-sheedy
 */
public class LoginResult {

    private String LoggedInID;
    private String LoginResult;
    
    public void setLoggedInID(String LoggedInID) {
        this.LoggedInID = LoggedInID;
    }
    public String getLoggedInID() {
        return this.LoggedInID;
    }

    public void setLoginResult(String LoginResult) {
        this.LoginResult = LoginResult;
    }
    public String getLoginResult() {
        return this.LoginResult;
    }

    public LoginResult(String LoggedInID, String LoginResult) {
        this.LoggedInID = LoggedInID;
        this.LoginResult = LoginResult;
    }
     
}
