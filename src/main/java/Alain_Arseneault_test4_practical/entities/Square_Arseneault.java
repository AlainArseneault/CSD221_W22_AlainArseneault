package Alain_Arseneault_test4_practical.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author alars
 */
@Entity
public class Square_Arseneault extends Shape_Arseneault {

    @Basic
    private double theLength;
    @Basic
    private double width;

    public double getTheLength() {
        return theLength;
    }

    public void setTheLength(double theLength) {
        this.theLength = theLength;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    public void areaCalc(){
        double t = this.theLength*this.theLength;
        this.setArea(t);
    }

}