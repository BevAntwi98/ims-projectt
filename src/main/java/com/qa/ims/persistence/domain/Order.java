package com.qa.ims.persistence.domain;
import java.util.Date;



public class Order {
	
	Items item = new Items();
		
		private Long order_id;  
		private Long fkcustomer_id;
		private Date placed_date;
		private double total_order;
		
		
		
		public Order(Long order_id, Long fkcustomer_id, Date placed_date, double total_order) {
			super();
			this.order_id = order_id;
			this.fkcustomer_id = fkcustomer_id;
			this.placed_date = placed_date;
			this.total_order = total_order;
		}


		public Order(Long customer_id, Date placed_date, double total_order) {
			super();
			
			this.fkcustomer_id = customer_id;
			this.placed_date = placed_date;
			this.total_order = total_order;
		}


		public Order(Long fkcustomer_id, double total_order) {
			super();
			this.fkcustomer_id = fkcustomer_id;
			this.total_order = total_order;
		}
        
		public Order() {
			
		}
		

		public Long getOrder_id() {
			return order_id;
		}


		public void setOrder_id(Long order_id) {
			this.order_id = order_id;
		}


		public Long getCustomer_id() {
			return fkcustomer_id;
		}


		public void setCustomer_id(Long customer_id) {
			this.fkcustomer_id = customer_id;
		}


		public Date getPlaced_date() {
			return placed_date;
		}


		public void setPlaced_date(Date placed_date) {
			this.placed_date = placed_date;
		}


		public double getTotal_order() {
			return total_order;
		}


		public void setTotal_order(double total_order) {
			this.total_order = total_order;
		}
		
		
		public String addItemToOrder() {
		return item.getItem_name();
			
		}
		
		
		
		
	 
}
