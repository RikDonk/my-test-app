package nl.rikdonk.mytestapp.controllers;

import nl.rikdonk.mytestapp.entities.Department;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.services.interfaces.IDepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {

    private IDepartmentService departmentService;

    public DepartmentRestController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/departments/{departmentId}")
    public Department getDepartment(@PathVariable int departmentId) {

        var theDepartment = departmentService.findById(departmentId);
        if(theDepartment == null){
            throw new NotFoundException("Department id not found - " + departmentId);
        }

        return theDepartment;
    }

    @GetMapping("/departments/{departmentId}/employees")
    public Department getDepartmentWithEmployees(@PathVariable int departmentId) {
        var theDepartment = departmentService.findById(departmentId);
        if(theDepartment == null){
            throw new NotFoundException("Department id not found - " + departmentId);
        }

        return theDepartment;
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department theDepartment) {

        theDepartment.setId(0); // only with a new Department
        var dbDepartment = departmentService.save(theDepartment);
        return dbDepartment;
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department theDepartment) {

        var dbDepartment = departmentService.save(theDepartment);
        return dbDepartment;
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable int DepartmentId) {
        var tempDepartment = departmentService.findById(DepartmentId);

        if(tempDepartment == null) {
            throw new NotFoundException("Department id not found - " + DepartmentId);
        }

        departmentService.deleteById(DepartmentId);

        return "Deleted Department id - " + DepartmentId;
    }

}
