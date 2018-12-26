package b190172.backend.dao;


import b190172.backend.model.AdminDetails;

public interface AdminDao {
	
     public AdminDetails login(String employeeCode,String password);
     public AdminDetails validateEmail(String email,String employeeCode);
     public String generateRandomPassword();
}
