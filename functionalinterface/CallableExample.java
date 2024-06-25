package functionalinterface;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a single-threaded executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // Define a Callable task using a lambda expression
        Callable<String> callable = () -> "Task's result";
        // Submit the Callable task to the executor and get a Future
        // representing the result
        Future<String> future = executorService.submit(callable);
        // Retrieve and print the result of the Callable task
        System.out.println(future.get());
        // Shut down the executor
        executorService.shutdown();
    }
}
