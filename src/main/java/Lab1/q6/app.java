/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1.q6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aa
 */
public class app {
    Scanner input = new Scanner(System.in);
    Boolean done = false;
    ArrayList<Person> people = new ArrayList<Person>();
    public String menu = "1. Create Person \n"+"2. Display List \n" + "3. Remove Person \n" + "99. Exit";
    public void createPerson(){
        System.out.println("Enter First Name : ");
        String first = input.nextLine();
        first = input.nextLine();
        System.out.println("Enter Last Name  : ");
        String last = input.nextLine();
        System.out.println("Enter The Sin : ");
        int sin = input.nextInt();
        Person p = new Person(first,last,sin);
        people.add(p);
    }
    public void printList(){
        for (int x = 0; x < people.size(); x++) {
            System.out.println(people.get(x));
        }
    }
    public void removePerson(){
        System.out.println("Which car would you like to delete? (index) : ");
        int index = input.nextInt();
        people.remove(index);
    }
    public void end(){
        done = true;
    }
    public void run() {
        while (!done) {
            System.out.println(menu);
            int option = input.nextInt();

            switch (option) {
                case 1 :
                    createPerson();
                    break;
                case 2:
                    printList();
                    break;
                case 3: 
                    removePerson();
                    break;
                case 99:
                    end();
                    break;
            }
        }
    }
}
