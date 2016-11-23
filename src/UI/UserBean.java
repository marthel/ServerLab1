package UI;

import BO.UserManager;
import UI.ViewModels.UserViewModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Marthin on 2016-11-11.
 */
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {
    private UserViewModel user;
    private UserManager userManager;
    private boolean isAuthenticated;
    private String searchTerm;

    public UserBean() {
        this.user = new UserViewModel();
        userManager = new UserManager();
        isAuthenticated = false;
        searchTerm = "";
    }

    public UserViewModel getUser() {
        return this.user;
    }
    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String register(){
        this.user = new UserViewModel(this.user.getUsername(),this.user.getPassword());
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
    public List<UserViewModel> getUsers(){
        return userManager.getAllUsers(this.user, searchTerm);
    }
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml";
    }
}
