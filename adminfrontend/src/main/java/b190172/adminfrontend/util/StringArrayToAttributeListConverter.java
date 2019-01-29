package b190172.adminfrontend.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import b190172.backend.dao.AttributeDao;
import b190172.backend.model.Attribute;
@Service
public class StringArrayToAttributeListConverter implements Converter<String[], List<Attribute>> {
	
	@Autowired
	private AttributeDao attributeDao;

	@Override
	public List<Attribute> convert(String[] attributeIds) {
		List<Attribute> attributes=new ArrayList<Attribute>();
		for(String attributeId:attributeIds) {
			attributes.add(attributeDao.get(Long.parseLong(attributeId)));
		}
		return attributes;
	}

}
