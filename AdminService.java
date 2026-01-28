import java.util.ArrayList;
import java.util.Scanner;

/**
 * AdminService Class
 * Handles all admin-related operations
 * Admin credentials are hardcoded for this implementation
 */
public class AdminService {
    private String adminEmail = "ayushranjan8757@airline.com";
    private String adminPassword = "Ayush@8757";
    private FlightService flightService;

    /**
     * Constructor to initialize AdminService
     */
    public AdminService(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Authenticate admin login
     * @param email Admin email
     * @param password Admin password
     * @return true if login successful
     */
    public boolean adminLogin(String email, String password) {
        if (email.equals(adminEmail) && password.equals(adminPassword)) {
            System.out.println("✓ Admin login successful!");
            return true;
        } else {
            System.out.println("❌ Invalid admin credentials!");
            return false;
        }
    }

    /**
     * Display admin menu and handle operations
     */
    public void displayAdminMenu(Scanner scanner) {
        boolean adminLoggedIn = true;
        
        while (adminLoggedIn) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           ADMIN MENU - FLIGHT MANAGEMENT");
            System.out.println("=".repeat(50));
            System.out.println("1. Add Flight");
            System.out.println("2. View All Flights");
            System.out.println("3. Update Flight");
            System.out.println("4. Delete Flight");
            System.out.println("5. View Flight Details");
            System.out.println("6. Logout");
            System.out.println("=".repeat(50));
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addFlightMenu(scanner);
                        break;
                    case 2:
                        viewAllFlights();
                        break;
                    case 3:
                        updateFlightMenu(scanner);
                        break;
                    case 4:
                        deleteFlightMenu(scanner);
                        break;
                    case 5:
                        viewFlightDetailsMenu(scanner);
                        break;
                    case 6:
                        System.out.println("✓ Admin logged out successfully!");
                        adminLoggedIn = false;
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Menu to add a new flight
     */
    private void addFlightMenu(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  ADD NEW FLIGHT");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Flight ID: ");
            String flightId = scanner.nextLine().trim();

            if (flightId.isEmpty()) {
                System.out.println("❌ Flight ID cannot be empty!");
                return;
            }

            System.out.print("Enter Source City: ");
            String source = scanner.nextLine().trim();
            if (source.isEmpty()) {
                System.out.println("❌ Source cannot be empty!");
                return;
            }

            System.out.print("Enter Destination City: ");
            String destination = scanner.nextLine().trim();
            if (destination.isEmpty()) {
                System.out.println("❌ Destination cannot be empty!");
                return;
            }

            System.out.print("Enter Departure Time (HH:MM AM/PM): ");
            String departureTime = scanner.nextLine().trim();
            if (departureTime.isEmpty()) {
                System.out.println("❌ Departure time cannot be empty!");
                return;
            }

            System.out.print("Enter Arrival Time (HH:MM AM/PM): ");
            String arrivalTime = scanner.nextLine().trim();
            if (arrivalTime.isEmpty()) {
                System.out.println("❌ Arrival time cannot be empty!");
                return;
            }

            System.out.print("Enter Total Seats: ");
            int totalSeats = scanner.nextInt();
            if (totalSeats <= 0) {
                System.out.println("❌ Seats must be greater than 0!");
                return;
            }

            System.out.print("Enter Ticket Price (₹): ");
            double ticketPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            if (ticketPrice <= 0) {
                System.out.println("❌ Price must be greater than 0!");
                return;
            }

            Flight flight = new Flight(flightId, source, destination, departureTime, arrivalTime, totalSeats, ticketPrice);
            flightService.addFlight(flight);
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please check and try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    /**
     * View all flights
     */
    private void viewAllFlights() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  ALL FLIGHTS");
        System.out.println("-".repeat(50));

        ArrayList<Flight> allFlights = flightService.getAllFlights();
        if (allFlights.isEmpty()) {
            System.out.println("No flights available!");
            return;
        }

        for (Flight flight : allFlights) {
            System.out.println(flight);
        }
    }

    /**
     * Menu to update a flight
     */
    private void updateFlightMenu(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  UPDATE FLIGHT");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Flight ID to update: ");
            String flightId = scanner.nextLine().trim();

            if (!flightService.flightExists(flightId)) {
                System.out.println("❌ Flight not found!");
                return;
            }

            Flight currentFlight = flightService.getFlightById(flightId);
            System.out.println("\nCurrent Flight Details:");
            System.out.println(currentFlight);

            System.out.println("\nWhat would you like to update?");
            System.out.println("1. Source\n2. Destination\n3. Departure Time\n4. Arrival Time\n5. Ticket Price\n6. Total Seats");
            System.out.print("Enter your choice: ");
            int updateChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (updateChoice) {
                case 1:
                    System.out.print("Enter new Source: ");
                    currentFlight.setSource(scanner.nextLine().trim());
                    break;
                case 2:
                    System.out.print("Enter new Destination: ");
                    currentFlight.setDestination(scanner.nextLine().trim());
                    break;
                case 3:
                    System.out.print("Enter new Departure Time: ");
                    currentFlight.setDepartureTime(scanner.nextLine().trim());
                    break;
                case 4:
                    System.out.print("Enter new Arrival Time: ");
                    currentFlight.setArrivalTime(scanner.nextLine().trim());
                    break;
                case 5:
                    System.out.print("Enter new Ticket Price: ");
                    currentFlight.setTicketPrice(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Enter new Total Seats: ");
                    currentFlight.setTotalSeats(scanner.nextInt());
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
                    return;
            }
            flightService.updateFlight(flightId, currentFlight);
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please check and try again.");
            scanner.nextLine();
        }
    }

    /**
     * Menu to delete a flight
     */
    private void deleteFlightMenu(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  DELETE FLIGHT");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Flight ID to delete: ");
            String flightId = scanner.nextLine().trim();

            if (!flightService.flightExists(flightId)) {
                System.out.println("❌ Flight not found!");
                return;
            }

            Flight flight = flightService.getFlightById(flightId);
            System.out.println("Flight Details:");
            System.out.println(flight);

            System.out.print("\nAre you sure you want to delete this flight? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                flightService.deleteFlight(flightId);
            } else {
                System.out.println("✓ Deletion cancelled!");
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please check and try again.");
            scanner.nextLine();
        }
    }

    /**
     * Menu to view flight details
     */
    private void viewFlightDetailsMenu(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  FLIGHT DETAILS");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Flight ID: ");
            String flightId = scanner.nextLine().trim();

            if (!flightService.flightExists(flightId)) {
                System.out.println("❌ Flight not found!");
                return;
            }

            Flight flight = flightService.getFlightById(flightId);
            System.out.println("\n" + flight);
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please check and try again.");
            scanner.nextLine();
        }
    }
}
