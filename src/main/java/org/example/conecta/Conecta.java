package org.example.conecta;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conecta {
    public static Connection connection;

    public static Connection connect() throws IOException, ClassNotFoundException, SQLException {

        FileInputStream envFile = new FileInputStream("src/main/resources/.env");
        Properties properties = new Properties();
        properties.load(envFile);
        Class.forName(properties.getProperty("DRIVERNAME"));

        connection = DriverManager.getConnection(
                properties.getProperty("URL"),
                properties.getProperty("USERNAME"),
                properties.getProperty("PASSWORD"));

        System.out.println("Conectado.....");

        return connection;
    }






}
