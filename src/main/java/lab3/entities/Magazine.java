package lab3.entities;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author alars
 */
@Entity
public class Magazine extends Publication {

    @Basic
     int orderQty;
    @Basic
     Date currIssue;

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public Date getCurrIssue() {
        return currIssue;
    }

    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }
    public String toString(){
        return "Title : " + this.getTitle() + "\nCopies : "+this.getCopies() + "\nPrice : " +this.getPrice() + "\nOrder Qty: " + orderQty + "\nCurrent Issue Date: " + currIssue ;
    }

}