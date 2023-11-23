package com.parkpro;

/**
 *
 * @author khusyasy
 */
public class Admin {
    private int id;
    private String nama;
    private String username;
    private String password;

    public Admin(int id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public LahanParkir lihatLahanParkir(Parkiran parkiran, int idLahanParkir) {
        return parkiran.getLahanParkir(idLahanParkir);
    }

    public void tambahLahanParkir(Parkiran parkiran, LahanParkir lahanParkir) {
        parkiran.addLahanParkir(lahanParkir);
    }

    public void ubahLahanParkir(Parkiran parkiran, LahanParkir lahanParkir) {
        parkiran.removeLahanParkir(lahanParkir.getId());
        parkiran.addLahanParkir(lahanParkir);
    }

    public void hapusLahanParkir(Parkiran parkiran, int idLahanParkir) {
        parkiran.removeLahanParkir(idLahanParkir);
    }
}
