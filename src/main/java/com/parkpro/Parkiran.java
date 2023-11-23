package com.parkpro;

/**
 *
 * @author gandhi
 */
public class Parkiran {
    private String nama;
    private int kapasitas;
    private LahanParkir[] tempat;

    public Parkiran(String nama, int kapasitas) {
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.tempat = new LahanParkir[kapasitas];
    }

    public LahanParkir getLahanParkir(int index) {
        return tempat[index];
    }

    public int getKapasitas() {
        return kapasitas;
    }
    
    public LahanParkir[] getTempat() {
        return tempat;
    }

    public LahanParkir findLahanParkir(int id) {
        for (LahanParkir lahan : tempat) {
            if (lahan != null && lahan.getId() == id) {
                return lahan;
            }
        }
        return null;
    }

    public void addLahanParkir(LahanParkir lahan) {
        for (int i = 0; i < kapasitas; i++) {
            if (tempat[i] == null) {
                tempat[i] = lahan;
                break;
            }
        }
    }

    public void removeLahanParkir(int id) {
        for (int i = 0; i < kapasitas; i++) {
            if (tempat[i] != null && tempat[i].getId() == id) {
                tempat[i] = null;
                break;
            }
        }
    }

    public boolean masukParkir(int id) {
        LahanParkir lahan = findLahanParkir(id);
        if (lahan.getTersedia()) {
            lahan.setTersedia(false);
            return true;
        } else {
            return false;
        }
    }

    public boolean keluarParkir(int id) {
        LahanParkir lahan = findLahanParkir(id);
        if (!lahan.getTersedia()) {
            lahan.setTersedia(true);
            return true;
        } else {
            return false;
        }
    }
}
