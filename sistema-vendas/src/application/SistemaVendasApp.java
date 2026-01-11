package application;

import service.MenuService;

public class SistemaVendasApp {
    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        menuService.menuPrincipal();
    }
}
