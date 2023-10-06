package nl.rikdonk.mytestapp.dto.converters;

import nl.rikdonk.mytestapp.dto.CompanyDTO;
import nl.rikdonk.mytestapp.dto.DepartmentDTO;
import nl.rikdonk.mytestapp.entities.Company;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyDTOConverter extends DTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public CompanyDTO convert(Company company) {
        CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);

        companyDTO.setDepartments(mapList(company.getDepartments(), DepartmentDTO.class));

        return companyDTO;
    }

    public Company reverse(CompanyDTO companyDTO) {
        Company company = modelMapper.map(companyDTO, Company.class);

        return company;
    }

}
