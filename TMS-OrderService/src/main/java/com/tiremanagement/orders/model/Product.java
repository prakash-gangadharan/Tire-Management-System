package com.tiremanagement.orders.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;

    String productName;

    String productDescription;

    double unitPrice;

    @ManyToOne
    @JoinColumn(name = "orderDetailsNo")
    OrderDetails orderDetails;

	public Product(String productName, String productDescription, double unitPrice, OrderDetails orderDetails) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.unitPrice = unitPrice;
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "productId = " + productId + ", productName = " + productName + ", productDescription = "
				+ productDescription + ", unitPrice = " + unitPrice;
	}
}
