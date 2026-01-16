
package Clases;


public class productos {
    
    private int Id;
    private String Nombre;
    private double Precio;
    private int Stock;
    
    public productos(){
    
    }

    public productos(int Id, String Nombre, double Precio, int Stock) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Stock = Stock;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
    
}
