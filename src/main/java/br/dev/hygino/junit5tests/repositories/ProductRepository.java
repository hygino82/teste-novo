package br.dev.hygino.junit5tests.repositories;

import br.dev.hygino.junit5tests.entities.Product;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductRepository {

    private final Set<Product> products;

    public ProductRepository() {
        products = new HashSet<>(Arrays.asList(
                new Product("TV", 900.45),
                new Product("Laptop", 1500.99),
                new Product("Smartphone", 1200.00),
                new Product("Tablet", 500.00),
                new Product("Smartwatch", 300.50),
                new Product("Headphones", 150.25),
                new Product("Camera", 750.00),
                new Product("Printer", 250.99),
                new Product("Monitor", 600.75),
                new Product("Keyboard", 75.50),
                new Product("Mouse", 50.99),
                new Product("Soundbar", 299.99),
                new Product("Speaker", 120.00),
                new Product("Projector", 1200.00),
                new Product("Game Console", 2500.00),
                new Product("Router", 150.00),
                new Product("Modem", 200.00),
                new Product("External HDD", 500.00),
                new Product("SSD", 350.00),
                new Product("Flash Drive", 20.00)
        ));
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (!products.add(product)) {
            throw new IllegalArgumentException("Produto com id repetido!");
        }
    }

    public Product findById(long id) {
        Predicate<Product> predicate = p -> p.getId() == id;
        return products.stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nao existe Produto com o id: " + id));
    }

    public Set<Product> findByPriceLowerThan(double value) {
        Predicate<Product> predicate = p -> p.getPrice() <= value;
        return products.stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }

    /**
     * busca produtos em um intervalo de preco
     *
     * @param startValue
     * @param endValue
     * @return
     */
    public Set<Product> findByPriceBeetween(double startValue, double endValue) {
        if (startValue >= endValue || startValue < 0.0 || endValue < 0.0) {
            throw new IllegalArgumentException("O valor inicial deve ser menor que o valor final e devem ser positivos!");
        }
        
        Predicate<Product> predicate = p -> p.getPrice() <= endValue && p.getPrice() >= startValue;
        
        return products.stream()
                .filter(predicate)
                .sorted()
                .collect(Collectors.toSet());
    }

    public Set<Product> findByIdGreaterThan(int value) {
        Predicate<Product> predicate = p -> p.getId() >= value;
        return products.stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }
}
