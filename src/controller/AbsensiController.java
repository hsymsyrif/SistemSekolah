package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Absensi;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import dao.AbsensiDAO;
import model.Absensi;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class AbsensiController implements Initializable {
    private AbsensiDAO dao = new AbsensiDAO();

    private Absensi selectedAbsensi;

    @FXML
    private TableColumn<Absensi, String> colNis;

    @FXML
    private TableColumn<Absensi, String> colNama;

    @FXML
    private TableColumn<Absensi, java.sql.Date> colTanggal;

    @FXML
    private TableColumn<Absensi, String> colStatus;

    @FXML
    private TextField txtNis;

    @FXML
    private TextField txtNama;

    @FXML
    private DatePicker dpTanggal;

    @FXML
    private ComboBox<String> cbStatus;

    @FXML
    private TableView<Absensi> tableAbsensi;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableAbsensi.setColumnResizePolicy(
        TableView.CONSTRAINED_RESIZE_POLICY);

        cbStatus.getItems().addAll(
                "Hadir",
                "Izin",
                "Sakit",
                "Alpha"
        );

        loadTable();

        tableAbsensi.setOnMouseClicked(event -> {
            pilihData();
        });
    }

    private void pilihData() {

        selectedAbsensi =
                tableAbsensi.getSelectionModel()
                            .getSelectedItem();

        if (selectedAbsensi != null) {

            txtNis.setText(
                    selectedAbsensi.getNis());

            txtNama.setText(
                    selectedAbsensi.getNamaSiswa());

            dpTanggal.setValue(
                    selectedAbsensi.getTanggal()
                                .toLocalDate());

            cbStatus.setValue(
                    selectedAbsensi.getStatus());
        }
    }

    private void clearForm() {
        txtNis.clear();
        txtNama.clear();
        dpTanggal.setValue(null);
        cbStatus.setValue(null);
    }

    private void loadTable() {

        colNis.setCellValueFactory(
                new PropertyValueFactory<>("nis"));

        colNama.setCellValueFactory(
                new PropertyValueFactory<>("namaSiswa"));

        colTanggal.setCellValueFactory(
                new PropertyValueFactory<>("tanggal"));

        colStatus.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        ObservableList<Absensi> data =
                FXCollections.observableArrayList(
                        dao.getAllAbsensi());

        tableAbsensi.setItems(data);
    }

    @FXML
    public void simpanData() {

        String nis = txtNis.getText();
        String nama = txtNama.getText();

        Date tanggal = Date.valueOf(
                dpTanggal.getValue());

        String status =
                cbStatus.getValue();

        Absensi data = new Absensi(
                0,
                nis,
                nama,
                tanggal,
                status
        );

        dao.insertAbsensi(data);

        loadTable();

        clearForm();

        System.out.println("Data berhasil disimpan");
    }


    @FXML
    public void editData() {

        if (selectedAbsensi == null) {
            return;
        }

        selectedAbsensi.setNis(
                txtNis.getText());

        selectedAbsensi.setNamaSiswa(
                txtNama.getText());

        selectedAbsensi.setTanggal(
                java.sql.Date.valueOf(
                        dpTanggal.getValue()));

        selectedAbsensi.setStatus(
                cbStatus.getValue());

        dao.updateAbsensi(
                selectedAbsensi);

        loadTable();

        clearForm();

        selectedAbsensi = null;
    }

    @FXML
    public void hapusData() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Hapus Data?");
        alert.setContentText("Yakin ingin menghapus data ini?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            dao.deleteAbsensi(selectedAbsensi.getId());

            loadTable();
            clearForm();
            selectedAbsensi = null;
        }
    }

}