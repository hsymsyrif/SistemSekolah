package dao;

import model.Absensi;
import util.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class AbsensiDAO {
    public void insertAbsensi(Absensi absensi) {

        String sql = "INSERT INTO absensi (nis, nama_siswa, tanggal, status) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, absensi.getNis());
            stmt.setString(2, absensi.getNamaSiswa());
            stmt.setDate(3, absensi.getTanggal());
            stmt.setString(4, absensi.getStatus());

            stmt.executeUpdate();

            System.out.println("Data berhasil disimpan!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Absensi> getAllAbsensi() {

        List<Absensi> list = new ArrayList<>();

        String sql = "SELECT * FROM absensi";

        try (
            Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {

            while (rs.next()) {

                Absensi a = new Absensi(
                        rs.getInt("id"),
                        rs.getString("nis"),
                        rs.getString("nama_siswa"),
                        rs.getDate("tanggal"),
                        rs.getString("status")
                );

                list.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateAbsensi(Absensi absensi) {

        String sql = "UPDATE absensi SET nis=?, nama_siswa=?, tanggal=?, status=? WHERE id=?";

        try (
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, absensi.getNis());
            stmt.setString(2, absensi.getNamaSiswa());
            stmt.setDate(3, absensi.getTanggal());
            stmt.setString(4, absensi.getStatus());
            stmt.setInt(5, absensi.getId());

            stmt.executeUpdate();

            System.out.println("Data berhasil diupdate!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAbsensi(int id) {

        String sql = "DELETE FROM absensi WHERE id=?";

        try (
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Data berhasil dihapus!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}