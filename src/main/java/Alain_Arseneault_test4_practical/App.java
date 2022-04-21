/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alain_Arseneault_test4_practical;

import Alain_Arseneault_test4_practical.entities.Square_Arseneault;
import Alain_Arseneault_test4_practical.entities.Triangle_Arseneault;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alars
 */
public class App {

    //sinlge table inheritance means that all the classes in that inherit will be mapped to one table
    public void Run() {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("alain_arseneault_test4_PU");
            em = emf.createEntityManager();
            Logger.getLogger(App.class.getName()).log(Level.INFO, "Entity Manager created (" + emf + ")");
            em.getTransaction().begin();
            
            Triangle_Arseneault a = new Triangle_Arseneault();
            a.setBase(12);
            a.setHeight(2);
            a.areaCalc();
            
            Square_Arseneault t = new Square_Arseneault();
            t.setTheLength(12);
            t.setWidth(2);
            t.areaCalc();
            em.persist(a);
            em.persist(t);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (emf != null) {
                emf.close();
            }

        }
    }
}
