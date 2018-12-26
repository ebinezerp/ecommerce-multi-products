package b190172.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String lastName;
	
	
	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private String email;
	
	
	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	private String mobile;
	
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String password;
	
	
	
	@NotNull
	@NotBlank
	@Column(nullable = false)
	private String role;
	

	@Column(nullable = false)
	private boolean enable;


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isEnable() {
		return enable;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
	
	

}
