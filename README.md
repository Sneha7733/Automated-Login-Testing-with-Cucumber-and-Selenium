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
- Java
- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- Maven
- ChromeDriver

---

## ⚙️ Setup Instructions

1. **Clone or Create Project**
   ```bash
   git clone <repo-url>
   cd SeleniumLoginProject 
2. **Maven Dependencies**
   - **IntelliJ will auto-import dependencies from pom.xml.**
   - **Or run:**
     mvn clean install
   ```
3. Run tests:  
   ```bash
   mvn test
   ```

---

## 🎯 Bonus
Data-driven testing implemented using Cucumber **Scenario Outline** with **Examples** table.
