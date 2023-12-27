package com.parkpro;

import java.sql.Timestamp;

/**
 *
 * @author khusyasy
 */
public class Tiket {
    private int id;
    private int pengguna;
    private int lahan;
    private Timestamp waktuMasuk;
    private Timestamp waktuKeluar;

    public Tiket(int id, int pengguna, int lahan, Timestamp waktuMasuk, Timestamp waktuKeluar) {
        this.id = id;
        this.pengguna = pengguna;
        this.lahan = lahan;
        this.waktuMasuk = waktuMasuk;
        this.waktuKeluar = waktuKeluar;
    }

    public int getId() {
        return id;
    }

    public int getPengguna() {
        return pengguna;
    }

    public int getLahan() {
        return lahan;
    }

    public Timestamp getWaktuMasuk() {
        return waktuMasuk;
    }

    public Timestamp getWaktuKeluar() {
        return waktuKeluar;
    }

    public String getTanggalMasuk() {
        return waktuMasuk.toString().substring(0, 10);
    }

    public String getTanggalKeluar() {
        return waktuKeluar.toString().substring(0, 10);
    }

    public String getJamMasuk() {
        return waktuMasuk.toString().substring(11, 19);
    }

    public String getJamKeluar() {
        return waktuKeluar.toString().substring(11, 19);
    }

    public int hitungDurasi() {
        long milliseconds = waktuKeluar.getTime() - waktuMasuk.getTime();
        long hours = (milliseconds + 3599999) / 3600000;
        return (int) hours;
    }
}
