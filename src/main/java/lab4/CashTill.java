/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author alars
 */
public class CashTill {
    public double total = 0;
    
    public void sellItem(Ticket a, int number){
        this.total += (number*a.getPrice());
    }
    public  void sellItem(Publication a, int number){
        a.setCopies(a.getCopies()-number);
        this.total += (a.getPrice()*number);
    }
    public  void sellItem(Book a, int number){
        a.setCopies(a.getCopies()-number);
        this.total += (a.getPrice()*number);
    }
    public  void sellItem(Magazine a, int number){
        a.setCopies(a.getCopies()-number);
        this.total += (a.getPrice()*number);
    }
    public  void sellItem(DiscMag a, int number){
        a.setCopies(a.getCopies()-number);
        this.total += (a.getPrice()*number);
    }
    public double getTotal(){
        return this.total;
    }
}
