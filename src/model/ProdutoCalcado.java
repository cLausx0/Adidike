package model;

public class ProdutoCalcado extends Produto {

    private int tamanho;
    private String cor;
    private String marca;
    private String genero;
    private String esporteRelacionado;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEsporteRelacionado() {
        return esporteRelacionado;
    }

    public void setEsporteRelacionado(String esporteRelacionado) {
        this.esporteRelacionado = esporteRelacionado;
    }

}
