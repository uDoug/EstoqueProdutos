package com.example.estoque.controller;

import com.example.estoque.products.ProductRequestDTO;
import com.example.estoque.products.ProductResponseDTO;
import com.example.estoque.products.Products;
import com.example.estoque.products.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products") //Endpoint
public class ProductsController {

    @Autowired
    private ProductsRepository repository;

    //salvar no banco
    @PostMapping
    public void SaveNewProduct(@RequestBody ProductRequestDTO data){
        Products productData = new Products(data);
        repository.save(productData);

    }

    //Select all
    @GetMapping
    public List<ProductResponseDTO> GetAll(){

        List<ProductResponseDTO> productsList = repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return productsList;
    }

}
