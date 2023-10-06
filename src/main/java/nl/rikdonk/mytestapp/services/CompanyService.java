package nl.rikdonk.mytestapp.services;

import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.repositories.interfaces.ICompanyRepository;
import nl.rikdonk.mytestapp.services.interfaces.ICompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    private ICompanyRepository repoCompany;

    public CompanyService(ICompanyRepository repoCompany) {
        this.repoCompany = repoCompany;
    }

    @Override
    public List<Company> findAll() {
        return repoCompany.findAll();
    }

    @Override
    public Company findById(int theId) {
        Company Company = null;

        Company = repoCompany.findByIdWithDepartments(theId);

        if(Company == null) {
            throw new NotFoundException("Company not found - " + theId);
        }

        return Company;
    }

    @Override
    @Transactional
    public Company save(Company theCompany) {
        return repoCompany.save(theCompany);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        repoCompany.deleteById(theId);
    }
}
