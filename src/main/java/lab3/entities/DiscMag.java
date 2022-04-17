package lab3.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * @author alars
 */
@Entity
public class DiscMag extends Magazine implements Serializable {
    
        @Override
        public String toString(){
        return "Title : " + this.getTitle() + "\nCopies : "+this.getCopies() + "\nPrice : " +this.getPrice() + "\nOrder Qty: " + orderQty + "\nCurrent Issue Date: " + currIssue ;
    }
}