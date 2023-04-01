package com.diken.ecommerce.services;

import com.diken.ecommerce.exceptions.NoProductExistInRepository;
import com.diken.ecommerce.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll() throws NoProductExistInRepository;
    Product getById(Long id) throws NoProductExistInRepository;
    Product add(Product product);
}
