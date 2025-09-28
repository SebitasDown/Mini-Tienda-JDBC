
import database.ConfigDB;

import java.sql.Connection;
import controller.PoductoController;
import model.ProductoModel;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conexion = ConfigDB.openConnection();
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    1. Crear Producto
                    2. Listar productos
                    3. Encontrar Producto por ID
                    4. Eliminar producto 
                    5. Actualizar producto
                    6. Leave
                    """);
            if (option == null) {
                break;
            }
            switch (option) {
                case "1":
                    PoductoController.crear();
                    break;
                case "2":
                    PoductoController.listar();
                    break;
                case "3":
                    PoductoController.encontrarPorId();
                    break;
                case "4":
                    PoductoController.eliminar();
                    break;
                case "5":
                    PoductoController.actualizar();
                    break;
                case "6":
                    break;
            }
        }while (!option.equals("6"));

    }
}