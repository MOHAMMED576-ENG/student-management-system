# Student Management System

A Java console application for managing student records.

This project was built to practice Java, Object-Oriented Programming (OOP), file handling, and Git/GitHub.

## Features

- Add new students
- View all students
- Search for a student by ID
- Update student information
- Delete students
- Prevent duplicate student IDs
- Validate GPA input
- Save student data to a local file
- Load saved data when the application starts

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- File Handling
- Git
- GitHub

## Project Structure

- `Main.java` - Handles the application menu and user input
- `Student.java` - Represents a student object
- `StudentManager.java` - Handles student management and file storage
- `.gitignore` - Excludes unnecessary and local files

## How to Run

Make sure Java JDK 21 or later is installed.

Compile the project:

```bash
javac Main.java Student.java StudentManager.java
```

Run the application:

```bash
java Main
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
Choose:
```

## What I Learned

Through this project, I practiced:

- Creating Java classes and objects
- Using methods and collections
- Working with ArrayList
- Reading and writing data to files
- Input validation
- Basic CRUD operations
- Version control using Git and GitHub

## Future Improvements

- MySQL database integration
- Graphical user interface
- User authentication
- Unit testing