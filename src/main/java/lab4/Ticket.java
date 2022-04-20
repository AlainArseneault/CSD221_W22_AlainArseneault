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
public class Ticket implements SaleableItem{
    double price = 0;
    @Override
    public void setPrice(double a) {
        price = a;
    }
    public double getPrice(){
        return price;
    }

    
    
}
