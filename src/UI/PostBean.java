package UI;

import BO.PostManager;
import UI.ViewModels.PostViewModel;

import javax.faces.bean.ManagedBean;
/**
 * Created by Marthin on 2016-11-11.
 */
@ManagedBean
public class PostBean {
    private PostViewModel post;
    private PostManager postManager;

    public PostBean() {
        this.post = new PostViewModel();
        postManager = new PostManager();
    }

    public PostViewModel getPost() {
        return post;
    }

    public void setPost(PostViewModel post) {
        this.post = post;
    }

    public void createPost(){
        postManager.createPost(post);
    }
}
