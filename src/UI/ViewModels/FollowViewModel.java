package UI.ViewModels;

public class FollowViewModel {

    private UserViewModel follower;
    private UserViewModel followee;

    public UserViewModel getFollower() {
        return follower;
    }

    public void setFollower(UserViewModel follower) {
        this.follower = follower;
    }

    public UserViewModel getFollowee() {
        return followee;
    }

    public void setFollowee(UserViewModel followee) {
        this.followee = followee;
    }
}
