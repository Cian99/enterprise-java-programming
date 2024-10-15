# Enterprise Java Programming
This repository contains two Java-based web applications:
- Hobbies Calculator with Servlets - A servlet-based web application that captures personal details and hobbies and calculates a fitness score.
- Secure Data Transfer - An employee authentication and customer data retrieval system using servlets, JSPs, and XML.

Each application includes HTML forms, servlets, JSP pages, database connections, and XML parsing.

## EEProgA3 - Hobbies Calculator with Servlets
### Objective
Create a servlet-based web application where users submit personal details and hobbies through an HTML form, and the servlet calculates their fitness points based on predefined rules.
### Features
- HTML Form: The form captures personal details (name, email) and multiple hobbies.
- Servlet Processing: The form data is sent to a servlet, which calculates fitness points.
- Fitness Points Calculation:
    - 10 points each for the following hobbies: Running, Swimming, Cycling, Football, Soccer, Rugby.
    - Fitness level points: Low (10), Average (20), High (30).
    - 10 points each for music preferences: Pop, Classical, Country.
    - Reading preferences: Historical Fiction (10), Historical Non-Fiction (20), Crime Fiction (30), Romance (10), Comedy (50).
- Response: The servlet sends back an HTML response displaying the user's total fitness score.
### Instructions
- HTML Form:
    - The form (e.g., index.html) should capture personal details and hobbies, submitting them to the servlet.
- Servlet:
    - The servlet retrieves form data using request.getParameter().
    - Points are calculated based on the user's hobby and fitness selections.
    - The total score is displayed in an HTML response.

## EEProgA3 - Secure Data Transfer
### Objective
Create a web application where users authenticate using an employee.xml file. Upon successful authentication, customer data is retrieved and displayed in a JSP.
### Features
- XML Authentication: Users upload an employee.xml file containing email and phone (acting as a password).
- SQL Query Authentication: The servlet queries the MySQL database to authenticate the user.
- Customer Data Retrieval:
    - If authentication succeeds, customer data (customer number, name, phone) is retrieved from the database.
    - A link to view "More details" for each customer is provided.
    - Clicking the link displays detailed information about the selected customer.
### Instructions
- Employee Authentication:
    - Users submit their email and phone using an employee.xml file.
    - The servlet parses the XML file to check for valid email and phone formats:
        - Phone must be all digits.
        - Email must contain an "@" symbol and at least one dot.
    - The servlet executes an SQL query:
    - If authentication fails, an error message is returned on index.jsp.
    - If successful, the user is redirected to GetAllCustServlet.
- Customer Data Retrieval:
    - GetAllCustServlet retrieves all customer data (customer number, name, and phone) from the customers table.
    - AllCustomers.jsp displays the data in a table format with "More details" links for each customer.
    - Clicking the "More details" link calls GetOneCustServlet to fetch detailed customer information.
    - CustomerDetail.jsp displays the full customer information.