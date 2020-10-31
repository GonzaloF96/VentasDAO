/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Cliente;

/**
 *
 * @author Hugo Chanampe
 */
public class GrillaCliente extends AbstractTableModel{
    
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    
    
    public GrillaCliente(ArrayList<Cliente> datos) {
        this.clientes = datos;
    }
    
    

    @Override
    public int getRowCount() {
        return clientes.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch(columnIndex){
            
              case 0: return cliente.getNombre();
              case 1: return cliente.getApellido();
              case 2: return cliente.getCuil();
              case 3: return cliente.getRazon_social();
              case 4: return cliente.getTipoCliente();
              
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "NOMBRE";
            case 1: return "APELLIDO";
            case 2: return "CUIL";
            case 3: return "RAZON SOCIAL";
            case 4: return "TIPO CLIENTE ID";
            
                    
            default: return ""; 
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
}
