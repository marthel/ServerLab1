package DB.DAL;

import DB.Entities.UserEntity;
import UI.ViewModels.UserViewModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import BO.Converter;
import org.hibernate.criterion.MatchMode;

import java.util.Collection;

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

    public void register(UserViewModel user){
        this.user =  Converter.convertToUserEntity(user);
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public UserEntity authenticate(UserViewModel user){
        this.user = Converter.convertToUserEntity(user);
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> u = cq.from(UserEntity.class);
        Predicate p1 = cb.equal(u.get("username"),this.user.getUsername());
        Predicate p2 = cb.equal(u.get("password"),this.user.getPassword());
        cq.where(cb.and(p1,p2));
        UserEntity usr = entityManager.createQuery(cq).getSingleResult();
        entityManager.close();
        return  usr;
    }

    public Collection<UserEntity> findAllUsers(UserViewModel user) {
        this.user = Converter.convertToUserEntity(user);
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> u = cq.from(UserEntity.class);

        Predicate p1 = cb.notEqual(u.get("username"),this.user.getUsername());
        cq.where(p1);
        Collection<UserEntity> users = entityManager.createQuery(cq).getResultList();
        entityManager.close();

        return  users;
    }

    public Collection<UserEntity> findUsersByName(UserViewModel user, String name) {
        this.user = Converter.convertToUserEntity(user);
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> u = cq.from(UserEntity.class);

        Predicate p1 = cb.notEqual(u.get("username"),this.user.getUsername());
        Predicate p2 = cb.like(u.get("username"),"%"+name+"%");
        cq.where(cb.and(p1,p2));
        Collection<UserEntity> users = entityManager.createQuery(cq).getResultList();
        entityManager.close();

        return  users;
    }
}
