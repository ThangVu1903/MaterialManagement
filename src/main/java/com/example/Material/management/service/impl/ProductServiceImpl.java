package com.example.Material.management.service.impl;
import com.example.Material.management.entity.Product;
import com.example.Material.management.repository.ProductRepository;
import com.example.Material.management.service.base.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Iterable<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> SearchProduct(String term) {
        return productRepository.findProductByName(term);
    }

    @Override
    public Optional<Product> findOneProduct(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
