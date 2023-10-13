package nl.rikdonk.mytestapp.services;

import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.dto.DepartmentDTO;
import nl.rikdonk.mytestapp.dto.DepartmentListDTO;
import nl.rikdonk.mytestapp.dto.converters.DepartmentDTOConverter;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.repositories.interfaces.IDepartmentRepository;
import nl.rikdonk.mytestapp.entities.Department;
import nl.rikdonk.mytestapp.services.interfaces.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository repoDepartment;

    @Autowired
    DepartmentDTOConverter departmentDTOConverter;

    public DepartmentService(IDepartmentRepository repoDepartment) {
        this.repoDepartment = repoDepartment;
    }

    @Override
    public List<DepartmentListDTO> findAll(int companyId) {
        List<Department> departments = repoDepartment.findAll(companyId);
        return departmentDTOConverter.mapList(departments, DepartmentListDTO.class);
    }

    @Override
    public DepartmentDTO findById(int theId) {
        DepartmentDTO department = null;

        department = departmentDTOConverter.convert(repoDepartment.findByIdWithEmployees(theId));

        if(department == null) {
            throw new NotFoundException("Department not found - " + theId);
        }

        return department;
    }

    @Override
    @Transactional
    public Department add(Department theDepartment) {
        return repoDepartment.save(theDepartment);
    }

    @Override
    public Department update(Department theDepartment) {
        return null;
    }


    @Override
    @Transactional
    public void deleteById(int theId) {
        repoDepartment.deleteById(theId);
    }
}
