package com.parkpro;

/**
 *
 * @author gandhi
 */
public class LahanParkir {
    private int id;
    private String lantai;
    private String lokasi;
    private boolean tersedia;

    public LahanParkir(int id, String lantai, String lokasi) {
        this.id = id;
        this.lantai = lantai;
        this.lokasi = lokasi;
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

    public boolean getTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
