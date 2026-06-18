package dao;

import model.Jadwal;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JadwalDAO {

    // INSERT
    public void insertJadwal(Jadwal jadwal) {

        String sql = "INSERT INTO jadwal(hari, jam, mapel, guru) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, jadwal.getHari());
            stmt.setString(2, jadwal.getJam());
            stmt.setString(3, jadwal.getMapel());
            stmt.setString(4, jadwal.getGuru());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Jadwal> getAllJadwal() {

        List<Jadwal> list = new ArrayList<>();

        String sql = "SELECT * FROM jadwal";

        try (
            Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        ) {

            while (rs.next()) {
                list.add(new Jadwal(
                    rs.getInt("id"),
                    rs.getString("hari"),
                    rs.getString("jam"),
                    rs.getString("mapel"),
                    rs.getString("guru")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public void updateJadwal(Jadwal jadwal) {

        String sql = "UPDATE jadwal SET hari=?, jam=?, mapel=?, guru=? WHERE id=?";

        try (
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, jadwal.getHari());
            stmt.setString(2, jadwal.getJam());
            stmt.setString(3, jadwal.getMapel());
            stmt.setString(4, jadwal.getGuru());
            stmt.setInt(5, jadwal.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteJadwal(int id) {

        String sql = "DELETE FROM jadwal WHERE id=?";

        try (
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}