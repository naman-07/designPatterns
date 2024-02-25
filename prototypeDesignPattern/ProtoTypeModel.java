package designpatternpractice;

import java.util.ArrayList;
import java.util.List;

/**
 * main class to show describe prototype model using shadow copy for student and
 * deep copy for employee
 */
public class ProtoTypeModel {
    public static void main(String args[]) throws InterruptedException, CloneNotSupportedException {
        /*
         * example to show prototype model using shadow copy of objects
         */
        protoTypeUsingShadowCopy();
        /*
         * example to show prototype model using deep copy of objects
         */
        protoTypeUsingDeepCopy();
    }

    /**
     * Method to show prototype model using shadow copy.
     * 
     * @throws InterruptedException
     * @throws CloneNotSupportedException
     * Output- Creating object using prototype design : shallow copy
     *  1: naman:[Java, Python]
     *  2: akshay:[Java, Python]
     */
    private static void protoTypeUsingShadowCopy() throws InterruptedException, CloneNotSupportedException {
        System.out.println("Creating object using prototype design : shallow copy");
        // create a new object
        Student student = new Student();
        List<String> subject = new ArrayList<>();
        subject.add("Java");
        // will load important information after sleeping for 5 seconds
        student.loadImportantInformation(1, "naman", subject);
        /*
         * create a clone of above student with shallow copy
         */
        Student student2 = (Student) student.clone();
        /*
         * if we change the roll no as it is primitive datatype it will only be
         * changed for student 2
         */
        student2.setRollNumber(2);
        student2.setName("akshay");
        /*
         * if we change the subject as it is a list in case of shallow copy it
         * stores reference of same list in both student and if we override for
         * one it will be overriden for both
         */
        // adding a new subject will reflect for both
        subject.add("Python");
        System.out.println(student);
        System.out.println(student2);
    }

    /**
     * Method to show prototype model using deep copy.
     * 
     * @throws InterruptedException
     * @throws CloneNotSupportedException
     * Output- Creating object using prototype design : deep copy
     *  1: naman:[Java, Python]
     *  2: akshay:[Java]
     */
    private static void protoTypeUsingDeepCopy() throws InterruptedException, CloneNotSupportedException {
        System.out.println("Creating object using prototype design : deep copy");
        // create a new object
        Employee employee = new Employee();
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        // will load important information after sleeping for 5 seconds
        employee.loadImportantInformation(1, "naman", languages);
        /*
         * create a clone of above employee with deep copy
         */
        Employee employee2 = (Employee) employee.clone();
        /*
         * if we change the roll no as it is primitive datatype it will only be
         * changed for student 2
         */
        employee2.setEmployeeCode(2);
        employee2.setName("akshay");
        /*
         * if we change the language as it is a list in case of deep copy it
         * stores new object of list in employee and the employeeClone and if we
         * override for one it will not be overriden for both
         */
        // adding a new language will reflect for original employee and not the
        // clone
        languages.add("Python");
        System.out.println(employee);
        System.out.println(employee2);
    }
}
