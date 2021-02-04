package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;

public class AbstractDao<T> {

  protected final Class<T> entityClass;
  protected EntityManager entityManager;

  public AbstractDao(Class<T> entityClass, EntityManager entityManager) {
    this.entityClass = entityClass;
    this.entityManager = entityManager;
  }

  protected EntityManager getEntityManager() {
    return entityManager;
  }

  public void create(T entity) {
    getEntityManager().getTransaction().begin();
    getEntityManager().persist(entity);
    getEntityManager().getTransaction().commit();
  }

  public T find(Object id) throws NoResultException {
    try {
      return getEntityManager().find(entityClass, id);
    } catch (NoResultException noResultException) {
      throw new NoResultException("not found in dataBase");
    }
  }

  public List<T> findAll() {
    CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

  public void close() {
    entityManager.close();
  }
}
