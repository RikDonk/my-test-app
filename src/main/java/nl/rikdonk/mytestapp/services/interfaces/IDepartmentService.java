package nl.rikdonk.mytestapp.services.interfaces;

import nl.rikdonk.mytestapp.dto.DepartmentDTO;
import nl.rikdonk.mytestapp.dto.DepartmentListDTO;
import nl.rikdonk.mytestapp.entities.Department;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentListDTO> findAll(int companyId);

    DepartmentDTO findById(int theId);

    Department save(Department theDepartment);

    void deleteById(int theId);
}
