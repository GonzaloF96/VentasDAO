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
            
              case 0: return cliente.getId();
              case 1: return cliente.getNombre();
              case 2: return cliente.getApellido();
              case 3: return cliente.getCuil();
              case 4: return cliente.getRazon_social();
              case 5: return cliente.getTipoCliente();
              
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "APELLIDO";
            case 3: return "CUIL";
            case 4: return "RAZON SOCIAL";
            case 5: return "TIPO CLIENTE ID";
            
                    
            default: return ""; 
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    
}
