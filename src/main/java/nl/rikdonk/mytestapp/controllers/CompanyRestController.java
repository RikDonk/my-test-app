package nl.rikdonk.mytestapp.controllers;

import nl.rikdonk.mytestapp.dto.CompanyDTO;
import nl.rikdonk.mytestapp.dto.CompanyListDTO;
import nl.rikdonk.mytestapp.dto.converters.CompanyDTOConverter;
import nl.rikdonk.mytestapp.exceptions.ErrorResponse;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.services.interfaces.ICompanyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyRestController {

    private ICompanyService companyService;
    @Autowired
    private CompanyDTOConverter companyDTOConverter;

    public CompanyRestController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public ResponseEntity<List<CompanyListDTO>> getCompanies() {

        var companies =companyDTOConverter.mapList(companyService.findAll(), CompanyListDTO.class);
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable int companyId) {

        var company = companyService.findById(companyId);

        if(company == null){
            throw new NotFoundException("Company id not found: " + companyId);
        }

        var companyDTO = companyDTOConverter.convert(company);

        return ResponseEntity.ok(companyDTO);
    }

    @PostMapping()
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDTO) {

        var company = companyDTOConverter.reverse(companyDTO);
        var savedCompany = companyService.save(company);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCompany.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping()
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO) {

        var company = companyDTOConverter.reverse(companyDTO);
        var savedCompany = companyService.save(company);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCompany.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable int companyId) {
        companyService.deleteById(companyId);
    }

}
