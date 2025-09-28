package controller;

import database.ConfigDB;
import entity.Producto;
import model.ProductoModel;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoductoController {
    public static void crear(){
        ProductoModel objProductoModel = new ProductoModel();

        // Se piden los datos al usuario
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        BigDecimal precio = new BigDecimal(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:"));

        Producto objProducto = new Producto();
        objProducto.setNombre(nombre);
        objProducto.setPrecio(precio);
        objProducto.setStock(stock);

        objProducto = (Producto) objProductoModel.crear(objProducto);
        JOptionPane.showMessageDialog(null, objProducto.toString());
    }

    public static void listar(){
        ProductoModel objProductoModel = new ProductoModel();
        String listProductos = "\n" + "Lista de productos" + "\n";
        for(Object i : objProductoModel.listar()){
            Producto objProducto = (Producto) i;
            listProductos += objProducto.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listProductos);
    }

    public static void encontrarPorId() {
        ProductoModel objProductoModel = new ProductoModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto que desea buscar:"));
        Producto objProducto = (Producto) objProductoModel.porId(id);
        if (objProducto == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        } else {
            JOptionPane.showMessageDialog(null, objProducto.toString());
        }

    }

    public  static void actualizar(){
        ProductoModel ProductoModel = new ProductoModel();

        listar();

        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto que desea actualizar:"));
        Producto objProducto = (Producto) ProductoModel.porId(idUpdate);
        if (objProducto == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        }else{
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
            BigDecimal precio = new BigDecimal(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:"));

            objProducto.setNombre(nombre);
            objProducto.setPrecio(precio);
            objProducto.setStock(stock);
            ProductoModel.editar(objProducto);
        }
    }

    public  static void eliminar(){
        ProductoModel ProductoModel = new ProductoModel();
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto que desea eliminar:"));
        Producto objProducto = (Producto) ProductoModel.porId(idDelete);
        if (objProducto == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estas seguro?");
            if (confirm == 0) ProductoModel.eliminar(idDelete);
        }
    }
}
