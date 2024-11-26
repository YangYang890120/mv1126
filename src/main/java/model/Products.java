package model;

public class Products {
	private int productId;
	private String name;
	private String type;
	private int price;
	private int amount;
	public Products() {}
	public Products(String name, String type, int price, int amount) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
