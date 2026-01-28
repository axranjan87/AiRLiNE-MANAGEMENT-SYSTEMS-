/**
 * Flight Model Class
 * Represents a flight entity with all necessary flight information
 */
public class Flight {
    private String flightId;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;

    /**
     * Constructor to initialize a Flight object
     */
    public Flight(String flightId, String source, String destination, 
                  String departureTime, String arrivalTime, int totalSeats, double ticketPrice) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
    }

    // Getters
    public String getFlightId() {
        return flightId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    // Setters
    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    /**
     * Book a seat on this flight
     * @return true if booking is successful, false otherwise
     */
    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    /**
     * Cancel a booking and free up a seat
     * @return true if cancellation is successful
     */
    public boolean cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
            return true;
        }
        return false;
    }

    /**
     * Display flight details
     */
    @Override
    public String toString() {
        return "Flight ID: " + flightId + 
               " | From: " + source + " To: " + destination + 
               " | Departure: " + departureTime + " | Arrival: " + arrivalTime + 
               " | Available Seats: " + availableSeats + "/" + totalSeats + 
               " | Price: ₹" + ticketPrice;
    }
}
