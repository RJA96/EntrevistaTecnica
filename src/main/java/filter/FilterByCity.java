package filter;

import java.util.List;
import lombok.AllArgsConstructor;
import model.Person;

@AllArgsConstructor
public class FilterByCity implements FilterInterface {
  private final String cityToCompare;

  @Override
  public List<Person> filter(final List<Person> personList) {
    personList.removeIf(person -> !person.getCity().equals(cityToCompare));
    return personList;
  }
}
