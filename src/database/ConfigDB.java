package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    public static Connection objConnection = null;


    public static Connection openConnection () {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://mysql-cb47f1b-mazoosebas-b7e8.g.aivencloud.com:26554/defaultdb";
            String user = "avnadmin";
            String password = "AVNS_2Qftsx_8VJDBC7AkaRx";

            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        }catch (ClassNotFoundException error){
            System.out.println("Driver No instalado" + error.getMessage());
    }catch (SQLException error){
            System.out.println("Error al conectar con la base de datos" + error.getMessage());

        }
        return objConnection;
    }

    public static void closeConnection(){
        try{
            if(objConnection !=null){
                objConnection.close();
                System.out.println("Se ha finalizado la conexion");
            }
        }catch (SQLException error){
            System.out.println("Error" + error.getMessage());
        }
    }
}
