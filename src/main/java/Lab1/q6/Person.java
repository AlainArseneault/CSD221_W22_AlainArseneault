/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1.q6;

/**
 *
 * @author aa
 */
public class Person {
    String firstName;
    String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSin(int Sin) {
        this.Sin = Sin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSin() {
        return Sin;
    }
    int Sin;
    Person(String first, String last, int S){
        this.firstName = first;
        this.lastName = last;
        this.Sin = S;
    }
    @Override
    public String toString() {

        System.out.println("Name : " + this.firstName + " " + this.lastName+ ", Sin : " + this.Sin);

        return "";

    }
}
