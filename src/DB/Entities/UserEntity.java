package DB.Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Marthin on 2016-11-17.
 */
@Entity
@Table(name = "user", schema = "lab1", catalog = "")
public class UserEntity {
    private int userId;
    private String username;
    private String password;
    private Collection<PostEntity> postsByUserId;

    @Id
    @Column(name = "user_id")
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

    @OneToMany(mappedBy = "userByUserId")
    public Collection<PostEntity> getPostsByUserId() {
        return postsByUserId;
    }

    public void setPostsByUserId(Collection<PostEntity> postsByUserId) {
        this.postsByUserId = postsByUserId;
    }
}
