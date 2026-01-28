import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Booking Model Class
 * Represents a flight booking made by a customer
 */
public class Booking {
    private String bookingId;
    private String passengerName;
    private String flightId;
    private String seatNumber;
    private LocalDate bookingDate;
    private String bookingStatus; // CONFIRMED, CANCELLED

    /**
     * Constructor to initialize a Booking object
     */
    public Booking(String bookingId, String passengerName, String flightId, 
                   String seatNumber, LocalDate bookingDate, String bookingStatus) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    // Setters
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    /**
     * Cancel this booking
     */
    public void cancelBooking() {
        this.bookingStatus = "CANCELLED";
    }

    /**
     * Display booking details
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Booking ID: " + bookingId + 
               " | Passenger: " + passengerName + 
               " | Flight ID: " + flightId + 
               " | Seat: " + seatNumber + 
               " | Date: " + bookingDate.format(formatter) + 
               " | Status: " + bookingStatus;
    }
}
