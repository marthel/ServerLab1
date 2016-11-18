package UI;

import BO.PostManager;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marthin on 2016-11-11.
 */
@ManagedBean
public class PostBean implements Serializable {
    private PostViewModel post;
    private List<PostViewModel> posts;
    private PostManager postManager;
    @ManagedProperty(value="#{userBean.user}")
    private UserViewModel user;

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public PostBean() {
        this.post = new PostViewModel();
        postManager = new PostManager();
        posts = new ArrayList<>();
    }
    @PostConstruct
    public void init(){
        posts = postManager.getAllPosts(this.user);
    }
    public PostViewModel getPost() {
        return post;
    }

    public void setPost(PostViewModel post) {
        this.post = post;
    }


    public void createPost(){
        this.post.setUser(this.user);
        postManager.createPost(post);
    }

   public List<PostViewModel> getPosts(){
        return this.posts;
    }
}
