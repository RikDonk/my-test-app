package nl.rikdonk.mytestapp.dto;

import nl.rikdonk.mytestapp.entities.Company;

import java.util.List;

public class DepartmentDTO {
    private int id;
    private String name;
    private Company company;
    private List<EmployeeDTO> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
