package nl.rikdonk.mytestapp.services.repositories.interfaces;

import nl.rikdonk.mytestapp.entities.Department;

import java.util.List;

public interface IDepartmentRepository {

    List<Department> findAll();

    Department findById(int theId);

    Department save(Department theEmployee);

    void deleteById(int theId);
}
