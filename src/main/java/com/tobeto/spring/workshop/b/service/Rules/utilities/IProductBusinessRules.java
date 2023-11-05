package com.tobeto.spring.workshop.b.service.Rules.utilities;

import com.tobeto.spring.workshop.b.module.Product;

public interface IProductBusinessRules {

    void ifCheckDeleteProduct(int id);
    void ifCheckProductId(int id);
    void ifCheckProductName(String name);
    void ifCheckProductPrice(double price);
    void ifCheckProductStock(int stock);
    void ifCheckUpdateProduct(int id, Product product);



}
