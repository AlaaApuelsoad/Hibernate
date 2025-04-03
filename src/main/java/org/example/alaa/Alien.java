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

    /*
    fetch type eager
     */
    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", aName='" + aName + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }


    /*
    Fetch type lazy won't get the related entity
    Hibernate: select l1_0.aliens_id,l1_1.id,l1_1.brand,l1_1.model,l1_1.ram from laptop_alien_table l1_0
     join laptop l1_1 on l1_1.id=l1_0.laptops_id where l1_0.aliens_id=?

     */
//    @Override
//    public String toString() {
//        return "Alien{" +
//                "id=" + id +
//                ", aName='" + aName + '\'' +
//                ", tech='" + tech + '\'' +
//                '}';
//    }
}
