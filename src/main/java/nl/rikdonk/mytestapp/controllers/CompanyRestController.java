package nl.rikdonk.mytestapp.controllers;

import nl.rikdonk.mytestapp.dto.CompanyDTO;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.services.interfaces.ICompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompanyRestController {

    private ICompanyService companyService;

    public CompanyRestController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public List<CompanyDTO> getCompanies() {
        return companyService.findAll();
    }

    @GetMapping("/companies/{companyId}")
    public CompanyDTO getCompany(@PathVariable int companyId) {

        var theCompany = companyService.findById(companyId);
        if(theCompany == null){
            throw new NotFoundException("Company id not found - " + companyId);
        }

        return theCompany;
    }
}
