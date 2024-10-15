

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class GetOneCustServlet
 */
public class GetOneCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// insert database info
	private static final String DATABASE_URL = "your_database_url";
	private static final String USERNAME = "your_database_user";
	private static final String PASSWORD = "your_database_password";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// read incoming parameters & connect to database, Query
		String customerNumber = request.getParameter("custid");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = null;
			java.sql.Statement stmt = null;

			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customers WHERE customerNumber='"+customerNumber+"'");
			
			if(!rs.next()) { // no result
				// call dispatcher and send flow to index
				request.setAttribute("error", "No Customer Found");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else { // yes result
				// create customer instance
			    CustomerBean customer = new CustomerBean();
			    customer.setCustomerNumber(rs.getLong("customerNumber"));
			    customer.setCustomerName(rs.getString("customerName"));
			    customer.setPhone(rs.getString("phone"));
			    customer.setContactLastName(rs.getString("contactLastName"));
			    customer.setContactFirstName(rs.getString("contactFirstName"));
			    customer.setAddressLine1(rs.getString("addressLine1"));
			    customer.setAddressLine2(rs.getString("addressLine2"));
			    customer.setCity(rs.getString("city"));
			    customer.setState(rs.getString("state"));
			    customer.setPostalCode(rs.getString("postalCode"));
			    customer.setCountry(rs.getString("country"));
			    customer.setSalesRepEmployeeNumber(rs.getLong("salesRepEmployeeNumber"));
			    customer.setCreditLimit(rs.getDouble("creditLimit"));
                
			    // Set the customer attribute in the request scope
	            request.setAttribute("customer", customer);
			    
                // Forward the request to showResults.jsp
                request.getRequestDispatcher("/CustomerDetail.jsp").forward(request, response);
			}

			con.close();

		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}
}
