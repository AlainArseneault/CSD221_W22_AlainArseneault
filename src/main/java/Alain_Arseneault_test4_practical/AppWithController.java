/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alain_Arseneault_test4_practical;

import Alain_Arseneault_test4_practical.entities.Shape_Arseneault;
import Alain_Arseneault_test4_practical.entities.Square_Arseneault;
import Alain_Arseneault_test4_practical.entities.Triangle_Arseneault;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alars
 */
public class AppWithController {

        public void run(){
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("alain_arseneault_test4_PU");
            em = emf.createEntityManager();
            Logger.getLogger(App.class.getName()).log(Level.INFO, "Entity Manager created (" + emf + ")");
            em.getTransaction().begin();
            //creating data
            Triangle_Arseneault alban = new Triangle_Arseneault();
            alban.setBase(12);
            alban.setHeight(2);
            alban.areaCalc();
            
            Triangle_Arseneault toDelete = new Triangle_Arseneault();
            toDelete.setBase(122);
            toDelete.setHeight(222);
            toDelete.areaCalc();
            
            Square_Arseneault albert = new Square_Arseneault();
            albert.setTheLength(12);
            albert.setWidth(2);
            albert.areaCalc();
            
            Square_ArseneaultJpaController squareController = new Square_ArseneaultJpaController(emf);
            squareController.create(albert);
            
            Triangle_ArseneaultJpaController triangleController = new Triangle_ArseneaultJpaController(emf);
            triangleController.create(alban);
            triangleController.create(toDelete);
            
            //displaying editing data
            albert.setWidth(22);
            albert.areaCalc();
            squareController.edit(albert);
            
            //printing data
            //squares
            List<Square_Arseneault> ListOfSquares = squareController.findSquare_ArseneaultEntities();
            System.out.println("List of Squares");
            for (Shape_Arseneault pub : ListOfSquares) {
                System.out.println("area="+pub.getArea()+" id="+pub.getId());
            }
            //triangles
            List<Triangle_Arseneault> ListOfTriangles = triangleController.findTriangle_ArseneaultEntities();
            System.out.println("List of Triangles");
            for (Shape_Arseneault pub : ListOfTriangles) {
                System.out.println("area="+pub.getArea()+" id="+pub.getId());
            }
            //showing delete of triangle with id 3
            triangleController.destroy((long)3);
            //reprint to show delete
            ListOfTriangles = triangleController.findTriangle_ArseneaultEntities();
            System.out.println("List of Triangles After Delete");
            for (Shape_Arseneault pub : ListOfTriangles) {
                System.out.println("area="+pub.getArea()+" id="+pub.getId());
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (emf != null) {
                emf.close();
            }

        }
    }
}
