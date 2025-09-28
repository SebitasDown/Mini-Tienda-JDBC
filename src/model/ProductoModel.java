package model;

import database.ConfigDB;
import interfaces.Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Producto;

import javax.swing.*;

public class ProductoModel implements Repositorio {
    @Override
    public List listar() {
        List <Producto> productos = new ArrayList();

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM Producto";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Producto producto = new Producto();
                producto.setId_producto(objResult.getInt("id_producto"));
                producto.setNombre(objResult.getString("nombre"));
                producto.setPrecio(objResult.getBigDecimal("precio"));
                producto.setStock(objResult.getInt("stock"));
                productos.add(producto);
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        ConfigDB.closeConnection();
        return productos;
    }

    @Override
    public Object porId(Integer id) {
        Connection objConnection = ConfigDB.openConnection();
        Producto producto = null;
        try {
            String sql = "SELECT * FROM Producto WHERE id_producto = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()){
                producto = new Producto();
                producto.setId_producto(objResult.getInt("id_producto"));
                producto.setNombre(objResult.getString("nombre"));
                producto.setPrecio(objResult.getBigDecimal("precio"));
                producto.setStock(objResult.getInt("stock"));
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        ConfigDB.closeConnection();
        return producto;
    }

    @Override
    public Producto crear(Object pr) {
        // Abrir conexión
        Connection objConnection = ConfigDB.openConnection();
            Producto objProducto = (Producto) pr;

        try{
            String sql =" INSERT INTO Producto(nombre, precio, stock) VALUES (?,?,?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setBigDecimal(2, objProducto.getPrecio());
            objPrepare.setInt(3, objProducto.getStock());

            objPrepare.execute();

            ResultSet objRest = objPrepare.getGeneratedKeys();
            while(objRest.next()){
                objProducto.setId_producto(objRest.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Producto fue agregado exitosamente");

        }catch(SQLException error){
            System.out.println("Error" + error.getMessage());
        }
        ConfigDB.closeConnection();
        return objProducto;
    }

    @Override
    public boolean editar(Object pr) {


        Connection objConnection = ConfigDB.openConnection();
        Producto objProducto = (Producto) pr;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE Producto SET nombre = ?, precio = ?, stock = ? where id_producto= ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setBigDecimal(2, objProducto.getPrecio());
            objPrepare.setInt(3, objProducto.getStock());
            objPrepare.setInt(4, objProducto.getId_producto());

            int result = objPrepare.executeUpdate();

            if (result > 0) {
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "El producto fue actualizado exitosamente");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

        ConfigDB.closeConnection();
        return false;
    }
    @Override
    public boolean eliminar(Integer id) {

        Producto objProducto = (Producto)  porId(id);
        Connection objConnection = ConfigDB.openConnection();
        boolean isDelete = false;
        try {
            String sql = "DELETE FROM Producto WHERE id_producto = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, objProducto.getId_producto());

            int result = objPrepare.executeUpdate();

            if (result > 0) {
                isDelete = true;
                JOptionPane.showMessageDialog(null, "El producto fue eliminado exitosamente");
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        ConfigDB.closeConnection();
        return isDelete;
    }
}
