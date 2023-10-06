package nl.rikdonk.mytestapp.dto.converters;

import nl.rikdonk.mytestapp.dto.DepartmentDTO;
import nl.rikdonk.mytestapp.entities.Department;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDTOConverter extends DTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDTO convert(Department department) {

        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);

        return departmentDTO;
    }

    public Department reverse(DepartmentDTO departmentDTO) {

        Department department = modelMapper.map(departmentDTO, Department.class);

        return department;
    }
}
