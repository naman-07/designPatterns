package functionalinterface;

import java.util.function.Function;

public class HigherOrderFunctionExample {
    // Higher-order function that takes two functions and composes them
    public static <T, R, U> Function<T, U> compose(Function<T, R> f1, Function<R, U> f2) {
        return (T t) -> f2.apply(f1.apply(t));
    }

    public static void main(String[] args) {
        // Function to double the input integer
        Function<Integer, Integer> doubleFunction = x -> x * 2;
        // Function to convert integer to string
        Function<Integer, String> toStringFunction = Object::toString;
        // Compose both functions: double and then convert to string
        Function<Integer, String> composedFunction = compose(doubleFunction, toStringFunction);
        // Applying the composed function
        System.out.println(composedFunction.apply(5)); // Output: "10"
    }
}
