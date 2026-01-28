import java.util.Scanner;
// import AdminService;
// import UserService;
// import FlightService;
// import BookingService;
// import CustomerService;

/**
 * Main Class
 * Entry point for the Airline Management System
 * Displays the main menu and coordinates between admin and customer modules
 */
public class Main {
    public static void main(String[] args) {
        // Initialize all services
        FlightService flightService = new FlightService();
        UserService userService = new UserService();
        BookingService bookingService = new BookingService();
        AdminService adminService = new AdminService(flightService);
        CustomerService customerService = new CustomerService(userService, flightService, bookingService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Display welcome message
        displayWelcomeMessage();

        while (running) {
            displayMainMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        adminLoginMenu(scanner, adminService);
                        break;
                    case 2:
                        customerService.displayCustomerMenu(scanner);
                        break;
                    case 3:
                        running = false;
                        displayExitMessage();
                        break;
                    default:
                        System.out.println("❌ Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close();
    }

    /**
     * Display welcome message
     */
    private static void displayWelcomeMessage() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  ✈️  WELCOME TO AIRLINE MANAGEMENT SYSTEM ✈️");
        System.out.println("=".repeat(50));
        System.out.println("  Book Your Flights Easily and Conveniently");
        System.out.println("=".repeat(50) + "\n");
    }

    /**
     * Display main menu
     */
    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                  MAIN MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. Admin Login");
        System.out.println("2. Customer Portal");
        System.out.println("3. Exit");
        System.out.println("=".repeat(50));
    }

    /**
     * Admin login menu
     */
    private static void adminLoginMenu(Scanner scanner, AdminService adminService) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("                  ADMIN LOGIN");
        System.out.println("-".repeat(50));

        try {
            System.out.print("Enter Admin Email: ");
            String email = scanner.nextLine().trim();

            System.out.print("Enter Admin Password: ");
            String password = scanner.nextLine().trim();

            if (adminService.adminLogin(email, password)) {
                adminService.displayAdminMenu(scanner);
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please try again.");
            scanner.nextLine();
        }
    }

    /**
     * Display exit message
     */
    private static void displayExitMessage() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("    Thank you for using Airline Management System!");
        System.out.println("             Have a pleasant flight!");
        System.out.println("=".repeat(50) + "\n");
    }
}
