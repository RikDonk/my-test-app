package nl.rikdonk.mytestapp.services;

import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.dto.CompanyDTO;
import nl.rikdonk.mytestapp.dto.converters.CompanyDTOConverter;
import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.repositories.interfaces.ICompanyRepository;
import nl.rikdonk.mytestapp.services.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    private ICompanyRepository repoCompany;

    @Autowired
    CompanyDTOConverter companyDTOConverter;

    public CompanyService(ICompanyRepository repoCompany) {
        this.repoCompany = repoCompany;
    }

    @Override
    public List<CompanyDTO> findAll() {
        var companies = repoCompany.findAll();

        return companyDTOConverter.mapList(companies, CompanyDTO.class);
    }

    @Override
    public CompanyDTO findById(int theId) {
        Company company = null;

        company = repoCompany.findByIdWithDepartments(theId);

        if(company == null) {
            throw new NotFoundException("Company not found - " + theId);
        }

        CompanyDTO companyDTO = companyDTOConverter.convert(company);

        return companyDTO;
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
