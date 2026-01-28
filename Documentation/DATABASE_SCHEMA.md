# Database Schema Documentation

This document outlines the database structure needed for a JDBC/MySQL version of the Airline Management System.

## 📊 Database Design

### Database Name
```sql
CREATE DATABASE AirlineMS;
USE AirlineMS;
```

---

## 📋 Table Schemas

### 1. FLIGHTS Table

```sql
CREATE TABLE flights (
    flight_id VARCHAR(10) PRIMARY KEY,
    source VARCHAR(50) NOT NULL,
    destination VARCHAR(50) NOT NULL,
    departure_time VARCHAR(20) NOT NULL,
    arrival_time VARCHAR(20) NOT NULL,
    total_seats INT NOT NULL,
    available_seats INT NOT NULL,
    ticket_price DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

**Indexes:**
```sql
CREATE INDEX idx_source_destination ON flights(source, destination);
CREATE INDEX idx_source ON flights(source);
CREATE INDEX idx_destination ON flights(destination);
```

---

### 2. USERS Table

```sql
CREATE TABLE users (
    user_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

**Indexes:**
```sql
CREATE INDEX idx_email ON users(email);
CREATE INDEX idx_phone ON users(phone_number);
```

---

### 3. BOOKINGS Table

```sql
CREATE TABLE bookings (
    booking_id VARCHAR(20) PRIMARY KEY,
    passenger_name VARCHAR(100) NOT NULL,
    user_id VARCHAR(20),
    flight_id VARCHAR(10) NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    booking_date DATE NOT NULL,
    booking_status VARCHAR(20) NOT NULL,
    booking_amount DECIMAL(10, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

**Indexes:**
```sql
CREATE INDEX idx_passenger_name ON bookings(passenger_name);
CREATE INDEX idx_flight_id ON bookings(flight_id);
CREATE INDEX idx_user_id ON bookings(user_id);
CREATE INDEX idx_booking_status ON bookings(booking_status);
```

---

### 4. ADMIN_USERS Table (Optional)

```sql
CREATE TABLE admin_users (
    admin_id VARCHAR(20) PRIMARY KEY,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100),
    role VARCHAR(50) DEFAULT 'ADMIN',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

---

### 5. BOOKINGS_HISTORY Table (Optional - for audit trail)

```sql
CREATE TABLE booking_history (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id VARCHAR(20) NOT NULL,
    action VARCHAR(50) NOT NULL,
    old_status VARCHAR(20),
    new_status VARCHAR(20),
    action_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id)
);
```

---

### 6. PAYMENTS Table (Optional - for future enhancement)

```sql
CREATE TABLE payments (
    payment_id VARCHAR(20) PRIMARY KEY,
    booking_id VARCHAR(20) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50),
    payment_status VARCHAR(20),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id)
);
```

---

## 🔑 Key Constraints & Relationships

| Table | Column | References | Type |
|-------|--------|-----------|------|
| bookings | flight_id | flights | Foreign Key |
| bookings | user_id | users | Foreign Key |
| booking_history | booking_id | bookings | Foreign Key |
| payments | booking_id | bookings | Foreign Key |

---

## 📝 Sample Data

### Insert Sample Flights
```sql
INSERT INTO flights VALUES
('FL001', 'Delhi', 'Mumbai', '08:00 AM', '10:30 AM', 150, 140, 5000.00, NOW(), NOW()),
('FL002', 'Delhi', 'Bangalore', '09:00 AM', '12:00 PM', 180, 170, 6000.00, NOW(), NOW()),
('FL003', 'Mumbai', 'Goa', '03:00 PM', '05:00 PM', 120, 115, 4500.00, NOW(), NOW()),
('FL004', 'Bangalore', 'Chennai', '10:00 AM', '11:30 AM', 100, 95, 3500.00, NOW(), NOW()),
('FL005', 'Delhi', 'Kolkata', '02:00 PM', '05:00 PM', 160, 155, 5500.00, NOW(), NOW());
```

### Insert Sample Users
```sql
INSERT INTO users VALUES
('USER1001', 'Ayush Ranjan', 'ayushranjan8757@gmail.com', 'Ayush8757', '8757491266', NOW(), NOW()),
('USER1002', 'Shruti Kumari', 'ar6455476@gmail.com', 'Shruti8757', '8757491266', NOW(), NOW());
```

### Insert Admin User
```sql
INSERT INTO admin_users VALUES
('ADMIN001', 'ayushranjan8757@airline.com', 'Ayush@8757', 'Admin User', 'ADMIN', NOW(), NOW());
```

---

## 🔍 Useful Queries

### Get all flights from a source
```sql
SELECT * FROM flights WHERE source = 'Delhi';
```

### Get all bookings for a passenger
```sql
SELECT * FROM bookings WHERE passenger_name = 'Ayush Ranjan';
```

### Get available flights on a route
```sql
SELECT * FROM flights 
WHERE source = 'Delhi' AND destination = 'Mumbai' 
AND available_seats > 0;
```

### Get booking details with flight info
```sql
SELECT b.*, f.source, f.destination, f.departure_time 
FROM bookings b
JOIN flights f ON b.flight_id = f.flight_id
WHERE b.passenger_name = 'Ayush Ranjan';
```

### Count confirmed bookings per flight
```sql
SELECT flight_id, COUNT(*) as confirmed_count 
FROM bookings 
WHERE booking_status = 'CONFIRMED' 
GROUP BY flight_id;
```

### Get flight utilization percentage
```sql
SELECT flight_id, 
       ROUND((total_seats - available_seats) / total_seats * 100, 2) as utilization_percent
FROM flights;
```

---

## 🔒 Database Security

1. **User Permissions**
```sql
CREATE USER 'airline_user'@'localhost' IDENTIFIED BY 'secure_password';
GRANT SELECT, INSERT, UPDATE, DELETE ON AirlineMS.* TO 'airline_user'@'localhost';
FLUSH PRIVILEGES;
```

2. **For Admin-only access**
```sql
CREATE USER 'airline_admin'@'localhost' IDENTIFIED BY 'admin_password';
GRANT ALL PRIVILEGES ON AirlineMS.* TO 'airline_admin'@'localhost';
FLUSH PRIVILEGES;
```

---

## 📈 Query Performance Tips

1. **Add indexes for frequently searched columns:**
   - email (users table)
   - passenger_name (bookings table)
   - flight_id (bookings table)

2. **Use EXPLAIN to analyze queries:**
```sql
EXPLAIN SELECT * FROM flights WHERE source = 'Delhi';
```

3. **Archive old bookings periodically**
```sql
-- Archive bookings older than 1 year
INSERT INTO bookings_archive 
SELECT * FROM bookings WHERE booking_date < DATE_SUB(NOW(), INTERVAL 1 YEAR);
```

---

## 🔄 Transaction Example

```sql
START TRANSACTION;

UPDATE flights SET available_seats = available_seats - 1 WHERE flight_id = 'FL001';

INSERT INTO bookings VALUES ('BK5001', 'Customer Name', 'USER1001', 'FL001', 'S1', NOW(), 'CONFIRMED', 5000, NOW(), NOW());

COMMIT;
```

---

## 📊 Data Types Reference

| Java Type | SQL Type | Notes |
|-----------|----------|-------|
| String | VARCHAR | Use appropriate length |
| int | INT | For counts, IDs |
| double | DECIMAL(10,2) | For monetary values |
| LocalDate | DATE | For dates without time |
| LocalDateTime | TIMESTAMP | For complete date/time |
| boolean | TINYINT(1) | 0 or 1 |

---

## 🚀 Migration Path (Current → JDBC)

### Phase 1: Database Setup
- Create database and tables
- Insert sample data
- Test connections

### Phase 2: Update Model Classes
- Add JPA annotations or JDBC methods
- Update constructors for database IDs

### Phase 3: Create DAOs (Data Access Objects)
```
FlightDAO.java
UserDAO.java
BookingDAO.java
```

### Phase 4: Update Service Classes
- Replace HashMap operations with database queries
- Update CRUD methods

### Phase 5: Connection Management
- Create ConnectionPool class
- Implement connection lifecycle management

---

## 💡 Future Enhancements

1. **Caching Layer** - Redis for frequently accessed flights
2. **Search Optimization** - Elasticsearch for advanced search
3. **Reporting** - Daily booking reports
4. **Analytics** - Flight occupancy trends
5. **Backup Strategy** - Automated database backups

---

For more information, refer to the main README.md file.
