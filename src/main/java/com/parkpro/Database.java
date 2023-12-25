package com.parkpro;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khusyasy
 */
public class Database {
    private Connection conn;

    public Database() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Properties prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(input);

            String dbURL = prop.getProperty("DB_URL");
            String username = prop.getProperty("DB_USERNAME");
            String password = prop.getProperty("DB_PASSWORD");

            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return conn.createStatement().executeQuery(query);
    }

    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeQuery();
    }

    public int executeUpdate(String query) throws SQLException {
        return conn.createStatement().executeUpdate(query);
    }

    public int executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeUpdate();
    }

    public int getLastInsertId() throws SQLException {
        ResultSet rs = executeQuery("SELECT LAST_INSERT_ID()");
        rs.next();
        return rs.getInt(1);
    }
}
