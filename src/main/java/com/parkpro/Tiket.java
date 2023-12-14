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
    
    public int hitungDurasi() {
        return waktuMasuk.compareTo(waktuKeluar);
    }
}
