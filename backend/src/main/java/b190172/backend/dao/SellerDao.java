package b190172.backend.dao;

import java.util.List;

import b190172.backend.model.Seller;

public interface SellerDao {
	
	public boolean add(Seller seller);
	public boolean update(Seller seller);
	public boolean delete(Seller seller);
	public Seller get(int sellerId);
	public List<Seller> get();
	public List<Seller> getActiveSeller();
	

}
