package lab3.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author alars
 */
@Entity
public class Book extends Publication {

    @Basic
    private String author;
    public void Book(){
        
    }
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String toString(){
        return "Author : " + author +"\nTitle : " + this.getTitle() + "\nCopies : "+this.getCopies() + "\nPrice : " +this.getPrice();
    }
}