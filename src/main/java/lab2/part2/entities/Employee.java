package lab2.part2.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author alars
 */
@Entity
public class Employee extends Person implements Serializable {

    @Basic
    private String title;
    @Basic
    private String salary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

}