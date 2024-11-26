

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import model.Products;

/**
 * Servlet implementation class SerchProductServlet
 */
@WebServlet("/search")
public class SerchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao productDao=new ProductDao();
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
		String keyword = request.getParameter("keyword");
		List<Products> products= productDao.serchProducts(keyword);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/results.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
