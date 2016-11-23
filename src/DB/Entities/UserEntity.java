package DB.Entities;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "user", schema = "lab1")
public class UserEntity {
    private int userId;
    private String username;
    private String password;
    private Collection<ChatMessageEntity> chatMessagesSent;
    private Collection<ChatMessageEntity> chatMessagesReceived;
    private Collection<PostEntity> posts;
    private Collection<FollowEntity> followers;
    private Collection<FollowEntity> followees;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sender")
    public Collection<ChatMessageEntity> getChatMessagesSent() {
        return chatMessagesSent;
    }

    public void setChatMessagesSent(Collection<ChatMessageEntity> chatMessagesByUserId) {
        this.chatMessagesSent = chatMessagesByUserId;
    }

    @OneToMany(mappedBy = "receiver")
    public Collection<ChatMessageEntity> getChatMessagesReceived() {
        return chatMessagesReceived;
    }

    public void setChatMessagesReceived(Collection<ChatMessageEntity> chatMessagesByUserId_0) {
        this.chatMessagesReceived = chatMessagesByUserId_0;
    }

    @OneToMany(mappedBy = "user")
    public Collection<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(Collection<PostEntity> postsByUserId) {
        this.posts = postsByUserId;
    }

    @OneToMany(mappedBy = "follower")
    public Collection<FollowEntity> getFollowers() {
        return followers;
    }

    public void setFollowers(Collection<FollowEntity> followsByUserId) {
        this.followers = followsByUserId;
    }

    @OneToMany(mappedBy = "followee")
    public Collection<FollowEntity> getFollowees() {
        return followees;
    }

    public void setFollowees(Collection<FollowEntity> followsByUserId_0) {
        this.followees = followsByUserId_0;
    }
}
