package controller;

import exception.StokTidakCukupException;
import model.*;
import view.MenuView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final List<MenuItem> menuList;
    private final MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
        this.menuList = new ArrayList<>();
        
        menuList.add(new Kopi("M-01", "Kopi Susu", 20000, 5));
        menuList.add(new Teh("M-02", "Teh Tarik", 15000, 10));
        menuList.add(new Roti("M-03", "Roti Cokelat", 12000, 8));
    }

    public void run() {
        view.displayMenuList(menuList);

        MenuItem selectedIte = null;

        while (selectedItem == null) {
            String idInput = view.inputIdMenu();
            selectedItem = cariMenuById(idInput);
            
            if (selectedItem == null) {
                view.showMessage("Id menu tidak di temukan");
            }
        }

        int jumlah = 0;
        
        while (true) {
            try {
                jumlah = view.inputJumlah();

                if (jumlah > selectedItem.getStok()) {
                    throw new StokTidakCukupException("Stok tidak cukup, Sisa stok menu tersedia: " + selectedItem.getStok());
                }
                
                if (jumlah <= 0) {
                    view.showMessage("Minimal 1 pesanan");
                    continue;
                }
                break;
                
            } catch (StokTidakCukupException e) {
                view.showMessage("Exception: " + e.getMessage());
                view.showMessage("Input stok lebih rendah");
            }
        }

        if (selectedItem instanceof Kopi) {
            int rum = view.inputKustomisasi("Rum", 1);
            int es = view.inputKustomisasi("Es", 5);
            int gula = view.inputKustomisasi("Gula", 5);
            int karamel = view.inputKustomisasi("Karamel", 5);
            ((Kopi) selectedItem).customize(new int[]{rum, es, gula, karamel});

        } else if (selectedItem instanceof Teh) {
            int boba = view.inputKustomisasi("Boba", 3);
            int es = view.inputKustomisasi("Es", 5);
            int gula = view.inputKustomisasi("Gula", 5);
            int karamel = view.inputKustomisasi("Karamel", 5);
            ((Teh) selectedItem).customize(new int[]{boba, es, gula, karamel});

        } else if (selectedItem instanceof Roti) {
            int gula = view.inputKustomisasi("Gula", 5);
            int meses = view.inputKustomisasi("Meses", 5);
            int karamel = view.inputKustomisasi("Karamel", 5);
            ((Roti) selectedItem).customize(new int[]{gula, meses, karamel});
        }

        selectedItem.setStok(selectedItem.getStok() - jumlah);
        double totalHarga = selectedItem.hitungHargaTotal(jumlah, EnumUkuran.MEDIUM);

        view.printStruk(selectedItem.getOrderDetail() + " | Jumlah: " + jumlah, totalHarga);
    }

    private MenuItem cariMenuById(String id) {
        for (MenuItem item : menuList) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }
}