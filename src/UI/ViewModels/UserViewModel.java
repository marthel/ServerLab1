package UI.ViewModels;


import java.util.Collection;
import java.util.List;

/**
 * Created by Marthin on 2016-11-11.
 */
public class UserViewModel {
    private int userId;
    private String username;
    private String password;
    private Collection<PostViewModel> posts;
    private Collection<ChatMessageViewModel> sentChatMessages;
    private Collection<ChatMessageViewModel> receivedChatMessages;

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

    public Collection<PostViewModel> getPosts() {
        return posts;
    }

    public void setPosts(Collection<PostViewModel> posts) {
        this.posts = posts;
    }

    public Collection<ChatMessageViewModel> getSentChatMessages() {
        return sentChatMessages;
    }

    public void setSentChatMessages(Collection<ChatMessageViewModel> sentChatMessages) {
        this.sentChatMessages = sentChatMessages;
    }

    public Collection<ChatMessageViewModel> getReceivedChatMessages() {
        return receivedChatMessages;
    }

    public void setReceivedChatMessages(Collection<ChatMessageViewModel> receivedChatMessages) {
        this.receivedChatMessages = receivedChatMessages;
    }

    @Override
    public String toString() {
        return "UserViewModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
