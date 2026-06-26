import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        try {

            Connection conn = DatabaseManager.getConnection();

            System.out.println("Berhasil terhubung ke database!");

            conn.close();

        } catch (Exception e) {

            System.out.println("Gagal koneksi");
            e.printStackTrace();

        }

    }

}