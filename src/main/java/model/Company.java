package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer idCompany;

  String name;

  String cuit;

  @OneToMany List<Person> people = new ArrayList<>();

  public void addPerson(Person person) {
    this.people.add(person);
  }

  @Builder
  public Company(String name, String cuit) {
    this.name = name;
    this.cuit = cuit;
  }
}
