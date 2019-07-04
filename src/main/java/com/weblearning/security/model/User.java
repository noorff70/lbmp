package com.weblearning.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.weblearning.domain.Grade;

/*
 * This class is used to identify the user in the system
 */

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USERTYPE")
public class User{
	@JsonIgnore
	private Set<Grade> gradeUser = new HashSet<Grade>(0);
	
	Long userId;
	
	@NotEmpty(message = "Please enter User Name.")
	String username;
	String password;
	String postalCode;
	
	String userRole;
	
	public User(){
		
	}
	
	
	@Id
	@Column(name="USERID")
	public Long getUserId(){
		return userId;
	}
	
	public void setUserId(Long uId){
		userId = uId;
	}
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name="POSTALCODE")
	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String pCode) {
		this.postalCode = pCode;
	}
	
	@Transient
	public String getUserRole() {
		return this.userRole;
	}
	
	public void setUserRole(String type) {
		this.userRole = type;
	}

	
	// many to many relationship for tutor and grade and tutor owning side

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_grade",
        joinColumns = @JoinColumn(name = "USER_USERID", insertable=false, updatable=false),
        inverseJoinColumns = @JoinColumn(name = "GRADE_GRADEID", insertable=false, updatable=false))
	
	public Set<Grade> getGradeUser() {
		return this.gradeUser;
	}
	
	public void setGradeUser(Set<Grade> tg) {
		this.gradeUser = tg;
	}

}
