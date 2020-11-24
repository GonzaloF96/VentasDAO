package ventasdao.objetos;

public class DetalleFactura {
    
    private Integer id;
    
    private Double cantidad;
    
    private Producto productos;
    
    private Factura facturas;
    
    private Double precio_total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos = productos;
    }

    public Factura getFacturas() {
        return facturas;
    }

    public void setFacturas(Factura facturas) {
        this.facturas = facturas;
    }

    public Double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Double precio_total) {
        this.precio_total = precio_total;
    }

    
    
}
