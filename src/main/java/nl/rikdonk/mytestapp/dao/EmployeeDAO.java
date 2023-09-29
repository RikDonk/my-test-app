package nl.rikdonk.mytestapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO implements IEmployeeDAO{

    // define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        var theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        var employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        var theEmployee = entityManager.find(Employee.class, theId);
        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        var dbEmployee = entityManager.merge(theEmployee);
        // return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find employee by id
        var theEmployee = entityManager.find(Employee.class, theId);
        // remove employee
        entityManager.remove(theEmployee);
    }
}
