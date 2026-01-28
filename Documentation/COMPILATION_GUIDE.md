# Compilation and Execution Guide

## 🖥️ Using Command Line (Windows)

### Step 1: Navigate to Project Directory
```bash
cd "C:\Users\ayush\OneDrive\Desktop\AiRLiNE MS"
```

### Step 2: Compile All Java Files
```bash
javac *.java
```

This will generate .class files for each .java file.

### Step 3: Run the Application
```bash
java Main
```

The application will start and display the welcome message.

---

## 🎯 Using Eclipse IDE

### Step 1: Create New Java Project
- File → New → Java Project
- Project name: AiRLiNE-MS
- Click Finish

### Step 2: Create Package
- Right-click src folder
- New → Package
- Package name: `airline.system` (optional, can skip)

### Step 3: Import/Create Files
- Copy all .java files into the src folder (or src/airline.system/)

### Step 4: Run Application
- Right-click Main.java
- Run As → Java Application

---

## 🎯 Using IntelliJ IDEA

### Step 1: Create New Project
- File → New → Project
- Select Java, choose your JDK
- Project name: AiRLiNE-MS
- Click Create

### Step 2: Add Files
- Copy all .java files to src/ folder
- IntelliJ will automatically recognize them

### Step 3: Run Application
- Right-click Main.java
- Click "Run 'Main'"
- Or press Shift + F10

---

## 🎯 Using VS Code with Java Extension

### Step 1: Install Extensions
- Java Extension Pack (Microsoft)
- Debugger for Java

### Step 2: Create Folder Structure
```
AiRLiNE MS/
└── src/
    ├── Main.java
    ├── Flight.java
    ├── User.java
    ├── Booking.java
    ├── FlightService.java
    ├── UserService.java
    ├── BookingService.java
    ├── AdminService.java
    └── CustomerService.java
```

### Step 3: Open Folder in VS Code
- File → Open Folder → Select project directory

### Step 4: Run Application
- Click Run button on Main.java
- Or press F5

---

## 🧪 Testing the Application

### Test Admin Login
1. Select "Admin Login" from main menu
2. Email: `admin@airline.com`
3. Password: `admin123`

### Test Customer Registration
1. Select "Customer Portal"
2. Select "Register"
3. Fill in required details:
   - Name: Your Name
   - Email: your@email.com
   - Password: password123 (min 6 chars)
   - Phone: 9876543210 (10 digits)

### Test Customer Login
1. Select "Customer Portal"
2. Select "Login"
3. Use registered credentials

### Test Flight Search
1. Login as customer
2. Select "Search Flights"
3. Try searching by:
   - Source: Delhi, Destination: Mumbai
   - Or view all flights

### Test Flight Booking
1. Search and select a flight
2. Click "Book Ticket"
3. Enter passenger name
4. Confirm booking

### Test Booking Cancellation
1. View booking history
2. Select "Cancel Booking"
3. Enter booking ID
4. Confirm cancellation

---

## 📊 Sample Test Data

### Pre-loaded Flights
```
FL001: Delhi → Mumbai (08:00 AM - 10:30 AM) ₹5000
FL002: Delhi → Bangalore (09:00 AM - 12:00 PM) ₹6000
FL003: Mumbai → Goa (03:00 PM - 05:00 PM) ₹4500
FL004: Bangalore → Chennai (10:00 AM - 11:30 AM) ₹3500
FL005: Delhi → Kolkata (02:00 PM - 05:00 PM) ₹5500
```

### Sample User Accounts
```
User 1: ----@gmail.com / -----
User 2: ----@gmail.com / -----
```

---

## 🔧 Troubleshooting

### Issue: "javac: command not found"
**Solution:**
- Add Java to PATH environment variable
- Windows: Go to System Properties → Environment Variables
- Add JDK bin directory to PATH

### Issue: "java: command not found"
**Solution:** Same as above - add Java to PATH

### Issue: "cannot find symbol" compilation error
**Solution:**
- Ensure all .java files are in the same directory
- Check for typos in class names
- Verify imports if any

### Issue: NoSuchElementException when running
**Solution:**
- Ensure you're providing input through keyboard
- Don't pipe input from file
- Run directly without redirection

### Issue: Port or resource already in use
**Solution:**
- This application doesn't use network ports
- If error persists, restart your terminal

---

## 📝 Expected Output

### Welcome Message
```
==================================================
  ✈️  WELCOME TO AIRLINE MANAGEMENT SYSTEM ✈️
==================================================
  Book Your Flights Easily and Conveniently
==================================================
```

### Main Menu
```
==================================================
                  MAIN MENU
==================================================
1. Admin Login
2. Customer Portal
3. Exit
==================================================
Enter your choice:
```

---

## ✅ File Checklist

Before running, ensure you have all these files:
- [ ] Main.java
- [ ] Flight.java
- [ ] User.java
- [ ] Booking.java
- [ ] FlightService.java
- [ ] UserService.java
- [ ] BookingService.java
- [ ] AdminService.java
- [ ] CustomerService.java
- [ ] README.md
- [ ] COMPILATION_GUIDE.md

---

## 🚀 Quick Start (Copy-Paste)

### Windows Command Prompt
```bash
cd "C:\Users\ayush\OneDrive\Desktop\AiRLiNE MS"
javac *.java
java Main
```

### Linux/Mac Terminal
```bash
cd ~/AiRLiNE\ MS
javac *.java
java Main
```

---

Happy Coding! ✨
