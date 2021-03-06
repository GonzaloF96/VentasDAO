
package ventasdao.ui.abm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ventasdao.controladores.ClienteControlador;
import ventasdao.controladores.FacturaControlador;
import ventasdao.controladores.FormaPagoControlador;
import ventasdao.controladores.ProductoControlador;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Factura;
import ventasdao.objetos.FormaPago;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaFactura;



public class AbmaFactura extends javax.swing.JInternalFrame {
    
   private FacturaControlador facturaControlador;
    private ProductoControlador productoControlador;
    private ClienteControlador clienteControlador;
    private FormaPagoControlador formaPagoControlador;
    private GrillaFactura grillaFactura;
    private DefaultComboBoxModel modelCombo;
    
    private Connection connection;
    private Statement statementmt;
    private PreparedStatement ps;
    private ResultSet resultSet;
    private String sql;
    private Producto producto;
    private SimpleDateFormat simpleDateFormat;
  
  
    public AbmaFactura() throws Exception {
        initComponents();
        
       /* facturacontrolador = new FacturaControlador();
      formapagocontrolador = new FormaPagoControlador();*/
      
        
     /*   try {
            grillafactura = new GrillaFactura((ArrayList<Factura>) facturacontrolador.listar());
            jtfactura.setModel(grillafactura);
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            ArrayList<FormaPago> formaPagos = formapagocontrolador.listar();
            
            modelCombo = new DefaultComboBoxModel(formaPagos.toArray());
            jcbforma_pago.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            
            ArrayList<Cliente> clientes = clientecontrolador.listar();
            
            modelCombo = new DefaultComboBoxModel(clientes.toArray());
            jcbforma_pago.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }   */
     facturaControlador = new FacturaControlador();
        productoControlador = new ProductoControlador();
        clienteControlador = new ClienteControlador();
        formaPagoControlador = new FormaPagoControlador();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        try {
            grillaFactura = new GrillaFactura((ArrayList<Factura>) facturaControlador.listar());            
            jtListadoFactura.setModel(grillaFactura);
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ArrayList<Producto> producto = productoControlador.listar();            
            
            modelCombo = new DefaultComboBoxModel(producto.toArray());
            jcbProducto.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ArrayList<Cliente> cliente = clienteControlador.listar();            
            
            modelCombo = new DefaultComboBoxModel(cliente.toArray());
            jcbCliente.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ArrayList<FormaPago> formaPago = (ArrayList<FormaPago>) formaPagoControlador.listar();            
            
            modelCombo = new DefaultComboBoxModel(formaPago.toArray());
            jcbFormaPago.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   private void refreshTable()
    {
        try 
        {
            jtListadoFactura.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void limpiarCampos()
    {
        jtfId.setText("");
        jtfCantidad.setText("");
        jtfNumFactura.setText("");
        jtaObservacion.setText("");
        jcbProducto.setSelectedIndex(0);
        jcbCliente.setSelectedIndex(0);
        jcbFormaPago.setSelectedIndex(0);
    }
    private void ActualizarTotal_Factura()
    {
        Float auxCant = Float.parseFloat(jtfCantidad.getText());
        Float auxPrecio = Float.parseFloat(jtfPrecioProd.getText());
        Float auxTotal = auxPrecio * auxCant;
        jtfTotal.setText(auxTotal.toString());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jtfCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaObservacion = new javax.swing.JTextArea();
        jtfNumFactura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbAgregarProducto = new javax.swing.JButton();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoFactura = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbEliminarProducto = new javax.swing.JButton();
        jbEditarProducto = new javax.swing.JButton();
        jtfId = new javax.swing.JTextField();
        jcbProducto = new javax.swing.JComboBox<>();
        jcbCliente = new javax.swing.JComboBox<>();
        jcbFormaPago = new javax.swing.JComboBox<>();
        jtfPrecioProd = new javax.swing.JTextField();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jtfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCantidadActionPerformed(evt);
            }
        });
        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jLabel7.setText("Nuumero Factura");

        jLabel5.setText("Fecha");

        jLabel10.setText("Precio del Producto");

        jtaObservacion.setColumns(20);
        jtaObservacion.setRows(5);
        jtaObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtaObservacionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jtaObservacion);

        jtfNumFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNumFacturaActionPerformed(evt);
            }
        });
        jtfNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNumFacturaKeyTyped(evt);
            }
        });

        jLabel8.setText("Observacion");

        jbAgregarProducto.setText("Agregar");
        jbAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarProductoActionPerformed(evt);
            }
        });

        jtListadoFactura.setAutoCreateRowSorter(true);
        jtListadoFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtListadoFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoFactura);

        jLabel9.setText("Total");

        jtfTotal.setEditable(false);

        jLabel1.setText("Producto");

        jLabel2.setText("Cantidad");

        jLabel3.setText("Cliente");

        jLabel4.setText("Forma de Pago");

        jbEliminarProducto.setText("Eliminar");
        jbEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarProductoActionPerformed(evt);
            }
        });

        jbEditarProducto.setText("Modificar");
        jbEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarProductoActionPerformed(evt);
            }
        });

        jtfId.setEnabled(false);
        jtfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdActionPerformed(evt);
            }
        });

        jcbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProductoActionPerformed(evt);
            }
        });

        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtfPrecioProd.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jbAgregarProducto)
                                        .addGap(54, 54, 54))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addGap(26, 26, 26))))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jcbFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jbEditarProducto)
                                .addGap(28, 28, 28)
                                .addComponent(jbEliminarProducto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jcbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtfPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbEditarProducto)
                            .addComponent(jbAgregarProducto)
                            .addComponent(jbEliminarProducto))))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCantidadActionPerformed

    private void jtfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyReleased
        // TODO add your handling code here:
        ActualizarTotal_Factura();
    }//GEN-LAST:event_jtfCantidadKeyReleased

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        char v = evt.getKeyChar();
        if(Character.isLetter(v)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_jtfCantidadKeyTyped

    private void jtaObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaObservacionKeyTyped
        char v = evt.getKeyChar();
        if(Character.isDigit(v)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo letras");
        }
    }//GEN-LAST:event_jtaObservacionKeyTyped

    private void jtfNumFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNumFacturaKeyTyped
        /*        char v = evt.getKeyChar();
        if(Character.isLetter(v)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        } */
    }//GEN-LAST:event_jtfNumFacturaKeyTyped

    private void jbAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarProductoActionPerformed
        // TODO add your handling code here:
        Factura factura = new Factura();

        factura.setFecha_creacion(jdcFecha.getDate());
        factura.setTotal_factura(Float.parseFloat(jtfTotal.getText()));
        factura.setNumero(Integer.parseInt(jtfNumFactura.getText()));
        factura.setProducto_id((Producto)jcbProducto.getSelectedItem());
        factura.setCliente_id((Cliente)jcbCliente.getSelectedItem());
        factura.setFormapago_id((FormaPago)jcbFormaPago.getSelectedItem());
        factura.setCantidad_producto(Float.parseFloat(jtfCantidad.getText()));
        factura.setObservacion(jtaObservacion.getText());

        try {
            this.limpiarCampos();
            this.refreshTable();
            facturaControlador.crear(factura);
            limpiarCampos();
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiarCampos();
        this.refreshTable();
    }//GEN-LAST:event_jbAgregarProductoActionPerformed

    private void jtListadoFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoFacturaMouseClicked

        Factura factura = grillaFactura.getFacturaFromRow(jtListadoFactura.getSelectedRow());

        jtfCantidad.setText(factura.getCantidad_producto().toString());
        jtfNumFactura.setText(factura.getNumero().toString());
        jdcFecha.setDate(factura.getFecha_creacion());
        jtfId.setText(factura.getId().toString());
        jtfTotal.setText(factura.getTotal_factura().toString());
        jtaObservacion.setText(factura.getObservacion());

    }//GEN-LAST:event_jtListadoFacturaMouseClicked

    private void jbEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarProductoActionPerformed
        // TODO add your handling code here:
        Factura factura = new Factura();

        factura.setId(Integer.parseInt(jtfId.getText()));

        try {
            facturaControlador.eliminar(factura);
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jtListadoFactura.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiarCampos();
        this.refreshTable();
    }//GEN-LAST:event_jbEliminarProductoActionPerformed

    private void jbEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarProductoActionPerformed
        // TODO add your handling code here:
        Factura factura = new Factura();

        factura.setNumero(Integer.parseInt(jtfNumFactura.getText()));
        factura.setFecha_creacion(jdcFecha.getDate());
        factura.setTotal_factura(Float.parseFloat(jtfTotal.getText()));
        factura.setCliente_id((Cliente)jcbCliente.getSelectedItem());
        factura.setFormapago_id((FormaPago)jcbFormaPago.getSelectedItem());
        factura.setProducto_id((Producto)jcbProducto.getSelectedItem());
        factura.setObservacion(jtaObservacion.getText());
        factura.setCantidad_producto(Float.parseFloat(jtfCantidad.getText()));
        factura.setId(Integer.parseInt(jtfId.getText()));

        try {
            this.limpiarCampos();
            this.refreshTable();
            facturaControlador.modificar(factura);
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jtListadoFactura.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmaFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiarCampos();
        this.refreshTable();
    }//GEN-LAST:event_jbEditarProductoActionPerformed

    private void jtfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdActionPerformed

    private void jcbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProductoActionPerformed
        // TODO add your handling code here:
        try
        {
            connection=Conexion.obtenerConexion();
            this.statementmt = connection.createStatement();
            this.sql = "SELECT precio FROM productos WHERE nombre= '"+jcbProducto.getSelectedItem()+"'";
            this.resultSet   = statementmt.executeQuery(sql);

            resultSet.next();
            jtfPrecioProd.setText(String.valueOf(resultSet.getFloat("precio")));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jcbProductoActionPerformed

    private void jtfNumFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNumFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNumFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAgregarProducto;
    private javax.swing.JButton jbEditarProducto;
    private javax.swing.JButton jbEliminarProducto;
    private javax.swing.JComboBox<String> jcbCliente;
    private javax.swing.JComboBox<String> jcbFormaPago;
    private javax.swing.JComboBox<String> jcbProducto;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable jtListadoFactura;
    private javax.swing.JTextArea jtaObservacion;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNumFactura;
    private javax.swing.JTextField jtfPrecioProd;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}
