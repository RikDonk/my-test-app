package nl.rikdonk.mytestapp.dao;

import nl.rikdonk.mytestapp.entities.Employee;

import java.util.List;

public interface IEmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
