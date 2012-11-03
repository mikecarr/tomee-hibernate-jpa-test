package tomee.hibernate.jpa.test.service;

import java.io.Serializable;
import java.util.List;

/**
 * User: mcarr
 * Date: 10/31/12

 * Base service that provides base interface methods common
 * to all services.
 */
public interface BaseService<T> {
    /**
     * Find all of the objects of the given type.
     *
     * @param type the model type to find
     * @return a collection of all instances of the given type
     */
    public List<T> findAll(Class<T> type);

    /**
     * Find the model with the given id(PK).
     *
     * @param type the model type
     * @param id the pk
     * @return the model with the given id (PK) or null if no such model was found
     */
    public T findByPK(Class<T> type, Serializable id);

    /**
     * Create (save) the persistent model.
     *
     * @param modelObject the model to create
     */
    public void create(T modelObject);

    /**
     * Update the persistent state to reflect the model.
     *
     * @param modelObject the model to update
     */
    public void update(T modelObject);

    /**
     * Delete the persistent state for the model.
     *
     * @param modelObject the model to delete
     */
    public void delete(T modelObject);
}
