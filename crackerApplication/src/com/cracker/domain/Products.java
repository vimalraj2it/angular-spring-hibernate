package com.cracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name="PRODUCTS")
public class Products extends Quantity{
	@Id
    @Column(name="PRODUCTID", nullable=false, unique=true, length=11)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_seq_prod")
	@SequenceGenerator(name = "id_seq_prod", sequenceName = "ID_SEQ_PRODUCT", initialValue=1, allocationSize=1)
	private long prod_id;
	@Expose
	@SerializedName("id")
	@Column(name="CODE", length=100, nullable=false)
	private String prod_code;
	
	@Expose
	@SerializedName("name")
	@Column(name="NAME", length=100, nullable=false)
	private String prod_name;
	
	@Column(name="SUPPLIERID", length=100, nullable=false)
	private long supplier_id;
	@Expose
	@SerializedName("amt")
	@Column(name="PRICE", length=100, nullable=false)
	private double prod_price;
	@Expose
	@SerializedName("banner")
	@Column(name="BANNER", length=100, nullable=false)
	private String banner;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SUPPLIERID", nullable = false,  insertable=false, updatable= false)
	private Supplier supplierItem;
	
	
	
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_code() {
		return prod_code;
	}
	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Supplier getSupplierItem() {
		return supplierItem;
	}
	public void setSupplierItem(Supplier supplierItem) {
		this.supplierItem = supplierItem;
	}

	
	
	
}
