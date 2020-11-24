
package ventasdao.objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
    
    private Integer id;
    
    private String fecha_creacion;
    
    private List<DetalleFactura> detallefacturas;
    
    private Cliente cliente_id;
    
    private FormaPago formapago_id;
    
    private Integer numero;
    
    private String observacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    

   

    public void setDetallefacturas(List<DetalleFactura> detallefacturas) {
        this.detallefacturas = detallefacturas;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

    public FormaPago getFormapago_id() {
        return formapago_id;
    }

    public void setFormapago_id(FormaPago formapago_id) {
        this.formapago_id = formapago_id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
    
    

   
}
