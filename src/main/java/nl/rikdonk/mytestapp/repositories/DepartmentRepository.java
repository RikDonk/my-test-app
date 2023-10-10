package nl.rikdonk.mytestapp.repositories;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.entities.Department;
import nl.rikdonk.mytestapp.entities.Employee;
import nl.rikdonk.mytestapp.repositories.interfaces.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

    private EntityManager entityManager;

    @Autowired
    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Department> findAll(int companyId) {
        // create a query
        var query = entityManager.createQuery(
                "select c FROM Company c " +
                        "left join fetch c.departments " +
                        "where c.id = :data",
                Company.class);

        query.setParameter("data", companyId);

        // execute query and get result list
        var departments = query.getSingleResult().getDepartments();

        return departments;
    }

    @Override
    public Department findById(int theId) {
        var theDepartment = entityManager.find(Department.class, theId);
        return theDepartment;
    }

    @Override
    public Department findByIdWithEmployees(int theId) {
        TypedQuery<Department> query = entityManager.createQuery(
                "select d from Department d " +
                        "join fetch d.employees " +
                        "where d.id = :data",
                Department.class
        );

        query.setParameter("data", theId);

        return query.getSingleResult();
    }

    @Override
    public Department save(Department theEmployee) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }

}
