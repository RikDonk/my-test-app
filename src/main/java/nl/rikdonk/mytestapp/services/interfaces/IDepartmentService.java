package nl.rikdonk.mytestapp.services.interfaces;

import nl.rikdonk.mytestapp.entities.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();

    Department findById(int theId);

    Department save(Department theDepartment);

    void deleteById(int theId);
}
