package b190172.backend.dao;

import java.util.List;

import b190172.backend.model.SubCategory;

public interface SubCategoryDao {
	
	public boolean addSubCategory(SubCategory subCategory);
	public boolean updateSubCategory(SubCategory subCategory);
	public boolean deleteSubCategory(SubCategory subCategory);
	public SubCategory get(int subCategoryId);
	public List<SubCategory> getSubCategories();

}
