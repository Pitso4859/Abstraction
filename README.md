🏢 Employee Payroll System (Java)
Description

This is a menu-driven Employee Payroll System built in Java to demonstrate Object-Oriented Programming (OOP) concepts such as:

Abstraction – via the abstract Employee class and calculateSalary() method.

Inheritance – FullTimeEmployee, PartTimeEmployee, and CommissionEmployee extend Employee.

Polymorphism – All employee types are handled through the Employee reference, allowing dynamic salary calculation.

Encapsulation – Employee data is protected using private fields.

The system allows users to add employees, display details, and calculate total payroll through a simple console-based menu.

Features

Add Full-Time Employee with fixed monthly salary

Add Part-Time Employee with hourly rate × hours worked

Add Commission Employee with base salary + commission

Display all employee details

Calculate total payroll dynamically

Menu-driven and interactive

Stores employees dynamically using ArrayList<Employee>

Technologies Used

Java SE

Object-Oriented Programming Concepts:

Abstract Classes & Methods

Method Overriding

Polymorphism

ArrayList for dynamic employee storage

Scanner for user input

UML Diagram
+------------------+
|   Employee (abstract)  |
+------------------+
| - name: String       |
| - id: int            |
+------------------+
| + calculateSalary(): double (abstract) |
| + displayInfo(): void                 |
+------------------+
          ^
          |
  -------------------------
  |           |            |
FullTime   PartTime   Commission
Employee   Employee   Employee
+-----------------------------+
| + monthlySalary: double     |
+-----------------------------+
| + calculateSalary(): double |
+-----------------------------+

Arrow ^ shows inheritance

Each subclass implements calculateSalary() differently

Getting Started

Clone the Repository

git clone https://github.com/<your-username>/employee-payroll-system.git

Compile the Program

javac EmployeePayrollSystem.java

Run the Program

java EmployeePayrollSystem
Sample Usage
===== EMPLOYEE PAYROLL MENU =====
1. Add Full-Time Employee
2. Add Part-Time Employee
3. Add Commission Employee
4. Display All Employees
5. Calculate Total Payroll
6. Exit
Enter your choice: 1
Enter Name: John
Enter ID: 101
Enter Monthly Salary: 25000
Full-Time Employee Added!

===== EMPLOYEE PAYROLL MENU =====
Enter your choice: 2
Enter Name: Mary
Enter ID: 102
Enter Hourly Rate: 150
Enter Hours Worked: 80
Part-Time Employee Added!

===== EMPLOYEE PAYROLL MENU =====
Enter your choice: 4
ID: 101
Name: John
Salary: 25000.0
---------------------------
ID: 102
Name: Mary
Salary: 12000.0
---------------------------

===== EMPLOYEE PAYROLL MENU =====
Enter your choice: 5
Total Payroll: 37000.0
