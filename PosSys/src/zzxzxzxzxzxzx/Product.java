package zzxzxzxzxzxzx;

import java.time.LocalDate;

public class Product {
	
	String name;
	String productNumber;
	double price;
	int quantiy;
	String restrictions;
	String description;
	LocalDate expireDate;
	public Product( String productNumber,String name, double price) {
		this.name = name;
		this.productNumber = productNumber;
		this.price = price;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String string) {
		this.productNumber = string;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}
	public String getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", productNumber=" + productNumber + ", price=" + price + ", quantiy="
				+ quantiy + ", restrictions=" + restrictions + ", description=" + description + ", expireDate="
				+ expireDate + "]";
	}
	
	public String print() {
		return   productNumber +"       " + name +  "     (" + price + ")$";
	}
	
	
	
	
	

}
