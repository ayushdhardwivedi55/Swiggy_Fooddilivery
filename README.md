# Swiggy Food Delivery API Test Automation

This project contains automated API tests for the Swiggy Food Delivery platform. The tests cover key functionality such as user login, fetching restaurants, adding items to the cart, placing orders, and validating checkout success.

---

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Setup & Installation](#setup--installation)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Notes](#notes)
- [Contributing](#contributing)
- [Contact](#contact)

---

## Project Overview

This project automates the testing of Swiggy's food delivery REST APIs using Java, TestNG, and RestAssured. It includes parallel execution of tests to improve efficiency and detailed assertions to validate API responses.

---

## Technologies Used

- **Java** - programming language  
- **TestNG** - testing framework  
- **RestAssured** - API automation library  
- **Maven** - build and dependency management  
- **Git** - version control  
- **Eclipse IDE** - development environment  

---

## Prerequisites

- Java JDK 11 or above installed  
- Maven installed  
- Git installed  
- Eclipse IDE (or any Java IDE)  
- Internet connection to hit Swiggy's APIs  

---

## Project Structure

Swiggy_Food_Delivery/
├── src/
│ ├── main/
│ └── test/
│ ├── java/
│ │ └── Swiggy/ # Package containing all test classes
│ │ ├── CartTest.java
│ │ ├── CheckoutTest.java
│ │ ├── HomeTest.java
│ │ ├── LoginTest.java
│ │ ├── MenuTests.java
│ │ ├── OrderSuccessTest.java
│ │ └── RestaurantsTest.java
│ └── resources/
├── pom.xml # Maven dependencies and build file
└── README.md


---

## Setup & Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/ayushdhardwivedi55/Swiggy_Fooddilivery.git
    cd Swiggy_Fooddilivery
    ```

2. Open the project in your favorite IDE (e.g., Eclipse).

3. Ensure Maven dependencies are downloaded:
    ```bash
    mvn clean install
    ```

4. Configure Java JDK and Maven in your IDE if not configured already.

---

## Running Tests

You can run tests in several ways:

- **Using TestNG XML Suite**:  
  Run the `testng.xml` file from your IDE to execute all tests in parallel.

- **Using Maven**:
  ```bash
  mvn test

Contact
Created by Ayush Dhar Dwivedi
Email: princedhardwivedi55@gmail.com
GitHub: https://github.com/ayushdhardwivedi55

