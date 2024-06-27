package functionalinterface;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Example with orElse
        String nullName = null;
        String name1 = Optional.ofNullable(nullName).orElse("Default Name");
        System.out.println("Name1: " + name1);
        // Example with orElseGet
        String name2 = Optional.ofNullable(nullName).orElseGet(() -> "Generated Name");
        System.out.println("Name2: " + name2);
        // Example with a non-null value
        String actualName = "John Doe";
        String name3 = Optional.ofNullable(actualName).orElse("Default Name");
        System.out.println("Name3: " + name3);
        String name4 = Optional.ofNullable(actualName).orElseGet(() -> "Generated Name");
        System.out.println("Name4: " + name4);
        // Example with isPresent
        Optional<String> optionalName = Optional.ofNullable(actualName);
        if (optionalName.isPresent()) {
            System.out.println("The name is present: " + optionalName.get());
        } else {
            System.out.println("The name is not present.");
        }
        // Example with isPresent and null value
        Optional<String> emptyOptional = Optional.ofNullable(nullName);
        if (emptyOptional.isPresent()) {
            System.out.println("The name is present: " + emptyOptional.get());
        } else {
            System.out.println("The name is not present.");
        }
    }
}
