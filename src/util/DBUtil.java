package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static {
        try {
            // 加载驱动
            Class.forName("lib");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        String ip = "localhost";
        String port = "3306";
        String database = "hutubill";
        String encoding = "UTF-8";
        String url = String.format("jdbc:mysql://%s:%s/%s?characterEncoding=%s",
                ip, port, database, encoding);
        String loginName = "root";
        String password = "canton0520";
        return DriverManager.getConnection(url, loginName, password);
    }
}
