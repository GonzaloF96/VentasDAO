
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Factura;
import ventasdao.objetos.FormaPago;



public class FacturaControlador implements ICrud<Factura>{
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    private String query;
    
    private FormaPagoControlador formapagocontrolador;
    
    private ClienteControlador clientecontrolador;

    @Override
    
    
    
    public boolean crear(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO facturas (fecha_creacion,numero,observacion,forma_pago_id, clientes_id) VALUES (?,?,?,?,?)";
   
      /*  Date fecha = new Date (entidad.getFecha_creacion().getTime()); */ 
         
        try {
            
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getFecha_creacion());
            ps.setInt(2, entidad.getNumero());
            ps.setString(3, entidad.getObservacion());
            ps.setInt(4, entidad.getFormapago_id().getId());           
            ps.setInt(5, entidad.getCliente_id().getId());
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(FacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Factura entidad) throws SQLException, Exception {
       connection = Conexion.obtenerConexion ();
         String sql = "delete from facturas where id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    @Override
    public Factura extraer(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Factura entidad) throws SQLException, Exception {
           connection = Conexion.obtenerConexion ();
         String sql = "UPDATE facturas set fecha_creacion = ?,numero =?,observacion =?,forma_pago_id=?, clientes_id =? WHERE id =? ";
       /*  Date fecha = new Date(entidad.getFechaCreacion().getTime()); */
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getFecha_creacion());
            ps.setInt(2, entidad.getNumero());
            ps.setString(3, entidad.getObservacion());
            ps.setInt(4, entidad.getFormapago_id().getId());           
            ps.setInt(5, entidad.getCliente_id().getId());
            ps.setInt(6, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
    }
    

    @Override
    public List<Factura> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM facturas";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Factura> facturas = new ArrayList();
            
            while(rs.next()){
                
               Factura factura = new Factura();
                
                
                factura.setObservacion(rs.getString("observacion"));
                factura.setId(rs.getInt("id"));
                factura.setNumero(rs.getInt("numero"));
               /* factura.setFecha_creacion(rs.getDate("fecha_creacion"));  */
               factura.setFecha_creacion(rs.getString("fecha_creacion"));
                factura.setCliente_id(getCliente(rs.getInt("clientes_id")));
                factura.setFormapago_id(getFormaPago(rs.getInt("forma_pago_id")));
      

                facturas.add(factura);
                
            }
            //System.out.println(cont);
            return facturas;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private FormaPago getFormaPago(Integer id) throws Exception{
     this.formapagocontrolador = new FormaPagoControlador();
     
     FormaPago formapago = formapagocontrolador.extraer(id);
     
     return formapago;
 }   
    private Cliente getCliente(Integer id) throws Exception{
     this.clientecontrolador = new ClienteControlador();
     Cliente cliente = clientecontrolador.extraer(id);
     return cliente;

    }}

