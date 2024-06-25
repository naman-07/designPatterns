package functionalinterface;

public class RunnableExample {
    public static void main(String[] args) {
        // Print the name of the main thread
        System.out.println("Main thread name: " + Thread.currentThread().getName());
        // Using a lambda expression
        Runnable runnable = () -> {
            System.out.println("New thread name: " + Thread.currentThread().getName());
            System.out.println("Running a task!");
        };
        /*
         * Starting a new thread
         */
        Thread newThread = new Thread(runnable);
        newThread.setName("Runnable New Thread");
        newThread.start();
        /*
         * it will be executing main thread
         */
        runnable.run();
    }
}
