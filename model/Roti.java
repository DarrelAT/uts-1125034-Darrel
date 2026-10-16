package model;

import java.util.List;

public class Roti extends MenuItem implements Customizable {
    private int gula;     
    private int meses;     
    private int karamel;   

    public Roti(String id, String nama, double hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
        this.gula = 0;
        this.meses = 0;
        this.karamel = 0;
    }

    @Override
    public void customize(List<Integer> customizations) {
        if (customizations.size() >= 3) {
            this.gula = customizations.get(0);
            this.meses = customizations.get(1);
            this.karamel = customizations.get(2);
        }
    }

    @Override
    public void customize(int[] customizations) {
        if (customizations.length >= 3) {
            this.gula = customizations[0];
            this.meses = customizations[1];
            this.karamel = customizations[2];
        }
    }

    private double hitungBiayaKustomisasi() {
        return (meses * 500) + (karamel * 3000);
    }

    @Override
    public double hitungHargaTotal(int jumlah) {
        return (getHargaBase() + hitungBiayaKustomisasi()) * jumlah;
    }

    @Override
    public double hitungHargaTotal(int jumlah, String kodePromo) {
        double total = hitungHargaTotal(jumlah);
        if (kodePromo != null && kodePromo.equalsIgnoreCase("COFFEEHEMAT")) {
            total = total * 0.85;
        }
        return total;
    }

    @Override
    public double hitungHargaTotal(int jumlah, EnumUkuran ukuran) {
        double hargaSatuan = getHargaBase() + hitungBiayaKustomisasi() + ukuran.getTambahanHarga();
        return hargaSatuan * jumlah;
    }

    @Override
    public String getOrderDetail() {
        return "Roti [" + getNama() + "] (ID: " + getId() + ") | Gula: " + gula + ", Meses: " + meses + ", Karamel: " + karamel;
    }
}