package nl.rikdonk.mytestapp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.repositories.interfaces.ICompanyRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository implements ICompanyRepository {

    private EntityManager entityManager;
    private Session session;

    public CompanyRepository(EntityManager entityManager, Session session) {
        this.entityManager = entityManager;
        this.session = session;
    }


    @Override
    public List<Company> findAll() {
        // create a query
        var theQuery = entityManager.createQuery(
                "select c FROM Company c " +
                        "left join fetch c.departments "
                , Company.class);

        // execute query and get result list
        var companies = theQuery.getResultList();

        return companies;
    }

    @Override
    public Company save(Company company) {
        company.getDepartments().stream().forEach(x -> x.setCompany(company));
        return entityManager.merge(company);
    }


    @Override
    public void deleteById(int companyId) {
        var company = entityManager.find(Company.class, companyId);
        entityManager.remove(company);
    }

    @Override
    public Company findByIdWithDepartments(int theId) {
        Company company;
        try {
            TypedQuery<Company> query = entityManager.createQuery(
                    "select c from Company c " +
                            "left join fetch c.departments " +
                            "where c.id = :data", Company.class
            );

            query.setParameter("data", theId);

            company = query.getSingleResult();
        }
        catch(NoResultException exc) {
            return null;
        }

        return company;
    }

    @Override
    public Boolean exists(int id) {

        if (entityManager.find(Company.class, id) != null) {
            return true;
        }

        return false;
    }

    @Override
    public Company findById(int theId) {
        return null;
    }
}
