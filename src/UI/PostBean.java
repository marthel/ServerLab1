package UI;

import BO.PostManager;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marthin on 2016-11-11.
 */
@ManagedBean
@SessionScoped
public class PostBean implements Serializable {
    private PostViewModel post;
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

   public List<PostViewModel> getYourPosts(){
        return postManager.getYourPosts(this.user);
    }
    public String getCharsLeft(){
        int charsLeft = 255 - post.getBody().length();
        StringBuilder sb = new StringBuilder();
        sb.append("characters left: ");
        sb.append( charsLeft > 0 ? charsLeft : 0);
        return sb.toString();
    }
}
