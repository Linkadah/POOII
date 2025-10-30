package controller;

import dao.ClienteDAO;
import model.Cliente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.swing.table.TableColumn;

public class ClienteController {
    #FXML private TableView<Cliente> tableView;
    #FXML private TableColumn<Cliente, Integer> colId;
    #FXML private TableColumn<Cliente, String> colName;
    #FXML private TableColumn<Cliente, String> colEmail;
    #FXML private TableColumn<Cliente, String> colTelefone;
    #FXML private TextField txtNome, txtEmail, txtTelefone, txtEndereco;

    private ObservableList<Cliente> clenteLista;
    private ClienteDAO clienteDAO;



}