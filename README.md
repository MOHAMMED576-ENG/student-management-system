# Student Management System

A simple Java console application for managing student records.

## Features

- Add a student
- Show all students
- Search for a student by ID
- Update a student's name and GPA
- Delete a student
- Prevent duplicate student IDs
- Validate GPA values between 0.0 and 5.0
- Validate user input

## Technologies

- Java
- Object-Oriented Programming (OOP)
- ArrayList / List
- Scanner
- Git & GitHub

## Project Structure

```text
student-management-system/
├── src/
│   ├── Main.java
│   ├── Student.java
│   └── StudentManager.java
├── .gitignore
└── README.md
```

## How to Run

From the project folder:

```bash
javac src/*.java
java -cp src Main
```

## Example

```text
=== Student Management System ===
1. Add Student
2. Show Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
Choose: 1

ID: 1
Name: Mohammed
GPA (0.0 - 5.0): 3.26

Student added successfully.
```

## Future Improvements

- Save students to a file
- Connect the project to MySQL
- Add a graphical user interface
- Add unit tests