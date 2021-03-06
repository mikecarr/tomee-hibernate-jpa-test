package tomee.hibernate.jpa.test.service;

import org.apache.commons.lang.Validate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * User: mcarr
 * Date: 10/31/12
 */
public abstract class HibernateBaseService<T> implements BaseService<T>
{
    @PersistenceContext
    protected EntityManager entityManager;

    /* (non-Javadoc)
     * @see com.qualcomm.service.BaseService#findAll(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll(Class<T> type)
    {
        Validate.notNull(type, "Model type is required");
        Validate.isTrue(type.isAnnotationPresent(Entity.class), "Only javax.persistence.Entity objects can be found");
        String queryString = "from " + type.getCanonicalName() + " model";
        return Collections.checkedList(entityManager.createQuery(queryString).getResultList(), type);
    }

    /* (non-Javadoc)
     * @see com.qualcomm.service.BaseService#findByPK(java.lang.Class, java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
    @Override
    public T findByPK(Class<T> type, Serializable key)
    {
        Validate.notNull(type, "Model type is required");
        Validate.isTrue(type.isAnnotationPresent(Entity.class), "Only javax.persistence.Entity objects can be found");
        Validate.notNull(key, "Primary Key is required");
        return (T) entityManager.find(type, key);
    }

    /*
	 * (non-Javadoc)
	 * @see com.qualcomm.service.BaseService#create(java.lang.Object)
	 */
    @Transactional
    @Override
    public T create(T modelObject)
    {
        validateModel(modelObject);
        this.entityManager.persist(modelObject);
        return modelObject;
    }

    /*
      * (non-Javadoc)
      * @see com.qualcomm.service.BaseService#update(java.lang.Object)
      */
    @Override
    @Transactional
    public T update(T modelObject)
    {
        validateModel(modelObject);
        return this.entityManager.merge(modelObject);
    }

    /*
      * (non-Javadoc)
      * @see com.qualcomm.service.BaseService#delete(java.lang.Object)
      */
    @Override
    @Transactional
    public void delete(T modelObject)
    {
        validateModel(modelObject);
        modelObject = this.entityManager.merge(modelObject);
        this.entityManager.remove(modelObject);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    public List<T> search(Criteria criteria)
    {
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    public T searchForUnique(Criteria criteria)
    {
        return (T)criteria.uniqueResult();
    }

    private void validateModel(T modelObject)
    {
        Validate.notNull(modelObject, "Model type is required");
        Validate.isTrue(modelObject.getClass().isAnnotationPresent(Entity.class), "Only javax.persistence.Entity objects can be found");
    }
}