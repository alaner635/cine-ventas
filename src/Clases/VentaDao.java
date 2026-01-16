package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDao {
    Conexion con=new Conexion();
    Connection cn = con.conectarPostgreSQL();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int idVenta(){
        int id =0;
        String sql = "SELECT MAX(id)FROM ventas ";
        try {
            ps=cn.prepareStatement(sql);
            rs= ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
    public int registrarVenta(Venta v){
        String sql = "INSERT INTO ventas (total) VALUES (?)"; 
        try {
            ps=cn.prepareStatement(sql);
            ps.setDouble(1, v.getTotal());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
        return r;
    }
    public int RegistroDetalle(Detalles Dv){
        String sql = "INSERT INTO detallesventa (ventaid, productoid , cantidad , preciounitario) VALUES (?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, Dv.getVentaid());
            ps.setInt(2, Dv.getProductoid());
            ps.setInt(3, Dv.getCantidad());
            ps.setDouble(4, Dv.getPreciouni());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        return r;
    }
    public boolean ActualizarStock(int cant, String cod){
        
        String sql = "UPDATE productos SET stock = ? where id = ?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, Integer.parseInt(cod));
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    public void cerrar (){
        try {
            cn.close();
        } catch (SQLException e) {
            System.out.println("Base de datos cerrada correctamente.");
        }
            
        }
}
