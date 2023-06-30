package controller;

import app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class relatoriosController {

    public void initialize() {
        //#region Mapeando clique para trocar de tela
        tabClientes.setOnSelectionChanged(event -> {
            if (tabClientes.isSelected()) {
                App.mudarTela("clientes");
            }
        });

        tabProdutos.setOnSelectionChanged(event -> {
            if (tabProdutos.isSelected()) {
                App.mudarTela("produtos");
            }
        });

        tabVendas.setOnSelectionChanged(event -> {
            if (tabVendas.isSelected()) {
                App.mudarTela("vendas");
            }
        });
        //#endregion
    }

    @FXML
    private TabPane conjuntoTelas;

    @FXML
    private Tab tabClientes;

    @FXML
    private Tab tabProdutos;

    @FXML
    private Tab tabRelatorios;

    @FXML
    private Tab tabVendas;

}
