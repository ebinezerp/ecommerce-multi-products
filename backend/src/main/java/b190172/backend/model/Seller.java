package b190172.backend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sellerId;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String companyName;
	
	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private String lisence;
	
	@NotNull
	@Column(nullable = false)
	private Date lisenceEndDate;
	

	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private User user;

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLisence() {
		return lisence;
	}

	public void setLisence(String lisence) {
		this.lisence = lisence;
	}

	public Date getLisenceEndDate() {
		return lisenceEndDate;
	}

	public void setLisenceEndDate(Date lisenceEndDate) {
		this.lisenceEndDate = lisenceEndDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
