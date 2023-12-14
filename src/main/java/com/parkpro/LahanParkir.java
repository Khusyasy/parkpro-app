package com.parkpro;

/**
 *
 * @author gandhi
 */
public class LahanParkir {
    private int id;
    private String lantai;
    private String lokasi;
    private int nomor;
    private boolean tersedia;

    public LahanParkir(int id, String lantai, String lokasi, int nomor, boolean tersedia) {
        this.id = id;
        this.lantai = lantai;
        this.lokasi = lokasi;
        this.nomor = nomor;
        this.tersedia = tersedia;
    }

    public int getId() {
        return id;
    }

    public String getLantai() {
        return lantai;
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getNomor() {
        return nomor;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    @Override
    public String toString() {
        return id + "," + lantai + "," + lokasi + "," + nomor + "," + tersedia;
    }
}
