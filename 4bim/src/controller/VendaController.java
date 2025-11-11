package controller;

import dao.VendaDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Venda;
import model.Cliente;
import model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class VendaController {

    @FXML private TableView<Venda> tableView;
    @FXML private TableColumn<Venda, Integer> colId;
    @FXML private TableColumn<Venda, String> colCliente;
    @FXML private TableColumn<Venda, String> colProduto;
    @FXML private TableColumn<Venda, Integer> colQuantidade;
    @FXML private TableColumn<Venda, Double> colValorTotal;
    @FXML private TableColumn<Venda, LocalDate> colDataVenda;

    @FXML private ComboBox<Cliente> cmbCliente;
    @FXML private ComboBox<Produto> cmbProduto;
    @FXML private TextField txtQuantidade, txtValorTotal;
    @FXML private DatePicker dpDataVenda;

    private ObservableList<Venda> vendasList;
    private ObservableList<Cliente> clientesList;
    private ObservableList<Produto> produtosList;

    private VendaDAO vendaDAO;
    private ClienteDAO clienteDAO;
    private ProdutoDAO produtoDAO;

    @FXML
    public void initialize() {
        vendaDAO = new VendaDAO();
        clienteDAO = new ClienteDAO();
        produtoDAO = new ProdutoDAO();

        vendasList = FXCollections.observableArrayList();
        clientesList = FXCollections.observableArrayList();
        produtosList = FXCollections.observableArrayList();

        tableView.setItems(vendasList);
        cmbCliente.setItems(clientesList);
        cmbProduto.setItems(produtosList);

        colId.setCellValueFactory(cell -> cell.getValue().idProperty().asObject());
        colCliente.setCellValueFactory(cell -> cell.getValue().clienteNomeProperty());
        colProduto.setCellValueFactory(cell -> cell.getValue().produtoNomeProperty());
        colQuantidade.setCellValueFactory(cell -> cell.getValue().quantidadeProperty().asObject());
        colValorTotal.setCellValueFactory(cell -> cell.getValue().valorTotalProperty().asObject());
        colDataVenda.setCellValueFactory(cell -> cell.getValue().dataVendaProperty());

        carregarVendas();
        carregarClientes();
        carregarProdutos();

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> selecionarVenda(newValue)
        );
    }

    private void carregarVendas() {
        try {
            vendasList.clear();
            vendasList.addAll(vendaDAO.read());
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar vendas: " + e.getMessage());
        }
    }

    private void carregarClientes() {
        try {
            clientesList.clear();
            clientesList.addAll(clienteDAO.read());
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar clientes: " + e.getMessage());
        }
    }

    private void carregarProdutos() {
        try {
            produtosList.clear();
            produtosList.addAll(produtoDAO.read());
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void selecionarVenda(Venda venda) {
        if (venda != null) {
            dpDataVenda.setValue(venda.getDataVenda());
            txtQuantidade.setText(String.valueOf(venda.getQuantidade()));
            txtValorTotal.setText(String.valueOf(venda.getValorTotal()));

            for (Cliente c : clientesList) {
                if (c.getId() == venda.getClienteId()) {
                    cmbCliente.getSelectionModel().select(c);
                    break;
                }
            }
            for (Produto p : produtosList) {
                if (p.getId() == venda.getProdutoId()) {
                    cmbProduto.getSelectionModel().select(p);
                    break;
                }
            }
        }
    }

    @FXML
    private void handleSalvar() {
        if (validarCampos()) {
            try {
                Venda venda = new Venda();
                venda.setDataVenda(dpDataVenda.getValue());
                venda.setClienteId(cmbCliente.getValue().getId());
                venda.setProdutoId(cmbProduto.getValue().getId());
                venda.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
                venda.setValorTotal(Double.parseDouble(txtValorTotal.getText()));

                vendaDAO.create(venda);
                carregarVendas();
                limparCampos();
                mostrarAlerta("Venda registrada com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao registrar venda: " + e.getMessage());
            }
        }
    }

    @FXML
    private void handleExcluir() {
        Venda vendaSelecionada = tableView.getSelectionModel().getSelectedItem();
        if (vendaSelecionada != null) {
            try {
                vendaDAO.delete(vendaSelecionada.getId());
                carregarVendas();
                limparCampos();
                mostrarAlerta("Venda excluída com sucesso!", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                mostrarAlerta("Erro ao excluir venda: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Selecione uma venda para excluir!");
        }
    }

    @FXML
    private void handleLimpar() {
        limparCampos();
        tableView.getSelectionModel().clearSelection();
    }

    private void limparCampos() {
        dpDataVenda.setValue(null);
        txtQuantidade.clear();
        txtValorTotal.clear();
        cmbCliente.getSelectionModel().clearSelection();
        cmbProduto.getSelectionModel().clearSelection();
    }

    private boolean validarCampos() {
        if (cmbCliente.getValue() == null || cmbProduto.getValue() == null ||
                dpDataVenda.getValue() == null || txtQuantidade.getText().isEmpty() ||
                txtValorTotal.getText().isEmpty()) {
            mostrarAlerta("Todos os campos são obrigatórios!");
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