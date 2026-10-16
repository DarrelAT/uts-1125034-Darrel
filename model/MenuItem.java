package model;

public abstract class MenuItem {
    private String id;
    private String nama;
    private double hargaBase;
    private int stok;

    public MenuItem(String id, String nama, double hargaBase, int stok) {
        this.id = id;
        this.nama = nama;
        this.hargaBase = hargaBase;
        this.stok = stok;
    }

    public String getId() {
        return id; 
    }
    public String getNama() { 
        return nama; 
    }
    public double getHargaBase() {
        return hargaBase; 
    }
    public int getStok() { 
        return stok; 
    }
    public void setStok(int stok) {
        this.stok = stok; 
    }

    public abstract double hitungHargaTotal(int jumlah);
    public abstract double hitungHargaTotal(int jumlah, EnumUkuran ukuran);

    public abstract String getOrderDetail();
}