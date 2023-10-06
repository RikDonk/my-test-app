package nl.rikdonk.mytestapp.repositories.interfaces;

import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.entities.Department;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartmentRepository {

    List<Department> findAll();

    Department findById(int theId);

    Department save(Department theEmployee);

    void deleteById(int theId);

    Department findByIdWithEmployees(int theId);

}
