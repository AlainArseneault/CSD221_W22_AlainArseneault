/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import lab3.entities.*;
/**
 *
 * @author alars
 */
public class App {
    Scanner input = new Scanner(System.in);
    Boolean done = false;
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Magazine> magazines = new ArrayList<Magazine>();
    ArrayList<DiscMag> discmags = new ArrayList<DiscMag>();
    public String menu = "1. Add a Book \n"+
            "2. Edit a Book \n" + 
            "3. Delete a Book "
            + "\n4. Print Books "
            + "\n5. Add Magazine "
            + "\n6. Print Magazines "
            + "\n7. Add Disc Magazine"
            + "\n8. Print Disc Magazines "
            + "\n99. Exit";
    
    public void addBook(){
        Book temp = new Book();
        System.out.println("Enter the name of the book: \n");
        temp.setTitle(input.nextLine());
        temp.setTitle(input.nextLine());
        System.out.println("Enter the authors name: \n");
        temp.setAuthor(input.nextLine());
        System.out.println("Enter the number of copies: \n");
        temp.setCopies(input.nextInt());
        System.out.println("Enter the price of the book: \n");
        temp.setPrice(input.nextDouble());
        books.add(temp);
    }
    public void editBook(){
        for(int i = 0; i < books.size(); i++) {   
            System.out.print(i + ") " + books.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to edit? : ");
        int selection = input.nextInt();
        Book temp = new Book();
        System.out.println("Enter the name of the book: \n");
        temp.setTitle(input.nextLine());temp.setTitle(input.nextLine());
        System.out.println("Enter the authors name: \n");
        temp.setAuthor(input.nextLine());
        System.out.println("Enter the number of copies: \n");
        temp.setCopies(input.nextInt());
        System.out.println("Enter the price of the book: \n");
        temp.setPrice(input.nextDouble());
        books.set(selection, temp);
    }
    
    public void deleteBook(){
        for(int i = 0; i < books.size(); i++) {   
            System.out.print(i + ") " + books.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to edit? : ");
        int selection = input.nextInt();
        books.remove(selection);
        System.out.println(selection + " has been deleted.\n");
    }
    public void printBook(){
        for(int i = 0; i < books.size(); i++) {   
            System.out.print(i + ") " + books.get(i).getTitle());
        }
        System.out.println("\nWhick would you like to print information?\n");
        int selection = input.nextInt();
        System.out.println(books.get(selection));
        
    }
    public void addMag(){
        Magazine temp = new Magazine();
        System.out.println("Enter the Title: \n");
        temp.setTitle(input.nextLine());
        temp.setTitle(input.nextLine());
        System.out.println("Enter the price per unit: \n");
        temp.setPrice(input.nextDouble());
        System.out.println("Enter Number of copies: \n");
        temp.setCopies(input.nextInt());
        System.out.println("Setting Date.... ");
        Date thisDate = new Date();
        temp.setCurrIssue(thisDate);
        System.out.println("Date Set!");
        System.out.println("Enter Order Qty: ");
        temp.setOrderQty(input.nextInt());
        magazines.add(temp);
        
    }
    public void printMags(){
        for(int i = 0; i < magazines.size(); i++) {   
            System.out.print((i+1) +  ") " + magazines.get(i).getTitle());
        }
        System.out.println("\nWhick would you like to print information?\n");
        int selection = input.nextInt();
        selection -= 1;
        System.out.println(magazines.get(selection));
    }
        public void addDiscMag(){
        DiscMag temp = new DiscMag();
        System.out.println("Enter the Title: \n");
        temp.setTitle(input.nextLine());
        temp.setTitle(input.nextLine());
        System.out.println("Enter the price per unit: \n");
        temp.setPrice(input.nextDouble());
        System.out.println("Enter Number of copies: \n");
        temp.setCopies(input.nextInt());
        System.out.println("Setting Date.... ");
        Date thisDate = new Date();
        temp.setCurrIssue(thisDate);
        System.out.println("Date Set!");
        System.out.println("Enter Order Qty: ");
        temp.setOrderQty(input.nextInt());
        discmags.add(temp);
        
    }
    public void printDiscMags(){
        for(int i = 0; i < discmags.size(); i++) {   
            System.out.print((i+1) +  ") " + discmags.get(i).getTitle());
        }
        System.out.println("\nWhick would you like to print information?\n");
        int selection = input.nextInt();
        selection -= 1;
        System.out.println(discmags.get(selection));
    }
    public void Run(){
        while (!done){
            System.out.println(menu);
            
            int option = input.nextInt();
            
            
            switch(option){
                case 1:
                    addBook();
                    break;
                case 2: 
                    editBook();
                    break;
                case 3: 
                    deleteBook();
                    break;
                case 4: 
                    printBook();
                    break;
                case 5:
                    addMag();
                    break;
                case 6:
                    printMags();
                    break;
                case 7: 
                    addDiscMag();
                    break;
                case 8:
                    printDiscMags();
                    break;
                case 99:
                    done = true;
                    break;
            }
        }
    }
    
}
