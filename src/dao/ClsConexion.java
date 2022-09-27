/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin
 */
public class ClsConexion {

    Connection _conexion = null;

    ClsUtil utilitarios = new ClsUtil();
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String usuario = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/db_petsystem";

    static {               //estableceremos la conexion
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Proyecto", 0);
        }
    }

    public Connection getCn() {
        try {
            _conexion = DriverManager.getConnection(url, usuario, password); //se conecta a la base de datos

        } catch (Exception ex) {
            utilitarios.msj(ex.toString(), 0);
        }

        return _conexion;
    }

}
