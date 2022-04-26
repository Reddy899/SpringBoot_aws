package com.AWSDemo.AWS.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="product_inventory")
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

@Column(name="product_name",nullable= false)
        private String productName;

@Column(name="color")
    private String color;

@Column(name="price")
    private int price;
}
