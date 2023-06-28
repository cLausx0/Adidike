package model;

public class ProdutoEquipamento extends Produto {

    private String esporteRelacionado;
    private String itemEquipamento;

    public String getEsporteRelacionado() {
        return esporteRelacionado;
    }

    public void setEsporteRelacionado(String esporteRelacionado) {
        this.esporteRelacionado = esporteRelacionado;
    }

    public String getItemEquipamento() {
        return itemEquipamento;
    }

    public void setItemEquipamento(String itemEquipamento) {
        this.itemEquipamento = itemEquipamento;
    }

}
