package model;

import java.util.List;

public class Kopi extends MenuItem implements Customizable {
    private int rum;       
    private int es;        
    private int gula;      
    private int karamel;   

    public Kopi(String id, String nama, double hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
        this.rum = 0;
        this.es = 0;
        this.gula = 0;
        this.karamel = 0;
    }

    @Override
    public void customize(List<Integer> customizations) {
        if (customizations.size() >= 4) {
            this.rum = customizations.get(0);
            this.es = customizations.get(1);
            this.gula = customizations.get(2);
            this.karamel = customizations.get(3);
        }
    }

    @Override
    public void customize(int[] customizations) {
        if (customizations.length >= 4) {
            this.rum = customizations[0];
            this.es = customizations[1];
            this.gula = customizations[2];
            this.karamel = customizations[3];
        }
    }

    private double hitungBiayaKustomisasi() {
        double biayaRum = rum * 3000;
        double biayaKaramel = karamel * 3000;
        return biayaRum + biayaKaramel;
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
        return "Kopi [" + getNama() + "] (ID: " + getId() + ") | Rum: " + rum + ", Es: " + es + ", Gula: " + gula + ", Karamel: " + karamel;
    }
}