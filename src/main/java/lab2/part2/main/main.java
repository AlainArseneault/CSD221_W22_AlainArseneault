/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.part2.main;
import lab2.part2.domain.Customer;
import lab2.part2.domain.Employee;
import lab2.part2.domain.Person;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lab2.part2.domain.Customer;
import lab2.part2.domain.Person;

/**
 *
 * @author alars
 */
public class main {
     public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        
        try{
            emf=Persistence.createEntityManagerFactory("DEFAULT_PU");
            em=emf.createEntityManager();
            Logger.getLogger(main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
            em.getTransaction().begin();
            //you would create entities here
            Person p1 = new Person();
            p1.setFirstName("Alain");
            p1.setLastName("Arseneault");
            p1.setSIN(123);
            Customer p2 = new Customer();
            p2.setFirstName("Fred");
            p2.setLastName("Carella");
            p2.setSIN(456);
            p2.setCredit_card_number("123123123");
            p2.setCust_id("1");
            
            
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
            List<Person> ListOfPersons = em.createQuery("SELECT c FROM Person c").getResultList();
            
            
            System.out.println("List of Persons");
            for(Person Person:ListOfPersons){
                System.out.println(Person.getFirstName()+ " "+Person.getLastName());
            }
            
            
            
        }catch(Exception e){
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(emf!=null)
                emf.close();
//            if(em!=null)
//                em.close();
        }
    }
}
