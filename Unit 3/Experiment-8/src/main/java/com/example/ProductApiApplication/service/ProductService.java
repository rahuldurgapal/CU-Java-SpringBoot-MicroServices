package com.example.ProductApiApplication.service;

import com.example.ProductApiApplication.model.Product;
import com.example.ProductApiApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create a new product
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    // Retrieve all products
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    // Retrieve a product by ID
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    // Update a product by ID
    public Product updateProduct(int id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());

        return productRepository.save(product);
    }

    // Delete a product by ID
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }

}
