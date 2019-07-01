package com.weblearning.security.model;

/*
 * This class is used to identify the user in the system
 */

public class LoggedUser{
	
	//private Set<Grade> gradeTutor = new HashSet<Grade>(0);
	
	Long userId;
	
	String username;
	String password;
	String postalCode;
	
	String userRole;
	
	
	public Long getUserId(){
		return userId;
	}
	
	public void setUserId(Long uId){
		userId = uId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String pCode) {
		this.postalCode = pCode;
	}
	
	public String getUserRole() {
		return this.userRole;
	}
	
	public void setUserRole(String type) {
		this.userRole = type;
	}

	
	//public Set<Grade> getGradeTutor() {
	//	return this.gradeTutor;
	//}
	
	//public void setGradeTutor(Set<Grade> tg) {
	//	this.gradeTutor = tg;
	//}

}
