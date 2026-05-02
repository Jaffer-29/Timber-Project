# Timber Management System (Java Console Application)

A structured and efficient **Timber Inventory Management System** developed in Java, designed to manage real-world inventory operations such as stock tracking, sales processing, and record maintenance.

This project was developed as the **first assignment of the third semester** as part of academic coursework. It demonstrates a solid foundation in **Data Structures, File Handling, and Object-Oriented Programming (OOP)** through a complete, working system. A **GUI-based version (Java Swing/JavaFX)** is currently under development to further enhance usability and user experience.

---

## Overview

Managing timber inventory manually can lead to inconsistencies and inefficiencies. This system provides a lightweight digital solution to:

* Maintain timber stock records
* Track sales and availability
* Analyze inventory levels
* Store and retrieve data using file handling

The application uses a **Linked List-based dynamic structure** to manage records in memory while ensuring persistence through file storage.

---

## Key Features

### Timber Record Management

* Add new timber entries with unique IDs
* Prevent duplicate record insertion
* Store attributes such as zone, kind, quantity, price, weight, height, and status

### Inventory Display

* Display all timber records in a structured tabular format
* Zone-based sorted display (A, B, C, D)

### Search Functionality

* Search timber records by:

  * Zone
  * Kind (case-insensitive)

### Stock Analysis

* Identify low-stock timber using a user-defined threshold
* Supports better inventory planning and restocking decisions

### Sales Processing

* Sell timber using:

  * Timber ID
  * Timber Kind
* Automatic stock deduction and status updates

### Update Operations

* Update stock quantity along with weight and height
* Modify timber pricing dynamically

### Record Deletion

* Delete timber records with user confirmation
* Ensures synchronization between memory and file storage

### Inventory Report

* Total timber types
* Total quantity
* Inventory value
* Average weight and height
* Stock status summary (In Stock, Sold, Reserved)

### File Handling (Persistent Storage)

* Stores data in `TimberData.txt`
* Reads and reconstructs records into memory
* Maintains data consistency across program executions

---

## Technical Highlights

### Data Structure Used

* Singly Linked List

  * Dynamic memory allocation
  * Efficient insertion and traversal
  * Custom node structure using the `Timber` class

### File Handling

* BufferedWriter for writing records
* BufferedReader for reading records
* Supports both append and full rewrite operations

### Object-Oriented Programming Concepts

* Encapsulation: Data and methods combined within class structure
* Abstraction: Logical separation of functionalities
* Composition: Linked object relationships
* Modularity: Independent methods for each operation

### Execution Flow

1. Load existing records from file into memory
2. User interacts through a menu-driven interface
3. Operations update the linked list dynamically
4. Changes are written back to the file system

---

## Project Structure

```bash id="b9x3pk"
Timber-Management-System/
│── Timber.java        # Core logic, data structure, and operations
│── TimberTest.java    # Main class (menu-driven interface)
│── TimberData.txt     # Data storage file (auto-generated)
```

---

## Getting Started

### Requirements

* Java JDK 8 or higher

### Compile and Run

```bash id="o1l7yk"
javac Timber.java TimberTest.java
java TimberTest
```

---

## Sample Workflow

1. Launch the system
2. Add timber records
3. View or search inventory
4. Perform sales or updates
5. Analyze stock levels
6. Exit and relaunch — data persists

---

## Limitations

* Console-based interface (GUI version under development)
* No undo/redo functionality
* File format is plain text
* No multi-user support
* Date parsing from file is currently disabled

---

## Future Improvements

* Graphical User Interface using Java Swing or JavaFX
* Database integration (MySQL or SQLite)
* Authentication and user roles
* Export reports (PDF/CSV)
* Undo/Redo functionality
* REST API version using Spring Boot

---

## Code Review and Design Notes

This project reflects a strong foundational understanding of core Java concepts and their application to a real-world problem.

### Strengths

* Clear and modular structure
* Effective use of linked lists for dynamic data management
* Duplicate ID validation ensures data integrity
* Functional file persistence mechanism
* Covers complete CRUD operations

### Areas for Improvement

* The `Timber` class combines both data and business logic (can be separated for better scalability)
* Repeated traversal logic can be optimized using helper methods
* File writing approach can be improved to avoid unnecessary rewrites
* Exception handling can be made more specific instead of using generic exceptions
* User interaction flow can be refined for better usability

---

## Author

Muhammad Jaffer <br>
Java Developer with a focus on Object-Oriented Programming and Data Structures

---

## License

This project is intended for educational and academic use.<br>
You are free to use, modify, and extend it.

---

## Final Note

This project represents an early but solid step toward building more advanced inventory management systems. Future development will focus on improving scalability, introducing a graphical interface, and integrating modern backend technologies.

---
