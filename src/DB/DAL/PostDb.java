package DB.DAL;

import DB.Entities.PostEntity;
import UI.ViewModels.PostViewModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.Calendar;

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

    public static PostEntity convertToPostEntity(PostViewModel p){
        PostEntity post = new PostEntity();
        post.setBody(p.getBody());
        post.setUserByUserId(UserDb.convertToUserEntity(p.getUser()));
        return post;
    }
    public void addPost(PostViewModel post) {
        this.post = convertToPostEntity(post);
        this.post.setCreationDate(new Date(Calendar.getInstance().getTime().getTime()));
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
