/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.part2;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lab2.part2.entities.*;

/**
 *
 * @author alars
 */
public class Main2 {
     public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        
        try{
            emf=Persistence.createEntityManagerFactory("LAB2_PART2_DEFAULT_PU");
            em=emf.createEntityManager();
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
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
            
            Employee emp=new Employee();
            emp.setFirstName("First");
            emp.setLastName("Last");
            emp.setSIN(1234);
            emp.setTitle("Janitor");
            emp.setSalary("50000");
            
            em.persist(p1);
            em.persist(p2);
            em.persist(emp);
            em.getTransaction().commit();
 
            System.out.println("----------------------------------------------");
            List<Person> ListOfPersons = em.createQuery("SELECT c FROM Person c").getResultList();
            System.out.println("List of Persons");
            for(Person Person:ListOfPersons){
                System.out.println(Person.getFirstName()+ " "+Person.getLastName());
            }
            System.out.println("---------------------------------------------- ");
            List<Customer> ListOfCustomers = em.createQuery("SELECT c FROM Customer c").getResultList();
            System.out.println("List of Customers");
            for(Customer Customer:ListOfCustomers){
                System.out.println(Customer.getFirstName()+ " "+Customer.getLastName());
            }
            System.out.println("----------------------------------------------");
            System.out.println("Hello");
            List<Employee> ListOfEmployees = em.createQuery("SELECT c FROM Employee c").getResultList();
            System.out.println("List of Employees");
            for(Employee Employee:ListOfEmployees){
                System.out.println(Employee.getFirstName()+ " "+Employee.getLastName());
            }
            
            
        }catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(emf!=null)
                emf.close();
//            if(em!=null)
//                em.close();
        }
    }
}
