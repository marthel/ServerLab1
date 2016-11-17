package DB.DAL;

import DB.Entities.PostEntity;
import UI.ViewModels.PostViewModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    private void setPost(PostViewModel post){
        this.post = new PostEntity();
        this.post.setBody(post.getBody());

    }
    public void addPost(PostViewModel post) {
        setPost(post);
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
