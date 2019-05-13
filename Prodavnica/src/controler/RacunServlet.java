package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bussinesService.RacunMetode;
import model.Bill;
import model.Product;
import model.User;

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
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("ovdeCuvamUsera");
		
		String [] quantity = request.getParameterValues("quantity");
		String [] nizIdProizvoda = request.getParameterValues("check");
		
		
		RacunMetode rm = new RacunMetode();
		List<String> listaQuantitija = rm.izbaciNuleIzQuantitija(quantity);
		
		List<Product> listaProizvoda = rm.listOfProduct(nizIdProizvoda, listaQuantitija);
		
		Bill bill = rm.upisiRacunUBazu(user.getIdUser(), listaProizvoda);
		
		if(bill != null) {
			HttpSession sessionForBill = request.getSession();
			sessionForBill.setAttribute("racun", bill);
			response.sendRedirect("jsp/racun.jsp");
		}else {
			response.sendRedirect("jsp/user.jsp");
		}
	
		

		
		
		
	
		
	}

}
