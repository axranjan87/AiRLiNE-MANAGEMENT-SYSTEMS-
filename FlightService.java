import java.util.ArrayList;
import java.util.HashMap;

/**
 * FlightService Class
 * Manages all flight-related operations (CRUD)
 * Uses HashMap to store flights with flightId as key
 */
public class FlightService {
    private HashMap<String, Flight> flights;

    /**
     * Constructor to initialize FlightService
     */
    public FlightService() {
        this.flights = new HashMap<>();
        initializeSampleFlights();
    }

    /**
     * Initialize sample flights for demonstration
     */
    private void initializeSampleFlights() {
        // Add some sample flights
        flights.put("FL001", new Flight("FL001", "Delhi", "Mumbai", "08:00 AM", "10:30 AM", 150, 5000));
        flights.put("FL002", new Flight("FL002", "Delhi", "Bangalore", "09:00 AM", "12:00 PM", 180, 6000));
        flights.put("FL003", new Flight("FL003", "Mumbai", "Goa", "03:00 PM", "05:00 PM", 120, 4500));
        flights.put("FL004", new Flight("FL004", "Bangalore", "Chennai", "10:00 AM", "11:30 AM", 100, 3500));
        flights.put("FL005", new Flight("FL005", "Delhi", "Kolkata", "02:00 PM", "05:00 PM", 160, 5500));
    }

    /**
     * Add a new flight
     * @param flight Flight object to add
     * @return true if flight added successfully
     */
    public boolean addFlight(Flight flight) {
        if (flights.containsKey(flight.getFlightId())) {
            System.out.println("❌ Flight with ID " + flight.getFlightId() + " already exists!");
            return false;
        }
        flights.put(flight.getFlightId(), flight);
        System.out.println("✓ Flight added successfully!");
        return true;
    }

    /**
     * Update an existing flight
     * @param flightId ID of flight to update
     * @param updatedFlight Updated flight object
     * @return true if flight updated successfully
     */
    public boolean updateFlight(String flightId, Flight updatedFlight) {
        if (!flights.containsKey(flightId)) {
            System.out.println("❌ Flight with ID " + flightId + " not found!");
            return false;
        }
        flights.put(flightId, updatedFlight);
        System.out.println("✓ Flight updated successfully!");
        return true;
    }

    /**
     * Delete a flight
     * @param flightId ID of flight to delete
     * @return true if flight deleted successfully
     */
    public boolean deleteFlight(String flightId) {
        if (!flights.containsKey(flightId)) {
            System.out.println("❌ Flight with ID " + flightId + " not found!");
            return false;
        }
        flights.remove(flightId);
        System.out.println("✓ Flight deleted successfully!");
        return true;
    }

    /**
     * Get a flight by ID
     * @param flightId ID of flight to retrieve
     * @return Flight object if found, null otherwise
     */
    public Flight getFlightById(String flightId) {
        return flights.get(flightId);
    }

    /**
     * Get all flights
     * @return ArrayList of all flights
     */
    public ArrayList<Flight> getAllFlights() {
        return new ArrayList<>(flights.values());
    }

    /**
     * Search flights by source and destination
     * @param source Source city
     * @param destination Destination city
     * @return ArrayList of matching flights
     */
    public ArrayList<Flight> searchFlights(String source, String destination) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights.values()) {
            if (flight.getSource().equalsIgnoreCase(source) && 
                flight.getDestination().equalsIgnoreCase(destination)) {
                result.add(flight);
            }
        }
        return result;
    }

    /**
     * Search flights by source only
     * @param source Source city
     * @return ArrayList of matching flights
     */
    public ArrayList<Flight> searchFlightsBySource(String source) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights.values()) {
            if (flight.getSource().equalsIgnoreCase(source)) {
                result.add(flight);
            }
        }
        return result;
    }

    /**
     * Search flights by destination only
     * @param destination Destination city
     * @return ArrayList of matching flights
     */
    public ArrayList<Flight> searchFlightsByDestination(String destination) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights.values()) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                result.add(flight);
            }
        }
        return result;
    }

    /**
     * Check if flight exists
     * @param flightId ID of flight to check
     * @return true if flight exists
     */
    public boolean flightExists(String flightId) {
        return flights.containsKey(flightId);
    }

    /**
     * Get total number of flights
     * @return total number of flights
     */
    public int getTotalFlights() {
        return flights.size();
    }
}
