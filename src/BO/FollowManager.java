package BO;

import DB.DAL.FollowDb;
import DB.Entities.FollowEntity;
import UI.ViewModels.FollowViewModel;
import UI.ViewModels.UserViewModel;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class FollowManager {


    private FollowDb db;

    public FollowManager(){
        this.db = new FollowDb();
    }

    public void addFriend(FollowViewModel follow) {
        db.addFollower(follow);
    }

    public List<FollowViewModel> getYourFollows(UserViewModel user, String searchTerm) {
        Collection<FollowEntity> follows = db.findYourFollows(user, searchTerm);
        return follows.stream().map(Converter::convertToFollowViewModel).collect(Collectors.toList());
    }
}
