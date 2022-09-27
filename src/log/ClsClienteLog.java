/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;

import beans.ClsCliente;
import dao.ClsClienteDao;
import dao.ClsUtil;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Martin
 */
public class ClsClienteLog {
    
   ClsClienteDao obj = new ClsClienteDao();
   ClsUtil uti = new ClsUtil();
    
    public void agregar(String nom, String ap, String masc, String est, String deu) {
    
        if(obj.agregar(new ClsCliente(nom,ap,masc, est, deu))){
            uti.msj("Dato agregado", 1);
        }
    
     }
     public void actualizar(int cod,String nom, String ap, String masc, String est, String deu) {
        if(obj.actualizar(new ClsCliente(cod,nom,ap,masc, est, deu))){
            uti.msj("Registro actualizado", 1);
        }
    
    }
    
     public void eliminar(int codigo) {
     
        if(obj.eliminar(codigo))
            uti.msj("Cliente Eliminado", 1);
         
     }
     
   public DefaultTableModel lista() {
       return obj.lista(); //retorno la tabla
   }
     
     
     
}
