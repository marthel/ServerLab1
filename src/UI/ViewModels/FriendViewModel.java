package UI.ViewModels;

/**
 * Created by waleedhassan on 22/11/16.
 */
public class FriendViewModel {

    private UserViewModel user;
    private UserViewModel newFriend;

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public UserViewModel getNewFriend() {
        return newFriend;
    }

    public void setNewFriend(UserViewModel newFriend) {
        this.newFriend = newFriend;
    }
}
