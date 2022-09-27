/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.ClsCliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin
 */
public class ClsClienteDao implements IntPersona<ClsCliente>{
    
        Connection conexion = new ClsConexion().getCn(); //conexion
        ClsUtil uti = new ClsUtil();
        
 //agregamos los metodos abstractos de la interfaz
    @Override
    public boolean agregar(ClsCliente obj) {
       boolean _band = false;
       try{
            CallableStatement cs = conexion.prepareCall("{call USP_AGREGARCLIENTE(?,?,?,?,?)}");
            cs.setString(1, obj.getNombre());
            cs.setString(2, obj.getApellido());          //mandamos los parametros con su orden
            cs.setString(3, obj.getTipoMascota());
            cs.setString(4, obj.getEstadoMascota());
            cs.setString(5, obj.getDeuda());   //revisar aca que paso un numero!!!
            
            if(cs.executeUpdate()>0)
                _band = true;
            
       }catch(Exception ex){
           uti.msj(ex.toString(), 0);
       }
       
       return _band;
    }

    @Override
    public boolean actualizar(ClsCliente obj) {
              boolean _band = false;
       try{
            CallableStatement cs = conexion.prepareCall("{call USP_ACTUALIZARCLIENTE(?,?,?,?,?,?)}");
            cs.setInt(1, obj.getCodigo());
            cs.setString(2, obj.getNombre());
            cs.setString(3, obj.getApellido());          //mandamos los parametros con su orden
            cs.setString(4, obj.getTipoMascota());
            cs.setString(5, obj.getEstadoMascota());
            cs.setString(6, obj.getDeuda());   //revisar aca que paso un numero!!!
            
            if(cs.executeUpdate()>0)
                _band = true;
            
       }catch(Exception ex){
           uti.msj(ex.toString(), 0);
       }
       
       return _band;
    }

    @Override
    public boolean eliminar(int codigo) {
       boolean _band = false;
       try{
            CallableStatement cs = conexion.prepareCall("{call USP_ELIMINARCLIENTE(?)}");
            cs.setInt(1, codigo);

            if(cs.executeUpdate()>0)
                _band = true;
            
       }catch(Exception ex){
           uti.msj(ex.toString(), 0);
       }
       
       return _band;
    }

    @Override
    public DefaultTableModel lista() {
       DefaultTableModel modelo = new DefaultTableModel();
       modelo.addColumn("Codigo");
       modelo.addColumn("Nombre");
       modelo.addColumn("Apellido");
       modelo.addColumn("Mascota");
       modelo.addColumn("Estado");
       modelo.addColumn("Deuda");
       
       try{
           CallableStatement cs=conexion.prepareCall("{call USP_LISTADOCLIENTE()}");
           ResultSet rs = cs.executeQuery(); //guardamos el formato en la variable rs de tipo result set
           
           while(rs.next()){  //si hay registros capturo los registros
               Object data[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
               
               modelo.addRow(data); //si hay registros se carga la data y formo las filas
           }
           
       }catch(Exception ex){
           uti.msj(ex.toString(), 0);
       }
       
       
      return modelo;  //retorno la tabla
    }



}
