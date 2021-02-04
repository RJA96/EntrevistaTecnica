package service;

import dao.CompanyDao;
import dao.PersonDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import model.Company;
import utils.ApplicationContext;

public class CompanyServiceImpl implements CompanyService {
  private final ApplicationContext context = ApplicationContext.getInstance();
  private final EntityManager entityManager = context.getEntityManager();
  private final CompanyDao companyDao = new CompanyDao(entityManager);
  private final PersonDao personDao = new PersonDao(entityManager);

  @Override
  public Company addCompany(Company company) {
    companyDao.create(company);
    return company;
  }

  @Override
  public List<Company> findAll() {
    return companyDao.findAll();
  }

  @Override
  public Company findById(Integer id) {
    return companyDao.find(id);
  }

  @Override
  public Company addPerson(Company company, String dni) throws NoResultException {
    company.addPerson(personDao.findByDni(dni));
    return company;
  }

  @Override
  public Company findByCuit(String cuit) {
    return companyDao.findByCuit(cuit);
  }
}
