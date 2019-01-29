package b190172.backend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private String productModel;
	private String brand;
	private float price;
	@OneToMany(cascade=CascadeType.ALL)
	private List<ProductAttributeValue> productAttributeValues;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<ProductAttributeValue> getProductAttributeValues() {
		return productAttributeValues;
	}

	public void setProductAttributeValues(List<ProductAttributeValue> productAttributeValues) {
		this.productAttributeValues = productAttributeValues;
	}

}
