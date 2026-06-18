import util.DatabaseConnection;
import java.sql.Connection;

public class TestKoneksi {

    public static void main(String[] args) {

        Connection conn =
                DatabaseConnection.connect();

        if (conn != null) {
            System.out.println(
                    "Koneksi berhasil!"
            );
        } else {
            System.out.println(
                    "Koneksi gagal!"
            );
        }
    }
}