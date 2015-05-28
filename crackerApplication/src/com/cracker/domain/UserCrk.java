package com.cracker.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;






/**
 * @author vimalraj
 *
 */
@Entity
@Table(name="USERCRK")
public class UserCrk {
	
	@Id
    @Column(name="USERID", nullable=false, unique=true, length=11)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_seq_user" )
	@SequenceGenerator(name = "id_seq_user", sequenceName = "ID_SEQ_USER", initialValue=1, allocationSize=1)
	@Expose
	@SerializedName("id")
	private long user_id;
	
	@Expose
	@SerializedName("address")
	 @Column(name="ADDRESS", length=100, nullable=true)
	private String address;
	 
	@Expose
	@SerializedName("name")
	 @Column(name="NAME", length=100, nullable=true)
	private String user_name;
	 
	@Expose
	@SerializedName("email")
	 @Column(name="EMAIL", length=100, nullable=true)
	private String email;
	
	@Expose
	@SerializedName("phoneNo")
	@Column(name="PHONENO", length=100, nullable=true )
	 private String phoneNo;
	 
	 
	
	 
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
