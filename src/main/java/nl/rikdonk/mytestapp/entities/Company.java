package nl.rikdonk.mytestapp.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String Name;

    public Company() {
    }

    public Company(int id, String name) {
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

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}

