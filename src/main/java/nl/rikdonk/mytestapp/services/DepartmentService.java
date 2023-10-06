package nl.rikdonk.mytestapp.services;

import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.repositories.interfaces.IDepartmentRepository;
import nl.rikdonk.mytestapp.entities.Department;
import nl.rikdonk.mytestapp.services.interfaces.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository repoDepartment;

    public DepartmentService(IDepartmentRepository repoDepartment) {
        this.repoDepartment = repoDepartment;
    }

    @Override
    public List<Department> findAll() {
        return repoDepartment.findAll();
    }

    @Override
    public Department findById(int theId) {
        Department department = null;

        department = repoDepartment.findByIdWithEmployees(theId);

        if(department == null) {
            throw new NotFoundException("Department not found - " + theId);
        }

        return department;
    }

    @Override
    @Transactional
    public Department save(Department theDepartment) {
        return repoDepartment.save(theDepartment);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        repoDepartment.deleteById(theId);
    }
}
