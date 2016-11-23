package UI.ViewModels;

import java.sql.Date;

/**
 * Created by Marthin on 2016-11-11.
 */
public class PostViewModel {
    private int postId;
    private String body;
    private Date creationDate;
    private UserViewModel user;

    public PostViewModel() {
        body = "";
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return body + " " + user.getUsername() + " date: " + creationDate.toString();
    }
}
