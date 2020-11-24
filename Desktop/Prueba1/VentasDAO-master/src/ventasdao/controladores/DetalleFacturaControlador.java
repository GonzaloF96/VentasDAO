/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.DetalleFactura;
import ventasdao.objetos.Producto;
import ventasdao.controladores.ProductoControlador;


public class DetalleFacturaControlador implements ICrud<DetalleFactura>{
    
    private Connection connection;

    private Statement statementmt;

    private PreparedStatement ps;

    private ResultSet resultSet;

    private String query;
    
    
    
    @Override
    public boolean crear(DetalleFactura entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(DetalleFactura entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleFactura extraer(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(DetalleFactura entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleFactura> listar() throws SQLException, Exception {
       connection = Conexion.obtenerConexion ();
        try{
            
            this.statementmt = connection.createStatement();
            this.query = "SELECT * FROM detalle_factura";
            this.resultSet   = statementmt.executeQuery(query);
            connection.close();
            
            ArrayList<DetalleFactura> detallefacturas = new ArrayList();
            
            while(resultSet.next()){
                
                DetalleFactura detallefactura = new DetalleFactura();
                
                detallefactura.setCantidad(resultSet.getDouble("cantidad"));
                detallefactura.setPrecio_total(resultSet.getDouble("precio_total"));
                detallefactura.setId(resultSet.getInt("id"));
             /*   detallefactura.setProductos(get(resultSet.getInt("producto_id"))); */
                       
                detallefacturas.add(detallefactura);
                
            }
           
            return detallefacturas;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
}
