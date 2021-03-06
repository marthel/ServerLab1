package DB.DAL;

import BO.Converter;
import DB.Entities.FollowEntity;
import DB.Entities.UserEntity;
import UI.ViewModels.FollowViewModel;
import UI.ViewModels.UserViewModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

public class FollowDb {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private FollowEntity follow;

    public FollowDb() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
    }
    public Collection<FollowEntity> findYourFollows(UserViewModel usr, String name) {
        entityManager = entityManagerFactory.createEntityManager();
        UserEntity user = entityManager.find(UserEntity.class,usr.getUserId());
        Collection<FollowEntity> follows = user.getFollow();
        follows.removeIf(f -> !f.getFollowing().getUsername().contains(name));
        entityManager.close();
        return follows;
    }
    public void addFollower(FollowViewModel follow) {
        this.follow = Converter.convertToFollowEntity(follow);
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.follow);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
