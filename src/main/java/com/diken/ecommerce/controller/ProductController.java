package com.diken.ecommerce.controller;


import com.diken.ecommerce.exceptions.NoProductExistInRepository;
import com.diken.ecommerce.models.Product;
import com.diken.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/check")
    public String check() {
        return "ESTA FUNCIONANDO";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        try {
            return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.FOUND);
        } catch (NoProductExistInRepository e) {
            return new ResponseEntity("List Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product) throws IOException {
        Product user = productService.add(product);
        return new ResponseEntity<Product>(user,HttpStatus.CREATED);
    }

    @GetMapping("/get/by/id/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<Product>(productService.getById(id),HttpStatus.FOUND);
        } catch (NoProductExistInRepository e) {
            return new ResponseEntity("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
