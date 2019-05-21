package pl.coderslab.SpringCMS;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> returnAllCategories() {
        Query query = entityManager.createQuery("select b from Category b");
        List<Category> allCategories = query.getResultList();
        return allCategories;
    }

    public void addCategory(Category entity) {
        entityManager.persist(entity);
    }

    public void removeCategory(Long id){
        Category entity = entityManager.find(Category.class, id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public void editCategory(Category category){
        entityManager.merge(category);
    }

    public Category findCategoryById(Long id){
        return entityManager.find(Category.class, id);

    }
}
