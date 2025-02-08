package org.example.alaa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop l = new Laptop();
        l.setBrand("Dell");
        l.setModel("Inspiron5570");
        l.setRam(16);

        Laptop l2 = new Laptop();
        l2.setBrand("Asus");
        l2.setModel("ZnBook");
        l2.setRam(16);
        
        Laptop l3 = new Laptop();
        l3.setBrand("Apple");
        l3.setModel("Macbook");
        l3.setRam(16);
        


        Alien a1 = new Alien();
        a1.setaName("Alaa");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l,l2));

        Alien a2 = new Alien();
        a2.setaName("Mohamed");
        a2.setTech("C++");
        a2.setLaptops(Arrays.asList(l3));

        l.setAliens(Arrays.asList(a1));
        l2.setAliens(Arrays.asList(a1));
        l3.setAliens(Arrays.asList(a2));



//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(Student.class);
//        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.persist(a1);
        session.persist(a2);
        tx.commit();
        session.close();

        //Opening a new session to fire a select query
        Session session1 = sf.openSession();
        Alien alien = session1.get(Alien.class, 1);
        System.out.println(alien);



        sf.close();


    }
}