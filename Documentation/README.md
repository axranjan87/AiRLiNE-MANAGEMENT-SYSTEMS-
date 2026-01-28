# Airline Management System - Java

A complete console-based Airline Management System built with Java following SOLID principles and clean code practices.

## 📋 Project Overview

This is a professional-grade Airline Management System with separate modules for administrators and customers. The system manages flights, user registrations, bookings, and cancellations with a menu-driven interface.

## ✨ Features

### Admin Module
- ✅ Admin Authentication
- ✅ Add New Flights
- ✅ Update Flight Details
- ✅ Delete Flights
- ✅ View All Flights
- ✅ View Flight Details

### Customer Module
- ✅ User Registration
- ✅ User Login
- ✅ Search Flights (by source, destination, both)
- ✅ Book Tickets
- ✅ View Booking History
- ✅ Cancel Bookings
- ✅ View User Profile

### Flight Management
- Flight ID (Unique identifier)
- Source City
- Destination City
- Departure Time
- Arrival Time
- Total Seat Capacity
- Available Seats (Dynamic)
- Ticket Price

### Booking Management
- Booking ID (Unique)
- Passenger Name
- Flight ID Reference
- Seat Number Assignment
- Booking Date
- Booking Status (CONFIRMED/CANCELLED)

## 🏗️ Architecture & Classes

### Model Classes
1. **Flight.java**
   - Represents flight entity
   - Manages seat availability
   - Includes booking/cancellation logic

2. **User.java**
   - Represents customer entity
   - Stores user profile information

3. **Booking.java**
   - Represents booking entity
   - Manages booking status

### Service Classes
1. **FlightService.java**
   - CRUD operations for flights
   - Uses HashMap for efficient lookup
   - Search functionality (source, destination, both)

2. **UserService.java**
   - User registration with validation
   - User authentication (login)
   - User management

3. **BookingService.java**
   - Book flights with availability check
   - Cancel bookings
   - Retrieve booking history
   - Uses HashMap for efficient booking storage

4. **AdminService.java**
   - Admin authentication
   - Admin menu interface
   - Flight management operations

5. **CustomerService.java**
   - Customer authentication
   - Customer menu interface
   - Flight search and booking
   - Booking management

### Main Application
- **Main.java**
  - Entry point of the application
  - Main menu coordination
  - Initializes all services

## 🔐 Default Credentials

### Admin Login
- **Email:** ayushranjan8757@airline.com
- **Password:** Ayush@875**

### Sample Customer Accounts
- **Email:** ---@gmail.com | **Password:** --------
- **Email:** ----@gmail.com | **Password:** ------

## 📦 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any IDE (Eclipse, IntelliJ IDEA, VS Code) or Command Line

### Step 1: Create Project Structure
```
AiRLiNE MS/
├── Flight.java
├── User.java
├── Booking.java
├── FlightService.java
├── UserService.java
├── BookingService.java
├── AdminService.java
├── CustomerService.java
└── Main.java
```

### Step 2: Compile All Files (Command Line)
```bash
javac *.java
```

### Step 3: Run the Application
```bash
java Main
```

### Step 4: Using IDE
1. Create a new Java project
2. Create a new package (e.g., `airline.system`)
3. Add all .java files to the package
4. Right-click Main.java → Run As → Java Application

## 🎯 Usage Examples

### Admin Operations
1. Launch application → Select "Admin Login"
2. Enter credentials: admin@airline.com / admin123
3. Choose options:
   - **Add Flight:** Provide flight details
   - **View All Flights:** See all available flights
   - **Update Flight:** Modify flight information
   - **Delete Flight:** Remove a flight
   - **View Flight Details:** Get specific flight info

### Customer Operations
1. Launch application → Select "Customer Portal"
2. **Register:** Create new account with email/password/phone
3. **Login:** Use registered credentials
4. After login, choose options:
   - **Search Flights:** Find flights by source/destination
   - **Book Ticket:** Select flight and confirm booking
   - **View History:** See all your bookings
   - **Cancel Booking:** Cancel existing booking
   - **View Profile:** See your account details

## 📝 Data Validation

The system includes comprehensive input validation:
- ✓ Non-empty string validation
- ✓ Email format validation (implicit)
- ✓ Password length validation (min 6 characters)
- ✓ Phone number format (10 digits)
- ✓ Seat availability checks
- ✓ Duplicate email prevention
- ✓ Flight existence verification

## 💾 Data Storage (Current)

Data is stored in-memory using Java Collections:
- **HashMap<String, Flight>** - O(1) flight lookup
- **HashMap<String, User>** - O(1) user lookup
- **HashMap<String, Booking>** - O(1) booking lookup
- **ArrayList<>** - For search results and listings

## 🚀 Future Enhancement Possibilities

1. **File Handling**
   - Serialize data to files (.dat, .txt)
   - Load data on application startup

2. **Database Integration**
   - MySQL/PostgreSQL with JDBC
   - JPA/Hibernate ORM

3. **Additional Features**
   - Payment Gateway Integration
   - Email Notifications
   - SMS Alerts
   - Refund Processing
   - Reward Points System

4. **UI Improvements**
   - GUI using Swing/JavaFX
   - Web Interface (Spring Boot + Web)
   - Mobile App (Android/iOS)

5. **Advanced Features**
   - Multiple Admin Support
   - Seat Map Visualization
   - Discount Coupons
   - Round-trip Bookings
   - Multi-passenger Bookings

## 🔒 Security Notes

For production use:
- Use proper password hashing (BCrypt, PBKDF2)
- Implement JWT or OAuth authentication
- Use encrypted connections (HTTPS/TLS)
- Validate/sanitize all inputs
- Implement role-based access control
- Add audit logging

## 📊 Class Relationships

```
Main
├── AdminService
│   └── FlightService
├── CustomerService
│   ├── UserService
│   ├── FlightService
│   └── BookingService
│       └── FlightService
├── FlightService
│   └── Flight (Model)
├── UserService
│   └── User (Model)
└── BookingService
    └── Booking (Model)
```

## 🎓 Code Quality Features

- ✅ Object-Oriented Programming (OOP)
- ✅ SOLID Principles
- ✅ Design Patterns (Service Pattern)
- ✅ Comprehensive Comments (Javadoc style)
- ✅ Exception Handling
- ✅ Input Validation
- ✅ Clean Code Practices
- ✅ Meaningful Variable Names
- ✅ Separated Concerns
- ✅ DRY (Don't Repeat Yourself)

## 📚 Learning Resources

This project is perfect for learning:
- Java Collections (HashMap, ArrayList)
- Object-Oriented Design
- Service Architecture Pattern
- Input/Output Handling
- Exception Handling
- Menu-Driven Programming

## 🐛 Troubleshooting

**Issue:** "Exception in thread 'main' java.util.NoSuchElementException"
- **Solution:** Ensure you're running the program correctly in command line or IDE

**Issue:** Invalid input errors
- **Solution:** Follow the input format specified (use 10-digit phone, valid email format)

**Issue:** Class not found errors
- **Solution:** Ensure all .java files are in the same directory/package

## 📄 License

This project is free to use for educational purposes.

## 👨‍💻 Author

AYUSH RANJAN

---

**Happy Coding! ✨**

For any queries or improvements, feel free to modify and enhance the system according to your needs.
Mail : ayushranjan8757@gmail.com
