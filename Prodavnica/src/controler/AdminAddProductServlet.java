package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinesService.AdminMetode;

/**
 * Servlet implementation class AdminAddProductServlet
 */
@WebServlet(description = "dodavanje proizvoda", urlPatterns = { "/AdminAddProductServlet" })
public class AdminAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		String productPrice = request.getParameter("price");
		double price = Double.parseDouble(productPrice);
		
		String productStock = request.getParameter("stock");
		int stock = Integer.parseInt(productStock);
		
		String productQuantity = request.getParameter("quantity");
		int quantity = Integer.parseInt(productQuantity);
		
		String productDiscount = request.getParameter("discount");
		double discount = Double.parseDouble(productDiscount);
		
		AdminMetode am = new AdminMetode();
		
		boolean ubaci = am.ubaciProizvod(name, price, stock, quantity, discount);
		
		if(ubaci) {
			response.sendRedirect("jsp/admin.jsp");
		}else {
			response.sendRedirect("jsp/admin.jsp");
		}
		
		
	}



}
