package com.tobeto.spring.workshop.b.service.concretes;


import com.tobeto.spring.workshop.b.module.Product;
import com.tobeto.spring.workshop.b.repository.abstracts.ProductRepository;
import com.tobeto.spring.workshop.b.service.Rules.utilities.IProductBusinessRules;
import com.tobeto.spring.workshop.b.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {
    public final ProductRepository products;
    public final IProductBusinessRules  businessRules;
@Autowired
    public ProductManager(ProductRepository productRepository, IProductBusinessRules businessRules) {
        this.products = productRepository;
        this.businessRules = businessRules;
    }

    @Override
    public List<Product> getall() {
        return products.getall();
    }

    @Override
    public Product getById(int id) {
    this.businessRules.ifCheckDeleteProduct(id);
        return products.getById(id);
    }

    @Override
    public String add(Product product) {
    this.businessRules.ifCheckProductName(product.getName());
    this.businessRules.ifCheckProductId(product.getId());
    this.businessRules.ifCheckProductPrice(product.getPrice());
    this.businessRules.ifCheckProductStock(product.getStock());
       return products.add(product);
    }

    @Override
    public String delete(int id) {
    this.businessRules.ifCheckDeleteProduct(id);
        return products.delete(id);
    }

    @Override
    public String updateProduct(int id, Product updatedProduct) {
    this.businessRules.ifCheckUpdateProduct(id, updatedProduct);
    this.businessRules.ifCheckProductPrice(updatedProduct.getPrice());
    this.businessRules.ifCheckProductStock(updatedProduct.getStock());
        return products.updateProduct(id, updatedProduct);
    }
}
