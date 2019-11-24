package blog.com.repository.impl;

import blog.com.model.Blog;
import blog.com.repository.BlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepositoryImpl implements BlogRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List findAll() {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(long id) {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c where  c.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Blog model) {
        if(model.getId() != null){
            em.merge(model);
        } else {
            em.persist(model);
        }
    }
    @Override
    public void remove(long id) {
        Blog blog = findById(id);
        if(blog != null){
            em.remove(blog);
        }
    }
    }

