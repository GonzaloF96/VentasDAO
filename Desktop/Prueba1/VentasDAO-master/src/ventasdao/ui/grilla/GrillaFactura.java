
package ventasdao.ui.grilla;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Factura;

public class GrillaFactura extends AbstractTableModel{
    private ArrayList<Factura> facturas = new ArrayList<>();
   
    public GrillaFactura(ArrayList<Factura> datos) {
        this.facturas = datos;
    }
    
    
    
    @Override
    public int getRowCount() {
        return facturas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }


 @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura factura = facturas.get(rowIndex);
        switch(columnIndex){
              case 0: return factura.getId();
              case 1: return factura.getFecha_creacion();
              case 2: return factura.getNumero();
              case 3: return factura.getObservacion();
              case 4: return factura.getCliente_id();
              case 5: return factura.getFormapago_id();
             
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Fecha_creacion";
            case 2: return "Numero";
            case 3: return "Observacion";
            case 4: return "Cliente id";
            case 5: return "Forma Pago id";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }

    public Factura getFacturaFromRow(int rowIndex){
   
            return facturas.get(rowIndex);
   }
    
    
}