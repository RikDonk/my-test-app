package nl.rikdonk.mytestapp.dto;

import java.util.List;

public class CompanyDTO {
    private int id;
    private String name;
    private String city;
    private List<DepartmentListDTO> departments;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<DepartmentListDTO> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentListDTO> departments) {
        this.departments = departments;
    }

}
