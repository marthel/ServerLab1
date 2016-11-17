package BO;

import DB.DAL.PostDb;
import UI.ViewModels.PostViewModel;

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
}
