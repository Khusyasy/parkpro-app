package com.khusyasy.parkpro;

import java.util.Date;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author khusyasy
 */
public class Pengguna {
    private int id;
    private String gender;
    private String noTelepon;
    private String password;
    private String dateOfBirth;
    private String nama;
    private String jenisKendaraan;

    public Pengguna(int id, String gender, String noTelepon, String password, String dateOfBirth, String nama, String jenisKendaraan) {
        this.id = id;
        this.gender = gender;
        this.noTelepon = noTelepon;
        this.password = hashPassword(password);
        this.dateOfBirth = dateOfBirth;
        this.nama = nama;
        this.jenisKendaraan = jenisKendaraan;
    }

    public Pengguna(int id, String gender, String noTelepon, String password, String dateOfBirth, String nama, String jenisKendaraan, boolean db) {
        this.id = id;
        this.gender = gender;
        this.noTelepon = noTelepon;
        this.password = db ? password : hashPassword(password);
        this.dateOfBirth = dateOfBirth;
        this.nama = nama;
        this.jenisKendaraan = jenisKendaraan;
    }

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getPassword() {
        return password;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }
    
    public boolean checkPassword(String inputPass) {
        return BCrypt.checkpw(inputPass, password); 
    }

    public void pesanLahanParkir(Parkiran parkiran, int id) {
        parkiran.masukParkir(id);
        Tiket tiket = new Tiket(id, this, parkiran.findLahanParkir(id), new Date(), null);
        System.out.println("Tiket anda: " + tiket.getId());
    }
}
