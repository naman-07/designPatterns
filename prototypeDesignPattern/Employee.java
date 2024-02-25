package designpatternpractice;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {
    // role number
    Integer employeeCode;
    // name
    String name;
    // list of subjects
    List<String> languages;

    // default constructor
    public Employee() {
    }

    // constructor for initilization of all fields
    public Employee(Integer employeeCode, String name) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.languages = new ArrayList<>();
    }

    /**
     * @return the rollNumber
     */
    public Integer getEmployeeCode() {
        return employeeCode;
    }

    /**
     * @param employeeCode
     *            the employeeCode to set
     */
    public void setEmployeeCode(Integer employeeCode) {
        this.employeeCode = employeeCode;
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
     * @return the languages
     */
    public List<String> getLanguages() {
        return languages;
    }

    /**
     * @param languages
     *            the languages to set
     */
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    /**
     * load very important data
     * 
     * @param rollNumber
     * @param name
     * @param subject
     * @throws InterruptedException
     */
    public void loadImportantInformation(Integer employeeCode, String name, List<String> languages)
            throws InterruptedException {
        this.languages = languages;
        this.employeeCode = employeeCode;
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
        return this.employeeCode + ": " + this.name + ":" + this.languages;
    }

    /**
     * clone the object using deep copy in this we ourselves have to create a
     * new copy of the object and initialize with all fields and return
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Employee employeeCopy = new Employee();
        employeeCopy.setName(this.name);
        employeeCopy.setEmployeeCode(this.employeeCode);
        employeeCopy.setLanguages(new ArrayList<>());
        for(String language : this.languages) {
            employeeCopy.getLanguages().add(language);
        }
        return employeeCopy;
    }
}
