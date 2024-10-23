package Management_Exc;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Main {
    public static void main(String[] args){

    }
    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */

    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Person m = null, e = null;
        for (Person p: persons){
            if (p.getName().equals(manager)){
                m = p;
                break;
            }
        }
        for (Person p: persons){
            if (p.getName().equals(employee)){
                e = p;
                break;
            }
        }

        if (m == null){
            throw new NoSuchElementException(manager + " does not exist");
        } else if (e == null){
            throw new NoSuchElementException(employee + " does not exist");
        } else if (!(m instanceof Manager)){
            throw new ClassCastException(m.getName() + " is not a manager");
        } else if (!(e instanceof Employee)){
            throw new ClassCastException(e.getName() + " is not an employee");
        } else {
            ((Manager)m).giveRaise((Employee) e, salary);
        }
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Person m = null, d = null;
        for (Person p: persons){
            if (p.getName().equals(manager)){
                m = p;
                break;
            }
        }
        for (Person p: persons){
            if (p.getName().equals(developer)){
                d = p;
                break;
            }
        }
        if (m == null){
            throw new NoSuchElementException(manager + " does not exist");
        } else if (d == null){
            throw new NoSuchElementException(developer + " does not exist");
        } else if (!(m instanceof Manager)){
            throw new ClassCastException(m.getName() + " is not a manager");
        } else if (!(d instanceof Developer)){
            throw new ClassCastException(d.getName() + " is not a developer");
        } else {
            ((Developer)d).setProjectManager((Manager) m);
        }
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws IllegalArgumentException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Person e = null, c = null;
        for (Person p: persons){
            if (p.getName().equals(customer)){
                c = p;
                break;
            }
        }
        for (Person p: persons){
            if (p.getName().equals(employee)){
                e = p;
                break;
            }
        }
        if (c == null){
            throw new NoSuchElementException(customer + " does not exist");
        } else if (e == null){
            throw new NoSuchElementException(employee + " does not exist");
        } else if (!(e instanceof Employee)){
            throw new ClassCastException(e.getName() + " is not an employee");
        } else if (!(c instanceof Customer)){
            throw new ClassCastException(c.getName() + " is not a customer");
        } else {
            return ((Customer)c).speak((Employee)e);
        }
    }
}
