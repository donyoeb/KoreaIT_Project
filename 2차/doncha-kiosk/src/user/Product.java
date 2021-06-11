package user;

import java.awt.Color;

public class Product {
	private int product_id; //primary key
	private int category_id; //카테고리	Bakery/BubbleTea/Coffee
	private String category;
	private String product_name; //상품 이름
	private int product_price; //상품 가격
	private String filename; //사진파일 이름
	
	public static final String[] CATEGORY = {"Bakery", "BubbleTea","Coffee"};
	public static final Color SIGNITURECOLOR = new Color(207, 220, 186);
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int product_id, int category_id, String product_name, int product_price, String filename) {
		this.product_id = product_id;
		this.category_id = category_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.filename = filename;
	}
	
	public Product(int product_id, String category, String product_name, int product_price, String filename) {
		this.product_id = product_id;
		this.category = category;
		this.product_name = product_name;
		this.product_price = product_price;
		this.filename = filename;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public static Color getSigniturecolor() {
		return SIGNITURECOLOR;
	}

	
	
}
