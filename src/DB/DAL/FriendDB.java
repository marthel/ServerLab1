package DB.DAL;

import BO.Converter;
import DB.Entities.FriendEntity;
import DB.Entities.UserEntity;
import UI.ViewModels.FriendViewModel;
import UI.ViewModels.UserViewModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
/**
 * Created by waleedhassan on 22/11/16.
 */
public class FriendDB {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private FriendEntity friend;

    public FriendDB() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
    }
    public Collection<FriendEntity> findYourFriends(UserViewModel usr) {
        entityManager = entityManagerFactory.createEntityManager();
        UserEntity user = entityManager.find(UserEntity.class,usr.getUserId());
        Collection<FriendEntity> friends = user.getUserByFollowID();
        entityManager.close();
        return friends;
    }

    public void addFriend(FriendViewModel newFriend) {
        this.friend = Converter.convertToFriendEntity(newFriend);
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.friend);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
