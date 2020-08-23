package com.tiremanagement.orders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderDetailsNo;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    int quantity;

    double subtotal;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getOrderDetailsNo() {
        return orderDetailsNo;
    }

    public void setOrderDetailsNo(Long orderDetailsNo) {
        this.orderDetailsNo = orderDetailsNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public OrderDetails() {
    }

    public OrderDetails(Orders orders, Product product, int quantity, double subtotal) {
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetailsNo=" + orderDetailsNo +
                ", orders=" + orders +
                ", product=" + product +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}
