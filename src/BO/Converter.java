package BO;

import DB.Entities.FriendEntity;
import DB.Entities.PostEntity;
import DB.Entities.UserEntity;
import UI.ViewModels.FriendViewModel;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;

/**
 * Created by waleedhassan on 22/11/16.
 */
public class Converter {


    public static FriendViewModel convertToFriendViewModel(FriendEntity f){
        FriendViewModel friend = new FriendViewModel();
        friend.setUser(convertToUserViewModel(f.getUserByUserId()));
        friend.setNewFriend(convertToUserViewModel(f.getUserByFollowId()));
        return friend;
    }
    public static FriendEntity convertToFriendEntity(FriendViewModel f){
        FriendEntity friend = new FriendEntity();
        friend.setUserByUserId(convertToUserEntity(f.getUser()));
        friend.setUserByFollowId(convertToUserEntity(f.getNewFriend()));
        return friend;
    }

    public static PostViewModel convertToPostViewModel(PostEntity p){
        PostViewModel post = new PostViewModel();
        post.setBody(p.getBody());
        post.setUser(convertToUserViewModel(p.getUser()));
        post.setCreationDate(p.getCreationDate());
        return post;
    }

    public static PostEntity convertToPostEntity(PostViewModel p){
        PostEntity post = new PostEntity();
        post.setBody(p.getBody());
        post.setUser(convertToUserEntity(p.getUser()));
        return post;
    }

    public static UserViewModel convertToUserViewModel(UserEntity u){
        UserViewModel user = new UserViewModel();
        user.setUserId(u.getUserId());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        return user;
    }

    public static UserEntity convertToUserEntity(UserViewModel u){
        UserEntity user = new UserEntity();
        user.setUserId(u.getUserId());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        return user;
    }
}
