package Clases;

public class Detalles {
    
    private int id;
    private int ventaid;
    private int productoid;
    private int cantidad;
    private double preciouni;
    
    public Detalles (){
    }

    public Detalles(int id, int ventaid, int productoid, int cantidad, double preciouni) {
        this.id = id;
        this.ventaid = ventaid;
        this.productoid = productoid;
        this.cantidad = cantidad;
        this.preciouni = preciouni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentaid() {
        return ventaid;
    }

    public void setVentaid(int ventaid) {
        this.ventaid = ventaid;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciouni() {
        return preciouni;
    }

    public void setPreciouni(double preciouni) {
        this.preciouni = preciouni;
    }
    
    
}
