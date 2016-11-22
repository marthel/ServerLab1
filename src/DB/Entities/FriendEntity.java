package DB.Entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by waleedhassan on 22/11/16.
 */
@Entity
@Table(name = "friend", schema = "lab1")
public class FriendEntity implements Serializable {
    private UserEntity userByUserId;
    private UserEntity userByFollowId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userByUserId.getUserId();
    }

    public void setUserId(int userId) {
        this.userByUserId.setUserId(userId);
    }

    @Id
    @Column(name = "follow_id")
    public int getFollowId() {
        return this.userByFollowId.getUserId();
    }

    public void setFollowId(int followId) {
        this.userByFollowId.setUserId(followId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendEntity that = (FriendEntity) o;

        if (userByUserId.getUserId() != that.userByUserId.getUserId()) return false;
        if (userByFollowId.getUserId() != that.userByFollowId.getUserId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userByUserId.getUserId();
        result = 31 * result + userByFollowId.getUserId();
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "follow_id", referencedColumnName = "user_id", nullable = false)
    public UserEntity getUserByFollowId() {
        return userByFollowId;
    }
    public void setUserByFollowId(UserEntity userByFollowId) {
        this.userByFollowId = userByFollowId;
    }
}
