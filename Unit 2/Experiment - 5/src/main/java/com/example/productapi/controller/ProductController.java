package com.example.productapi.controller;


import com.example.productapi.model.Product;
import com.example.productapi.service.ProductService;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //Get All Products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProuducts();
        return ResponseEntity.ok(products);
    }


    //Create New Product
    @PostMapping("/add-product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product p = productService.addProduct(product);
        return ResponseEntity.ok(p);
    }

    //Get Product By Id
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Product product = productService.getProductById(id).orElseThrow();
        return ResponseEntity.ok(product);
    }

    //Update Single Product By ID
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {

        try{
          productService.updateProduct(product,id);
          return ResponseEntity.ok().body(product);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {

        try{
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

}
