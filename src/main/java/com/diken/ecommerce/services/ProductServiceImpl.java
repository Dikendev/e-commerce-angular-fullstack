package com.diken.ecommerce.services;

import com.diken.ecommerce.exceptions.NoProductExistInRepository;
import com.diken.ecommerce.models.Product;
import com.diken.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() throws NoProductExistInRepository {
        List<Product> all = productRepository.findAll();
        if(all.isEmpty()) {
            throw new NoProductExistInRepository();
        } else {
            return all;
        }
    }

    @Override
    public Product getById(Long id) throws NoProductExistInRepository {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) {
            throw new NoProductExistInRepository();
        } else {
            return product.get();
        }
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }
}
