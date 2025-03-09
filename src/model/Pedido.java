package model;

import java.util.Date;

public class Pedido {
    private int id;
    private int idCliente;
    private Date dataPedido;
    private double total;

    // Construtor
    public Pedido(int id, int idCliente, Date dataPedido, double total) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataPedido = dataPedido;
        this.total = total;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
