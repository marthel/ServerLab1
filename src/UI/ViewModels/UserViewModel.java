package UI.ViewModels;


import java.util.List;

/**
 * Created by Marthin on 2016-11-11.
 */
public class UserViewModel {
    private int userId;
    private String username;
    private String password;
    private List<PostViewModel> posts;

    public UserViewModel() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PostViewModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostViewModel> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "UserViewModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
