package functionalinterface;

import java.util.concurrent.*;
import java.util.function.*;
import java.util.*;

public class FunctionInterfacesExample {
    public static void main(String[] args) throws Exception {
        runRunnableExample();
        runCallableExample();
        runSupplierExample();
        runConsumerExample();
        runFunctionExample();
        runPredicateExample();
        runBinaryOperatorExample();
        runUnaryOperatorExample();
        runBiFunctionExample();
        runBiConsumerExample();
        runBiPredicateExample();
        runComparatorExample();
    }

    public static void runRunnableExample() {
        Runnable runnable = () -> System.out.println("Running a task!");
        new Thread(runnable).start();
    }

    public static void runCallableExample() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Task's result";
        Future<String> future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();
    }

    public static void runSupplierExample() {
        Supplier<String> supplier = () -> "Hello, World!";
        System.out.println(supplier.get());
    }

    public static void runConsumerExample() {
        Consumer<String> consumer = message -> System.out.println(message);
        consumer.accept("Hello, World!");
    }

    public static void runFunctionExample() {
        // lambda
        Function<String, Integer> function = s -> Integer.parseInt(s);
        // method referencing
        Function<String, Integer> function2 = Integer::parseInt;
        Integer result = function.apply("123");
        Integer result2 = function2.apply("123");
        System.out.println(result);
        System.out.println(result2);
    }

    public static void runPredicateExample() {
        Predicate<String> predicate = str -> str.isEmpty();
        boolean result = predicate.test("");
        System.out.println(result); // Output: true
    }

    public static void runBinaryOperatorExample() {
        BinaryOperator<Integer> operator = (a, b) -> a + b;
        Integer result = operator.apply(3, 5);
        System.out.println(result); // Output: 8
    }

    public static void runUnaryOperatorExample() {
        UnaryOperator<Integer> operator = x -> x * x;
        Integer result = operator.apply(5);
        System.out.println(result); // Output: 25
    }

    public static void runBiFunctionExample() {
        BiFunction<String, String, Integer> function = (str1, str2) -> str1.length() + str2.length();
        Integer result = function.apply("Hello", "World");
        System.out.println(result); // Output: 10
    }

    public static void runBiConsumerExample() {
        BiConsumer<String, String> consumer = (str1, str2) -> System.out.println(str1 + str2);
        consumer.accept("Hello", " World!");
    }

    public static void runBiPredicateExample() {
        BiPredicate<String, String> predicate = (str1, str2) -> str1.equals(str2);
        boolean result = predicate.test("Hello", "Hello");
        System.out.println(result); // Output: true
    }

    public static void runComparatorExample() {
        Comparator<Integer> comparator = Integer::compareTo;
        int result = comparator.compare(3, 5);
        System.out.println(result); // Output: -1
    }
}
