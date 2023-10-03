package nl.rikdonk.mytestapp.services;

import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.services.repositories.interfaces.ICompanyRepository;
import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.services.interfaces.ICompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    private ICompanyRepository repo;

    public CompanyService(ICompanyRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Company> findAll() {
        return repo.findAll();
    }

    @Override
    public Company findById(int theId) {
        return repo.findById(theId).get();
    }

    @Override
    @Transactional
    public Company save(Company theCompany) {
        return repo.save(theCompany);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        repo.deleteById(theId);
    }
}
