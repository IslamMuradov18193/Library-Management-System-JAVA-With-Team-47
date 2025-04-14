[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/4zK3HDh5)
Compile the ProjectIn your Java IDE, compile the project to ensure all dependencies are resolved:
javac -cp ".:src/" src/MainApplicationFrame.java


Run the ApplicationRun the MainApplicationFrame.java file as the main entry point:
java -cp ".:src/" MainApplicationFrame

Explore the FeaturesDepending on your role as a User

Login or RegisterAfter starting the application:




# Library Management System 📚

## Overview

Welcome to the **Library Management System**, a comprehensive Java-based program designed to manage a library's user and book databases efficiently. This system supports various user roles (Admin, Personal User, and General User), provides robust login and registration capabilities, and includes intuitive GUI frames to manage and explore the library's resources.

## Features

### User Management
- **Registration and Login:** Supports user roles such as Admin, Personal User, and General User.
- **Admin Capabilities:** Admins can manage users and oversee the system.
- **Password Validation:** Ensures passwords adhere to security standards.

### Library Management
- **Book Management:** Add and manage books in the system.
- **Separate Interfaces:** Different interfaces for Admins, General Users, and Personal Users.
- **Library Separation:** Maintain both personal and general libraries.
- **Search and Exploration:** Search and explore available books.

### Database Management
- **CSV-Based Storage:** User, book, and login data stored in CSV files.
- **Banned Users:** Track and manage banned users.

## Project Structure

```plaintext
LibraryManagementSystem/
├── data/
│   ├── bannedUsers.csv
│   ├── brodsky.csv
│   ├── GeneralDatabase.csv
│   ├── LoginDatabase.csv
│   ├── PersonalDatabse.csv
├── src/
│   ├── AdminLibraryFrame.java
│   ├── AdminMainApplicationFrame.java
│   ├── AdminUserFrame.java
│   ├── AddBookDialog.java
│   ├── Book.java
│   ├── DatabaseHandler.java
│   ├── GeneralLibraryForUsersFrame.java
│   ├── LoginFrame.java
│   ├── MainApplicationFrame.java
│   ├── NavigableSortableTable.java
│   ├── Overloading.java
│   ├── PasswordChecklist.java
│   ├── PersonalLibraryFrame.java
│   ├── RegistrationFrame.java
│   └── UserDatabase.java
│   └── User.java
