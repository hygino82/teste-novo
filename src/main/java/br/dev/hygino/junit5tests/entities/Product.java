package br.dev.hygino.junit5tests.entities;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private static long generatedId = 0L;
    private long id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = ++generatedId;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(other.price, this.price);
    }
}
