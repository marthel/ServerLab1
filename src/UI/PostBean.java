package UI;

import BO.PostManager;
import UI.ViewModels.FollowViewModel;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;


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

    @ManagedProperty(value="#{followBean.follows}")
    private List<FollowViewModel> follows;
    public List<FollowViewModel> getFollows() {
        return follows;
    }
    public void setFollows(List<FollowViewModel> follows) {
      this.follows=follows;
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
    public List<PostViewModel> getFollowingPosts(){
        return postManager.getFollowingPosts(follows);
    }
    public String getCharsLeft(){
        int charsLeft = 255 - post.getBody().length();
        return "characters left: " +
                (charsLeft > 0 ? charsLeft : 0);
    }
}
