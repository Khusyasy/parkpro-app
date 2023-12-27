package com.parkpro;

import java.sql.Timestamp;

/**
 *
 * @author khusyasy
 */
public class Pembayaran {
    private int id;
    private Tiket tiket;
    private Pengguna pengguna;
    private String metodePembayaran;
    private Timestamp waktuBayar;
    private int totalPembayaran;

    public Pembayaran(int id, Tiket tiket, Pengguna pengguna, String metodePembayaran, Timestamp waktuBayar, int totalPembayaran) {
        this.id = id;
        this.tiket = tiket;
        this.pengguna = pengguna;
        this.metodePembayaran = metodePembayaran;
        this.waktuBayar = waktuBayar;
        this.totalPembayaran = totalPembayaran;
    }

    public int getId() {
        return id;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public Timestamp getWaktuBayar() {
        return waktuBayar;
    }

    public int getTotalPembayaran() {
        return totalPembayaran;
    }
    
    public int hitungTarif() {
        int durasi = tiket.hitungDurasi();
        // int tarif = tiket.getLahan().getTarif();
        int tarif = 3000;
        totalPembayaran = durasi * tarif;
        return totalPembayaran;
    }
}
