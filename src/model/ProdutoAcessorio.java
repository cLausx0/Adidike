package model;

public class ProdutoAcessorio extends Produto {

    private String categoriaAcessorio;
    private String producaoAcessorio;
    
    public String getCategoriaAcessorio() {
        return categoriaAcessorio;
    }

    public void setCategoriaAcessorio(String categoriaAcessorio) {
        this.categoriaAcessorio = categoriaAcessorio;
    }

    public String getProducaoAcessorio() {
        return producaoAcessorio;
    }

    public void setProducaoAcessorio(String producaoAcessorio) {
        this.producaoAcessorio = producaoAcessorio;
    }

}
