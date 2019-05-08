package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RacunServlet
 */
@WebServlet(description = "racun", urlPatterns = { "/RacunServlet" })
public class RacunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] quantity = request.getParameterValues("quantity");
		String [] nizIdProizvoda = request.getParameterValues("check");
		for(int i =0; i<nizIdProizvoda.length; i++) {
			System.out.println(nizIdProizvoda[i]);
		}
		for(int i =0; i<quantity.length; i++) {
			System.out.println(quantity[i]);
		}
	
		
	}

}
