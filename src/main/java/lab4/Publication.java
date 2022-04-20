package lab4;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class Publication implements SaleableItem {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String title;
    @Basic
    private int copies;
    @Basic
    private Date creationDate;
    @Basic
    public double price = 0;
    public Long getId() {
        return id;
    }
    @Override
    public void setPrice(double a){
        this.price = a;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public double getPrice(){
        return price;
    }
}
