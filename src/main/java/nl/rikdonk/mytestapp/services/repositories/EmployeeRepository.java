package nl.rikdonk.mytestapp.services.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import nl.rikdonk.mytestapp.entities.Employee;
import nl.rikdonk.mytestapp.services.repositories.interfaces.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    // define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public EmployeeRepository(EntityManager entityManager) {
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

    @Override
    public List<Employee> findEmployeesByDepartmentId(int theId) {

        TypedQuery<Employee> query = entityManager.createQuery(
                "from Employee where department.id = :data", Employee.class
        );

        query.setParameter("data", theId);
        List<Employee> employees = query.getResultList();


        return employees;
    }
}
