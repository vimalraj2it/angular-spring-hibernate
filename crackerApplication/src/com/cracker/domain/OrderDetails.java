package com.cracker.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetails {
	
	@Id
    @Column(name="ORDERID", nullable=false, unique=true, length=11)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_seq_order")
	@SequenceGenerator(name = "id_seq_order", sequenceName = "ID_SEQ_ORDER", initialValue=1, allocationSize=1)
	private long order_id;
	
	@Column(name="TOTAL_AMT", length=100, nullable=false)
	private double total_amt;
	
	@Column(name="USERID", length=100, nullable=false)
	private long user_id;
	
	@Column(name="ORDERDATE", length=100, nullable=false)
	private Date order_on;
	
	
	@Column(name="AMOUNT", length=100, nullable=false)
	private double amt;
	
	@Column(name="QUANTITY", length=100, nullable=false)
	private long quantity;
	
	@Column(name="SUPPLIERID", length=100, nullable=false)
	private String supplierId;
	
	@Column(name="PRODUCT", length=100, nullable=false)
	private String product;
	
	
	
	public double getTotal_amt() {
		return total_amt;
	}
	public void setTotal_amt(double total_amt) {
		this.total_amt = total_amt;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public Date getOrder_on() {
		return order_on;
	}
	public void setOrder_on(Date order_on) {
		this.order_on = order_on;
	}
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	
	
	

}
