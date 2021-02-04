package filter;

import java.util.List;
import model.Person;

public interface FilterInterface {
  List<Person> filter(List<Person> personList);
}
