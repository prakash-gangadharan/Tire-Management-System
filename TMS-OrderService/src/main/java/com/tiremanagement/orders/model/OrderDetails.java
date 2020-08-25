package com.tiremanagement.orders.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrderDetails {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderDetailsNo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    Orders orders;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    Product product;

    int quantity;

    double subtotal;

	public OrderDetails(Orders orders, Product product, int quantity, double subtotal) {
		this.orders = orders;
		this.product = product;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
}
