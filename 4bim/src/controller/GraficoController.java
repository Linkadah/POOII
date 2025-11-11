package controller;

import dao.VendaDAO;
import model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

  // Controlador pra mostrar as vendas mensais.
  // Usa dados da tabela de vendas (via VendaDAO).

public class GraficoController {

    @FXML private BarChart<String, Number> barChartVendas;
    @FXML private CategoryAxis eixoX;
    @FXML private NumberAxis eixoY;

    private VendaDAO vendaDAO;
    private ObservableList<Venda> vendasList;

    @FXML
    public void initialize() {
        vendaDAO = new VendaDAO();
        vendasList = FXCollections.observableArrayList();

        eixoX.setLabel("Mês");
        eixoY.setLabel("Total de Vendas (R$)");

        carregarVendas();
        gerarGrafico();
    }

    //
     Carrega a lista de vendas a partir do banco de dados.
     
    private void carregarVendas() {
        try {
            vendasList.clear();
            List<Venda> vendas = vendaDAO.read();
            vendasList.addAll(vendas);
        } catch (Exception e) {
            mostrarAlerta("Erro ao carregar vendas: " + e.getMessage());
        }
    }

    
     // Gera o gráfico de vendas mensais.
     
    private void gerarGrafico() {
        try {
            // Mapa ordenado por mês
            Map<Month, Double> vendasPorMes = new TreeMap<>();

            // Inicializa todos os meses com zero (para exibir mesmo sem vendas)
            for (Month mes : Month.values()) {
                vendasPorMes.put(mes, 0.0);
            }

            // Soma o valor total por mês
            for (Venda v : vendasList) {
                if (v.getDataVenda() != null) {
                    Month mes = v.getDataVenda().getMonth();
                    double totalAtual = vendasPorMes.getOrDefault(mes, 0.0);
                    vendasPorMes.put(mes, totalAtual + v.getValorTotal());
                }
            }

            // Cria série de dados
            XYChart.Series<String, Number> serie = new XYChart.Series<>();
            serie.setName("Vendas Mensais");

            for (Month mes : Month.values()) {
                double total = vendasPorMes.get(mes);
                serie.getData().add(new XYChart.Data<>(mes.name(), total));
            }

            barChartVendas.getData().clear();
            barChartVendas.getData().add(serie);

        } catch (Exception e) {
            mostrarAlerta("Erro ao gerar gráfico: " + e.getMessage());
        }
    }

    
     // Exibe um alerta simples de erro ou informação.
     
    private void mostrarAlerta(String mensagem) {
        mostrarAlerta(mensagem, Alert.AlertType.ERROR);
    }

    private void mostrarAlerta(String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(tipo == Alert.AlertType.ERROR ? "Erro" : "Informação");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // Atualiza o gráfico manualmente (caso botão "Atualizar" seja adicionado no FXML).
     
    @FXML
    private void handleAtualizarGrafico() {
        carregarVendas();
        gerarGrafico();
        mostrarAlerta("Gráfico atualizado com sucesso!", Alert.AlertType.INFORMATION);
    }
}
