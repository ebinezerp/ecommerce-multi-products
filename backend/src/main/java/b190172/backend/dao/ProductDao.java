package b190172.backend.dao;

import java.util.List;

import b190172.backend.model.Product;

public interface ProductDao {
	
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public Product getProduct(long productId);
	public List<Product> getProducts();

}
