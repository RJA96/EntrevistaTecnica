package service;

import filter.FilterInterface;
import java.util.List;
import model.Person;

public interface PersonService {
  Person addPerson(Person p);

  List<Person> findAll();

  Person findById(Integer id);

  List<Person> findAllByFilters(List<FilterInterface> filterInterface);
}
