/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.objetos;

/**
 *
 * @author Hugo Chanampe
 */
public class Cliente {
    
    private Integer id;
    
  
    private String nombre;
    
    private String apellido;
    
    private TipoCliente tipoCliente;
    
    private String razon_social;
    
    private String cuil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Cliente(Integer id, String nombre, String apellido, TipoCliente tipoCliente, String razon_social, String cuil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCliente = tipoCliente;
        this.razon_social = razon_social;
        this.cuil = cuil;
    }

    public Cliente() {
    }
    
    

   
 
    
}
