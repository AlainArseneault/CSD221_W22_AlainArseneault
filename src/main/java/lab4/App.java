/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import lab3.entities.*;

/**
 *
 * @author alars
 */
public class App {

    CashTill total = new CashTill();
    boolean done = false;
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Magazine> magazines = new ArrayList<Magazine>();
    Scanner input = new Scanner(System.in);

    String menu = "--------------------" + "\nMain" + "\n--------------------"
            + "\n1. Books"
            + "\n2. Tickets"
            + "\n3. Magazines"
            + "\n98. Show Total"
            + "\n99. Quit"
            + "\n--------------------";
    String booksMenu = "--------------------" + "\nBooks" + "\n--------------------"
            + "\n1. Add a Book"
            + "\n2. Edit a Book"
            + "\n3. Delete a Book"
            + "\n4. Sell a Book"
            + "\n5. Print a Book"
            + "\n98. Show Total"
            + "\n99. Quit";
    String ticketsMenu = "--------------------" + "\nTickets " + "\n--------------------"
            + "\n1. Sell Tickets"
            + "\n98. Show Total"
            + "\n99. Quit"
            + "\n--------------------";
    String magazineMenu = "--------------------" + "\nMagazines" + "\n--------------------"
            + "\n1. Add a Magazine"
            + "\n2. Edit a Magazine"
            + "\n3. Delete a Magazine"
            + "\n4. Sell a Magazine"
            + "\n5. Print a Magazine"
            + "\n98. Show Total"
            + "\n99. Quit"
            + "\n--------------------";

    public void addBook() {
        Book temp = new Book();
        System.out.println("Enter Author Name: \n");
        temp.setAuthor(input.nextLine());
        temp.setAuthor(input.nextLine());
        System.out.println("Qantity to Order: \n");
        temp.setCopies(input.nextInt());
        System.out.println("Enter Title: \n");
        temp.setTitle(input.nextLine());
        temp.setTitle(input.nextLine());
        System.out.println("Price: \n");
        temp.setPrice(input.nextDouble());
        books.add(temp);
    }

    public void editBook() {
        for (int i = 0; i < books.size(); i++) {
            System.out.print(i + 1 + ") " + books.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to edit? : ");
        int selection = input.nextInt() - 1;
        Book temp = new Book();
        System.out.println("Enter Author Name: \n");
        temp.setAuthor(input.nextLine());
        temp.setAuthor(input.nextLine());
        System.out.println("Qantity to Order: \n");
        temp.setCopies(input.nextInt());
        System.out.println("Enter Title: \n");
        temp.setTitle(input.nextLine());
        System.out.println("Price: \n");
        temp.setPrice(input.nextDouble());
        books.set(selection, temp);
    }

    public void deleteBook() {
        for (int i = 0; i < books.size(); i++) {
            System.out.print(i + 1 + ") " + books.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to delete? : ");
        int selection = input.nextInt() - 1;
        while (selection > books.size()) {
            System.out.println("Invalid Selection, try again!");
            for (int i = 0; i < books.size(); i++) {
                System.out.print("\n" + i + 1 + ") " + books.get(i).getTitle());
            }
            System.out.println("\nWhich would you like to delete? : ");
            selection = input.nextInt() - 1;
        }
        books.remove(selection);

    }

    public void sellBook() {
        for (int i = 0; i < books.size(); i++) {
            System.out.print(i + 1 + ") " + books.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to Sell? : ");
        int selection = input.nextInt() - 1;
        while (selection > books.size()) {
            System.out.println("Invalid Selection, try again!");
            for (int i = 0; i < books.size(); i++) {
                System.out.print("\n" + i + 1 + ") " + books.get(i).getTitle());
            }
            System.out.println("\nWhich would you like to sell? : ");
            selection = input.nextInt() - 1;
        }
        Book temp = books.get(selection);
        System.out.println("How many would you like to sell? : \n");
        int sellable = input.nextInt();
        while (sellable > temp.getCopies()) {
            System.out.println("Too large, try again:\n");
            sellable = input.nextInt();
        }
        total.sellItem(temp, sellable);
        System.out.println("Sold Books!");

        books.set(selection, temp);
    }

    public void printBook() {
        for (int i = 0; i < books.size(); i++) {
            System.out.print(i + 1 + ") " + books.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to print? : ");
        int selection = input.nextInt() - 1;
        while (selection > books.size()) {
            System.out.println("Invalid Selection, try again!");
            for (int i = 0; i < books.size(); i++) {
                System.out.print(i + 1 + ") " + books.get(i).getTitle());
            }
            System.out.println("\nWhich would you like to print? : ");
            selection = input.nextInt() - 1;
        }
        System.out.println(books.get(selection));
    }

    //End of books, Tickets start here
    public void sellTicket(int num, double price) {
        Ticket temp = new Ticket();
        temp.setPrice(price);
        total.sellItem(temp, num);
        System.out.println(num + " tickets sold at " + price + "$");
    }

    //end of Tickets, start of Magazine
    public void addMagazine() {
        Magazine temp = new Magazine();
        System.out.println("Enter Qty in stock: \n");
        temp.setCopies(input.nextInt());
        System.out.println("Qantity to Order: \n");
        temp.setOrderQty(input.nextInt());
        System.out.println("Enter Title: \n");
        temp.setTitle(input.nextLine());
        temp.setTitle(input.nextLine());
        System.out.println("Price: \n");
        temp.setPrice(input.nextDouble());
        magazines.add(temp);
    }

    public void editMagazine() {
        for (int i = 0; i < magazines.size(); i++) {
            System.out.print(i + 1 + ") " + magazines.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to edit? : ");
        int selection = input.nextInt() - 1;
        Magazine temp = new Magazine();
        System.out.println("Enter Qty in stock: \n");
        temp.setCopies(input.nextInt());
        System.out.println("Qantity to Order: \n");
        temp.setOrderQty(input.nextInt());
        System.out.println("Enter Title: \n");
        temp.setTitle(input.nextLine());
        temp.setTitle(input.nextLine());
        System.out.println("Price: \n");
        temp.setPrice(input.nextDouble());
        magazines.set(selection, temp);
    }

    public void deleteMagazine() {
        for (int i = 0; i < magazines.size(); i++) {
            System.out.print(i + 1 + ") " + magazines.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to delete? : ");
        int selection = input.nextInt() - 1;
        while (selection > magazines.size()) {
            System.out.println("Invalid Selection, try again!");
            for (int i = 0; i < magazines.size(); i++) {
                System.out.print("\n" + i + 1 + ") " + magazines.get(i).getTitle());
            }
            System.out.println("\nWhich would you like to delete? : ");
            selection = input.nextInt() - 1;
        }
        magazines.remove(selection);

    }

    public void sellMagazine() {
        for (int i = 0; i < magazines.size(); i++) {
            System.out.print(i + 1 + ") " + magazines.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to Sell? : ");
        int selection = input.nextInt() - 1;
        while (selection > magazines.size()) {
            System.out.println("Invalid Selection, try again!");
            for (int i = 0; i < magazines.size(); i++) {
                System.out.print("\n" + i + 1 + ") " + magazines.get(i).getTitle());
            }
            System.out.println("\nWhich would you like to sell? : ");
            selection = input.nextInt() - 1;
        }
        Magazine temp = magazines.get(selection);
        System.out.println("How many would you like to sell? : \n");
        int sellable = input.nextInt();
        while (sellable > temp.getCopies()) {
            System.out.println("Too large, try again:\n");
            sellable = input.nextInt();
        }
        total.sellItem(temp, sellable);
        System.out.println("Sold Magazines!");

        magazines.set(selection, temp);
    }

    public void printMagazine() {
        for (int i = 0; i < magazines.size(); i++) {
            System.out.print(i + 1 + ") " + magazines.get(i).getTitle());
        }
        System.out.println("\nWhich would you like to print? : ");
        int selection = input.nextInt() - 1;
        while (selection > magazines.size()) {
            System.out.println("Invalid Selection, try again!");
            for (int i = 0; i < magazines.size(); i++) {
                System.out.print(i + 1 + ") " + magazines.get(i).getTitle());
            }
            System.out.println("\nWhich would you like to print? : ");
            selection = input.nextInt() - 1;
        }
        System.out.println(magazines.get(selection));
    }

    public void showTotal() {
        System.out.println("You earned : " + total.getTotal() + "$");
    }

    public void Run() {

        while (!done) {

            System.out.println(menu);

            int option = input.nextInt();
            boolean inMenuOne = false;
            boolean inMenuTwo = false;
            boolean inMenuThree = false;
            switch (option) {
                default:
                    System.out.println("Invalid Entry, Try again!");
                    break;
                case 1:
                    inMenuOne = true;
                    while (inMenuOne) {
                        System.out.println(booksMenu);
                        int subMenu = input.nextInt();
                        switch (subMenu) {
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
                                sellBook();
                                break;
                            case 5:
                                printBook();
                                break;
                            case 98:
                                showTotal();
                                break;
                            case 99:
                                inMenuOne = false;
                                break;
                            default:
                                System.out.println("Invalid Entry, Try again!");
                                break;
                        }
                    }
                    break;
                case 2:
                    inMenuTwo = true;
                    while (inMenuTwo) {
                        System.out.println(ticketsMenu);
                        int subMenu = input.nextInt();
                        switch (subMenu) {
                            case 1:
                                System.out.println("How many would you like to sell?: \n");
                                int num = input.nextInt();
                                System.out.println("How much would you like to sell them for?:\n");
                                double price = input.nextDouble();
                                sellTicket(num, price);
                                break;
                            case 98:
                                showTotal();
                                break;
                            case 99:
                                inMenuTwo = false;
                                break;
                            default:
                                System.out.println("Invalid Entry, Try again!");
                                break;
                        }
                    }
                    break;
                case 3:
                    inMenuThree = true;
                    while (inMenuThree) {
                        System.out.println(magazineMenu);
                        int subMenu = input.nextInt();
                        switch (subMenu) {
                            case 1:
                                addMagazine();
                                break;
                            case 2:
                                editMagazine();
                                break;
                            case 3:
                                deleteMagazine();
                                break;
                            case 4:
                                sellMagazine();
                                break;
                            case 5:
                                printMagazine();
                                break;
                            case 98:
                                showTotal();
                                break;
                            case 99:
                                inMenuThree = false;
                                break;
                            default:
                                System.out.println("Invalid Entry, Try again!");
                                break;
                        }
                    }
                    break;
                case 98:
                    showTotal();
                    break;
                case 99:
                    done = true;
                    break;
            }
        }
    }

}
