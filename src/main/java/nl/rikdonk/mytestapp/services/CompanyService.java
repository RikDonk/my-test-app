package nl.rikdonk.mytestapp.services;

import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.dto.CompanyDTO;
import nl.rikdonk.mytestapp.dto.CompanyListDTO;
import nl.rikdonk.mytestapp.dto.converters.CompanyDTOConverter;
import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.entities.Department;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.repositories.interfaces.ICompanyRepository;
import nl.rikdonk.mytestapp.services.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repoCompany.findByIdWithDepartments(theId);
    }

    @Override
    @Transactional
    public Company save(Company company) {
        return repoCompany.save(company);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        repoCompany.deleteById(theId);
    }
}
