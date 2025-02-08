package org.example.alaa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alien_table")
public class Alien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "alien_name")
    private String aName;
//    @Transient
    private String tech;

//    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "alien")
    @ManyToMany(cascade = CascadeType.PERSIST,mappedBy = "aliens",fetch = FetchType.LAZY)
    private List<Laptop> laptops;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", aName='" + aName + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
