package b190172.backend.dao;

import java.util.List;

import b190172.backend.model.Category;

public interface CategoryDao {

	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public Category get(int categoryId);
	public List<Category> getCategories();
}
