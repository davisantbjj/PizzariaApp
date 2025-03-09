package model;

public class Pizza {
    private int id;
    private String sabor;
    private double preco;

    // Construtor
    public Pizza(int id, String sabor, double preco) {
        this.id = id;
        this.sabor = sabor;
        this.preco = preco;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
