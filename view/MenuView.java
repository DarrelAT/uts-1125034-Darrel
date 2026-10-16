package view;

import model.MenuItem;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenuList(List<MenuItem> menuItems) {
        System.out.println("\n=== DAFTAR MENU COFFEE SHOP ===");
        for (MenuItem item : menuItems) {
            System.out.println("ID: " + item.getId() + " | " + item.getNama() + " | Harga Base: Rp" + (int)item.getHargaBase() + " | Stok: " + item.getStok());
        }
    }

    public String inputIdMenu() {
        System.out.print("Masukkan ID Menu yang ingin dipesan: ");
        return scanner.nextLine().trim();
    }

    public int inputJumlah() {
        System.out.print("Masukkan Jumlah Pesanan: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Harus angka! Masukkan ulang jumlah pesanan: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); 
        return val;
    }

    public int inputCustom(String label, int max) {
        System.out.print("Masukkan jumlah " + label + " (0 - " + max + "): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Harus angka! Masukkan ulang: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    public void showMessage(String msg) {
        System.out.println(">> " + msg);
    }

    public void printStruk(String detail, double total) {
        System.out.println("\n================ STRUK PESANAN ================");
        System.out.println(detail);
        System.out.println("Total Harga Pembayaran: Rp" + (int)total);
        System.out.println("===============================================");
    }
}