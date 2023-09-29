package nl.rikdonk.mytestapp.services;

import nl.rikdonk.mytestapp.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
