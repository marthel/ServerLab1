package DB.DAL;

import DB.Entities.PostEntity;
import DB.Entities.UserEntity;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import BO.Converter;


/**
 * Created by Marthin on 2016-11-11.
 */
public class PostDb {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private PostEntity post;

    public PostDb() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
    }

    public void addPost(PostViewModel post) {
        this.post = Converter.convertToPostEntity(post);
        this.post.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));

        System.out.println("creator: " + this.post.getUser().getUsername() + " post: " + this.post.getBody() + " creation date: " + this.post.getCreationDate());
        System.out.println("\n id:" + this.post.getUser().getUserId());

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Collection<PostEntity> findAllPosts(UserViewModel usr) {
        //add follow posts
        return null;
    }
    public Collection<PostEntity> findYourPosts(UserViewModel usr) {
        entityManager = entityManagerFactory.createEntityManager();
        UserEntity user = entityManager.find(UserEntity.class,usr.getUserId());
        Collection<PostEntity> posts = user.getPosts();
        entityManager.close();
        return posts;
    }
}
