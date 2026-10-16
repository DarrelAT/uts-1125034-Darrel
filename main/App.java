package main;

import controller.MenuController;
import view.MenuView;

public class App {
    public static void main(String[] args) {
        MenuView view = new MenuView();
        MenuController controller = new MenuController(view);
        controller.run();
    }
}