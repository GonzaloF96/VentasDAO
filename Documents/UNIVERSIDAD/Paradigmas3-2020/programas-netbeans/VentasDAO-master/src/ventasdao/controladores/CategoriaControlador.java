/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ventasdao.dominio.Conexion;
import ventasdao.objetos.Categoria;

/**
 *
 * @author Hugo Chanampe
 */
public class CategoriaControlador implements ICrud<Categoria>{
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    

    
    public ArrayList<Categoria> listar() throws SQLException, Exception{
    
    
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM categorias";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Categoria> categorias = new ArrayList();
            
            while(rs.next()){
                
                Categoria categoria = new Categoria();
                
                categoria.setDenominacion(rs.getString("denominacion"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setId(rs.getInt("id"));
                
                        //System.out.println(cliente);
                
                
                categorias.add(categoria);
                
            }
            //System.out.println(cont);
            connection.close();
            return categorias;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    

    
    
    }

    @Override
    public boolean crear(Categoria entidad) throws SQLException, Exception{
        connection = Conexion.obtenerConexion ();
         String sql = "INSERT INTO categorias (denominacion,descripcion) VALUES (?,?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getDenominacion());
            ps.setString(2, entidad.getDescripcion());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Categoria entidad) throws SQLException, Exception {
       connection = Conexion.obtenerConexion ();
         String sql = "delete from categorias where id = ?";
        
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
    public Categoria extraer(int id) throws SQLException, Exception {
         connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM categorias where id = ?";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            
            while(rs.next()){
                
                Categoria categoria = new Categoria();
                
                categoria.setDenominacion(rs.getString("denominacion"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setId(rs.getInt("id"));
                
                       
                
          
                
            }
            
            connection.close();
         
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    
    }

    @Override
    public boolean modificar(Categoria entidad)throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
         String sql = "UPDATE categorias set denominacion = ?,descripcion =? where id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getDenominacion());
            ps.setInt(2, entidad.getId());
            ps.setString(3, entidad.getDescripcion() );
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}