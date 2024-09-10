package com.example.productapi.service;

import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProuducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        Product p1 = new Product();
        p1.setName(product.getName());
        p1.setDescription(product.getDescription());
        p1.setPrice(product.getPrice());

        return productRepository.save(p1);
    }

    public Product updateProduct(Product product, int id) {
        Product p1 = productRepository.findById(id).orElseThrow();

        p1.setName(product.getName());
        p1.setDescription(product.getDescription());
        p1.setPrice(product.getPrice());

        return productRepository.save(p1);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
