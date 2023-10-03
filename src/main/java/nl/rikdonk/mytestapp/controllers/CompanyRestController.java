package nl.rikdonk.mytestapp.controllers;

import nl.rikdonk.mytestapp.entities.Company;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.services.interfaces.ICompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyRestController {

    private ICompanyService CompanyService;

    public CompanyRestController(ICompanyService CompanyService) {
        this.CompanyService = CompanyService;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return CompanyService.findAll();
    }


}
