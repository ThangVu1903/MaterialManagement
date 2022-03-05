package com.example.Material.management.service.base;

import com.example.Material.management.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProductService {
    Iterable<Product> findAllProduct();

    List<Product> SearchProduct(String term);

    Optional<Product> findOneProduct(Integer id);

    void saveProduct(Product product);
    void deleteProduct(Integer id);
}
