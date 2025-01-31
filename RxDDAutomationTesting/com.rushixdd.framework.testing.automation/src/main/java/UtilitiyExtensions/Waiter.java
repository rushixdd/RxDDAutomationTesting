package UtilitiyExtensions;

public class Waiter {
    public static void waitMilliseconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interrupted state
        }
    }

    // New static method to wait for a specified number of seconds
    public static void waitSeconds(long seconds) {
        waitMilliseconds(seconds * 1000);  // Convert seconds to milliseconds
    }
}
