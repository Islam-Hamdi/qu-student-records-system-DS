# 🗃️ QU Student Records System

> **CMPS303 – Data Structures | Qatar University**  
> **Spring 2022 – Second Year, Third Semester**

Java console application developed for CMPS303 (Data Structures) at Qatar University. Implements a hybrid data structure (Hash Table of Trees) to manage and optimize student records with insert, search, and delete operations.

---

## 📌 Overview

The system models Qatar University's student records management, where each student has:
- `ID` (composed of admission year + unique number)
- `Name`
- `GPA`

### Menu Functionality:
```
1. Insert a new student  
2. Search for a student  
3. Delete a student  
4. Exit and save data
```

All records are stored and retrieved using **object serialization**, allowing the program to persist data across sessions.

---

## 🚀 Key Features

- ✅ **Insert, Search, Delete** operations via a console interface  
- 🧠 **Custom data structure** combining Hash Tables and Trees for efficiency  
- 💾 **Persistent storage** using Java Serialization (`.dat` file)  
- 📊 **Performance comparison** with alternative ADTs (chaining, nested hash tables, etc.)  
- 📂 Clean package structure with separation of concerns  

---

## 🧠 Data Structure: Hash Table of Trees

Each bucket of the hash table contains a **Binary Search Tree** storing students admitted in a specific year. The student ID format helps optimize search ranges by year-based hashing.

### Complexity Comparison

| Operation | Our Option (B): Hash Table of Trees | Option A: Chaining | Option C: Nested Hash Table | Option D: Tree of Linked Lists |
|-----------|--------------------------------------|--------------------|-----------------------------|--------------------------------|
| Insert    | O(log n)                             | O(n)               | O(1)                        | O(log n)                       |
| Delete    | O(log n)                             | O(n)               | O(1)                        | O(n log n)                     |
| Search    | O(log n)                             | O(n)               | O(1)                        | O(n log n)                     |
| Memory    | Medium                               | Moderate           | High                        | Low                            |

---

## 📁 Project Structure

```
📂 src/
├── Node.java                 # Node structure for Tree
├── Student.java              # Model class for student records
├── Tree.java                 # Binary Search Tree logic
├── TreeInHashTable.java      # Hash table with tree buckets
└── Tester.java               # Main menu and interaction logic

📄 HashArray.dat              # Serialized data (generated at runtime)
```

---

## 🛠 How to Run

1. Open the project in any Java IDE (e.g., Eclipse, IntelliJ).
2. Ensure all `.java` files are in the same `src/` directory.
3. Run `Tester.java` to launch the system.
4. Interact via the console menu.

> ⚠️ The application will load saved data from `HashArray.dat` if available.

---

## 👨🏻‍💻 Team Members

- **Islam Hamdi** – 202004552  
- Fatima Mahgoub – 202007684  
- Najah Alnounou – 202006879  
- Salma Badawy – 202007736  

---

## 📸 Screenshots

Include images such as:
- Menu on startup
- <img width="591" alt="image" src="https://github.com/user-attachments/assets/a7180bcf-aa73-47f1-885e-3c3f365ab9f5" />

- Insert student console
- Search and delete outputs
- Data serialization confirmation

> *(Place your screenshots in a `/screenshots/` folder if uploading to GitHub)*

---

## 📜 License

This project is for educational purposes only and was developed for coursework at Qatar University.
