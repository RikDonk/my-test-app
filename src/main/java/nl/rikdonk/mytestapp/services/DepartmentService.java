package nl.rikdonk.mytestapp.services;

import jakarta.transaction.Transactional;
import nl.rikdonk.mytestapp.services.repositories.interfaces.IDepartmentRepository;
import nl.rikdonk.mytestapp.entities.Department;
import nl.rikdonk.mytestapp.services.interfaces.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository repo;

    public DepartmentService(IDepartmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Department> findAll() {
        return repo.findAll();
    }

    @Override
    public Department findById(int theId) {
        return repo.findById(theId);
    }

    @Override
    @Transactional
    public Department save(Department theDepartment) {
        return repo.save(theDepartment);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        repo.deleteById(theId);
    }
}
