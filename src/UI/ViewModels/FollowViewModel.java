package UI.ViewModels;

public class FollowViewModel {

    private UserViewModel follower;
    private UserViewModel following;

    public UserViewModel getFollower() {
        return follower;
    }

    public void setFollower(UserViewModel follower) {
        this.follower = follower;
    }

    public UserViewModel getFollowing() {
        return following;
    }

    public void setFollowing(UserViewModel following) {
        this.following = following;
    }
}
