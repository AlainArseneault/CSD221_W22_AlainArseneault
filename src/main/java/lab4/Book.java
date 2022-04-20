package lab4;

import javax.persistence.Basic;


/**
 * @author alars
 */

public class Book extends Publication {

    @Basic
    private String Author;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    @Override
    public String toString(){
        return "Author : " + this.Author +"\nTitle : " + this.getTitle() + "\nCopies : "+this.getCopies() + "\nPrice : " +this.getPrice();
    }

}