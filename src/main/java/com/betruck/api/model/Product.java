package com.betruck.api.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int width;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int rating;
}
