package functionalinterface;

import java.util.Optional;

public class OptionalFlatMapExample {
    public static void main(String[] args) {
        // Example using flatMap with Optional
        Optional<String> optionalName = Optional.of("John Doe");
        Optional<Integer> nameLength = optionalName.flatMap(name -> getLengthIfPresent(name));
        nameLength.ifPresent(length -> System.out.println("Name length: " + length));
        // Example with an empty Optional
        Optional<String> emptyOptional = Optional.empty();
        Optional<Integer> emptyNameLength = emptyOptional.flatMap(name -> getLengthIfPresent(name));
        if (emptyNameLength.isPresent()) {
            System.out.println("Name length: " + emptyNameLength.get());
        } else {
            System.out.println("Name length: " + 0);
        }
    }

    private static Optional<Integer> getLengthIfPresent(String name) {
        if (name != null && !name.isEmpty()) {
            return Optional.of(name.length());
        } else {
            return Optional.empty();
        }
    }
}
