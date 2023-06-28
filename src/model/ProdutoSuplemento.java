package model;

public class ProdutoSuplemento extends Produto {

    private String consistenciaSuplemento;
    private int caloriasSuplemento;
    private double gramasSuplemento;
    private String saborSuplemento;
    
    public String getConsistenciaSuplemento() {
        return consistenciaSuplemento;
    }

    public void setConsistenciaSuplemento(String consistenciaSuplemento) {
        this.consistenciaSuplemento = consistenciaSuplemento;
    }

    public int getCaloriasSuplemento() {
        return caloriasSuplemento;
    }

    public void setCaloriasSuplemento(int caloriasSuplemento) {
        this.caloriasSuplemento = caloriasSuplemento;
    }

    public double getGramasSuplemento() {
        return gramasSuplemento;
    }

    public void setGramasSuplemento(double gramasSuplemento) {
        this.gramasSuplemento = gramasSuplemento;
    }

    public String getSaborSuplemento() {
        return saborSuplemento;
    }

    public void setSaborSuplemento(String saborSuplemento) {
        this.saborSuplemento = saborSuplemento;
    }

}
