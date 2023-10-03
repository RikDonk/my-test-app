package nl.rikdonk.mytestapp.services.repositories;

import jakarta.persistence.EntityManager;
import nl.rikdonk.mytestapp.entities.Department;
import nl.rikdonk.mytestapp.services.repositories.interfaces.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

    private EntityManager entityManager;

    @Autowired
    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Department> findAll() {
        // create a query
        var theQuery = entityManager.createQuery("from Department", Department.class);

        // execute query and get result list
        var departments = theQuery.getResultList();

        return departments;
    }

    @Override
    public Department findById(int theId) {
        var theDepartment = entityManager.find(Department.class, theId);
        return theDepartment;
    }

    @Override
    public Department save(Department theEmployee) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }
}
