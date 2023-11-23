package com.parkpro;

import java.util.Date;

/**
 *
 * @author khusyasy
 */
public class Tiket {
    private int id;
    private Pengguna pengguna;
    private LahanParkir lahan;
    private Date waktuMasuk;
    private Date waktuKeluar;

    public Tiket(int id, Pengguna pengguna, LahanParkir lahan, Date waktuMasuk, Date waktuKeluar) {
        this.id = id;
        this.pengguna = pengguna;
        this.lahan = lahan;
        this.waktuMasuk = waktuMasuk;
        this.waktuKeluar = waktuKeluar;
    }

    public int getId() {
        return id;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public LahanParkir getLahan() {
        return lahan;
    }

    public Date getWaktuMasuk() {
        return waktuMasuk;
    }

    public Date getWaktuKeluar() {
        return waktuKeluar;
    }
    
    public int hitungDurasi() {
        return waktuMasuk.compareTo(waktuKeluar);
    }
}
