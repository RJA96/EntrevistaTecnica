package service;

import java.util.List;
import javassist.NotFoundException;
import javax.persistence.NoResultException;
import model.Company;
import model.Person;

public interface CompanyService {
  Company addCompany(Company company);

  List<Company> findAll();

  Company findById(Integer id);

  Company addPerson(Company company, String dni) throws NoResultException;

  Company findByCuit(String cuit);
}
