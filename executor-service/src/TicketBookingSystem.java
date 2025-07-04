import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketBookingSystem {
    public static void main(String[] args) {
        int numberOfBookings = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < numberOfBookings; i++) {
            executorService.execute(new TicketBookingTask(i + 1));
        }
        executorService.shutdown();
    }
}
