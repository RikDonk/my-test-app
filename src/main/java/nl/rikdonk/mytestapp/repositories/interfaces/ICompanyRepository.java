package nl.rikdonk.mytestapp.repositories.interfaces;

import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.entities.Department;

import java.util.List;

public interface ICompanyRepository {

    List<Company> findAll();

    Company findById(int theId);

    Company save(Company theEmployee);

    void deleteById(int theId);

    Company findByIdWithDepartments(int theId);
}
