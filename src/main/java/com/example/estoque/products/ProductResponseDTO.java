package com.example.estoque.products;

public record ProductResponseDTO(Long id, String nome, String descricao, int quantidade) {
    public ProductResponseDTO (Products product){
        this(product.getId(), product.getNome(), product.getDescricao(), product.getQuantidade());
    }
}
