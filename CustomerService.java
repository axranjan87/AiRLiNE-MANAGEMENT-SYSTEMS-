import java.util.ArrayList;
import java.util.Scanner;

/**
 * UserService (Customer Service) Class
 * Handles all customer-related operations
 * Note: This is the customer operations class (different from UserService which handles user management)
 */
public class CustomerService {
    private UserService userService;
    private FlightService flightService;
    private BookingService bookingService;
    private User currentUser;

    /**
     * Constructor to initialize CustomerService
     */
    public CustomerService(UserService userService, FlightService flightService, BookingService bookingService) {
        this.userService = userService;
        this.flightService = flightService;
        this.bookingService = bookingService;
        this.currentUser = null;
    }

    /**
     * Display customer menu and handle operations
     */
    public void displayCustomerMenu(Scanner scanner) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           CUSTOMER - LOGIN / REGISTRATION");
        System.out.println("=".repeat(50));
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Back to Main Menu");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loginCustomer(scanner);
                    break;
                case 2:
                    registerCustomer(scanner);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please enter a number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    /**
     * Handle customer login
     */
    private void loginCustomer(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  CUSTOMER LOGIN");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine().trim();

            currentUser = userService.loginUser(email, password);
            if (currentUser != null) {
                displayUserMenu(scanner);
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    /**
     * Handle customer registration
     */
    private void registerCustomer(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  CUSTOMER REGISTRATION");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();

            System.out.print("Enter Password (minimum 6 characters): ");
            String password = scanner.nextLine().trim();

            System.out.print("Enter Phone Number (10 digits): ");
            String phoneNumber = scanner.nextLine().trim();

            userService.registerUser(name, email, password, phoneNumber);
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    /**
     * Display user menu after successful login
     */
    private void displayUserMenu(Scanner scanner) {
        boolean userLoggedIn = true;

        while (userLoggedIn) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("          CUSTOMER MENU - " + currentUser.getName());
            System.out.println("=".repeat(50));
            System.out.println("1. Search Flights");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Booking History");
            System.out.println("4. Cancel Booking");
            System.out.println("5. View Profile");
            System.out.println("6. Logout");
            System.out.println("=".repeat(50));
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        searchFlightsMenu(scanner);
                        break;
                    case 2:
                        bookFlightMenu(scanner);
                        break;
                    case 3:
                        viewBookingHistory();
                        break;
                    case 4:
                        cancelBookingMenu(scanner);
                        break;
                    case 5:
                        viewProfile();
                        break;
                    case 6:
                        System.out.println("✓ Logged out successfully!");
                        currentUser = null;
                        userLoggedIn = false;
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
     * Menu to search flights
     */
    private void searchFlightsMenu(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  SEARCH FLIGHTS");
        System.out.println("-".repeat(50));
        System.out.println("1. Search by Source and Destination");
        System.out.println("2. Search by Source Only");
        System.out.println("3. Search by Destination Only");
        System.out.println("4. View All Flights");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            ArrayList<Flight> searchResults = new ArrayList<>();

            switch (choice) {
                case 1:
                    System.out.print("Enter Source City: ");
                    String source = scanner.nextLine().trim();
                    System.out.print("Enter Destination City: ");
                    String destination = scanner.nextLine().trim();
                    searchResults = flightService.searchFlights(source, destination);
                    break;
                case 2:
                    System.out.print("Enter Source City: ");
                    source = scanner.nextLine().trim();
                    searchResults = flightService.searchFlightsBySource(source);
                    break;
                case 3:
                    System.out.print("Enter Destination City: ");
                    destination = scanner.nextLine().trim();
                    searchResults = flightService.searchFlightsByDestination(destination);
                    break;
                case 4:
                    searchResults = flightService.getAllFlights();
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
                    return;
            }

            if (searchResults.isEmpty()) {
                System.out.println("❌ No flights found!");
            } else {
                System.out.println("\n" + "-".repeat(50));
                System.out.println("              AVAILABLE FLIGHTS");
                System.out.println("-".repeat(50));
                for (int i = 0; i < searchResults.size(); i++) {
                    System.out.println((i + 1) + ". " + searchResults.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    /**
     * Menu to book a flight
     */
    private void bookFlightMenu(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  BOOK FLIGHT");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Flight ID to book: ");
            String flightId = scanner.nextLine().trim();

            if (!flightService.flightExists(flightId)) {
                System.out.println("❌ Flight not found!");
                return;
            }

            Flight flight = flightService.getFlightById(flightId);
            System.out.println("\nFlight Details:");
            System.out.println(flight);

            System.out.print("\nProceed with booking? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                Booking booking = bookingService.bookFlight(currentUser.getName(), flightId, flightService);
                if (booking != null) {
                    System.out.println("\n" + booking);
                }
            } else {
                System.out.println("✓ Booking cancelled!");
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    /**
     * View booking history for current user
     */
    private void viewBookingHistory() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  BOOKING HISTORY");
        System.out.println("-".repeat(50));

        ArrayList<Booking> bookings = bookingService.getPassengerBookings(currentUser.getName());
        if (bookings.isEmpty()) {
            System.out.println("No bookings found!");
            return;
        }

        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i));
        }
    }

    /**
     * Menu to cancel a booking
     */
    private void cancelBookingMenu(Scanner scanner) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  CANCEL BOOKING");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Booking ID to cancel: ");
            String bookingId = scanner.nextLine().trim();

            if (!bookingService.bookingExists(bookingId)) {
                System.out.println("❌ Booking not found!");
                return;
            }

            Booking booking = bookingService.getBookingById(bookingId);
            System.out.println("\nBooking Details:");
            System.out.println(booking);

            System.out.print("\nAre you sure you want to cancel? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                bookingService.cancelBooking(bookingId, flightService);
            } else {
                System.out.println("✓ Cancellation cancelled!");
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    /**
     * View current user profile
     */
    private void viewProfile() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  USER PROFILE");
        System.out.println("-".repeat(50));
        System.out.println(currentUser);
    }

    /**
     * Get current logged-in user
     * @return current user
     */
    public User getCurrentUser() {
        return currentUser;
    }
}
