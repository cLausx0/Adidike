package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ProdutoAcessorio;
import model.ProdutoCalcado;
import model.ProdutoEquipamento;
import model.ProdutoRoupa;
import model.ProdutoSuplemento;

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
    public void initialize() {

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

        tabelaAcessorio.setItems(FXCollections.observableArrayList());
        tabelaCalcado.setItems(FXCollections.observableArrayList());
        tabelaEquipamento.setItems(FXCollections.observableArrayList());
        tabelaRoupa.setItems(FXCollections.observableArrayList());
        tabelaSuplemento.setItems(FXCollections.observableArrayList());
    }
    //#endregion

    //#region botões de controle
    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnEditar;

    @FXML
    void addTabelaProduto(ActionEvent event) {
        
        if (menuTipoProduto.getText() == "Acessório") {
            for (int i = 0; i < tabelaAcessorio.getItems().size(); i++){
                if (Integer.parseInt(textID.getText()) == tabelaAcessorio.getItems().get(i).getId()) {
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

        } 
        else if (menuTipoProduto.getText() == "Calçado") {
            for (int i = 0; i < tabelaCalcado.getItems().size(); i++){
                if (Integer.parseInt(textID.getText()) == tabelaCalcado.getItems().get(i).getId()) {
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

        } 
        else if (menuTipoProduto.getText() == "Equipamento") {
            for (int i = 0; i < tabelaEquipamento.getItems().size(); i++){
                if (Integer.parseInt(textID.getText()) == tabelaEquipamento.getItems().get(i).getId()) {
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
            
        } 
        else if (menuTipoProduto.getText() == "Roupa") {
            for (int i = 0; i < tabelaRoupa.getItems().size(); i++){
                if (Integer.parseInt(textID.getText()) == tabelaRoupa.getItems().get(i).getId()) {
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

        } 
        else if (menuTipoProduto.getText() == "Suplemento") {
            for (int i = 0; i < tabelaSuplemento.getItems().size(); i++){
                if (Integer.parseInt(textID.getText()) == tabelaSuplemento.getItems().get(i).getId()) {
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

        }

        textID.setText("");
        textNome.setText("");
        textPreco.setText("");
        textEstoque.setText("");
        textMinEstoque.setText("");
        textCategoriaAces.setText("");
        textMaterialAces.setText("");
        textTamanhoCalc.setText("");
        textCorCalc.setText("");
        textMarcaCalc.setText("");
        textGeneroCalc.setText("");
        textEsporteCalc.setText("");
        textEsporteEquip.setText("");
        textItemEquip.setText("");
        textTamanhoRoupa.setText("");
        textCorRoupa.setText("");
        textMarcaRoupa.setText("");
        textMaterialRoupa.setText("");
        textConsistenciaSupl.setText("");
        textCaloriasSupl.setText("");
        textGramasSupl.setText("");
        textSaborSupl.setText("");

    }

    @FXML
    void deletarCampoProduto(ActionEvent event) {

    }

    @FXML
    void editarCampoProduto(ActionEvent event) {

    }
    //#endregion

    //#region Telas
    @FXML
    private Tab telaClientes;

    @FXML
    private Tab telaRelatorios;

    @FXML
    private Tab telaVendas;

    @FXML
    void mudarTelaClientes(ActionEvent event) throws Exception {
        // FXMLLoader loader = new FXMLLoader((getClass().getResource("../view/telaRelatorios.fxml")));
        // Parent root = loader.load();
        
        // // relatoriosController controladorRelatorios = loader.getController();

        // Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Stage novaJanela = new Stage();
        // novaJanela.setScene(new Scene(root));

        // novaJanela.show();
        // stageAtual.close();

        System.out.println("to chegando aqui");
    }

    @FXML
    void mudarTelaRelatorios(ActionEvent event) throws Exception {

    }

    @FXML
    void mudarTelaVendas(ActionEvent event) throws Exception {

    }

    //#endregion
}
