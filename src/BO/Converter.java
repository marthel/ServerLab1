package BO;

import DB.Entities.FollowEntity;
import DB.Entities.PostEntity;
import DB.Entities.UserEntity;
import UI.ViewModels.FollowViewModel;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;


public class Converter {


    public static FollowViewModel convertToFollowViewModel(FollowEntity f){
        FollowViewModel follow = new FollowViewModel();
        follow.setFollower(convertToUserViewModel(f.getFollower()));
        follow.setFollowing(convertToUserViewModel(f.getFollowing()));
        return follow;
    }
    public static FollowEntity convertToFollowEntity(FollowViewModel f){
        FollowEntity follow = new FollowEntity();
        follow.setFollower(convertToUserEntity(f.getFollower()));
        follow.setFollowing(convertToUserEntity(f.getFollowing()));
        return follow;
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
