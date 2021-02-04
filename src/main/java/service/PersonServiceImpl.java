package service;

import dao.PersonDao;
import filter.FilterInterface;
import java.util.List;
import javax.persistence.EntityManager;
import model.Person;
import utils.ApplicationContext;

public class PersonServiceImpl implements PersonService {
  private final ApplicationContext context = ApplicationContext.getInstance();
  private final EntityManager entityManager = context.getEntityManager();
  private final PersonDao dao = new PersonDao(entityManager);

  @Override
  public Person addPerson(Person p) {
    dao.create(p);
    return p;
  }

  @Override
  public List<Person> findAll() {
    return dao.findAll();
  }

  @Override
  public Person findById(Integer id) {
    return dao.find(id);
  }

  @Override
  public List<Person> findAllByFilters(List<FilterInterface> filterInterfaces) {
    List<Person> people = findAll();
    filterInterfaces.forEach(filterInterface -> filterInterface.filter(people));
    return people;
  }
}
