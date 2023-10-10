package nl.rikdonk.mytestapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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
    private String Name;

    @OneToMany(mappedBy = "department", // mapped to department in Employee class
            fetch = FetchType.LAZY, // is the default
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}) // does not cascade delete
    //@JsonIgnore // prevent error 400
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Employee> employees;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}) // removes only the department, not the employee
    @JoinColumn(name="company_id") // column name in table Employee
    //@JsonBackReference // prevent Infinite recursion (StackOverFlowError)
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
