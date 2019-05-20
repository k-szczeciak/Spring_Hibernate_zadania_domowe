package pl.coderslab.SpringCMS;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ArticleDao  {

    @PersistenceContext
    EntityManager entityManager;

    public List<Article> findAllArticles() {
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY created DESC");
        query.setMaxResults(5);
        return query.getResultList();
    }

    public List<Article> allArticlesByCategory(Long id){
        Query query = entityManager.createQuery("select a from Article a where category.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }



}
