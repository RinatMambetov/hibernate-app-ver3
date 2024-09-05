package dev.rinat.hibernateApp3;

import dev.rinat.hibernateApp3.model.Passport;
import dev.rinat.hibernateApp3.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class).buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();

            Person person = new Person("Rinat", 23);
            Passport passport = new Passport(123);
            person.setPassport(passport);
            currentSession.persist(person);

//            Person person = currentSession.get(Person.class, 1);
//            System.out.println(person.getPassport().getPassportNumber());

//            Passport passport = currentSession.get(Passport.class, 1);
//            System.out.println(passport.getPerson().getName());

//            Person person = currentSession.get(Person.class, 1);
//            person.getPassport().setPassportNumber(777);

//            Person person = currentSession.get(Person.class, 1);
//            currentSession.remove(person);

            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
