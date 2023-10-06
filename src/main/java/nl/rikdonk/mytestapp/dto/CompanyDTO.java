package nl.rikdonk.mytestapp.dto;

import java.util.List;

public class CompanyDTO {
    private int id;
    private String name;
    private List<DepartmentDTO> departments;

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

    public List<DepartmentDTO> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentDTO> departments) {
        this.departments = departments;
    }
}
