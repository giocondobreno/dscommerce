package com.devsuperior.dscommerce.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPk id;
    private Integer quantity;
    private Double price;

    public OrderItem() {
        this.id = new OrderItemPk();
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id = new OrderItemPk(order, product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return this.id.getOrder();
    }

    public void setOrder(Order order){
        this.id.setOrder(order);
    }

    public Product getProduct(){
        return this.id.getProduct();
    }

    public void setProduct(Product product){
        this.id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
