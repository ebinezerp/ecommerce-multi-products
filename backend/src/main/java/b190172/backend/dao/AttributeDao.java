package b190172.backend.dao;

import java.util.List;

import b190172.backend.model.Attribute;

public interface AttributeDao {
	
	public boolean addAttribute(Attribute attribute);
	public boolean updateAttribute(Attribute attribute);
	public boolean deleteAttribute(Attribute attribute);
	public Attribute get(long attributeId);
	public List<Attribute> getAttributes(int categoryId);
	public List<Attribute> getAttributes();

}
