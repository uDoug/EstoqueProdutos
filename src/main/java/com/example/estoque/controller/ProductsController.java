package com.example.estoque.controller;

import com.example.estoque.products.Products;
import com.example.estoque.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products") //Endpoint
public class ProductsController {

    @Autowired
    private ProductsRepository repository;

    @GetMapping
    //Select all
    public List<Products> getAll(){

        List<Products> productsList = repository.findAll();
        return productsList;
    }

}
