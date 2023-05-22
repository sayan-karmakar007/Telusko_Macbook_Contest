package com.telusko.ProductSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductDB db;


    public void addProduct(Product p){

        db.save(p);

    }


    public List<Product> getAllProducts(){
        return db.findAll();
    }


    public Product getProduct(String name) {
        return db.findAll().stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }


    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();

        return db.findAll().stream().filter(p -> p.getName().toLowerCase().contains(str) || p.getType().toLowerCase().contains(str) || p.getPlace().toLowerCase().contains(str)).collect(Collectors.toList());
    }


    public List<Product> getProductOutofWarranty() {
        int currentYear = java.time.Year.now().getValue();
        return db.findAll().stream().filter(p -> p.getWarranty() < currentYear).collect(Collectors.toList());
    }

    public List<Product> getProductWithPlace(String searchText) {
        return db.findAll().stream().filter(p -> p.getPlace().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }

}
