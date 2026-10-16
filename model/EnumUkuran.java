package model;

public enum EnumUkuran {
    SMALL("Small", 0),
    MEDIUM("Medium", 3000),
    LARGE("Large", 6000);

    private final String namaUkuran;
    private final double tambahanHarga;

    EnumUkuran(String namaUkuran, double tambahanHarga) {
        this.namaUkuran = namaUkuran;
        this.tambahanHarga = tambahanHarga;
    }

    public String getNamaUkuran() {
        return namaUkuran; 
    }
    public double getTambahanHarga() {
        return tambahanHarga; 
    }
}