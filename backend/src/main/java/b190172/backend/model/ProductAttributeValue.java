package b190172.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductAttributeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long attributeValueId;
	@ManyToOne
	private Attribute attribute;
	@ManyToOne
	private Product product;

	private String attributeValue;

	public long getAttributeValueId() {
		return attributeValueId;
	}

	public void setAttributeValueId(long attributeValueId) {
		this.attributeValueId = attributeValueId;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

}
