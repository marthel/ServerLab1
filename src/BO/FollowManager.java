package BO;

import DB.DAL.followDb;
import DB.Entities.FollowEntity;
import UI.ViewModels.FollowViewModel;
import UI.ViewModels.UserViewModel;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class FollowManager {


    private followDb db;

    public FollowManager(){
        this.db = new followDb();
    }

    public void addFriend(FollowViewModel follow) {
        db.addFollower(follow);
    }

    public List<FollowViewModel> getYourFriends(UserViewModel user) {
        Collection<FollowEntity> friends = db.findYourFollowers(user);
        return friends.stream().map(Converter::convertToFollowViewModel).collect(Collectors.toList());
    }
}
