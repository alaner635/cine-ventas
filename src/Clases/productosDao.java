
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class productosDao {
    
    Conexion con=new Conexion();
    Connection cn = con.conectarPostgreSQL();
    PreparedStatement ps;
    ResultSet rs;
    
    public productos buscarProd(String cod) {
        productos prod = new productos();
        String sql = "SELECT * FROM productos WHERE id = ?";
        try {
            ps=cn.prepareStatement(sql);
            int id = Integer.parseInt(cod);
            ps.setInt(1, id);
            rs= ps.executeQuery();
            if (rs.next()) {
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));  

            }else{System.out.println("no hay consulta para esa id");}
            
        } catch (SQLException e) {
            System.out.println("error:"+e.getMessage());
        }
        return prod;
    }
    
    public static void main(String[] args) {
        productosDao pro= new productosDao();
        pro.buscarProd("3");
    }
}
