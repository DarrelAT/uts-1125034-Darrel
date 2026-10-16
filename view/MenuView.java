package view;

import model.MenuItem;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenuList(List<MenuItem> menuItems) {
        System.out.println("Tampilan Menu Awal");
        for (MenuItem item : menuItems) {
            System.out.println("ID: " + item.getId() + " | " + item.getNama() + " | Harga Base: Rp" + (int)item.getHargaBase() + " | Stok: " + item.getStok());
        }
    }

    public String inputIdMenu() {
        System.out.print("Input ID Menu: ");
        return scanner.nextLine();
    }

    public int inputJumlah() {
        System.out.print("Input Jumlah Pesanan: ");
        return scanner.nextInt();
    }

    public int inputKustomisasi(String label, int max) {
        System.out.print("Masukkan jumlah " + label + " (0 - " + max + "): ");
        return scanner.nextInt();
    }

    public void showMessage(String msg) {
        System.out.println(">> " + msg);
    }

    public void printStruk(String detail, double total) {
        System.out.println("\n Hasil Pemesanan");
        System.out.println(detail);
        System.out.println("Total Harga Pembayaran: Rp" + (int)total);
    }
}