
package beans;


public class ClsCliente extends ClsPersona {
    
    private int _codigo;
    private String _tipoMascota;
    private String _estadoMascota;
    private String _deuda;

    
    //sirve para actualizar datos en base de datos (necesita el codigo)
    public ClsCliente(int _codigo, String varNombre, String varApellido, String _tipoMascota, String _estadoMascota, String _deuda) {
        super(varNombre, varApellido);
        this._codigo = _codigo;
        this._tipoMascota = _tipoMascota;
        this._estadoMascota = _estadoMascota;
        this._deuda = _deuda;
    }
    //es para crear cliente nuevo, no necesita el codigo
      public ClsCliente(String varNombre, String varApellido, String _tipoMascota, String _estadoMascota, String _deuda) {
        super(varNombre, varApellido);
        this._tipoMascota = _tipoMascota;
        this._estadoMascota = _estadoMascota;
        this._deuda = _deuda;
    }

    public int getCodigo() {
        return _codigo;
    }

    public void setCodigo(int _codigo) {
        this._codigo = _codigo;
    }

    public String getTipoMascota() {
        return _tipoMascota;
    }

    public void setTipoMascota(String _tipoMascota) {
        this._tipoMascota = _tipoMascota;
    }

    public String getEstadoMascota() {
        return _estadoMascota;
    }

    public void setEstadoMascota(String _estadoMascota) {
        this._estadoMascota = _estadoMascota;
    }

    public String getDeuda() {
        return _deuda;
    }

    public void setDeuda(String _deuda) {
        this._deuda = _deuda;
    }
    
    
    
}
