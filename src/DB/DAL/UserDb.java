package DB.DAL;

import DB.Entities.UserEntity;
import UI.ViewModels.UserViewModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
    private void setUser(UserViewModel user){
        this.user = new UserEntity();
        this.user.setUsername(user.getUsername());
        this.user.setPassword(user.getPassword());
    }
    public void register(UserViewModel user){
        setUser(user);
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public boolean authenticate(UserViewModel user){
        setUser(user);
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> u = cq.from(UserEntity.class);
        Predicate p1 = cb.equal(u.get("username"),this.user.getUsername());
        Predicate p2 = cb.equal(u.get("password"),this.user.getPassword());
        cq.where(cb.and(p1,p2));
        //TypedQuery<UserEntity> q = entityManager.createQuery(cq);
        //int count = q.getResultList().size();
        int count = entityManager.createQuery(cq).getResultList().size();
        entityManager.close();
        return  count > 0;
    }
}
