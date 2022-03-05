package com.example.Material.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Export")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Export {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "productId", nullable = false)
    private String productId;

    @Column(name = "exportNumber",nullable = false)
    private Integer exportNumber;

    @Column(name = "exportDate",nullable = false)
    private String exportDate;

    @Column(name = "updateBy",nullable = false)
    private Integer updateBy;

    @Column(name = "price",nullable = false)
    private Double price;


}
