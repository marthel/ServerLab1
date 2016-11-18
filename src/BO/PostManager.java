package BO;

import DB.DAL.PostDb;
import DB.Entities.PostEntity;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marthin on 2016-11-11.
 */
public class PostManager {
    private PostDb db;
    public PostManager(){
        this.db = new PostDb();
    }
    public static PostViewModel convertToPostViewModel(PostEntity p){
        PostViewModel post = new PostViewModel();
        post.setBody(p.getBody());
        post.setUser(UserManager.convertToUserViewModel(p.getUser()));
        post.setCreationDate(p.getCreationDate());
        return post;
    }
    public void createPost(PostViewModel post) {
        db.addPost(post);
    }

    public List<PostViewModel> getAllPosts(UserViewModel user) {
        Collection<PostEntity> ePosts = db.findAllPosts(user);
        return ePosts.stream().map(PostManager::convertToPostViewModel).collect(Collectors.toList());
    }
}
