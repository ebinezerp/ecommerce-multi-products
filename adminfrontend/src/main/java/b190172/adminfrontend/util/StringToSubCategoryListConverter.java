package b190172.adminfrontend.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import b190172.backend.dao.SubCategoryDao;
import b190172.backend.model.SubCategory;

@Service
public class StringToSubCategoryListConverter implements Converter<String, List<SubCategory>>{
	
	@Autowired
	private SubCategoryDao  subCategoryDao;

	@Override
	public List<SubCategory> convert(String subCategoryId) {
		List<SubCategory> categories=new ArrayList<SubCategory>();
		categories.add(subCategoryDao.get(Integer.parseInt(subCategoryId)));
		return categories;
	}

}
