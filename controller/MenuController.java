package controller;

import exception.InputTidakValidException;
import exception.MenuTidakDitemukanException;
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

        MenuItem selectedItem = null;

        while (selectedItem == null) {
            try {
                String idInput = view.inputIdMenu();
                selectedItem = cariMenuById(idInput);
            } catch (MenuTidakDitemukanException e) {
                view.showMessage("ERROR: " + e.getMessage() + " Silakan coba lagi.");
            }
        }

        int jumlah = 0;
        while (true) {
            try {
                jumlah = view.inputJumlah();

                if (jumlah <= 0) {
                    throw new InputTidakValidException("Jumlah pesanan tidak boleh nol atau negatif!");
                }
                if (jumlah > selectedItem.getStok()) {
                    throw new StokTidakCukupException("Stok tidak cukup! Sisa stok: " + selectedItem.getStok());
                }
                break; 
            } catch (InputTidakValidException | StokTidakCukupException e) {
                view.showMessage("ERROR: " + e.getMessage());
            }
        }

        if (selectedItem instanceof Kopi) {
            int rum = view.inputCustom("Rum", 1);
            int es = view.inputCustom("Es", 5);
            int gula = view.inputCustom("Gula", 5);
            int karamel = view.inputCustom("Karamel", 5);
            ((Kopi) selectedItem).customize(new int[]{rum, es, gula, karamel});

        } else if (selectedItem instanceof Teh) {
            int boba = view.inputCustom("Boba", 3);
            int es = view.inputCustom("Es", 5);
            int gula = view.inputCustom("Gula", 5);
            int karamel = view.inputCustom("Karamel", 5);
            ((Teh) selectedItem).customize(new int[]{boba, es, gula, karamel});

        } else if (selectedItem instanceof Roti) {
            int gula = view.inputCustom("Gula", 5);
            int meses = view.inputCustom("Meses", 5);
            int karamel = view.inputCustom("Karamel", 5);
            ((Roti) selectedItem).customize(new int[]{gula, meses, karamel});
        }

        selectedItem.setStok(selectedItem.getStok() - jumlah);
        double totalHarga = selectedItem.hitungHargaTotal(jumlah, EnumUkuran.MEDIUM); 

        view.printStruk(selectedItem.getOrderDetail() + " | Jumlah: " + jumlah, totalHarga);
    }

    private MenuItem cariMenuById(String id) throws MenuTidakDitemukanException {
        for (MenuItem item : menuList) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        throw new MenuTidakDitemukanException("ID Menu '" + id + "' tidak terdaftar dalam sistem!");
    }
}