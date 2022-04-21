package Alain_Arseneault_test4_practical.entities;

import java.util.Optional;
import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author alars
 */
@Entity
public class Triangle_Arseneault extends Shape_Arseneault {

    @Basic
    private double base;
    @Basic
    private double height;

    public Optional<Double> getBase() {
        return Optional.ofNullable(base);
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void areaCalc(){
        double t = (this.base*this.height)/2;
        this.setArea(t);
    }
}