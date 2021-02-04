package utils;

import errors.UniqueNumberException;
import filter.FilterByCity;
import filter.FilterByName;
import filter.FilterInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.NoResultException;
import lombok.NoArgsConstructor;
import model.Company;
import model.Person;
import service.CompanyService;
import service.CompanyServiceImpl;
import service.PersonService;
import service.PersonServiceImpl;

@NoArgsConstructor
public class MenuProcessor {
  private final PersonService personService = new PersonServiceImpl();
  private final CompanyService companyService = new CompanyServiceImpl();

  public void start() {
    Scanner sc = new Scanner(System.in);
    String option = "";
    while (!option.equals("0")) {
      System.out.println("Insert Number");
      System.out.println("0 - Exit");
      System.out.println("1 - Add Person");
      System.out.println("2 - Add Company");
      System.out.println("3 - Add person to Company");
      System.out.println("4 - Search people by filters");
      System.out.println("5 - List people");
      System.out.println("6 - List Companies");
      option = sc.next();
      switch (option) {
        case "0":
          break;
        case "1":
          {
            addPerson(sc);
            break;
          }
        case "2":
          addCompany(sc);
          break;
        case "3":
          addPersonToCompany(sc);
          break;
        case "4":
          {
            serchPeopleByFilters(sc);
            break;
          }
        case "5":
          {
            System.out.println(personService.findAll());
            break;
          }
        case "6":
          {
            System.out.println(companyService.findAll());
            break;
          }
        default:
          System.out.println("Command not found");
      }
    }
  }

  private void serchPeopleByFilters(Scanner sc) {
    List<FilterInterface> filterInterfaces = new ArrayList<>();
    String s = "";
    while (!s.equals("0")) {
      System.out.println("For add a name filter press 1");
      System.out.println("For add city filter press 2");
      System.out.println("For stop adding filters press 0");
      s = sc.next();
      if (s.equals("1")) {
        System.out.println("add the name you want to filter by");
        filterInterfaces.add(new FilterByName(sc.next()));
      } else if (s.equals("2")) {
        System.out.println("add the city you want to filter by");
        filterInterfaces.add(new FilterByCity(sc.next()));
      }
      System.out.println(personService.findAllByFilters(filterInterfaces));
    }
  }

  private void addPerson(Scanner sc) {
    System.out.println("Insert name");
    String name = sc.next();
    System.out.println("Insert city");
    String city = sc.next();
    System.out.println("Insert dni");
    String dni = sc.next();
    System.out.println("Insert number");
    String number = sc.next();
    try {
      System.out.println(
          personService.addPerson(
              Person.builder().name(name).city(city).number(number).dni(dni).build()));
    } catch (UniqueNumberException uniqueNumberException) {
      System.out.println(uniqueNumberException);
    }
  }

  private void addCompany(Scanner sc) {
    System.out.println("Company name");
    String name = sc.next();
    System.out.println("Company cuit");
    String cuit = sc.next();
    try {
      System.out.println(
          companyService.addCompany(Company.builder().name(name).cuit(cuit).build()));
    } catch (UniqueNumberException uniqueNumberException) {
      System.out.println(uniqueNumberException);
    }
  }

  private void addPersonToCompany(Scanner sc) {

    try {
      System.out.println("Company cuit");
      Company company = companyService.findByCuit(sc.next());
      System.out.println("Person dni");
      System.out.println(companyService.addPerson(company, sc.next()));
    } catch (NoResultException notFoundException) {
      System.out.println(notFoundException);
    }
  }
}
