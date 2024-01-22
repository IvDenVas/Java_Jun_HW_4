package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Service {
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    Session session;

    public Service() {
    }
    public void save(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course course = Course.create();
        session.save(course);
        System.out.println("Объект успешно сохранен!");
        commitSession();
    }
    public void read(int numId){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course retrievedCourse = session.get(Course.class,numId);
        if(retrievedCourse != null){
            System.out.println("Найденный объект: " + retrievedCourse);
            commitSession();
        } else System.out.println("Такого объекта нет!");
    }
    public void delete(int numId){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course retrievedCourse = session.get(Course.class,numId);
        if(retrievedCourse != null) {
            session.delete(retrievedCourse);
            System.out.println("Объект успешно удален!");
            commitSession();
        } else System.out.println("Такого объекта нет!");
    }
    public void update(int numId){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course retrievedCourse = session.get(Course.class,numId);
        if(retrievedCourse != null) {
            retrievedCourse.updateDuration();
            retrievedCourse.updateTitle();
            session.update(retrievedCourse);
            commitSession();
        } else System.out.println("Такого объекта нет!");
    }

    public void commitSession() {
        session.getTransaction().commit();
        System.out.println("Transaction commit successfully");
    }

}
