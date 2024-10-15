

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 100 // 100MB
)

/**
 * Servlet implementation class ParseXMLServlet
 */
public class ParseXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		// read the XML file
			Part file = request.getPart("file");
			InputStream fileContent = file.getInputStream();

	        // Parse the XML file from the temporary file
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fileContent);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("employee");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	
	            	// extract email, phone
	            	Element eElement = (Element) nNode;
	            	String email = eElement.getElementsByTagName("email").item(0).getTextContent();
	            	String phone = eElement.getElementsByTagName("phone").item(0).getTextContent();
	               
	            	System.out.println("Email: " + email + " Phone: " + phone);
	            	
	            	// Validate email format
	                if(!email.contains("@")) {
	                    request.setAttribute("error", "Invalid email format: " + email);
	                    request.getRequestDispatcher("index.jsp").forward(request, response);
	                    return;
	                }

	                // Validate phone format
	                if(!phone.matches("\\d+")) {
	                    request.setAttribute("error", "Invalid phone format: " + phone);
	                    request.getRequestDispatcher("index.jsp").forward(request, response);
	                    return;
	                }
	            	
	            	// store in session
	            	HttpSession session = request.getSession();
	            	session.setAttribute("email", email);
	            	session.setAttribute("phone", phone);
	            	
	            	// forward request to AuthServlet
	            	RequestDispatcher dispatcher = request.getRequestDispatcher("/AuthServlet");
                    dispatcher.forward(request, response);
	            	
	            }
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error processing XML file");
	        request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
	}
}
