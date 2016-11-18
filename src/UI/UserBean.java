package UI;

import BO.UserManager;
import UI.ViewModels.UserViewModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Marthin on 2016-11-11.
 */
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {
    private UserViewModel user;
    private UserManager userManager;
    private boolean isAuthenticated;
    public UserBean() {
        this.user = new UserViewModel();
        userManager = new UserManager();
        isAuthenticated = false;
    }

    public UserViewModel getUser() {
        return this.user;
    }
    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public String register(){
        userManager.register(this.user);
        return "/login.xhtml";
    }
    public String login(){
        setUser(userManager.login(this.user));
        if(this.user!=null){
            isAuthenticated = true;
            return "/home.xhtml";
        }else return "/login.xhtml";
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}
