package controller;

import app.App;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.ProdutoAcessorio;
import model.ProdutoCalcado;
import model.ProdutoEquipamento;
import model.ProdutoRoupa;
import model.ProdutoSuplemento;
import service.JsonPersistenceAcessorio;
import service.JsonPersistenceCalcado;
import service.JsonPersistenceEquipamento;
import service.JsonPersistenceRoupa;
import service.JsonPersistenceSuplemento;

public class produtosController {


    //#region Grupos
    @FXML
    private Group grupoAcessorios;

    @FXML
    private Group grupoCalcados;

    @FXML
    private Group grupoEquipamentos;

    @FXML
    private Group grupoRoupas;

    @FXML
    private Group grupoSuplementos;
    //#endregion

    //#region Campos de texto
    @FXML
    private TextField textCaloriasSupl;

    @FXML
    private TextField textCategoriaAces;

    @FXML
    private TextField textConsistenciaSupl;

    @FXML
    private TextField textCorCalc;

    @FXML
    private TextField textCorRoupa;

    @FXML
    private TextField textEsporteCalc;

    @FXML
    private TextField textEsporteEquip;

    @FXML
    private TextField textEstoque;

    @FXML
    private TextField textGeneroCalc;

    @FXML
    private TextField textGramasSupl;

    @FXML
    private TextField textID;

    @FXML
    private TextField textMarcaCalc;

    @FXML
    private TextField textMarcaRoupa;

    @FXML
    private TextField textMaterialAces;

    @FXML
    private TextField textMaterialRoupa;

    @FXML
    private TextField textMinEstoque;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textPreco;

    @FXML
    private TextField textSaborSupl;

    @FXML
    private TextField textTamanhoCalc;

    @FXML
    private TextField textTamanhoRoupa;

    @FXML
    private TextField textItemEquip;
    //#endregion
    
    //#region Menu e Opções
    @FXML
    private SplitMenuButton menuTipoProduto;

    @FXML
    private MenuItem optionAcessorio;

    @FXML
    private MenuItem optionCalcado;

    @FXML
    private MenuItem optionEquipamento;

    @FXML
    private MenuItem optionRoupa;

    @FXML
    private MenuItem optionSuplemento;
    //#endregion

    //#region Seleção Condicional
    @FXML
    void selectedAcessorio(ActionEvent event) {
        menuTipoProduto.setText("Acessório");
        grupoAcessorios.setVisible(true);
        grupoCalcados.setVisible(false);
        grupoEquipamentos.setVisible(false);
        grupoRoupas.setVisible(false);
        grupoSuplementos.setVisible(false);

        tabelaAcessorio.setVisible(true);
        tabelaCalcado.setVisible(false);
        tabelaEquipamento.setVisible(false);
        tabelaRoupa.setVisible(false);
        tabelaSuplemento.setVisible(false);
    }

    @FXML
    void selectedCalcado(ActionEvent event) {
        menuTipoProduto.setText("Calçado");
        grupoAcessorios.setVisible(false);
        grupoCalcados.setVisible(true);
        grupoEquipamentos.setVisible(false);
        grupoRoupas.setVisible(false);
        grupoSuplementos.setVisible(false);

        tabelaAcessorio.setVisible(false);
        tabelaCalcado.setVisible(true);
        tabelaEquipamento.setVisible(false);
        tabelaRoupa.setVisible(false);
        tabelaSuplemento.setVisible(false);
    }

    @FXML
    void selectedEquipamento(ActionEvent event) {
        menuTipoProduto.setText("Equipamento");
        grupoAcessorios.setVisible(false);
        grupoCalcados.setVisible(false);
        grupoEquipamentos.setVisible(true);
        grupoRoupas.setVisible(false);
        grupoSuplementos.setVisible(false);

        tabelaAcessorio.setVisible(false);
        tabelaCalcado.setVisible(false);
        tabelaEquipamento.setVisible(true);
        tabelaRoupa.setVisible(false);
        tabelaSuplemento.setVisible(false);
    }

    @FXML
    void selectedRoupa(ActionEvent event) {
        menuTipoProduto.setText("Roupa");
        grupoAcessorios.setVisible(false);
        grupoCalcados.setVisible(false);
        grupoEquipamentos.setVisible(false);
        grupoRoupas.setVisible(true);
        grupoSuplementos.setVisible(false);

        tabelaAcessorio.setVisible(false);
        tabelaCalcado.setVisible(false);
        tabelaEquipamento.setVisible(false);
        tabelaRoupa.setVisible(true);
        tabelaSuplemento.setVisible(false);
    }

    @FXML
    void selectedSuplemento(ActionEvent event) {
        menuTipoProduto.setText("Suplemento");
        grupoAcessorios.setVisible(false);
        grupoCalcados.setVisible(false);
        grupoEquipamentos.setVisible(false);
        grupoRoupas.setVisible(false);
        grupoSuplementos.setVisible(true);

        tabelaAcessorio.setVisible(false);
        tabelaCalcado.setVisible(false);
        tabelaEquipamento.setVisible(false);
        tabelaRoupa.setVisible(false);
        tabelaSuplemento.setVisible(true);
    }
    //#endregion

    //#region Tabela Acessórios
    @FXML
    private TableColumn<ProdutoAcessorio, Integer> idAcessorio;

    @FXML
    private TableColumn<ProdutoAcessorio, String> nomeAcessorio;

    @FXML
    private TableColumn<ProdutoAcessorio, Double> precoAcessorio;

    @FXML
    private TableColumn<ProdutoAcessorio, Integer> estoqueAcessorio;

    @FXML
    private TableColumn<ProdutoAcessorio, Integer> minEstoqueAcessorio;

    @FXML
    private TableColumn<ProdutoAcessorio, String> tipoAcessorio;

    @FXML
    private TableColumn<ProdutoAcessorio, String> categoriaAcessorio;

    @FXML
    private TableColumn<ProdutoAcessorio, String> materialAcessorio;

    @FXML
    private TableView<ProdutoAcessorio> tabelaAcessorio;
    //#endregion

    //#region Tabela Calçado
    @FXML
    private TableColumn<ProdutoCalcado, Integer> idCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, String> nomeCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, Double> precoCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, Integer> estoqueCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, Integer> minEstoqueCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, String> tipoCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, Integer> tamanhoCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, String> corCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, String> marcaCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, String> generoCalcado;

    @FXML
    private TableColumn<ProdutoCalcado, String> esporteCalcado;

    @FXML
    private TableView<ProdutoCalcado> tabelaCalcado;
    //#endregion

    //#region Tabela Equipamento
    @FXML
    private TableColumn<ProdutoEquipamento, Integer> idEquipamento;
    
    @FXML
    private TableColumn<ProdutoEquipamento, String> nomeEquipamento;

    @FXML
    private TableColumn<ProdutoEquipamento, Double> precoEquipamento;

    @FXML
    private TableColumn<ProdutoEquipamento, Integer> estoqueEquipamento;

    @FXML
    private TableColumn<ProdutoEquipamento, Integer> minEstoqueEquipamento;

    @FXML
    private TableColumn<ProdutoEquipamento, String> tipoEquipamento;

    @FXML
    private TableColumn<ProdutoEquipamento, String> esporteEquipamento;

    @FXML
    private TableColumn<ProdutoEquipamento, String> itemEquipamento;

    @FXML
    private TableView<ProdutoEquipamento> tabelaEquipamento;
    //#endregion
    
    //#region Tabela Roupa
    @FXML
    private TableColumn<ProdutoRoupa, Integer> idRoupa;
    
    @FXML
    private TableColumn<ProdutoRoupa, String> nomeRoupa;

    @FXML
    private TableColumn<ProdutoRoupa, Double> precoRoupa;

    @FXML
    private TableColumn<ProdutoRoupa, Integer> estoqueRoupa;

    @FXML
    private TableColumn<ProdutoRoupa, Integer> minEstoqueRoupa;

    @FXML
    private TableColumn<ProdutoRoupa, String> tipoRoupa;

    @FXML
    private TableColumn<ProdutoRoupa, String> tamanhoRoupa;

    @FXML
    private TableColumn<ProdutoRoupa, String> corRoupa;

    @FXML
    private TableColumn<ProdutoRoupa, String> marcaRoupa;

    @FXML
    private TableColumn<ProdutoRoupa, String> materialRoupa;

    @FXML
    private TableView<ProdutoRoupa> tabelaRoupa;
    //#endregion

    //#region Tabela Suplemento
    @FXML
    private TableColumn<ProdutoSuplemento, Integer> idSuplemento;
    
    @FXML
    private TableColumn<ProdutoSuplemento, String> nomeSuplemento;
    
    @FXML
    private TableColumn<ProdutoSuplemento, Double> precoSuplemento;

    @FXML
    private TableColumn<ProdutoSuplemento, Integer> estoqueSuplemento;

    @FXML
    private TableColumn<ProdutoSuplemento, Integer> minEstoqueSuplemento;

    @FXML
    private TableColumn<ProdutoSuplemento, String> tipoSuplemento;
    
    @FXML
    private TableColumn<ProdutoSuplemento, String> consistenciaSuplemento;

    @FXML
    private TableColumn<ProdutoSuplemento, Integer> caloriasSuplemento;

    @FXML
    private TableColumn<ProdutoSuplemento, Double> gramasSuplemento;

    @FXML
    private TableColumn<ProdutoSuplemento, String> saborSuplemento;

    @FXML
    private TableView<ProdutoSuplemento> tabelaSuplemento;
    //#endregion

    //#region Inicialização de todas as tabelas

    private JsonPersistenceAcessorio persistenceAcessorio;
    private JsonPersistenceCalcado persistenceCalcado;
    private JsonPersistenceEquipamento persistenceEquipamento;
    private JsonPersistenceRoupa persistenceRoupa;
    private JsonPersistenceSuplemento persistenceSuplemento;

    
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
        //#endregion

        persistenceAcessorio = new JsonPersistenceAcessorio("dados_acessorios.json");
        persistenceCalcado = new JsonPersistenceCalcado("dados_calcados.json");
        persistenceEquipamento = new JsonPersistenceEquipamento("dados_equipamentos.json");
        persistenceRoupa = new JsonPersistenceRoupa("dados_roupas.json");
        persistenceSuplemento = new JsonPersistenceSuplemento("dados_suplementos.json");

        //#region tabela Acessorios
        idAcessorio.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        nomeAcessorio.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        precoAcessorio.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPreco()).asObject());
        estoqueAcessorio.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoque()).asObject());
        minEstoqueAcessorio.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoqueMIN()).asObject());
        tipoAcessorio.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipoProduto()));
        categoriaAcessorio.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategoriaAcessorio()));
        materialAcessorio.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProducaoAcessorio()));
        //#endregion

        //#region tabela Calçado
        idCalcado.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        nomeCalcado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        precoCalcado.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPreco()).asObject());
        estoqueCalcado.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoque()).asObject());
        minEstoqueCalcado.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoqueMIN()).asObject());
        tipoCalcado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipoProduto()));
        tamanhoCalcado.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTamanho()).asObject());
        corCalcado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCor()));
        marcaCalcado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMarca()));
        generoCalcado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGenero()));
        esporteCalcado.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEsporteRelacionado()));
        //#endregion

        //#region tabela Equipamento
        idEquipamento.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        nomeEquipamento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        precoEquipamento.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPreco()).asObject());
        estoqueEquipamento.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoque()).asObject());
        minEstoqueEquipamento.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoqueMIN()).asObject());
        tipoEquipamento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipoProduto()));
        esporteEquipamento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEsporteRelacionado()));
        itemEquipamento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItemEquipamento()));
        //#endregion

        //#region tabela Roupa
        idRoupa.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        nomeRoupa.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        precoRoupa.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPreco()).asObject());
        estoqueRoupa.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoque()).asObject());
        minEstoqueRoupa.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoqueMIN()).asObject());
        tipoRoupa.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipoProduto()));
        tamanhoRoupa.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTamanho()));
        corRoupa.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCor()));
        marcaRoupa.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMarca()));
        materialRoupa.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMaterial()));
        //#endregion

        //#region tabela Suplemento
        idSuplemento.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        nomeSuplemento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        precoSuplemento.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPreco()).asObject());
        estoqueSuplemento.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoque()).asObject());
        minEstoqueSuplemento.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getEstoqueMIN()).asObject());
        tipoSuplemento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipoProduto()));
        consistenciaSuplemento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getConsistenciaSuplemento()));
        caloriasSuplemento.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCaloriasSuplemento()).asObject());
        gramasSuplemento.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getGramasSuplemento()).asObject());
        saborSuplemento.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSaborSuplemento()));
        //#endregion

        ObservableList<ProdutoAcessorio> dadosAcessorios = FXCollections.observableArrayList(persistenceAcessorio.carregarDados());
        ObservableList<ProdutoCalcado> dadosCalcados = FXCollections.observableArrayList(persistenceCalcado.carregarDados());
        ObservableList<ProdutoEquipamento> dadosEquipamentos = FXCollections.observableArrayList(persistenceEquipamento.carregarDados());
        ObservableList<ProdutoRoupa> dadosRoupas = FXCollections.observableArrayList(persistenceRoupa.carregarDados());
        ObservableList<ProdutoSuplemento> dadosSuplementos = FXCollections.observableArrayList(persistenceSuplemento.carregarDados());

        tabelaAcessorio.setItems(dadosAcessorios);
        tabelaCalcado.setItems(dadosCalcados);
        tabelaEquipamento.setItems(dadosEquipamentos);
        tabelaRoupa.setItems(dadosRoupas);
        tabelaSuplemento.setItems(dadosSuplementos);

        //#region Colocar dados da linha selecionada nos campos de texto

        tabelaAcessorio.getSelectionModel().selectedItemProperty().addListener((obs, antigoValor, novoValor) -> {
            if (novoValor != null) {
                textID.setText(String.valueOf(novoValor.getId()));
                textNome.setText(novoValor.getNome());
                textPreco.setText(String.valueOf(novoValor.getPreco()));
                textEstoque.setText(String.valueOf(novoValor.getEstoque()));
                textMinEstoque.setText(String.valueOf(novoValor.getEstoqueMIN()));
                textCategoriaAces.setText(novoValor.getCategoriaAcessorio());
                textMaterialAces.setText(novoValor.getProducaoAcessorio());
            }
            else {
                textID.clear();
                textNome.clear();
                textPreco.clear();
                textEstoque.clear();
                textMinEstoque.clear();
                textCategoriaAces.clear();
                textMaterialAces.clear();
            }
        });

        tabelaCalcado.getSelectionModel().selectedItemProperty().addListener((obs, antigoValor, novoValor) -> {
            if (novoValor != null) {
                textID.setText(String.valueOf(novoValor.getId()));
                textNome.setText(novoValor.getNome());
                textPreco.setText(String.valueOf(novoValor.getPreco()));
                textEstoque.setText(String.valueOf(novoValor.getEstoque()));
                textMinEstoque.setText(String.valueOf(novoValor.getEstoqueMIN()));
                textTamanhoCalc.setText(String.valueOf(novoValor.getTamanho()));
                textCorCalc.setText(novoValor.getCor());
                textMarcaCalc.setText(novoValor.getMarca());
                textGeneroCalc.setText(novoValor.getGenero());
                textEsporteCalc.setText(novoValor.getEsporteRelacionado());
            }
            else {
                textID.clear();
                textNome.clear();
                textPreco.clear();
                textEstoque.clear();
                textMinEstoque.clear();
                textTamanhoCalc.clear();
                textCorCalc.clear();
                textMarcaCalc.clear();
                textGeneroCalc.clear();
                textEsporteCalc.clear();
            }
        });

        tabelaEquipamento.getSelectionModel().selectedItemProperty().addListener((obs, antigoValor, novoValor) -> {
            if (novoValor != null) {
                textID.setText(String.valueOf(novoValor.getId()));
                textNome.setText(novoValor.getNome());
                textPreco.setText(String.valueOf(novoValor.getPreco()));
                textEstoque.setText(String.valueOf(novoValor.getEstoque()));
                textMinEstoque.setText(String.valueOf(novoValor.getEstoqueMIN()));
                textEsporteEquip.setText(novoValor.getEsporteRelacionado());
                textItemEquip.setText(novoValor.getItemEquipamento());
            }
            else {
                textID.clear();
                textNome.clear();
                textPreco.clear();
                textEstoque.clear();
                textMinEstoque.clear();
                textEsporteEquip.clear();
                textItemEquip.clear();
            }
        });

        tabelaRoupa.getSelectionModel().selectedItemProperty().addListener((obs, antigoValor, novoValor) -> {
            if (novoValor != null) {
                textID.setText(String.valueOf(novoValor.getId()));
                textNome.setText(novoValor.getNome());
                textPreco.setText(String.valueOf(novoValor.getPreco()));
                textEstoque.setText(String.valueOf(novoValor.getEstoque()));
                textMinEstoque.setText(String.valueOf(novoValor.getEstoqueMIN()));
                textTamanhoRoupa.setText(novoValor.getTamanho());
                textCorRoupa.setText(novoValor.getCor());
                textMarcaRoupa.setText(novoValor.getMarca());
                textMaterialRoupa.setText(novoValor.getMaterial());
            }
            else {
                textID.clear();
                textNome.clear();
                textPreco.clear();
                textEstoque.clear();
                textMinEstoque.clear();
                textTamanhoRoupa.clear();
                textCorRoupa.clear();
                textMarcaRoupa.clear();
                textMaterialRoupa.clear();
            }
        });

        tabelaSuplemento.getSelectionModel().selectedItemProperty().addListener((obs, antigoValor, novoValor) -> {
            if (novoValor != null) {
                textID.setText(String.valueOf(novoValor.getId()));
                textNome.setText(novoValor.getNome());
                textPreco.setText(String.valueOf(novoValor.getPreco()));
                textEstoque.setText(String.valueOf(novoValor.getEstoque()));
                textMinEstoque.setText(String.valueOf(novoValor.getEstoqueMIN()));
                textConsistenciaSupl.setText(novoValor.getConsistenciaSuplemento());
                textCaloriasSupl.setText(String.valueOf(novoValor.getCaloriasSuplemento()));
                textGramasSupl.setText(String.valueOf(novoValor.getGramasSuplemento()));
                textSaborSupl.setText(novoValor.getSaborSuplemento());
            }
            else {
                textID.clear();
                textNome.clear();
                textPreco.clear();
                textEstoque.clear();
                textMinEstoque.clear();
                textConsistenciaSupl.clear();
                textCaloriasSupl.clear();
                textGramasSupl.clear();
                textSaborSupl.clear();
            }
        });
        
        //#endregion

    }
    //#endregion

    //#region botões de controle CRUD
    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnEditar;

    @FXML
    void addTabelaProduto(ActionEvent event) {
        if (menuTipoProduto.getText() == "Acessório") {
            for (ProdutoAcessorio dados : tabelaAcessorio.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoAcessorio acessorio = new ProdutoAcessorio();
            acessorio.setId(Integer.parseInt(textID.getText()));
            acessorio.setNome(textNome.getText());
            acessorio.setPreco(Double.parseDouble(textPreco.getText()));
            acessorio.setEstoque(Integer.parseInt(textEstoque.getText()));
            acessorio.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
            acessorio.setTipoProduto(menuTipoProduto.getText());
            acessorio.setCategoriaAcessorio(textCategoriaAces.getText());
            acessorio.setProducaoAcessorio(textMaterialAces.getText());

            tabelaAcessorio.getItems().add(acessorio);
            tabelaAcessorio.refresh();
            persistenceAcessorio.salvarDados(tabelaAcessorio.getItems());

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Produto cadastrado com sucesso");
            alert.setContentText("O produto foi cadastrado com sucesso");
            alert.showAndWait();

            resetarCampos();

        } 
        else if (menuTipoProduto.getText() == "Calçado") {
            for (ProdutoCalcado dados : tabelaCalcado.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoCalcado calcado = new ProdutoCalcado();
            calcado.setId(Integer.parseInt(textID.getText()));
            calcado.setNome(textNome.getText());
            calcado.setPreco(Double.parseDouble(textPreco.getText()));
            calcado.setEstoque(Integer.parseInt(textEstoque.getText()));
            calcado.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
            calcado.setTipoProduto(menuTipoProduto.getText());
            calcado.setTamanho(Integer.parseInt(textTamanhoCalc.getText()));
            calcado.setCor(textCorCalc.getText());
            calcado.setMarca(textMarcaCalc.getText());
            calcado.setGenero(textGeneroCalc.getText());
            calcado.setEsporteRelacionado(textEsporteCalc.getText());

            tabelaCalcado.getItems().add(calcado);
            tabelaCalcado.refresh();
            persistenceCalcado.salvarDados(tabelaCalcado.getItems());

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Produto cadastrado com sucesso");
            alert.setContentText("O produto foi cadastrado com sucesso");
            alert.showAndWait();

            resetarCampos();

        } 
        else if (menuTipoProduto.getText() == "Equipamento") {
            for (ProdutoEquipamento dados : tabelaEquipamento.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoEquipamento equipamento = new ProdutoEquipamento();
            equipamento.setId(Integer.parseInt(textID.getText()));
            equipamento.setNome(textNome.getText());
            equipamento.setPreco(Double.parseDouble(textPreco.getText()));
            equipamento.setEstoque(Integer.parseInt(textEstoque.getText()));
            equipamento.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
            equipamento.setTipoProduto(menuTipoProduto.getText());
            equipamento.setEsporteRelacionado(textEsporteEquip.getText());
            equipamento.setItemEquipamento(textItemEquip.getText());

            tabelaEquipamento.getItems().add(equipamento);
            tabelaEquipamento.refresh();
            persistenceEquipamento.salvarDados(tabelaEquipamento.getItems());

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Produto cadastrado com sucesso");
            alert.setContentText("O produto foi cadastrado com sucesso");
            alert.showAndWait();

            resetarCampos();
            
        } 
        else if (menuTipoProduto.getText() == "Roupa") {
            for (ProdutoRoupa dados : tabelaRoupa.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoRoupa roupa = new ProdutoRoupa();
            roupa.setId(Integer.parseInt(textID.getText()));
            roupa.setNome(textNome.getText());
            roupa.setPreco(Double.parseDouble(textPreco.getText()));
            roupa.setEstoque(Integer.parseInt(textEstoque.getText()));
            roupa.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
            roupa.setTipoProduto(menuTipoProduto.getText());
            roupa.setTamanho(textTamanhoRoupa.getText());
            roupa.setCor(textCorRoupa.getText());
            roupa.setMarca(textMarcaRoupa.getText());
            roupa.setMaterial(textMaterialRoupa.getText());

            tabelaRoupa.getItems().add(roupa);
            tabelaRoupa.refresh();
            persistenceRoupa.salvarDados(tabelaRoupa.getItems());

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Produto cadastrado com sucesso");
            alert.setContentText("O produto foi cadastrado com sucesso");
            alert.showAndWait();

            resetarCampos();

        } 
        else if (menuTipoProduto.getText() == "Suplemento") {
            for (ProdutoSuplemento dados : tabelaSuplemento.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoSuplemento suplemento = new ProdutoSuplemento();
            suplemento.setId(Integer.parseInt(textID.getText()));
            suplemento.setNome(textNome.getText());
            suplemento.setPreco(Double.parseDouble(textPreco.getText()));
            suplemento.setEstoque(Integer.parseInt(textEstoque.getText()));
            suplemento.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
            suplemento.setTipoProduto(menuTipoProduto.getText());
            suplemento.setConsistenciaSuplemento(textConsistenciaSupl.getText());
            suplemento.setCaloriasSuplemento(Integer.parseInt(textCaloriasSupl.getText()));
            suplemento.setGramasSuplemento(Double.parseDouble(textGramasSupl.getText()));
            suplemento.setSaborSuplemento(textSaborSupl.getText());

            tabelaSuplemento.getItems().add(suplemento);
            tabelaSuplemento.refresh();
            persistenceSuplemento.salvarDados(tabelaSuplemento.getItems());

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Produto cadastrado com sucesso");
            alert.setContentText("O produto foi cadastrado com sucesso");
            alert.showAndWait();

            resetarCampos();

        }
    }

    @FXML
    void deletarCampoProduto(ActionEvent event) {
        if (menuTipoProduto.getText() == "Acessório") {
            ProdutoAcessorio itemSelecionado = tabelaAcessorio.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                tabelaAcessorio.getItems().remove(itemSelecionado);
                tabelaAcessorio.refresh();
                persistenceAcessorio.salvarDados(tabelaAcessorio.getItems());

                //alerta de excluiu com sucesso
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto excluído com sucesso");
                alert.setContentText("O produto foi excluído com sucesso");
                alert.showAndWait();

                resetarCampos();

            } 
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        } 
        else if (menuTipoProduto.getText() == "Calçado") {
            ProdutoCalcado itemSelecionado = tabelaCalcado.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                tabelaCalcado.getItems().remove(itemSelecionado);
                tabelaCalcado.refresh();
                persistenceCalcado.salvarDados(tabelaCalcado.getItems());

                //alerta de excluiu com sucesso
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto excluído com sucesso");
                alert.setContentText("O produto foi excluído com sucesso");
                alert.showAndWait();

                resetarCampos();
            } 
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        } 
        else if (menuTipoProduto.getText() == "Equipamento") {
            ProdutoEquipamento itemSelecionado = tabelaEquipamento.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                tabelaEquipamento.getItems().remove(itemSelecionado);
                tabelaEquipamento.refresh();
                persistenceEquipamento.salvarDados(tabelaEquipamento.getItems());

                //alerta de excluiu com sucesso
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto excluído com sucesso");
                alert.setContentText("O produto foi excluído com sucesso");
                alert.showAndWait();

                resetarCampos();
            } 
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        } 
        else if (menuTipoProduto.getText() == "Roupa") {
            ProdutoRoupa itemSelecionado = tabelaRoupa.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                tabelaRoupa.getItems().remove(itemSelecionado);
                tabelaRoupa.refresh();
                persistenceRoupa.salvarDados(tabelaRoupa.getItems());

                //alerta de excluiu com sucesso
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto excluído com sucesso");
                alert.setContentText("O produto foi excluído com sucesso");
                alert.showAndWait();

                resetarCampos();
            } 
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        } 
        else if (menuTipoProduto.getText() == "Suplemento") {
            ProdutoSuplemento itemSelecionado = tabelaSuplemento.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                tabelaSuplemento.getItems().remove(itemSelecionado);
                tabelaSuplemento.refresh();
                persistenceSuplemento.salvarDados(tabelaSuplemento.getItems());

                //alerta de excluiu com sucesso
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto excluído com sucesso");
                alert.setContentText("O produto foi excluído com sucesso");
                alert.showAndWait();

                resetarCampos();
            } 
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void editarCampoProduto(ActionEvent event) {
        if (menuTipoProduto.getText() == "Acessório") {
            for (ProdutoAcessorio dados : tabelaAcessorio.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoAcessorio itemSelecionado = tabelaAcessorio.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                itemSelecionado.setId(Integer.parseInt(textID.getText()));
                itemSelecionado.setNome(textNome.getText());
                itemSelecionado.setPreco(Double.parseDouble(textPreco.getText()));
                itemSelecionado.setEstoque(Integer.parseInt(textEstoque.getText()));
                itemSelecionado.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
                itemSelecionado.setTipoProduto(menuTipoProduto.getText());
                itemSelecionado.setCategoriaAcessorio(textCategoriaAces.getText());
                itemSelecionado.setProducaoAcessorio(textMaterialAces.getText());

                tabelaAcessorio.refresh();
                persistenceAcessorio.salvarDados(tabelaAcessorio.getItems());

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto editado com sucesso");
                alert.setContentText("O produto foi editado com sucesso");
                alert.showAndWait();

                resetarCampos();
            }
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        }
        else if (menuTipoProduto.getText() == "Calçado") {
            for (ProdutoCalcado dados : tabelaCalcado.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoCalcado itemSelecionado = tabelaCalcado.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                itemSelecionado.setId(Integer.parseInt(textID.getText()));
                itemSelecionado.setNome(textNome.getText());
                itemSelecionado.setPreco(Double.parseDouble(textPreco.getText()));
                itemSelecionado.setEstoque(Integer.parseInt(textEstoque.getText()));
                itemSelecionado.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
                itemSelecionado.setTipoProduto(menuTipoProduto.getText());
                itemSelecionado.setTamanho(Integer.parseInt(textTamanhoCalc.getText()));
                itemSelecionado.setCor(textCorCalc.getText());
                itemSelecionado.setMarca(textMarcaCalc.getText());
                itemSelecionado.setGenero(textGeneroCalc.getText());
                itemSelecionado.setEsporteRelacionado(textEsporteCalc.getText());

                tabelaCalcado.refresh();
                persistenceCalcado.salvarDados(tabelaCalcado.getItems());

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto editado com sucesso");
                alert.setContentText("O produto foi editado com sucesso");
                alert.showAndWait();

                resetarCampos();
            }
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        }
        else if (menuTipoProduto.getText() == "Equipamento") {
            for (ProdutoEquipamento dados : tabelaEquipamento.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }
            
            ProdutoEquipamento itemSelecionado = tabelaEquipamento.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                itemSelecionado.setId(Integer.parseInt(textID.getText()));
                itemSelecionado.setNome(textNome.getText());
                itemSelecionado.setPreco(Double.parseDouble(textPreco.getText()));
                itemSelecionado.setEstoque(Integer.parseInt(textEstoque.getText()));
                itemSelecionado.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
                itemSelecionado.setTipoProduto(menuTipoProduto.getText());
                itemSelecionado.setEsporteRelacionado(textEsporteEquip.getText());
                itemSelecionado.setItemEquipamento(textItemEquip.getText());

                tabelaEquipamento.refresh();
                persistenceEquipamento.salvarDados(tabelaEquipamento.getItems());

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto editado com sucesso");
                alert.setContentText("O produto foi editado com sucesso");
                alert.showAndWait();

                resetarCampos();
            }
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        }
        else if (menuTipoProduto.getText() == "Roupa"){
            for (ProdutoRoupa dados : tabelaRoupa.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoRoupa itemSelecionado = tabelaRoupa.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                itemSelecionado.setId(Integer.parseInt(textID.getText()));
                itemSelecionado.setNome(textNome.getText());
                itemSelecionado.setPreco(Double.parseDouble(textPreco.getText()));
                itemSelecionado.setEstoque(Integer.parseInt(textEstoque.getText()));
                itemSelecionado.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
                itemSelecionado.setTipoProduto(menuTipoProduto.getText());
                itemSelecionado.setTamanho(textTamanhoRoupa.getText());
                itemSelecionado.setCor(textCorRoupa.getText());
                itemSelecionado.setMarca(textMarcaRoupa.getText());
                itemSelecionado.setMaterial(textMaterialRoupa.getText());

                tabelaRoupa.refresh();
                persistenceRoupa.salvarDados(tabelaRoupa.getItems());

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto editado com sucesso");
                alert.setContentText("O produto foi editado com sucesso");
                alert.showAndWait();

                resetarCampos();
            }
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        }
        else if (menuTipoProduto.getText() == "Suplemento") {
            for (ProdutoSuplemento dados : tabelaSuplemento.getItems()) {
                if (Integer.parseInt(textID.getText()) == dados.getId()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setHeaderText("ID já existente");
                    alert.setContentText("O ID digitado já existe na tabela");
                    alert.showAndWait();
                    return;
                }
            }

            ProdutoSuplemento itemSelecionado = tabelaSuplemento.getSelectionModel().getSelectedItem();
            if (itemSelecionado != null) {
                itemSelecionado.setId(Integer.parseInt(textID.getText()));
                itemSelecionado.setNome(textNome.getText());
                itemSelecionado.setPreco(Double.parseDouble(textPreco.getText()));
                itemSelecionado.setEstoque(Integer.parseInt(textEstoque.getText()));
                itemSelecionado.setEstoqueMIN(Integer.parseInt(textMinEstoque.getText()));
                itemSelecionado.setTipoProduto(menuTipoProduto.getText());
                itemSelecionado.setConsistenciaSuplemento(textConsistenciaSupl.getText());
                itemSelecionado.setCaloriasSuplemento(Integer.parseInt(textCaloriasSupl.getText()));
                itemSelecionado.setGramasSuplemento(Double.parseDouble(textGramasSupl.getText()));
                itemSelecionado.setSaborSuplemento(textSaborSupl.getText());

                tabelaSuplemento.refresh();
                persistenceSuplemento.salvarDados(tabelaSuplemento.getItems());

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Produto editado com sucesso");
                alert.setContentText("O produto foi editado com sucesso");
                alert.showAndWait();

                resetarCampos();
            }
            else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Nenhum item selecionado");
                alert.setContentText("Por favor, selecione um item da tabela");
                alert.showAndWait();
            }
        }
    }
    //#endregion

    private void resetarCampos() {
        textID.clear();
        textNome.clear();
        textPreco.clear();
        textEstoque.clear();
        textMinEstoque.clear();
        textCategoriaAces.clear();
        textMaterialAces.clear();
        textTamanhoCalc.clear();
        textCorCalc.clear();
        textMarcaCalc.clear();
        textGeneroCalc.clear();
        textEsporteCalc.clear();
        textEsporteEquip.clear();
        textItemEquip.clear();
        textTamanhoRoupa.clear();
        textCorRoupa.clear();
        textMarcaRoupa.clear();
        textMaterialRoupa.clear();
        textConsistenciaSupl.clear();
        textCaloriasSupl.clear();
        textGramasSupl.clear();
        textSaborSupl.clear();

        textID.requestFocus();
    }

    //#region Telas

    @FXML
    private Tab tabProdutos;

    @FXML
    private Tab tabClientes;

    @FXML
    private Tab tabRelatorios;

    @FXML
    private Tab tabVendas;

    //#endregion
}
