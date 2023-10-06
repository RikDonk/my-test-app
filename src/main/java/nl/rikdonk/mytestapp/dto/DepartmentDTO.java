package nl.rikdonk.mytestapp.dto;

import jakarta.persistence.Column;

public class DepartmentDTO {
    private int id;

    private String Name;

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
}
