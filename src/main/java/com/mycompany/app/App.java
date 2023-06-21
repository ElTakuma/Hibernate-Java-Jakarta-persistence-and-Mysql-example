package com.mycompany.app;

import com.mycompany.app.model.entity.Personne;
import com.mycompany.app.model.repository.EmployeeRepository;
import com.mycompany.app.model.repository.PersonneRepository;
import com.mycompany.app.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


/**
 * Hibernate Java Jakarta Persistence and Mysql Example
 *
 * @author  Roméo Tatchemo
 * @version 1.0
 * @since   2023-05-10
 */
public class App {


    public static void main(String[] args) {
        // Running hibernate on app run
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        } catch (Exception e) {
        }

        PersonneRepository personneRepository = new PersonneRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();

//        Personne personne = personneRepository.findOne(Long.valueOf(2));
//        personne.setLastName("Tatchum");
//        System.out.println(personne);
//        personneRepository.update(personne);
//        System.out.println(personne);
//        personneRepository.save(new Personne("Romeo", "gerar", LocalDate.of(1985,9,21), "paris", 'M'));
    }
}
