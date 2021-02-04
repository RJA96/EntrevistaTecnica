package dao;

import errors.NotFoundException;
import errors.UniqueNumberException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import model.Company;

public class CompanyDao extends AbstractDao<Company> {

  public CompanyDao(EntityManager entityManager) {
    super(Company.class, entityManager);
  }

  public Company findByCuit(String cuit) {
    try {
      Query query = entityManager.createQuery("SELECT c from Company c where cuit like :cuit");
      query.setParameter("cuit", cuit);
      return (Company) query.getSingleResult();
    } catch (NoResultException noResultException) {
      throw new NotFoundException("Company cuit not found");
    }
  }

  @Override
  public void create(Company entity) {
    try {
      super.create(entity);
    } catch (PersistenceException e) {
      throw new UniqueNumberException(
          "CUIT is unique, if you see this error please check CUIT number.");
    }
  }
}
