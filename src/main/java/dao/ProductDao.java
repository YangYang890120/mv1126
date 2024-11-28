package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Products;

public class ProductDAO {

	Connection conn=DbConnection.getDb();
	public boolean addProducts(Products p) {
		String SQL = "INSERT INTO products(name , type, price ,amount) VALUES(?,?,?,?)";
		try(PreparedStatement stmt = conn.prepareStatement(SQL)){
			stmt.setString(1, p.getName());			
			stmt.setString(2, p.getType());	
			stmt.setInt(3, p.getPrice());	
			stmt.setInt(4, p.getAmount());	
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected>0; 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Products>  searchProducts(String keyword) {
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
	public Products getProductById(int productId) {
		String SQL="SELECT * FROM products where productId = ? ";
		Products p =new Products();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, productId);
			try (ResultSet rs = stmt.executeQuery()) {
		        if (rs.next()) {
		            p.setProductId(rs.getInt("productId"));
		            p.setName(rs.getString("name"));
		            p.setType(rs.getString("type"));
		            p.setPrice(rs.getInt("price"));
		            p.setAmount(rs.getInt("amount"));
		            return p;
		        }
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateProduct(Products product) {
		String SQL="UPDATE products SET name = ?,type = ?, price = ?, amount = ? WHERE productId = ?";
		try {
			PreparedStatement stmt=conn.prepareStatement(SQL);
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getType());
			stmt.setInt(3, product.getPrice());
			stmt.setInt(4, product.getAmount());
			stmt.setInt(5, product.getProductId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteProduct(int id) {
		String SQL="DELETE FROM products WHERE productId = ?";
		try {
			PreparedStatement stmt=conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
