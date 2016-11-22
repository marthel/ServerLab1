package UI;

import BO.FriendManager;
import BO.PostManager;
import UI.ViewModels.FriendViewModel;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by waleedhassan on 22/11/16.
 */
@ManagedBean
public class FriendBean implements Serializable{


    private FriendViewModel newFriend;
    private List<FriendViewModel> friends;
    private FriendManager friendManager;
    @ManagedProperty(value="#{userBean.user}")
    private UserViewModel user;

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public FriendBean() {
        this.newFriend = new FriendViewModel();
        friendManager = new FriendManager();
        friends = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        friends = friendManager.getYourFriends(this.user);
    }
    public FriendViewModel getFriend() {
        return newFriend;
    }

    public void setFriend(FriendViewModel fvm) {
        this.newFriend = fvm;
    }

    public void addFriend(){
        this.newFriend.setUser(this.user);
        friendManager.addFriend(newFriend);
    }

    public List<FriendViewModel> getAllFriends(){
        return this.friends;
    }


}
