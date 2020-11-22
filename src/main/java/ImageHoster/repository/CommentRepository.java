package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    //Persist comment in database
	public void addComment(Comment cmt) {
		// TODO Auto-generated method stub
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            //persist() method changes the state of the model object from transient state to persistence state
            em.persist(cmt);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
	}

	public List<Comment> getAllComments(int imageId) {
		// TODO Auto-generated method stub
        EntityManager em = emf.createEntityManager();
        //TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image.getId()=:imageId", Comment.class).setParameter("imageId", imageId);
        Query query=em.createQuery("select c from Comment c  JOIN c.image i where i.id=:imageId", Comment.class);
        query.setParameter("imageId", imageId);
        List<Comment> resultList =  query.getResultList();

        return resultList;
	}

}
