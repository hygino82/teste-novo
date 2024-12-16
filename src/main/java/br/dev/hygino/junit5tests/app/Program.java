package br.dev.hygino.junit5tests.app;

import br.dev.hygino.junit5tests.repositories.ProductRepository;

public class Program {
    
    public static void main(String[] args) {
        final ProductRepository repository = new ProductRepository();
        System.out.println("Lista de todos os produtos");
        repository.getProducts().stream().sorted().forEach(System.out::println);
        
        final double price = 180.0;
        System.out.printf("\n\nListade todos os produtos com preco menor ou igual a %.2f\n", price);
        repository.findByPriceLowerThan(price).stream().sorted().forEach(System.out::println);
        
        System.out.println("\n\nBuscando por id valido");
        final long validId = 7L;
        try {
            System.out.println(repository.findById(validId));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n\nBuscando por id invalido");
        final long invalidId = 700L;
        try {
            System.out.println(repository.findById(invalidId));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        final double precoInicial = 200.0, precoFinal = 300.0;
        System.out.printf("\n\nLista de produtos com preco entre %.2f e %.2f\n", precoInicial, precoFinal);
        repository.findByPriceBeetween(precoInicial, precoFinal).forEach(System.out::println);
    }
}
