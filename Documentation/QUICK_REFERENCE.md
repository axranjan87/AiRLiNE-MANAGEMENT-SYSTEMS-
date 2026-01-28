# Quick Reference Guide

Fast lookup guide for the Airline Management System.

---

## 📱 Menu Navigation Map

```
┌─────────────────────────────────────┐
│         MAIN MENU                   │
│ 1. Admin Login                      │
│ 2. Customer Portal                  │
│ 3. Exit                             │
└────────┬────────────────────────────┘
         │
    ┌────┴─────────────────────────────────┐
    │                                      │
    ▼                                      ▼
┌──────────────────────┐          ┌──────────────────────┐
│  ADMIN LOGIN         │          │ CUSTOMER PORTAL      │
│(ayushranjan8757@airline.com     │1. Login              │
│  / Ayush@8757)         │        │ 2. Register          │
│                      │          │ 3. Back              │
└──────┬───────────────┘          └────────┬─────────────┘
       │                                   │
       ▼                           ┌───────┴────────┐
┌──────────────────────────────┐   │                │
│  ADMIN MENU                  │   │                │
│ 1. Add Flight                │   ▼                ▼
│ 2. View All Flights          │ ┌─────────┐  ┌──────────────┐
│ 3. Update Flight             │ │ LOGIN   │  │ REGISTER     │
│ 4. Delete Flight             │ │ PANEL   │  │ PANEL        │
│ 5. View Flight Details       │ └────┬────┘  └──────┬───────┘
│ 6. Logout                    │      │             │
└──────────────────────────────┘      │             │
                                      ▼             ▼
                               ┌──────────────────────────────┐
                               │  CUSTOMER MENU               │
                               │ 1. Search Flights            │
                               │ 2. Book Ticket               │
                               │ 3. View Booking History      │
                               │ 4. Cancel Booking            │
                               │ 5. View Profile              │
                               │ 6. Logout                    │
                               └──────────────────────────────┘
```

---

## 🔑 Credentials Quick Reference

| Role | Email | Password |
|------|-------|----------|
| Admin |ayushranjan8757@airline.com | Ayush@8757 |

---

## ✈️ Sample Flight Data

| Flight ID | Route | Time | Seats | Price |
|-----------|-------|------|-------|-------|
| FL001 | Delhi → Mumbai | 08:00 AM - 10:30 AM | 150 | ₹5000 |
| FL002 | Delhi → Bangalore | 09:00 AM - 12:00 PM | 180 | ₹6000 |
| FL003 | Mumbai → Goa | 03:00 PM - 05:00 PM | 120 | ₹4500 |
| FL004 | Bangalore → Chennai | 10:00 AM - 11:30 AM | 100 | ₹3500 |
| FL005 | Delhi → Kolkata | 02:00 PM - 05:00 PM | 160 | ₹5500 |

---

## 📁 File Structure

```
AiRLiNE MS/
├── Model Classes
│   ├── Flight.java
│   ├── User.java
│   └── Booking.java
├── Service Classes
│   ├── FlightService.java
│   ├── UserService.java
│   ├── BookingService.java
│   ├── AdminService.java
│   └── CustomerService.java
├── Main Application
│   └── Main.java
└── Documentation
    ├── README.md
    ├── COMPILATION_GUIDE.md
    ├── DATABASE_SCHEMA.md
    ├── TESTING_GUIDE.md
    └── QUICK_REFERENCE.md
```

---

## 🎯 Class Responsibilities

| Class | Purpose |
|-------|---------|
| **Flight** | Represents flight with seats, pricing |
| **User** | Represents customer profile |
| **Booking** | Represents ticket reservation |
| **FlightService** | CRUD operations on flights |
| **UserService** | User registration & auth |
| **BookingService** | Booking & cancellation logic |
| **AdminService** | Admin interface & operations |
| **CustomerService** | Customer interface & operations |
| **Main** | Application entry & coordination |

---

## 🔄 Common Operations

### Register New Customer
```
1. Select: Customer Portal
2. Select: Register
3. Enter: Name, Email, Password, Phone
4. Result: User ID generated
```

### Book a Flight
```
1. Login as customer
2. Select: Search Flights
3. Select: Book Ticket
4. Enter: Flight ID
5. Confirm: Booking details
6. Result: Booking ID & Seat assigned
```

### Cancel a Booking
```
1. Select: Cancel Booking
2. Enter: Booking ID
3. Confirm: Cancellation
4. Result: Refund initiated, Seat freed
```

### Add New Flight (Admin)
```
1. Login as Admin
2. Select: Add Flight
3. Enter: Flight details
4. Result: Flight added to system
```

---

## ⚠️ Input Validation Rules

| Field | Rule | Example |
|-------|------|---------|
| **Name** | Not empty | "Raj Kumar" |
| **Email** | Valid format | "raj@email.com" |
| **Password** | Min 6 chars | "password123" |
| **Phone** | Exactly 10 digits | "9876543210" |
| **Flight ID** | Alphanumeric | "FL001" |
| **Seats** | > 0 | "150" |
| **Price** | > 0 | "5000.00" |

---

## 📊 Data Structures Used

| Data Structure | Usage |
|-----------------|--------|
| **HashMap<String, Flight>** | Store flights by ID |
| **HashMap<String, User>** | Store users by ID |
| **HashMap<String, Booking>** | Store bookings by ID |
| **ArrayList<Flight>** | Return search results |
| **ArrayList<Booking>** | Return booking lists |

---

## 🚀 Compilation & Execution

### Windows Command Line
```bash
# Navigate to folder
cd "C:\Users\ayush\OneDrive\Desktop\AiRLiNE MS"

# Compile
javac *.java

# Run
java Main
```

### Linux/Mac Terminal
```bash
# Navigate to folder
cd ~/AiRLiNE\ MS

# Compile
javac *.java

# Run
java Main
```

---

## 🔍 Debugging Tips

| Issue | Solution |
|-------|----------|
| No output | Check if running from correct directory |
| Class not found | Ensure all .java files in same directory |
| Compilation error | Check class names and spelling |
| Input error | Type input carefully, follow format |
| NoSuchElementException | Don't pipe input, use keyboard |

---

## 📈 Features Summary

### Admin Features
✓ Add flights
✓ Update flight details
✓ Delete flights
✓ View all flights
✓ View flight details

### Customer Features
✓ Register account
✓ Login to account
✓ Search flights (multiple ways)
✓ Book tickets
✓ View booking history
✓ Cancel bookings
✓ View profile

### Technical Features
✓ Input validation
✓ Error handling
✓ Menu-driven interface
✓ Clean OOP design
✓ Efficient data structures
✓ Proper documentation

---

## 💾 Data Persistence

| Current | Future |
|---------|--------|
| In-memory (HashMaps) | File-based storage |
| Lost on exit | Persistent storage |
| Sample data reloads | Database integration |

---

## 🔐 Security Notes

**Current Implementation:**
- Hardcoded admin credentials
- Plain text passwords
- No encryption

**For Production:**
- Use password hashing (BCrypt)
- Implement proper authentication (JWT)
- Use SSL/TLS encryption
- Add database access controls
- Implement audit logging

---

## 📞 Support & Troubleshooting

### Recompile After Changes
```bash
javac *.java
java Main
```

### Clear Console Before Testing
```bash
# Windows
cls

# Linux/Mac
clear
```

### Check Java Installation
```bash
java -version
javac -version
```

---

## 🎓 Learning Concepts

This project teaches:
- Object-Oriented Programming (OOP)
- Collections Framework (HashMap, ArrayList)
- Exception Handling
- Input/Output Operations
- Menu-Driven Programming
- Service Architecture Pattern
- Data Validation
- Business Logic Implementation

---

## 🔗 Quick Links to Key Methods

| Class | Key Methods |
|-------|------------|
| **Flight** | bookSeat(), cancelSeat() |
| **FlightService** | addFlight(), searchFlights() |
| **UserService** | registerUser(), loginUser() |
| **BookingService** | bookFlight(), cancelBooking() |
| **AdminService** | adminLogin(), displayAdminMenu() |
| **CustomerService** | displayCustomerMenu(), searchFlightsMenu() |

---

## 📱 User Workflows

### Admin Workflow
```
Start → Admin Login → View Options → 
Choose Action → Execute → Return to Admin Menu → Logout
```

### Customer Workflow
```
Start → Register/Login → Search Flights → 
Book/View/Cancel → View History → Logout
```

---

## ✅ Pre-Testing Checklist

- [ ] All .java files in project directory
- [ ] No compilation errors
- [ ] Java installed and in PATH
- [ ] Terminal/IDE ready
- [ ] Sample credentials written down
- [ ] Understanding of menu structure
- [ ] Test scenarios prepared

---

## 📊 Performance Notes

| Operation | Complexity | Notes |
|-----------|-----------|-------|
| Search Flight | O(n) | Linear search through flights |
| Login User | O(n) | Linear search through users |
| Book Ticket | O(1) | Direct HashMap lookup |
| Cancel Booking | O(1) | Direct HashMap access |

---

## 🎯 Next Steps After Learning

1. **Add File Persistence** - Save data to files
2. **Database Integration** - Use MySQL with JDBC
3. **GUI Implementation** - Create Swing/JavaFX interface
4. **Web Version** - Build Spring Boot web application
5. **Mobile App** - Develop Android/iOS version
6. **Microservices** - Split into microservice architecture

---

**Remember:** This system is designed for educational purposes. Always validate and extend it according to real-world requirements!

Happy Coding! ✨
