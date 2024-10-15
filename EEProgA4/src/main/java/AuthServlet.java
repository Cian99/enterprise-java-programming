

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

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
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
		String email = (String) request.getSession().getAttribute("email");
		String pswd = (String) request.getSession().getAttribute("phone");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = null;
			java.sql.Statement stmt = null;

			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM emp WHERE email='"+email+"' and phone='"+pswd+"'");

			if(!rs.next()) { // no result
				// call dispatcher and send flow to index with error
				request.setAttribute("error", "Invalid Employee");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else { // yes result
				// call dispatcher and send flow to GetDataServlet
				request.getRequestDispatcher("/GetAllCustServlet").forward(request, response);
			}

			con.close();

		}

		catch (Exception e) {

			e.printStackTrace();

		}
		
	}

}
