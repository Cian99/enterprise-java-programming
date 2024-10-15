

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class GetAllCustServlet
 */
public class GetAllCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// insert database info
	private static final String DATABASE_URL = "your_database_url";
	private static final String USERNAME = "your_database_user";
	private static final String PASSWORD = "your_database_password";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// read incoming parameters & connect to database, Query
		String searchId = (String) request.getSession().getAttribute("searchId");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = null;
			java.sql.Statement stmt = null;

			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT customerNumber, customerName, phone FROM customers");

			// store customers in an ArrayList
			List<CustomerBean> customers = new ArrayList<>();
			while (rs.next()) {
				// create customer instances
			    CustomerBean customer = new CustomerBean();
			    customer.setCustomerNumber(rs.getLong("customerNumber"));
			    customer.setCustomerName(rs.getString("customerName"));
			    customer.setPhone(rs.getString("phone"));
			    
			    customers.add(customer);
			}
			
			if(customers.isEmpty()) { // no result
				// call dispatcher and send flow to index
				request.setAttribute("error", "No Results");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else { // yes result	
				// Store the customers in the request attribute
                request.setAttribute("customers", customers);
                
                // Forward the request to showResults.jsp
                request.getRequestDispatcher("/AllCustomers.jsp").forward(request, response);
			}

			con.close();

		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}
}
