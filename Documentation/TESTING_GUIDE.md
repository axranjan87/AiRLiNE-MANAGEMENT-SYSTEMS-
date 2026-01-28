# Testing Guide & Scenarios

Comprehensive testing guide for the Airline Management System.

---

## 🧪 Testing Categories

### 1. Unit Testing Scenarios
### 2. Integration Testing Scenarios
### 3. User Acceptance Testing (UAT)

---

## 🔐 Test 1: Admin Login

### Test Case 1.1: Valid Admin Credentials
```
Input:
  Email: admin@airline.com
  Password: admin123

Expected Output:
  ✓ Admin login successful!
  Admin Menu displayed
```

### Test Case 1.2: Invalid Email
```
Input:
  Email: wrong@email.com
  Password: admin123

Expected Output:
  ❌ Invalid admin credentials!
  Return to main menu
```

### Test Case 1.3: Invalid Password
```
Input:
  Email: admin@airline.com
  Password: wrongpass

Expected Output:
  ❌ Invalid admin credentials!
  Return to main menu
```

### Test Case 1.4: Empty Credentials
```
Input:
  Email: (empty)
  Password: (empty)

Expected Output:
  ❌ Invalid admin credentials!
  Return to main menu
```

---

## ✈️ Test 2: Flight Management (Admin)

### Test Case 2.1: Add New Flight
```
Input:
  Flight ID: FL100
  Source: Pune
  Destination: Hyderabad
  Departure: 11:00 AM
  Arrival: 01:00 PM
  Total Seats: 200
  Price: ₹7500

Expected Output:
  ✓ Flight added successfully!
  FL100 should appear in flight list
```

### Test Case 2.2: Add Duplicate Flight ID
```
Input:
  Flight ID: FL001 (existing)
  (other details)

Expected Output:
  ❌ Flight with ID FL001 already exists!
  Flight not added
```

### Test Case 2.3: Update Flight Details
```
Input:
  Flight ID: FL001
  Update Departure Time to: 09:00 AM

Expected Output:
  ✓ Flight updated successfully!
  FL001 now shows 09:00 AM departure
```

### Test Case 2.4: Delete Flight
```
Input:
  Flight ID: FL001
  Confirmation: yes

Expected Output:
  ✓ Flight deleted successfully!
  FL001 removed from system
```

### Test Case 2.5: Delete Non-Existent Flight
```
Input:
  Flight ID: FL999

Expected Output:
  ❌ Flight with ID FL999 not found!
```

### Test Case 2.6: View All Flights
```
Expected Output:
  List of all flights with details:
  - FL001 | From: Delhi To: Mumbai | ...
  - FL002 | From: Delhi To: Bangalore | ...
  (etc.)
```

---

## 👤 Test 3: Customer Registration

### Test Case 3.1: Valid Registration
```
Input:
  Name: Akshay Verma
  Email: akshay@email.com
  Password: secure123
  Phone: 9987654321

Expected Output:
  ✓ Registration successful! 
  Your User ID: USER1003
  User can now login
```

### Test Case 3.2: Duplicate Email
```
Input:
  Name: Another User
  Email: raj@email.com (existing)
  Password: password123
  Phone: 1234567890

Expected Output:
  ❌ Email already registered!
  Registration fails
```

### Test Case 3.3: Invalid Phone Number
```
Input:
  Name: Test User
  Email: test@email.com
  Password: password123
  Phone: 12345 (only 5 digits)

Expected Output:
  ❌ Phone number must be 10 digits!
  Registration fails
```

### Test Case 3.4: Short Password
```
Input:
  Name: Test User
  Email: test@email.com
  Password: 123 (less than 6 characters)
  Phone: 1234567890

Expected Output:
  ❌ Password must be at least 6 characters long!
  Registration fails
```

### Test Case 3.5: Empty Name
```
Input:
  Name: (empty)
  Email: test@email.com
  Password: password123
  Phone: 1234567890

Expected Output:
  ❌ Name cannot be empty!
  Registration fails
```

---

## 🔑 Test 4: Customer Login

### Test Case 4.1: Valid Login
```
Input:
  Email: raj@email.com
  Password: password123

Expected Output:
  ✓ Login successful!
  Customer Menu displayed
```

### Test Case 4.2: Incorrect Password
```
Input:
  Email: raj@email.com
  Password: wrongpassword

Expected Output:
  ❌ Invalid email or password!
  Return to login
```

### Test Case 4.3: Non-existent Email
```
Input:
  Email: nonexistent@email.com
  Password: password123

Expected Output:
  ❌ Invalid email or password!
  Return to login
```

### Test Case 4.4: Empty Email
```
Input:
  Email: (empty)
  Password: password123

Expected Output:
  ❌ Email cannot be empty!
  Return to login
```

---

## 🔍 Test 5: Flight Search

### Test Case 5.1: Search by Source and Destination
```
Input:
  Search Type: Source and Destination
  Source: Delhi
  Destination: Mumbai

Expected Output:
  FL001 | From: Delhi To: Mumbai | Available Seats: 140/150 | ₹5000
  (Flight matching criteria displayed)
```

### Test Case 5.2: Search with No Results
```
Input:
  Source: XYZ City
  Destination: ABC City

Expected Output:
  ❌ No flights found!
```

### Test Case 5.3: Search by Source Only
```
Input:
  Search Type: Source Only
  Source: Delhi

Expected Output:
  FL001 | From: Delhi To: Mumbai | ...
  FL002 | From: Delhi To: Bangalore | ...
  FL005 | From: Delhi To: Kolkata | ...
  (All flights from Delhi)
```

### Test Case 5.4: Search by Destination Only
```
Input:
  Search Type: Destination Only
  Destination: Mumbai

Expected Output:
  FL001 | From: Delhi To: Mumbai | ...
  (All flights to Mumbai)
```

### Test Case 5.5: View All Flights
```
Expected Output:
  Complete list of all flights in system
```

---

## 🎫 Test 6: Flight Booking

### Test Case 6.1: Successful Booking
```
Input:
  Flight ID: FL001
  Passenger Name: Raj Kumar
  Confirmation: yes

Expected Output:
  ✓ Booking successful! 
  Booking ID: BK5001
  Seat Number: S10
  Total Cost: ₹5000
  Flight available seats reduced from 140 to 139
```

### Test Case 6.2: Booking Non-Existent Flight
```
Input:
  Flight ID: FL999

Expected Output:
  ❌ Flight not found!
  Booking cancelled
```

### Test Case 6.3: Booking with No Available Seats
```
Pre-condition: Flight has 0 available seats

Expected Output:
  ❌ No seats available on this flight!
  Booking fails
```

### Test Case 6.4: Empty Passenger Name
```
Input:
  Passenger Name: (empty)
  Flight ID: FL001

Expected Output:
  ❌ Passenger name cannot be empty!
  Booking fails
```

### Test Case 6.5: Booking Cancelled by User
```
Input:
  Flight ID: FL001
  Confirmation: no

Expected Output:
  ✓ Booking cancelled!
  Return to menu
  Seat availability unchanged
```

---

## 📋 Test 7: View Booking History

### Test Case 7.1: User with Multiple Bookings
```
Input:
  Logged in as: Raj Kumar

Expected Output:
  1. Booking ID: BK5001 | Passenger: Raj Kumar | Flight: FL001 | Seat: S10 | Status: CONFIRMED
  2. Booking ID: BK5002 | Passenger: Raj Kumar | Flight: FL002 | Seat: S15 | Status: CONFIRMED
  (All bookings listed)
```

### Test Case 7.2: User with No Bookings
```
Expected Output:
  No bookings found!
```

### Test Case 7.3: View Cancelled Bookings
```
Expected Output:
  Cancelled bookings also displayed in history with CANCELLED status
```

---

## ❌ Test 8: Cancel Booking

### Test Case 8.1: Cancel Valid Booking
```
Input:
  Booking ID: BK5001
  Confirmation: yes

Expected Output:
  ✓ Booking cancelled successfully! Amount will be refunded.
  Booking Status changed to CANCELLED
  Flight available seats increased
```

### Test Case 8.2: Cancel Already Cancelled Booking
```
Input:
  Booking ID: BK5001 (already cancelled)

Expected Output:
  ❌ Booking is already cancelled!
```

### Test Case 8.3: Cancel Non-Existent Booking
```
Input:
  Booking ID: BK9999

Expected Output:
  ❌ Booking not found!
```

### Test Case 8.4: Cancel Cancelled by User
```
Input:
  Booking ID: BK5001
  Confirmation: no

Expected Output:
  ✓ Cancellation cancelled!
  Return to menu
  Booking status unchanged
```

---

## 👤 Test 9: View/Manage Profile

### Test Case 9.1: View User Profile
```
Expected Output:
  User ID: USER1001
  Name: Raj Kumar
  Email: raj@email.com
  Phone: 9876543210
```

---

## 🔄 Test 10: Logout

### Test Case 10.1: Admin Logout
```
Expected Output:
  ✓ Admin logged out successfully!
  Return to main menu
```

### Test Case 10.2: Customer Logout
```
Expected Output:
  ✓ Logged out successfully!
  Return to main menu
```

---

## ⚠️ Test 11: Input Validation

### Test Case 11.1: Invalid Menu Choice
```
Input:
  Choice: 99

Expected Output:
  ❌ Invalid choice! Please try again.
```

### Test Case 11.2: Non-Numeric Input
```
Input:
  Choice: abc

Expected Output:
  ❌ Invalid input! Please enter a number.
```

### Test Case 11.3: Special Characters in Input
```
Input:
  Flight ID: FL@#$

Expected Output:
  Can proceed (system accepts)
```

### Test Case 11.4: Very Long Input
```
Input:
  Name: Very long string with many characters...

Expected Output:
  Can be stored (no length limit in current implementation)
```

---

## 🔀 Test 12: Concurrent Bookings

### Test Case 12.1: Multiple Users Booking Same Flight
```
Scenario:
  User 1 books last available seat on FL001
  User 2 tries to book same flight

Expected Output:
  User 1: ✓ Booking successful
  User 2: ❌ No seats available!
```

---

## 📊 Test 13: Data Persistence (Current Implementation)

### Test Case 13.1: Data Lost After Exit
```
Note: Current implementation uses in-memory storage
- All data is lost when application exits
- Restart shows sample data only

Expected behavior documented
```

---

## 🎯 Test 14: Exit Application

### Test Case 14.1: Exit from Main Menu
```
Input:
  Choice: 3

Expected Output:
  Thank you for using Airline Management System!
  Have a pleasant flight!
  Application closes gracefully
```

---

## 📝 Test Execution Checklist

- [ ] Run all admin login tests
- [ ] Run all flight management tests
- [ ] Run all customer registration tests
- [ ] Run all customer login tests
- [ ] Run all flight search tests
- [ ] Run all booking tests
- [ ] Run all booking history tests
- [ ] Run all cancellation tests
- [ ] Run all input validation tests
- [ ] Run all logout tests
- [ ] Run exit test

---

## 🐛 Bug Tracking Template

```
Bug ID: [XXXX]
Title: [Brief description]
Severity: [Critical/Major/Minor]
Steps to Reproduce:
  1. [Step 1]
  2. [Step 2]
  3. [Step 3]
Expected Result: [What should happen]
Actual Result: [What actually happened]
Environment: [OS, Java version]
Attachments: [Screenshots if needed]
```

---

## ✅ Test Summary Report Template

```
Test Suite: Airline Management System
Date: [DATE]
Tester: [NAME]
Total Tests: [NUMBER]
Passed: [NUMBER]
Failed: [NUMBER]
Success Rate: [PERCENTAGE]

Failed Tests:
  1. [Test name] - [Issue description]
  2. [Test name] - [Issue description]

Notes:
  [Any additional notes]
```

---

For automated testing, consider using:
- JUnit for unit tests
- Mockito for mocking services
- Selenium for UI testing (if GUI version created)

Happy Testing! ✨
