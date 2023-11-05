package com.tobeto.spring.workshop.b.service.Rules.utilities;

import com.tobeto.spring.workshop.b.module.Product;
import com.tobeto.spring.workshop.b.repository.abstracts.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.form.OptionsTag;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductBusinessRules implements IProductBusinessRules{

    public final ProductRepository productRepository;

    @Override
    public void ifCheckDeleteProduct(int id) {
        Optional<Product> product= this.productRepository.getall().stream().filter(p -> p.getId() == id).findFirst();
        if(!product.isPresent()){
            throw new IllegalArgumentException("İnvalid a product İD");
        }
    }

    @Override
    public void ifCheckProductId(int id) {
        Optional<Product> product= this.productRepository.getall().stream().filter(p -> p.getId() == id).findFirst();
        if(product.isPresent()){
            throw new IllegalArgumentException("already exists product with id: " + id );
        }

    }

    @Override
    public void ifCheckProductName(String name) {
            Optional<Product> product= this.productRepository.getall().stream().filter(p -> p.getName().equals(name)).findFirst();
            if(product.isPresent()){
                throw new IllegalArgumentException("already exists product with name: " + name );
            }

    }

    @Override
    public void ifCheckProductPrice(double price) {
            if(price <= 0){
                throw new IllegalArgumentException("product price cannot be less than 0 ");
            }
    }

    @Override
    public void ifCheckProductStock(int stock) {
        if(stock <= 0){
            throw new IllegalArgumentException("product stock cannot be less than 0 ");
        }

    }



    @Override
    public void ifCheckUpdateProduct(int id, Product product) {
        Optional<Product> product1= this.productRepository.getall().stream().filter(p -> p.getId() == id).findFirst();
        if(!product1.isPresent()){
            throw new IllegalArgumentException("invalid product id");
        }

    }
}
