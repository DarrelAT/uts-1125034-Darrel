package model;

import java.util.List;

public class Teh extends MenuItem implements Customizable {
    private int boba;      
    private int es;        
    private int gula;      
    private int karamel;   

    public Teh(String id, String nama, double hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
        this.boba = 0;
        this.es = 0;
        this.gula = 0;
        this.karamel = 0;
    }

    @Override
    public void customize(List<Integer> customizations) {
        if (customizations.size() >= 4) {
            this.boba = customizations.get(0);
            this.es = customizations.get(1);
            this.gula = customizations.get(2);
            this.karamel = customizations.get(3);
        }
    }

    @Override
    public void customize(int[] customizations) {
        if (customizations.length >= 4) {
            this.boba = customizations[0];
            this.es = customizations[1];
            this.gula = customizations[2];
            this.karamel = customizations[3];
        }
    }

    private double hitungBiayaKustomisasi() {
        return (boba * 1000) + (karamel * 3000);
    }

    @Override
    public double hitungHargaTotal(int jumlah) {
        return (getHargaBase() + hitungBiayaKustomisasi()) * jumlah;
    }

    @Override
    public double hitungHargaTotal(int jumlah, EnumUkuran ukuran) {
        double hargaSatuan = getHargaBase() + hitungBiayaKustomisasi() + ukuran.getTambahanHarga();
        return hargaSatuan * jumlah;
    }

    @Override
    public String getOrderDetail() {
        return "Teh [" + getNama() + "] (ID: " + getId() + ") | Boba: " + boba + ", Es: " + es + ", Gula: " + gula + ", Karamel: " + karamel;
    }
}