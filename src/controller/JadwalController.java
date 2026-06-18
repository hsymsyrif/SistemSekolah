package controller;

import dao.JadwalDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Jadwal;

import java.net.URL;
import java.util.ResourceBundle;

public class JadwalController implements Initializable {

    @FXML private TextField txtHari;
    @FXML private TextField txtJam;
    @FXML private TextField txtMapel;
    @FXML private TextField txtGuru;

    @FXML private TableView<Jadwal> tableJadwal;

    @FXML private TableColumn<Jadwal, String> colHari;
    @FXML private TableColumn<Jadwal, String> colJam;
    @FXML private TableColumn<Jadwal, String> colMapel;
    @FXML private TableColumn<Jadwal, String> colGuru;

    private JadwalDAO dao = new JadwalDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableJadwal.setColumnResizePolicy(
        TableView.CONSTRAINED_RESIZE_POLICY);

        loadTable();

        tableJadwal.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY);

        tableJadwal.setOnMouseClicked(event -> {
            pilihData();
        });
    }

    private Jadwal selectedJadwal;

    private void pilihData() {

        selectedJadwal =
                tableJadwal.getSelectionModel()
                            .getSelectedItem();

        if (selectedJadwal != null) {

            txtHari.setText(
                    selectedJadwal.getHari());

            txtJam.setText(
                    selectedJadwal.getJam());

            txtMapel.setText(
                    selectedJadwal.getMapel());

            txtGuru.setText(
                    selectedJadwal.getGuru());
        }
    }

    private void loadTable() {
        colHari.setCellValueFactory(
                new PropertyValueFactory<>("hari"));
        colJam.setCellValueFactory(
                new PropertyValueFactory<>("jam"));
        colMapel.setCellValueFactory(
                new PropertyValueFactory<>("mapel"));
        colGuru.setCellValueFactory(
                new PropertyValueFactory<>("guru"));

        ObservableList<Jadwal> data =
                FXCollections.observableArrayList(
                        dao.getAllJadwal());

        tableJadwal.setItems(data);
    }

    private void clearForm() {
        txtHari.clear();
        txtJam.clear();
        txtMapel.clear();
        txtGuru.clear();
    }

    @FXML
    public void simpanData() {

        Jadwal jadwal = new Jadwal(
                0,
                txtHari.getText(),
                txtJam.getText(),
                txtMapel.getText(),
                txtGuru.getText()
        );

        dao.insertJadwal(jadwal);

        loadTable();

        clearForm();
    }

    @FXML
    public void editData() {

        if (selectedJadwal == null) {
            return;
        }

        selectedJadwal.setHari(
                txtHari.getText());

        selectedJadwal.setJam(
                txtJam.getText());

        selectedJadwal.setMapel(
                txtMapel.getText());

        selectedJadwal.setGuru(
                txtGuru.getText());

        dao.updateJadwal(
                selectedJadwal);

        loadTable();

        clearForm();

        selectedJadwal = null;
    }

    @FXML
    public void hapusData() {

        if (selectedJadwal == null) {
            return;
        }

        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION);

        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Hapus Data?");
        alert.setContentText(
                "Yakin ingin menghapus data ini?");

        if (alert.showAndWait().get()
                == ButtonType.OK) {

            dao.deleteJadwal(
                    selectedJadwal.getId());

            loadTable();

            clearForm();

            selectedJadwal = null;
        }
    }
}