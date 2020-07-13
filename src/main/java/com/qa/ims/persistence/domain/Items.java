package com.qa.ims.persistence.domain;

public class Items {

	private Long id;
	private String item_name;
	private int quantity;
	private double total_price;

	public Items(String item_name, int quantity, double total_price) {
		super();
		this.item_name = item_name;
		this.quantity = quantity;
		this.total_price = total_price;
	}

	public Items(String item_name, int quantity) {
		super();
		this.item_name = item_name;
		this.quantity = quantity;
	}

	public String toString() {
		return "Items [id= " + id + ", item_name= " + item_name + ", quantity= " + quantity + ", total_price= £" + total_price
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (total_price == null) {
//			if (other.surname != null)
//				return false;
//		} else if (!surname.equals(other.surname))
//			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

}
