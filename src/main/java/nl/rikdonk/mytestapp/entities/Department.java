package nl.rikdonk.mytestapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    @Size(min = 2, max = 45, message = "Department Name must be between 2 and 45 characters.")
    private String Name;

    @OneToMany(mappedBy = "department",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private List<Employee> employees;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="company_id")
    private Company company;

    public Department() {
    }

    public Department(int id, String name) {
        this.id = id;
        Name = name;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // add convenience methods for bi-directional relationship
    public void add (Employee tempEmployee) {
        if(employees == null) {
            employees = new ArrayList<>();
        }

        employees.add(tempEmployee);
        tempEmployee.setDepartment(this);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
