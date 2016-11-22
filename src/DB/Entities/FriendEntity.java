package DB.Entities;

import javax.persistence.*;

/**
 * Created by waleedhassan on 22/11/16.
 */
@Entity
@Table(name = "friend", schema = "lab1")
@IdClass(FriendEntityPK.class)
public class FriendEntity {
    private int userId;
    private int followId;
    private UserEntity userByUserId;
    private UserEntity userByFollowId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "follow_id")
    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendEntity that = (FriendEntity) o;

        if (userId != that.userId) return false;
        if (followId != that.followId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + followId;
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
