package model;

import java.time.LocalDateTime;

public class Venda {
    private int id;
    private Cliente cliente;
    private ProdutoAcessorio acessorio;
    private ProdutoCalcado calcado;
    private ProdutoEquipamento equipamento;
    private ProdutoRoupa roupa;
    private ProdutoSuplemento suplemento;
    private LocalDateTime data;
    private double valorTotal;

    public ProdutoAcessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(ProdutoAcessorio acessorio) {
        this.acessorio = acessorio;
    }

    public ProdutoCalcado getCalcado() {
        return calcado;
    }

    public void setCalcado(ProdutoCalcado calcado) {
        this.calcado = calcado;
    }

    public ProdutoEquipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(ProdutoEquipamento equipamento) {
        this.equipamento = equipamento;
    }

    public ProdutoRoupa getRoupa() {
        return roupa;
    }

    public void setRoupa(ProdutoRoupa roupa) {
        this.roupa = roupa;
    }

    public ProdutoSuplemento getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(ProdutoSuplemento suplemento) {
        this.suplemento = suplemento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void verificaregetEstoqueMIN() {
        if (this.acessorio != null) {
            if (this.acessorio.getEstoque() <= this.acessorio.getEstoqueMIN()) {
                System.out.println("Acessório " + this.acessorio.getNome() + " está com estoque abaixo do mínimo!");
            }
        }
        if (this.calcado != null) {
            if (this.calcado.getEstoque() <= this.calcado.getEstoqueMIN()) {
                System.out.println("Calçado " + this.calcado.getNome() + " está com estoque abaixo do mínimo!");
            }
        }
        if (this.equipamento != null) {
            if (this.equipamento.getEstoque() <= this.equipamento.getEstoqueMIN()) {
                System.out.println("Equipamento " + this.equipamento.getNome() + " está com estoque abaixo do mínimo!");
            }
        }
        if (this.roupa != null) {
            if (this.roupa.getEstoque() <= this.roupa.getEstoqueMIN()) {
                System.out.println("Roupa " + this.roupa.getNome() + " está com estoque abaixo do mínimo!");
            }
        }
        if (this.suplemento != null) {
            if (this.suplemento.getEstoque() <= this.suplemento.getEstoqueMIN()) {
                System.out.println("Suplemento " + this.suplemento.getNome() + " está com estoque abaixo do mínimo!");
            }
        }
    }

}
