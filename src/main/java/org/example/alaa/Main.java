package org.example.alaa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;


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
//        Transaction tx = session.beginTransaction();
//        session.persist(a1);
//        session.persist(a2);
//        tx.commit();


        /*
        Hibernate first level cache (Session cache)
        enabled by default and works within the same session
         */
//        Alien alien1 = session.get(Alien.class,1); // hit the database
//        Alien alien2 = session.get(Alien.class,1); // retrieved from cache (no db call)
//        System.out.println(alien1);
//        System.out.println(alien2);


        /*
        Hibernate Query Language

        select * from laptop where ram = 32 --> sql
        from laptop where ram=32 --> hql using hibernate query
         */

        String brandName = "Asus";

        Query query = session.createQuery("from Laptop where brand LIKE :brandName");
        query.setParameter("brandName", "%" + brandName + "%");
        List<Laptop> laptopList = query.getResultList();
        System.out.println(laptopList);

//        Laptop l1 = session.get(Laptop.class,1);
//        System.out.println(l1);
//
//        Laptop laptop2 = session.load(Laptop.class,2); // will not hit the query until using the object -- deprecated use byId instead
////        System.out.println(laptop2);
//
//        Laptop laptop3 = session.byId(Laptop.class).getReference(3);
////        System.out.println(laptop3);

        System.out.println("****************************************");
        System.out.println("Level 2 cache");
        /*
        Implement level 2 cache using EHchace
        caching across multiple sessions

         */
        Laptop laptop1 = session.get(Laptop.class, 1);
        System.out.println(laptop1);

        session.close();

        Session session1 = sf.openSession();
        Laptop laptop2 = session1.get(Laptop.class, 1);
        System.out.println(laptop2);

        session1.close();

//        //Opening a new session to fire a select query
//        Session session1 = sf.openSession();
//        Alien alien = session1.get(Alien.class, 1);
//        System.out.println(alien);
//
//        sf.close();

    }
}