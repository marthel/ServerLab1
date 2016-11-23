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

public class followDb {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private FollowEntity follow;

    public followDb() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
    }
    public Collection<FollowEntity> findYourFollowers(UserViewModel usr) {
        entityManager = entityManagerFactory.createEntityManager();
        UserEntity user = entityManager.find(UserEntity.class,usr.getUserId());
        Collection<FollowEntity> followers = user.getFollowers();
        entityManager.close();
        return followers;
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
