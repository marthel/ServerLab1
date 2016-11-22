package BO;

import DB.DAL.FriendDB;
import DB.Entities.FriendEntity;
import UI.ViewModels.FriendViewModel;
import UI.ViewModels.UserViewModel;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by waleedhassan on 22/11/16.
 */
public class FriendManager {


    private FriendDB db;

    public FriendManager(){
        this.db = new FriendDB();
    }

    public void addFriend(FriendViewModel newFriend) {
        db.addFriend(newFriend);
    }

    public List<FriendViewModel> getYourFriends(UserViewModel user) {
        Collection<FriendEntity> friends = db.findYourFriends(user);
        System.out.println(friends.toArray().toString());

        return friends.stream().map(Converter::convertToFriendViewModel).collect(Collectors.toList());
    }


}
