package DB.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by waleedhassan on 22/11/16.
 */
public class FriendEntityPK implements Serializable {
    private int userId;
    private int followId;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "follow_id")
    @Id
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

        FriendEntityPK that = (FriendEntityPK) o;

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
}
