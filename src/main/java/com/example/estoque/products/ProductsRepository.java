package com.example.estoque.products;


import org.springframework.data.jpa.repository.JpaRepository;

//Cria todos os metodos de acessor ao banco dee dados (herda do Jpa)
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
