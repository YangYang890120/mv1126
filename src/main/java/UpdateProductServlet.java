

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Products;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ProductDAO productDAO = new ProductDAO(); ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		Products product = productDAO.getProductById(productId);
		System.out.println(product.getName());
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		int price = Integer.parseInt(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		Products product =new Products(productId,name,type,price,amount);
		productDAO.updateProduct(product);
		response.sendRedirect("search");
	}

}
