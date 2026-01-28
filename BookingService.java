import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * BookingService Class
 * Manages all booking-related operations
 * Uses HashMap to store bookings with bookingId as key
 */
public class BookingService {
    private HashMap<String, Booking> bookings;
    private int bookingCounter;

    /**
     * Constructor to initialize BookingService
     */
    public BookingService() {
        this.bookings = new HashMap<>();
        this.bookingCounter = 5000;
    }

    /**
     * Create a new booking
     * @param passengerName Name of passenger
     * @param flightId Flight ID for booking
     * @param flightService FlightService instance to check flight availability
     * @return Booking object if successful, null otherwise
     */
    public Booking bookFlight(String passengerName, String flightId, FlightService flightService) {
        // Validate input
        if (passengerName == null || passengerName.trim().isEmpty()) {
            System.out.println("❌ Passenger name cannot be empty!");
            return null;
        }

        // Check if flight exists
        if (!flightService.flightExists(flightId)) {
            System.out.println("❌ Flight not found!");
            return null;
        }

        // Get flight and check seat availability
        Flight flight = flightService.getFlightById(flightId);
        if (flight.getAvailableSeats() <= 0) {
            System.out.println("❌ No seats available on this flight!");
            return null;
        }

        // Book a seat
        if (!flight.bookSeat()) {
            System.out.println("❌ Booking failed! Please try again.");
            return null;
        }

        // Create booking
        bookingCounter++;
        String bookingId = "BK" + bookingCounter;
        String seatNumber = "S" + (flight.getTotalSeats() - flight.getAvailableSeats());
        LocalDate bookingDate = LocalDate.now();
        Booking booking = new Booking(bookingId, passengerName, flightId, seatNumber, bookingDate, "CONFIRMED");
        
        bookings.put(bookingId, booking);
        System.out.println("✓ Booking successful! Booking ID: " + bookingId);
        System.out.println("✓ Seat Number: " + seatNumber);
        System.out.println("✓ Total Cost: ₹" + flight.getTicketPrice());
        return booking;
    }

    /**
     * Cancel a booking
     * @param bookingId ID of booking to cancel
     * @param flightService FlightService instance to update seat availability
     * @return true if cancellation successful
     */
    public boolean cancelBooking(String bookingId, FlightService flightService) {
        if (!bookings.containsKey(bookingId)) {
            System.out.println("❌ Booking not found!");
            return false;
        }

        Booking booking = bookings.get(bookingId);
        
        // Check if already cancelled
        if (booking.getBookingStatus().equals("CANCELLED")) {
            System.out.println("❌ Booking is already cancelled!");
            return false;
        }

        // Get flight and cancel seat
        Flight flight = flightService.getFlightById(booking.getFlightId());
        if (flight != null) {
            flight.cancelSeat();
        }

        // Update booking status
        booking.cancelBooking();
        System.out.println("✓ Booking cancelled successfully! Amount will be refunded.");
        return true;
    }

    /**
     * Get booking by ID
     * @param bookingId ID of booking to retrieve
     * @return Booking object if found, null otherwise
     */
    public Booking getBookingById(String bookingId) {
        return bookings.get(bookingId);
    }

    /**
     * Get all bookings for a passenger
     * @param passengerName Name of passenger
     * @return ArrayList of passenger's bookings
     */
    public ArrayList<Booking> getPassengerBookings(String passengerName) {
        ArrayList<Booking> passengerBookings = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getPassengerName().equalsIgnoreCase(passengerName)) {
                passengerBookings.add(booking);
            }
        }
        return passengerBookings;
    }

    /**
     * Get all bookings
     * @return ArrayList of all bookings
     */
    public ArrayList<Booking> getAllBookings() {
        return new ArrayList<>(bookings.values());
    }

    /**
     * Get confirmed bookings only
     * @param passengerName Name of passenger
     * @return ArrayList of confirmed bookings
     */
    public ArrayList<Booking> getConfirmedBookings(String passengerName) {
        ArrayList<Booking> confirmedBookings = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getPassengerName().equalsIgnoreCase(passengerName) && 
                booking.getBookingStatus().equals("CONFIRMED")) {
                confirmedBookings.add(booking);
            }
        }
        return confirmedBookings;
    }

    /**
     * Check if booking exists
     * @param bookingId ID to check
     * @return true if booking exists
     */
    public boolean bookingExists(String bookingId) {
        return bookings.containsKey(bookingId);
    }

    /**
     * Get total number of bookings
     * @return total number of bookings
     */
    public int getTotalBookings() {
        return bookings.size();
    }
}
