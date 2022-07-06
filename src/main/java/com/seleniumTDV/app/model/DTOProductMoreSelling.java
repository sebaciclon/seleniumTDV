package com.seleniumTDV.app.model;



public class DTOProductMoreSelling {

	Product producto;
	private Long cantidad;

	public DTOProductMoreSelling() {
		super();
	}

	public DTOProductMoreSelling(Product producto, Long cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
}
