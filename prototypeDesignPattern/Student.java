package designpatternpractice;

import java.util.ArrayList;
import java.util.List;

public class Student implements Cloneable {
    // role number
    Integer rollNumber;
    // name
    String name;
    // list of subjects
    List<String> subject;

    // default constructor
    public Student() {
    }

    // constructor for initilization of all fields
    public Student(Integer rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.subject = new ArrayList<>();
    }

    /**
     * @return the rollNumber
     */
    public Integer getRollNumber() {
        return rollNumber;
    }

    /**
     * @param rollNumber
     *            the rollNumber to set
     */
    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the subject
     */
    public List<String> getSubject() {
        return subject;
    }

    /**
     * @param subject
     *            the subject to set
     */
    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    /**
     * load very important data
     * 
     * @param rollNumber
     * @param name
     * @param subject
     * @throws InterruptedException
     */
    public void loadImportantInformation(Integer rollNumber, String name, List<String> subject)
            throws InterruptedException {
        this.subject = subject;
        this.rollNumber = rollNumber;
        this.name = name;
        /*
         * put the thread to sleep to actually check first time initizalization
         * of the object will take time but cloning will be quick
         */
        Thread.sleep(5000);
    }

    /**
     * convert the object to string
     */
    @Override
    public String toString() {
        return this.rollNumber + ": " + this.name + ":" + this.subject;
    }

    /**
     * clone the object
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
