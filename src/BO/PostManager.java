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

    public void createPost(PostViewModel post) {
        db.addPost(post);

    }

    public List<PostViewModel> getAllPosts(UserViewModel user) {
        Collection<PostEntity> postEntities = db.findAllPosts(user);
        return postEntities.stream().map(Converter::convertToPostViewModel).collect(Collectors.toList());
    }

    public List<PostViewModel> getYourPosts(UserViewModel user) {
        Collection<PostEntity> postEntities = db.findYourPosts(user);
        return postEntities.stream().map(Converter::convertToPostViewModel).collect(Collectors.toList());
    }
}
