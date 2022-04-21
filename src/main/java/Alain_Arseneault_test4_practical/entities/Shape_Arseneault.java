package Alain_Arseneault_test4_practical.entities;

import Alain_Arseneault_test4_practical.ShapeInterface;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author alars
 */
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Entity
public class Shape_Arseneault implements ShapeInterface, Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private double area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double printArea() {
        return area;
    }

}