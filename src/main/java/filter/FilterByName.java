package filter;

import java.util.List;
import lombok.AllArgsConstructor;
import model.Person;

@AllArgsConstructor
public class FilterByName implements FilterInterface{
  private final String nameToCompare;
  @Override
  public List<Person> filter(final List<Person> personList) {
    personList.removeIf(person -> !person.getName().equals(nameToCompare));
    return personList;
  }
}
