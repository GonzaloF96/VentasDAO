
package ventasdao;

import ventasdao.controladores.CategoriaControlador;
import ventasdao.controladores.ClienteControlador;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Cliente;


public class VentasDAO {

    
    public static void main(String[] args) throws Exception {
         CategoriaControlador categoriaControlador = new CategoriaControlador ();

        Categoria categoria = new Categoria ();
        categoria.setId(2);
       categoria.setDenominacion ( "carbon" );
       categoria.setDescripcion ( "nnnnn" );

        categoriaControlador.eliminar(categoria );
        /*categoriaControlador.crear(categoria );
       /* categoriaControlador.modificar(categoria );*/
    /* ClienteControlador clienteControlador = new ClienteControlador();
      Cliente cliente = new Cliente();
      cliente.setNombre("gonzalo");
     cliente.setCuil("20-39701152-7");
      cliente.setRazonsocial("aaaaa");
      cliente.setApellido("fuentes");
      cliente.setTipocliente(id);
      
   
      
      clienteControlador.crear(cliente);
       */
      
       }



    }
    
