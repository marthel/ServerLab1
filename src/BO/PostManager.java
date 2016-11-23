package BO;

import DB.DAL.PostDb;
import DB.Entities.PostEntity;
import UI.ViewModels.FollowViewModel;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class PostManager {
    private PostDb db;
    public PostManager(){
        this.db = new PostDb();
    }

    public void createPost(PostViewModel post) {
        db.addPost(post);

    }

    public List<PostViewModel> getFollowingPosts(List<FollowViewModel> follows) {
        Collection<PostEntity> postEntities = new ArrayList<>();
        for (FollowViewModel f:follows) {
            postEntities.addAll(db.findPostsByUser(f.getFollowing()));
        }
        return postEntities.stream().map(Converter::convertToPostViewModel).collect(Collectors.toList());
    }

    public List<PostViewModel> getYourPosts(UserViewModel user) {
        Collection<PostEntity> postEntities = db.findPostsByUser(user);
        return postEntities.stream().map(Converter::convertToPostViewModel).collect(Collectors.toList());
    }
}
