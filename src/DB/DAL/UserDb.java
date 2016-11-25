package DB.DAL;

import DB.Entities.FollowEntity;
import DB.Entities.UserEntity;
import UI.ViewModels.UserViewModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

import BO.Converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


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
        Predicate p1 = cb.and(cb.equal(u.get("username"),this.user.getUsername()),cb.equal(u.get("password"),this.user.getPassword()));
        cq.where(p1);
        UserEntity usr = entityManager.createQuery(cq).getSingleResult();
        entityManager.close();
        return  usr;
    }

    public Collection<UserEntity> findUsersByName(UserViewModel user, String name) {
        this.user = Converter.convertToUserEntity(user);

        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> u = cq.from(UserEntity.class);

        Predicate p1 = cb.and(cb.notEqual(u.get("username"),this.user.getUsername()),cb.like(u.get("username"),"%"+name+"%"));

        UserEntity usr = entityManager.find(UserEntity.class,this.user.getUserId());
        Collection<FollowEntity> follows = usr.getFollow();
        if(follows.size()>0) {
            Collection<String> usrs = follows.stream().map(f -> f.getFollowing().getUsername()).collect(Collectors.toCollection(ArrayList::new));
            Expression<String> exp = u.get("username");
            Predicate p2 = cb.not(exp.in(usrs));
            cq.where(cb.and(p1,p2));
        } else {
            cq.where(p1);
        }

        Collection<UserEntity> users = entityManager.createQuery(cq).getResultList();
        entityManager.close();

        return  users;
    }
}
