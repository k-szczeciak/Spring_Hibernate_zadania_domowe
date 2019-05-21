package pl.coderslab.SpringCMS;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Author> returnAllAuthors() {
        Query query = entityManager.createQuery("select b from Author b");
        List<Author> allAuthors = query.getResultList();
        return allAuthors;
    }

    public void addAuthor(Author entity) {
        entityManager.persist(entity);
    }

    public void removeAuthor(Long id){
        Author entity = entityManager.find(Author.class, id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public void editAuthor(Author author){
        entityManager.merge(author);
    }

    public Author findAuthorById(Long id){
        return entityManager.find(Author.class, id);

    }
}
