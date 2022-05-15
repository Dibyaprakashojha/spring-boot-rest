package com.productapp.controllers;

import com.productapp.model.Product;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product){
        iProductService.addProduct(product);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }

    @DeleteMapping("/products/product-id/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId){
        iProductService.deleteProduct(productId);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.OK)
                        .header("desc", "deleting one product by id")
                        .build();
        return responseEntity;
    }

    @PutMapping("/products")
    public ResponseEntity<Void> updateProduct(@RequestBody Product product){
        iProductService.updateProduct(product);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return responseEntity;
    }

    @GetMapping("/products/product-id/{productId}")
    public ResponseEntity<Product> getById(@PathVariable("productId") int productId){
        Product product = iProductService.getById(productId);
        return ResponseEntity.ok().header("desc", "get by id").body(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = iProductService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "getting all products");
        headers.add("info", "get all method called");
        ResponseEntity<List<Product>> productResponseEntity =
                new ResponseEntity(products,headers, HttpStatus.OK);
        return productResponseEntity;
    }

    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category){
        List<Product> products = iProductService.getByCategory(category);
        return ResponseEntity.ok().header("desc", "get by category").body(products);
    }

    @GetMapping("/products/choice/{choice}")
    public ResponseEntity<List<Product>> getByChoice(@PathVariable("choice") String choice){
        List<Product> products = iProductService.getByChoice(choice);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by choice");
        ResponseEntity<List<Product>> productResponse = ResponseEntity.ok().headers(httpHeaders).body(products);
        return productResponse;
    }

    @GetMapping("/products/price/{price}")
    public ResponseEntity<List<Product>> getByPriceLessThan(@PathVariable("price") double price) {
        List<Product> products = iProductService.getByPriceLessThan(price);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by price");
        return  ResponseEntity.ok().headers(httpHeaders).body(products);

    }

    @GetMapping("/products/brand/{brand}")
    public ResponseEntity<List<Product>> getByBrandStartingWith(@PathVariable("brand") String brand){
        List<Product> products = iProductService.getByBrandStartingWith(brand);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc", "get by brand");
        ResponseEntity<List<Product>> productResponse = ResponseEntity.ok().headers(httpHeaders).body(products);
        return productResponse;
    }
}
