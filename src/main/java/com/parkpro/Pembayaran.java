package com.parkpro;

import java.util.Date;

/**
 *
 * @author khusyasy
 */
public class Pembayaran {
    private int id;
    private Tiket tiket;
    private Pengguna pengguna;
    private String metodePembayaran;
    private Date waktuBayar;
    private int totalPembayaran;

    public Pembayaran(int id, Tiket tiket, Pengguna pengguna, String metodePembayaran, Date waktuBayar, int totalPembayaran) {
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

    public Date getWaktuBayar() {
        return waktuBayar;
    }

    public int getTotalPembayaran() {
        return totalPembayaran;
    }
    
    public int hitungTarif() {
        int durasi = tiket.hitungDurasi();
        // int tarif = tiket.getLahan().getTarif();
        int tarif = 3000;
        return durasi * tarif;
    }
}
