public class TicketBookingTask implements Runnable {
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