package com.example.estoque.products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


@Getter
@Table(name = "produtos")
@Entity(name = "products")
public class Products {
    @Id
    private long id;
    private String nome;
    private String descricao;
    private int quantidade;
}
