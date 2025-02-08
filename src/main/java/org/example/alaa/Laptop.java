package org.example.alaa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int ram;

//    @ManyToOne
//    @JoinColumn(name = "alien_id")
    @ManyToMany
    private List<Alien> aliens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }


    @Override
    public String toString() {
        return "Laptop{" +
                "ram=" + ram +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", id=" + id +
                '}';
    }
}
