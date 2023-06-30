package controller;


import app.App;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Cliente;
import service.JsonPersistenceCliente;

public class clientesController {

    //#region Campos de Texto
    @FXML
    private TextField textEmail;

    @FXML
    private TextField textEndereco;

    @FXML
    private TextField textID;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textTelefone;
    //#endregion

    //#region Tabela Clientes

    @FXML
    private TableColumn<Cliente, Integer> idCliente;

    @FXML
    private TableColumn<Cliente, String> nomeCliente;

    @FXML
    private TableColumn<Cliente, String> emailCliente;

    @FXML
    private TableColumn<Cliente, String> telefoneCliente;

    @FXML
    private TableColumn<Cliente, String> enderecoCliente;
    
    @FXML
    private TableView<Cliente> tabelaCliente;
    //#endregion

    //#region Persistência de dados com Json
    private JsonPersistenceCliente persistenceCliente;
    //#endregion

    //#region Inicializando tabela
    public void initialize() {

        //#region Mapeando clique para trocar de tela
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

        tabRelatorios.setOnSelectionChanged(event -> {
            if (tabRelatorios.isSelected()) {
                App.mudarTela("relatorios");
            }
        });
        //#endregion
    
        //#region Criando Json's
        persistenceCliente = new JsonPersistenceCliente("dados_clientes.json");
        //#endregion
    
        //#region Tabela Clientes
        idCliente.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        nomeCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        emailCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
        telefoneCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTelefone()));
        enderecoCliente.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEndereco()));
        //#endregion
    
        //#region Criando lista observável do JavaFX e carregando dados nela
        ObservableList<Cliente> dadosClientes = FXCollections.observableArrayList(persistenceCliente.carregarDados());
        //#endregion
    
        //#region Colocando valores na tabela
        tabelaCliente.setItems(dadosClientes);
        //#endregion
    
        //#region Colocando dados da linha selecionada nos campos de texto
        tabelaCliente.getSelectionModel().selectedItemProperty().addListener((obs, antigoValor, novoValor) -> {
            if (novoValor != null) {
                textID.setText(String.valueOf(novoValor.getId()));
                textNome.setText(novoValor.getNome());
                textEmail.setText(novoValor.getEmail());
                textTelefone.setText(novoValor.getTelefone());
                textEndereco.setText(novoValor.getEndereco());
            }
            else {
                textID.clear();
                textNome.clear();
                textEmail.clear();
                textTelefone.clear();
                textEndereco.clear();
            }
        });
        //#endregion
    }
    //#endregion

    //#region Botões de controle do CRUD

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnEditar;

    @FXML
    void addTabelaCliente(ActionEvent event) {
        for (Cliente dados : tabelaCliente.getItems()) {
            if (Integer.parseInt(textID.getText()) == dados.getId()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("ID já existente");
                alert.setContentText("O ID inserido já existe na tabela");
                alert.showAndWait();
                return;
            }
        }

        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(textID.getText()));
        cliente.setNome(textNome.getText());
        cliente.setEmail(textEmail.getText());
        cliente.setTelefone(textTelefone.getText());
        cliente.setEndereco(textEndereco.getText());

        tabelaCliente.getItems().add(cliente);
        tabelaCliente.refresh();
        persistenceCliente.salvarDados(tabelaCliente.getItems());

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Cliente cadastrado com sucesso");
        alert.setContentText("O cliente foi cadastrado com sucesso");
        alert.showAndWait();

        resetarCampos();
    }

    @FXML
    void deletarCampoCliente(ActionEvent event) {
        Cliente clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
        if (clienteSelecionado != null) {
            tabelaCliente.getItems().remove(clienteSelecionado);
            tabelaCliente.refresh();
            persistenceCliente.salvarDados(tabelaCliente.getItems());

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Cliente deletado com sucesso");
            alert.setContentText("O cliente foi deletado com sucesso");
            alert.showAndWait();

            resetarCampos();
        }
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Erro");
            alert.setHeaderText("Nenhum cliente selecionado");
            alert.setContentText("Selecione um cliente para deletar");
            alert.showAndWait();
        }
    }

    @FXML
    void editarCampoCliente(ActionEvent event) {
        int idAntigo = tabelaCliente.getSelectionModel().getSelectedItem().getId();
        for (Cliente dados : tabelaCliente.getItems()) {
            if (Integer.parseInt(textID.getText()) == dados.getId() && Integer.parseInt(textID.getText()) != idAntigo) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("ID já existente");
                alert.setContentText("O ID inserido já existe na tabela");
                alert.showAndWait();
                return;
            }
        }

        Cliente clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
        if (clienteSelecionado != null) {
            clienteSelecionado.setId(Integer.parseInt(textID.getText()));
            clienteSelecionado.setNome(textNome.getText());
            clienteSelecionado.setEmail(textEmail.getText());
            clienteSelecionado.setTelefone(textTelefone.getText());
            clienteSelecionado.setEndereco(textEndereco.getText());

            tabelaCliente.refresh();
            persistenceCliente.salvarDados(tabelaCliente.getItems());

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Cliente editado com sucesso");
            alert.setContentText("O cliente foi editado com sucesso");
            alert.showAndWait();

            resetarCampos();
        }
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Erro");
            alert.setHeaderText("Nenhum cliente selecionado");
            alert.setContentText("Por favor, selecione um cliente para editar");
            alert.showAndWait();
        }
    }
    //#endregion

    private void resetarCampos() {
        textID.clear();
        textNome.clear();
        textEmail.clear();
        textTelefone.clear();
        textEndereco.clear();
    }

    //#region Telas

    @FXML
    private Tab tabClientes;

    @FXML
    private Tab tabProdutos;

    @FXML
    private Tab tabRelatorios;

    @FXML
    private Tab tabVendas;

    //#endregion

}
