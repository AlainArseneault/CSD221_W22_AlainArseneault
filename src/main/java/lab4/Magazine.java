package lab4;

import javax.persistence.Basic;

public class Magazine extends Publication {

    @Basic
    private int orderQty;

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }
    
    @Override
    public String toString(){
        return "\nTitle : "+this.getTitle() + "\nCopies in stock : "+this.getCopies() + "\nCopies on Order : "+this.getOrderQty() + "\nPrice : "+this.getPrice();
    }
}
