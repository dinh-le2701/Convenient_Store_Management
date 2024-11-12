package convenient_store.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    // Thông tin kết nối cơ sở dữ liệu
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=store_management;encrypt=true;trustServerCertificate=true;"; // Thay "your_database" bằng tên cơ sở dữ liệu của bạn
    private static final String username = "sa"; // Thay bằng tên người dùng MySQL của bạn
    private static final String password = "123456"; // Thay bằng mật khẩu MySQL của bạn

    // Phương thức kết nối
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Kết nối tới cơ sở dữ liệu
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại.");
            e.printStackTrace();
        }
        return connection;
    }

    // Phương thức đóng kết nối
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đóng kết nối thành công!");
            } catch (SQLException e) {
                System.out.println("Đóng kết nối thất bại.");
                e.printStackTrace();
            }
        }
    }
}
