

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Products;

/**
 * Servlet implementation class SerchProductServlet
 */
@WebServlet("/search")
public class SerchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO=new ProductDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//找關鍵字
		String action = request.getParameter("action");
		
		List<Products> products;
		try {
			String keyword = request.getParameter("keyword");
			products=productDAO.searchProducts(keyword);
		}finally {
			System.out.print("請求成功");
		}
		request.setAttribute("products", products);
		request.getRequestDispatcher("/productList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
