package com.example.estoque.products;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Table(name = "produtos")
@Entity(name = "products")
public class Products {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private int quantidade;


    public Products (ProductRequestDTO data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.quantidade = data.quantidade();
    }

}
