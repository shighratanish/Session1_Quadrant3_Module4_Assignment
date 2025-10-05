// SynchronizedTicketBooking.java

class TicketBooking {
    private int availableTickets = 5; // total tickets

    // synchronized method to ensure only one thread books at a time
    public synchronized void bookTicket(String user) {
        if (availableTickets > 0) {
            System.out.println(user + " booked a ticket. Tickets left: " + (availableTickets - 1));
            availableTickets--;
        } else {
            System.out.println("Sorry, " + user + ". No tickets available.");
        }
    }
}

class BookingThread extends Thread {
    private TicketBooking ticketBooking;
    private String userName;

    public BookingThread(TicketBooking ticketBooking, String userName) {
        this.ticketBooking = ticketBooking;
        this.userName = userName;
    }

    @Override
    public void run() {
        ticketBooking.bookTicket(userName);
    }
}

public class SynchronizedTicketBooking {
    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking();

        // Simulate multiple users booking tickets simultaneously
        Thread t1 = new BookingThread(ticketBooking, "User1");
        Thread t2 = new BookingThread(ticketBooking, "User2");
        Thread t3 = new BookingThread(ticketBooking, "User3");
        Thread t4 = new BookingThread(ticketBooking, "User4");
        Thread t5 = new BookingThread(ticketBooking, "User5");
        Thread t6 = new BookingThread(ticketBooking, "User6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
