package com.example.estoque.controller;

import com.example.estoque.products.ProductRequestDTO;
import com.example.estoque.products.ProductResponseDTO;
import com.example.estoque.products.Products;
import com.example.estoque.products.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products") //Endpoint
public class ProductsController {

    private ProductsRepository repository;

    public ProductsController(ProductsRepository repository) {
        this.repository = repository;
    }


    //Save
    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")//Restringe de onde vem as requisições
    public void SaveNewProduct(@RequestBody ProductRequestDTO data){
        Products productData = new Products(data);
        repository.save(productData);

    }

    //Select all
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProductResponseDTO> GetAll(){

        List<ProductResponseDTO> productsList = repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return productsList;
    }

    //Update
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Transactional//garente o rollback dos dados caso ocorra algum erro durante a excução do metodo
    public void UpdateProduct(@PathVariable long id, @RequestBody ProductRequestDTO data){
        Optional<Products> productData = repository.findById(id);
        if(productData.isPresent()){
            Products product  = productData.get();
            product.setNome(data.nome());
            product.setDescricao(data.descricao());
            product.setQuantidade(data.quantidade());
        }


    }

    //Delete

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable long id){
        Optional<Products> productData = repository.findById(id);
        if(productData.isPresent()){
            repository.delete(productData.get());
        }

    }

}
