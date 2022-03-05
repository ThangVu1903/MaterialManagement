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
@Table(name = "Import")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Import {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "productId", nullable = false)
    private String productId;

    @Column(name = "importNumber",nullable = false)
    private Integer importNumber;

    @Column(name = "importDate",nullable = false)
    private String importDate;

    @Column(name = "updateBy",nullable = false)
    private Integer updateBy;

    @Column(name = "price",nullable = false)
    private Double price;
}
