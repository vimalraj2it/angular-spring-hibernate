package com.cracker.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name="SUPPLIER")
public class Supplier {
	@Id
    @Column(name="SUPPLIERID", nullable=false, unique=true, length=11)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_seq_supp")
	@SequenceGenerator(name = "id_seq_supp", sequenceName = "ID_SEQ_SUPPLIER" , initialValue=1, allocationSize=1)
	private long supp_id;
	@Expose
	@SerializedName("id")
	@Column(name="CODE", length=100, nullable=true)
	private String supp_code;
	@Expose
	@SerializedName("name") 
	@Column(name="NAME", length=100, nullable=true)
	private String supp_name;
	
	@Expose
	@SerializedName("products")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "supplierItem",cascade = CascadeType.PERSIST)
	@Fetch (FetchMode.SELECT)
	private Set<Products> productSet = new HashSet<Products>(0);
	
	
	public long getSupp_id() {
		return supp_id;
	}
	public void setSupp_id(long supp_id) {
		this.supp_id = supp_id;
	}
	public String getSupp_code() {
		return supp_code;
	}
	public void setSupp_code(String supp_code) {
		this.supp_code = supp_code;
	}
	public String getSupp_name() {
		return supp_name;
	}
	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}

	public Set<Products> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Products> productSet) {
		this.productSet = productSet;
	}
	
	
}
