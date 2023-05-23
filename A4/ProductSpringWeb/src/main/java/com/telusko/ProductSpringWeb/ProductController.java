package com.telusko.ProductSpringWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return service.getAllProducts();
    }
    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name){
        return service.getProduct(name);
    }
    @GetMapping("/product/place/{place}")
    public List<Product> getProductByPlace(@PathVariable String place){
        return service.getProductWithPlace(place);
    }
    @GetMapping("/product/warrantyexp")
    public List<Product> getWarrantyExp(){
        return service.getProductOutofWarranty();
    }
    @GetMapping("/product/searchtext/{text}")
    public List<Product> getProductContainingText(@PathVariable String text){
        return service.getProductWithText(text);
    }
    @PostMapping("/addproduct")
    public void addProduct(@RequestBody Product p){
        service.addProduct(p);
    }
}
