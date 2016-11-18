package DB.DAL;

import DB.Entities.UserEntity;
import UI.ViewModels.UserViewModel;
import org.omg.CORBA.UserException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Marthin on 2016-11-11.
 */
public class UserDb {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private UserEntity user;

    public UserDb() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
    }

    public static UserEntity convertToUserEntity(UserViewModel u){
        UserEntity user = new UserEntity();
        user.setUserId(u.getUserId());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        return user;
    }
    public void register(UserViewModel user){
        this.user = convertToUserEntity(user);
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public UserEntity authenticate(UserViewModel user){
        this.user = convertToUserEntity(user);
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> u = cq.from(UserEntity.class);
        Predicate p1 = cb.equal(u.get("username"),this.user.getUsername());
        Predicate p2 = cb.equal(u.get("password"),this.user.getPassword());
        cq.where(cb.and(p1,p2));
        //TypedQuery<UserEntity> q = entityManager.createQuery(cq);
        //int count = q.getResultList().size();
        //int count = entityManager.createQuery(cq).getResultList().size();
        UserEntity usr = entityManager.createQuery(cq).getSingleResult();
        entityManager.close();
        return  usr;
    }
}
