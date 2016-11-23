package DB.DAL;

import DB.Entities.PostEntity;
import DB.Entities.UserEntity;
import UI.ViewModels.PostViewModel;
import UI.ViewModels.UserViewModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import BO.Converter;


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
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(this.post);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Collection<PostEntity> findPostsByUser(UserViewModel usr) {
        entityManager = entityManagerFactory.createEntityManager();
        UserEntity user = entityManager.find(UserEntity.class,usr.getUserId());
        Collection<PostEntity> posts = user.getPosts();
        entityManager.close();
        return posts;
    }
}
