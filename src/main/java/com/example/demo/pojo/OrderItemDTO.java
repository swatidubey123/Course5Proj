package com.example.demo.pojo;

public class OrderItemDTO {
	private Medicine medicine;
	 private int orderId;
    private int quantity;
    
    public OrderItemDTO() {
    }

    public OrderItemDTO(int orderId, Medicine medicine, int quantity) {
        this.orderId = orderId;
        this.medicine = medicine;
        this.quantity = quantity;
    }
    
    
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
