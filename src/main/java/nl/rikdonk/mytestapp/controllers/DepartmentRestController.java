package nl.rikdonk.mytestapp.controllers;

import nl.rikdonk.mytestapp.dto.DepartmentDTO;
import nl.rikdonk.mytestapp.dto.DepartmentListDTO;
import nl.rikdonk.mytestapp.entities.Department;
import nl.rikdonk.mytestapp.exceptions.NotFoundException;
import nl.rikdonk.mytestapp.services.interfaces.IDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {

    private IDepartmentService departmentService;

    public DepartmentRestController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // alle afdelingen van company met companyId
    @GetMapping("/departments/{companyId}")
    public ResponseEntity<List<DepartmentListDTO>> getDepartments(@PathVariable int companyId) {
        List<DepartmentListDTO> departments = departmentService.findAll(companyId);
        return new ResponseEntity<List<DepartmentListDTO>>(departments,HttpStatus.OK);
    }

    // afdeling met id
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable int departmentId) {

        var theDepartment = departmentService.findById(departmentId);
        if(theDepartment == null){
            throw new NotFoundException("Department id not found - " + departmentId);
        }

        return new ResponseEntity<DepartmentDTO>(theDepartment, HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}/employees")
    public DepartmentDTO getDepartmentWithEmployees(@PathVariable int departmentId) {
        var theDepartment = departmentService.findById(departmentId);
        if(theDepartment == null){
            throw new NotFoundException("Department id not found - " + departmentId);
        }

        return theDepartment;
    }

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department theDepartment) {

        theDepartment.setId(0); // only with a new Department
        var dbDepartment = departmentService.add(theDepartment);
        return dbDepartment;
    }

    @PutMapping("/department")
    public Department updateDepartment(@RequestBody Department theDepartment) {

        var dbDepartment = departmentService.update(theDepartment);
        return dbDepartment;
    }

    @DeleteMapping("/department/{departmentId}")
    public String deleteDepartment(@PathVariable int DepartmentId) {
        var tempDepartment = departmentService.findById(DepartmentId);

        if(tempDepartment == null) {
            throw new NotFoundException("Department id not found - " + DepartmentId);
        }

        departmentService.deleteById(DepartmentId);

        return "Deleted Department id - " + DepartmentId;
    }

}
