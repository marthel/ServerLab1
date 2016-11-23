package UI;

import BO.FollowManager;
import UI.ViewModels.FollowViewModel;
import UI.ViewModels.UserViewModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@SessionScoped
public class FollowBean implements Serializable{


    private FollowViewModel follow;
    private FollowManager followManager;
    @ManagedProperty(value="#{userBean.user}")
    private UserViewModel user;

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public FollowBean() {
        this.follow = new FollowViewModel();
        followManager = new FollowManager();
    }
    public FollowViewModel getFollow() {
        return follow;
    }

    public void setFollow(FollowViewModel fvw) {
        this.follow = fvw;
    }

    public void addFriend(UserViewModel user){
        this.follow.setFollower(this.user);
        this.follow.setFollowee(user);
        //System.out.println(user.getUsername() +" " + user.getUserId());
        followManager.addFriend(follow);
    }

    public List<FollowViewModel> getYourFriends(){
        return followManager.getYourFriends(this.user);
    }


}
