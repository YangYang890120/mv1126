package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Products;

public class ProductDao {

	Connection conn=DbConnection.getDb();
	public List<Products>  serchProducts(String keyword) {
		List<Products> products = new ArrayList<>();
		String query = "SELECT * FROM products WHERE name LIKE ? OR type LIKE ?";
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setString(1, "%"+keyword+"%");
			stmt.setString(2, "%"+keyword+"%");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Products p=new Products();
				p.setProductId(rs.getInt("productId"));
				p.setName(rs.getString("name"));
				p.setType(rs.getString("type"));
				p.setPrice(rs.getInt("price"));
				p.setAmount(rs.getInt("amount"));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
