package nl.rikdonk.mytestapp.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    @Size(min = 2, max = 45, message = "Company Name must be between 2 and 45 characters.")
    private String Name;

    @Column(name="city")
    @Size(min = 2, max = 45, message = "City Name must be between 2 and 45 characters.")
    private String City;

    @OneToMany(mappedBy = "company",
            fetch = FetchType.LAZY, // is the default
            cascade = {CascadeType.ALL})
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Department> departments;

    public Company() {
    }

    public Company(int id, String name, String city) {
        this.id = id;
        Name = name;
        City = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void add (Department tempDepartment) {
        if(departments == null) {
            departments = new ArrayList<>();
        }

        departments.add(tempDepartment);
        tempDepartment.setCompany(this);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Came='" + City + '\'' +
                '}';
    }
}

