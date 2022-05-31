package com.betruck.api.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "Products")
public class ProductModel {

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

    @Temporal( value = TemporalType.TIMESTAMP )
    @Generated( value = GenerationTime.INSERT )
    @Column( columnDefinition = "datetime(6) default NOW(6)", nullable = false)
    private Date created_at;
}
