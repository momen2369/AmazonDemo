# 🛒 Amazon Automation using Selenium & Page Object Model (POM)

## 📌 Overview
This project automates key scenarios on Amazon using **Selenium WebDriver**, **Page Object Model (POM)**, and **Java**.
It includes functionalities like login, selecting menus from sidebar, sorting, adding items to the cart, and verifying the cart summary.

## 🚀 Features
- ✅ **Login Automation** (Username & Password handling)
- 🔍 **Search Functionality** (Finding products based on criteria)
- 🛒 **Add to Cart** (Selecting items based on price filters)
- 📦 **Cart Summary Validation**
- 🏗 **Page Object Model (POM) Implementation**
- 🕵️‍♂️ **Explicit & Implicit Waits** for better stability
- 🏎 **Headless Execution** support

## 🛠 Tech Stack
- **Language**: Java
- **Automation Framework**: Selenium WebDriver
- **Design Pattern**: Page Object Model (POM)
- **Build Tool**: Maven
- **Test Runner**: TestNG

## 🔧 Setup & Installation
### 1️⃣ **Clone the Repository**
```sh
git clone https://github.com/momen2369/AmazonDemo.git
```

### 2️⃣ Install Dependencies
Make sure you have Java & Maven installed, then run:

```sh
mvn clean install
```
### 3️⃣ Run the Tests
Add valid Login Credentials to :
```ini
src/main/resources/config.properties
```
### 4️⃣ Run the Tests
```sh
mvn test
```

🏗 Project Structure
bash
```
📦 AmazonDemo
 ┣ 📂 src/main/java
 ┃ ┣ 📂 basePage
 ┃ ┃ ┗ BasePage.java
 ┃ ┣ 📂 pages
 ┃ ┃ ┣ CartPage.java
 ┃ ┃ ┣ CheckOutPage.java
 ┃ ┃ ┣ LoginEmailPage.java
 ┃ ┃ ┣ LoginPasswordPage.java
 ┃ ┃ ┣ HomePage.java
 ┃ ┃ ┗ ProductsList.java
 ┃ ┣ 📂 utils
 ┃ ┃ ┗ ConfigReader.java
 ┃ ┣ 📂 webDriver
 ┃ ┃ ┗ WebDriverSingleton.java
 ┃ ┣ 📂 resources
 ┃ ┃ ┗ config.properties
 ┣ 📂 src/test/java
 ┃ ┣ 📂 baseTest
 ┃ ┃ ┗ BaseTest.java
 ┃ ┣ 📂 tests
 ┃ ┃ ┗ CheckOutTest.java
 ┣ pom.xml
 ┣ README.md
```

### 📸 Screenshots
<img width="1333" alt="image" src="https://github.com/user-attachments/assets/9f068b65-5979-4217-89e5-2c9991cfa6a6" />
