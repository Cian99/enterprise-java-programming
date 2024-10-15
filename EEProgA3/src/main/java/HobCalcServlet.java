

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HobCalcServlet
 */
public class HobCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// retrieve personal info
		String name = request.getParameter("user");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		// retrieve hobby info
		int totalScore = 0;
		
		String running = request.getParameter("running");
		if(running != null)
			totalScore += 10;
		String swimming = request.getParameter("swimming");
		if(swimming != null)
			totalScore += 10;
		String cycling = request.getParameter("cycling");
		if(cycling != null)
			totalScore += 10;
		String football = request.getParameter("football");
		if(football != null)
			totalScore += 10;
		String soccer = request.getParameter("soccer");
		if(soccer != null)
			totalScore += 10;
		String rugby = request.getParameter("rugby");
		if(rugby != null)
			totalScore += 10;
		
		String fitness = request.getParameter("fitness");
		if("low".equals(fitness))
			totalScore += 10;
		if("average".equals(fitness))
			totalScore += 20;
		if("high".equals(fitness))
			totalScore += 30;
		
		String pop = request.getParameter("pop");
		if(pop != null)
			totalScore += 10;
		String classical = request.getParameter("classical");
		if(classical != null)
			totalScore += 10;
		String country = request.getParameter("country");
		if(country != null)
			totalScore += 10;
		
		String reading = request.getParameter("reading");
		if(reading.equals("HistoricalFiction"))
			totalScore += 10;
		else if(reading.equals("HistoricalNonFiction"))
			totalScore += 20;
		else if(reading.equals("CrimeFiction"))
			totalScore += 30;
		else if(reading.equals("Romance"))
			totalScore += 10;
		else if(reading.equals("Comedy"))
			totalScore += 50;
		
		response.getWriter().append("Name: " + name + "\nPhone Number: " + number + "\nEmail: " + email
				+ "\nAddress: " + address
				+ "\nYour total score is " + totalScore);
		
	}

}
