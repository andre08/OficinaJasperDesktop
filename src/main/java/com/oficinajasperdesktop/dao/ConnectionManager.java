package com.oficinajasperdesktop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import org.hibernate.cfg.Configuration;

public class ConnectionManager {

    public static Connection getConnection() {

        Connection conn = null;

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); //hibernate config xml file name
        String userName, passWord, classDrive, urlConect;//set them as per your needs
        userName = cfg.getProperties().getProperty("hibernate.connection.username");
        passWord = cfg.getProperties().getProperty("hibernate.connection.password");
        classDrive = cfg.getProperties().getProperty("hibernate.connection.driver_class");
        urlConect = cfg.getProperties().getProperty("hibernate.connection.url");

        try {
            Class.forName(classDrive);
            conn = DriverManager.getConnection(urlConect, userName, passWord);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conn;
    }
}
