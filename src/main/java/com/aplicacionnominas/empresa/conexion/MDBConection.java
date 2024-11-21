package com.aplicacionnominas.empresa.conexion;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

@Component
public class MDBConection {
    private static BasicDataSource dataSource;

    private static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("");
            dataSource.setUrl("jdbc:mysql://localhost:3306/gestionnominas2?serverTimezone=UTC");
            dataSource.setInitialSize(10);
            dataSource.setMaxIdle(10);
            dataSource.setMaxTotal(50);
            dataSource.setMaxWaitMillis(5000);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}