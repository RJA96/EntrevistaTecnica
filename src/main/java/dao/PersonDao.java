package dao;

import errors.NotFoundException;
import errors.UniqueNumberException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import model.Person;

public class PersonDao extends AbstractDao<Person> {

  public PersonDao(EntityManager entityManager) {
    super(Person.class, entityManager);
  }

  public Person findByDni(String dni) {
    try {
      Query query = entityManager.createQuery("SELECT p from Person p where dni like :dni");
      query.setParameter("dni", dni);
      return (Person) query.getSingleResult();
    } catch (NoResultException noResultException) {
      throw new NotFoundException(
          "person not found, for add people to company need first add the person.");
    }
  }

  @Override
  public void create(Person entity) {
    try {
      super.create(entity);

    } catch (PersistenceException e) {
      throw new UniqueNumberException(
          "DNI is unique, if you see this error please check DNI number.");
    }
  }
}
