package controller;

import dao.ProdutoDAO;
import dao.CategoriaDAO;
import model.Produto;
import model.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProdutoController {

    @FXML private TableView<Produto> tableView;
    @FXML private TableColumn<Produto, Integer> colId;
    @FXML private TableColumn<Produto, String> colNome;
    @FXML private TableColumn<Produto, String> colDescricao;
    @FXML private TableColumn<Produto, Double> colPreco;
    @FXML private TableColumn<Produto, Integer> colEstoque;
    @FXML private TableColumn<Produto, String> colCategoria;

    @FXML private TextField txtNome, txtDescricao, txtPreco, txtEstoque;
    @FXML private ComboBox<Categoria> cmbCategoria;

    private ObservableList<Produto> produtosList;
    private ObservableList<Categoria> categoriasList;
    private ProdutoDAO produtoDAO;
    private CategoriaDAO categoriaDAO;

    @FXML
    public void initialize() {
        produtoDAO = new ProdutoDAO();
        categoriaDAO = new CategoriaDAO();
        produtosList = FXCollections.observableArrayList();
        categoriasList = FXCollections.observableArrayList();

        tableView.setItems(produtosList);
        cmbCategoria.setItems(categoriasList);

        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        colDescricao.setCellValueFactory(cellData -> cellData.getValue().descricaoProperty());
        colPreco.setCellValueFactory(cellData -> cellData.getValue().precoProperty().asObject());
        colEstoque.setCellValueFactory(cellData -> cellData.getValue().estoqueProperty().asObject());
        colCategoria.setCellValueFactory(cellData -> cellData.getValue().categoriaNomeProperty());

        carregarProdutos();
        carregarCategorias();

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> selecionarProduto(newValue)
        );
    }

    private void carregarProdutos() {
        try {
            produtosList.clear();
            produtosList.addAll(produtoDAO.read());
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void carregarCategorias() {
        try {
            categoriasList.clear();
            categoriasList.addAll(categoriaDAO.read());
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar categorias: " + e.getMessage());
        }
    }

    private void selecionarProduto(Produto produto) {
        if (produto != null) {
            txtNome.setText(produto.getNome());
            txtDescricao.setText(produto.getDescricao());
            txtPreco.setText(String.valueOf(produto.getPreco()));
            txtEstoque.setText(String.valueOf(produto.getEstoque()));

            for (Categoria cat : categoriasList) {
                if (cat.getId() == produto.getCategoriaId()) {
                    cmbCategoria.getSelectionModel().select(cat);
                    break;
                }
            }
        }
    }

    @FXML
    private void handleSalvar() {
        if (validarCampos()) {
            try {
                Produto produto = new Produto();
                produto.setNome(txtNome.getText());
                produto.setDescricao(txtDescricao.getText());
                produto.setPreco(Double.parseDouble(txtPreco.getText()));
                produto.setEstoque(Integer.parseInt(txtEstoque.getText()));
                produto.setCategoriaId(cmbCategoria.getValue().getId());

                produtoDAO.create(produto);
                carregarProdutos();
                limparCampos();
                mostrarAlerta("Produto salvo com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao salvar produto: " + e.getMessage());
            }
        }
    }

    @FXML
    private void handleAtualizar() {
        Produto produtoSelecionado = tableView.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null && validarCampos()) {
            try {
                produtoSelecionado.setNome(txtNome.getText());
                produtoSelecionado.setDescricao(txtDescricao.getText());
                produtoSelecionado.setPreco(Double.parseDouble(txtPreco.getText()));
                produtoSelecionado.setEstoque(Integer.parseInt(txtEstoque.getText()));
                produtoSelecionado.setCategoriaId(cmbCategoria.getValue().getId());

                produtoDAO.update(produtoSelecionado);
                carregarProdutos();
                limparCampos();
                mostrarAlerta("Produto atualizado com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao atualizar produto: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecione um produto para atualizar!");
        }
    }

    @FXML
    private void handleExcluir() {
        Produto produtoSelecionado = tableView.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null) {
            try {
                produtoDAO.delete(produtoSelecionado.getId());
                carregarProdutos();
                limparCampos();
                mostrarAlerta("Produto excluído com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao excluir produto: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecione um produto para excluir!");
        }
    }

    @FXML
    private void handleLimpar() {
        limparCampos();
        tableView.getSelectionModel().clearSelection();
    }

    private void limparCampos() {
        txtNome.clear();
        txtDescricao.clear();
        txtPreco.clear();
        txtEstoque.clear();
        cmbCategoria.getSelectionModel().clearSelection();
    }

    private boolean validarCampos() {
        if (txtNome.getText().isEmpty()) {
            mostrarAlerta("Nome é obrigatório!");
            return false;
        }
        if (cmbCategoria.getValue() == null) {
            mostrarAlerta("Selecione uma categoria!");
            return false;
        }
        return true;
    }

    private void mostrarAlerta(String mensagem) {
        mostrarAlerta(mensagem, Alert.AlertType.ERROR);
    }

    private void mostrarAlerta(String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}