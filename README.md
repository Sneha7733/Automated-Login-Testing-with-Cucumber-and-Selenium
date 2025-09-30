# Login Automation Project

## 📌 Project Description
This project automates testing of the login form on  
🔗 https://the-internet.herokuapp.com/login

It uses **Cucumber (BDD)**, **Selenium WebDriver**, and **Java** to simulate different login scenarios.

---

## ✅ Test Cases Implemented
1. Valid Login → Redirects to Secure Area  
2. Invalid Login → Displays "Your username is invalid!"  
3. Empty Fields → Displays "This field is required"  
4. Bonus: Data-driven testing using Cucumber Examples  

---

## ⚙️ Tools & Technologies
- Java 11+
- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- Maven
- ChromeDriver

---

## ▶️ How to Run
1. Clone this repository  
2. Install dependencies:  
   ```bash
   mvn clean install
   ```
3. Run tests:  
   ```bash
   mvn test
   ```
4. Reports will be generated at:  
   ```
   target/cucumber-reports.html
   ```

---

## 🎯 Bonus
Data-driven testing implemented using Cucumber **Scenario Outline** with **Examples** table.
