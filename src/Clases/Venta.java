
package Clases;

public class Venta {
    
    private int id;
    private double total;
    
    public Venta(){
        
    }

    public Venta(int id, int total) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
