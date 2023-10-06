package nl.rikdonk.mytestapp.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.repositories.interfaces.ICompanyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository implements ICompanyRepository {

    private EntityManager entityManager;

    public CompanyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Company> findAll() {
        // create a query
        var theQuery = entityManager.createQuery("FROM Company", Company.class);

        // execute query and get result list
        var companies = theQuery.getResultList();
        companies.stream().forEach(x -> x.setDepartments(new ArrayList<>()));

        return companies;
    }

    @Override
    public Company save(Company theEmployee) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }

    @Override
    public Company findByIdWithDepartments(int theId) {
        TypedQuery<Company> query = entityManager.createQuery(
                "select comp from Company comp " +
                        "inner join fetch comp.departments dep " +
                        "where comp.id = :data", Company.class
        );

        query.setParameter("data", theId);

        var company = query.getSingleResult();
        company.getDepartments().stream().forEach(x -> x.setEmployees(new ArrayList<>()));


        return company;
    }


    @Override
    public Company findById(int theId) {
        return null;
    }
}
