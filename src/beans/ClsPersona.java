/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Martin
 */
public class ClsPersona {

    private String _nombre;
    private String _apellido;

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getApellido() {
        return _apellido;
    }

    public void setApellido(String _apellido) {
        this._apellido = _apellido;
    }

    public ClsPersona(String varNombre, String varApellido) {
        this._nombre = varNombre;
        this._apellido = varApellido;
    }

    public ClsPersona() {
    }

}
