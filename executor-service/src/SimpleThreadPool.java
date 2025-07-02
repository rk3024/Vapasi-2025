import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TicketBookingTask implements Runnable {
    int bookingId;

    TicketBookingTask(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public void run() {
        System.out.println("Booking " + bookingId + " received.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Payment " + bookingId + " processed.");
        System.out.println("Ticket " + bookingId + " confirmed.");
    }
}

public class SimpleThreadPool {
    public static void main(String[] args) {
        int numberOfBookings = 5;
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {

            for (int i = 0; i < numberOfBookings; i++) {
                executorService.execute(new TicketBookingTask(i + 1));
            }
            executorService.shutdown();
        }

    }
}
