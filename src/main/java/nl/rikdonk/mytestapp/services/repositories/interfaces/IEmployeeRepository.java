package nl.rikdonk.mytestapp.services.repositories.interfaces;

import nl.rikdonk.mytestapp.entities.Employee;

import java.util.List;

public interface IEmployeeRepository {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

    List<Employee> findEmployeesByDepartmentId(int theId);
}
