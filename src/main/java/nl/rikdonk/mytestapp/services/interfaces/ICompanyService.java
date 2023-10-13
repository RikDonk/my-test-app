package nl.rikdonk.mytestapp.services.interfaces;

import nl.rikdonk.mytestapp.entities.Company;
import java.util.List;

public interface ICompanyService {
    List<Company> findAll();

    Company findById(int theId);

    Company save(Company theCompany);

    void deleteById(int theId);
}

