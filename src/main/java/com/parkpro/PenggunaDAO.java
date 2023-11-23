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
public class PenggunaDAO {
    private Connection connection;

    public PenggunaDAO() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Properties prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(input);
            
            String dbURL = prop.getProperty("DB_URL");
            String username = prop.getProperty("DB_USERNAME");
            String password = prop.getProperty("DB_PASSWORD");
            
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (IOException ex) {
            Logger.getLogger(PenggunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PenggunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pengguna getPengguna(String noTelepon) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pengguna WHERE no_telepon = ?");
        stmt.setString(1, noTelepon);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Pengguna(
                rs.getInt("id"),
                rs.getString("gender"),
                rs.getString("no_telepon"),
                rs.getString("password"),
                rs.getString("date_of_birth"),
                rs.getString("nama"),
                rs.getString("jenis_kendaraan"),
                true
            );
        } else {
            return null;
        }
    }
    
    public void addPengguna(Pengguna pengguna) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO pengguna (gender, no_telepon, password, date_of_birth, nama, jenis_kendaraan) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, pengguna.getGender());
        stmt.setString(2, pengguna.getNoTelepon());
        stmt.setString(3, pengguna.getPassword());
        stmt.setString(4, pengguna.getDateOfBirth());
        stmt.setString(5, pengguna.getNama());
        stmt.setString(6, pengguna.getJenisKendaraan());
        stmt.executeUpdate();
    }
}
