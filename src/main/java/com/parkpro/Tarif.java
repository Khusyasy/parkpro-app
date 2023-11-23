package com.parkpro;

/**
 *
 * @author khusyasy
 */
public class Tarif {
    private int id;
    private int harga;
    private String jenisKendaraan;

    public Tarif(int id, int harga, String jenisKendaraan) {
        this.id = id;
        this.harga = harga;
        this.jenisKendaraan = jenisKendaraan;
    }

    public int getId() {
        return id;
    }

    public int getHarga() {
        return harga;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
}
