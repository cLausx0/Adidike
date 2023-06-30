package controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Cliente;
import model.ProdutoAcessorio;
import model.ProdutoCalcado;
import model.ProdutoEquipamento;
import model.ProdutoRoupa;
import model.ProdutoSuplemento;
import model.Venda;

public class vendasController {

    //#region Campos de Texto
    @FXML
    private TextField textID;

    @FXML
    private ComboBox<String> boxCalcados;

    @FXML
    private ComboBox<String> boxEquipamentos;

    @FXML
    private ComboBox<String> boxRoupas;

    @FXML
    private ComboBox<String> boxSuplementos;
    //#endregion

    //#region Tabela Venda
    @FXML
    private TableColumn<Venda, Integer> idCliente;

    @FXML
    private TableColumn<Venda, ProdutoAcessorio> nomeAcessorio;

    @FXML
    private TableColumn<Venda, ProdutoCalcado> nomeCalcado;

    @FXML
    private TableColumn<Venda, Cliente> nomeCliente;

    @FXML
    private TableColumn<Venda, ProdutoEquipamento> nomeEquipamento;

    @FXML
    private TableColumn<Venda, ProdutoRoupa> nomeRoupa;

    @FXML
    private TableColumn<Venda, ProdutoSuplemento> nomeSuplemento;

    @FXML
    private TableView<Venda> tabelaVenda;
    //#endregion

    //#region Inicialização de tabela
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

       tabRelatorios.setOnSelectionChanged(event -> {
           if (tabRelatorios.isSelected()) {
               App.mudarTela("relatorios");
           }
       });
       //#endregion

       //#region Ler arquivos Json
       Gson gson = new Gson();

       tabVendas.setOnSelectionChanged(event -> {
           if (tabVendas.isSelected()) {
               ObservableList<String> nomesClientes = FXCollections.observableArrayList();
               ObservableList<String> nomesAcessorios = FXCollections.observableArrayList();
               ObservableList<String> nomesCalcados = FXCollections.observableArrayList();
               ObservableList<String> nomesEquipamentos = FXCollections.observableArrayList();
               ObservableList<String> nomesRoupas = FXCollections.observableArrayList();
               ObservableList<String> nomesSuplementos = FXCollections.observableArrayList();

               try {
                   File clientesFile = new File("src/data/dados_clientes.json");
                   List<Cliente> clientes = gson.fromJson(new FileReader(clientesFile), new TypeToken<List<Cliente>>(){}.getType());
           
                   for (Cliente cliente : clientes) {
                       nomesClientes.add(cliente.getNome());
                   }
               } catch (IOException e) {
                   // Lidar com exceção de leitura do arquivo
                   e.printStackTrace();
               }
           
               // Carregar produtos do arquivo JSON
               try {
                   File produtosFile = new File("src/data/dados_acessorios.json");
                   List<ProdutoAcessorio> produtos = gson.fromJson(new FileReader(produtosFile), new TypeToken<List<ProdutoAcessorio>>(){}.getType());
           
                   for (ProdutoAcessorio produto : produtos) {
                       nomesAcessorios.add(produto.getNome());
                   }
               } catch (IOException e) {
                   // Lidar com exceção de leitura do arquivo
                   e.printStackTrace();
               }

                try {
                     File produtosFile = new File("src/data/dados_calcados.json");
                     List<ProdutoCalcado> produtos = gson.fromJson(new FileReader(produtosFile), new TypeToken<List<ProdutoCalcado>>(){}.getType());
              
                     for (ProdutoCalcado produto : produtos) {
                          nomesCalcados.add(produto.getNome());
                     }
                } catch (IOException e) {
                     // Lidar com exceção de leitura do arquivo
                     e.printStackTrace();
                }

                try {
                     File produtosFile = new File("src/data/dados_equipamentos.json");
                     List<ProdutoEquipamento> produtos = gson.fromJson(new FileReader(produtosFile), new TypeToken<List<ProdutoEquipamento>>(){}.getType());
              
                     for (ProdutoEquipamento produto : produtos) {
                          nomesEquipamentos.add(produto.getNome());
                     }
                } catch (IOException e) {
                     // Lidar com exceção de leitura do arquivo
                     e.printStackTrace();
                }

                try {
                     File produtosFile = new File("src/data/dados_roupas.json");
                     List<ProdutoRoupa> produtos = gson.fromJson(new FileReader(produtosFile), new TypeToken<List<ProdutoRoupa>>(){}.getType());
              
                     for (ProdutoRoupa produto : produtos) {
                          nomesRoupas.add(produto.getNome());
                     }
                } catch (IOException e) {
                     // Lidar com exceção de leitura do arquivo
                     e.printStackTrace();
                }

                try {
                     File produtosFile = new File("src/data/dados_suplementos.json");
                     List<ProdutoSuplemento> produtos = gson.fromJson(new FileReader(produtosFile), new TypeToken<List<ProdutoSuplemento>>(){}.getType());
              
                     for (ProdutoSuplemento produto : produtos) {
                          nomesSuplementos.add(produto.getNome());
                     }
                } catch (IOException e) {
                     // Lidar com exceção de leitura do arquivo
                     e.printStackTrace();
                }

               boxClientes.setItems(nomesClientes);
               boxAcessorios.setItems(nomesAcessorios);
               boxCalcados.setItems(nomesCalcados);
               boxEquipamentos.setItems(nomesEquipamentos);
               boxRoupas.setItems(nomesRoupas);
               boxSuplementos.setItems(nomesSuplementos);
               //#endregion
           }
       });

   }
   //#endregion

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnEditar;

    @FXML
    void addTabelaVendas(ActionEvent event) {
    }

    @FXML
    void deletarCampoVenda(ActionEvent event) {

    }

    @FXML
    void editarCampoVenda(ActionEvent event) {

    }

    @FXML
    private ComboBox<String> boxClientes;

    @FXML
    private ComboBox<String> boxAcessorios;

    @FXML
    private Tab tabClientes;

    @FXML
    private Tab tabProdutos;

    @FXML
    private Tab tabRelatorios;

    @FXML
    private Tab tabVendas;
}
