package Clases;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;


public class cbBox extends Encapsulation{
    Conexion con=new Conexion();
    Connection cnSqlServer = con.conectarSQLServer();
    Connection cnMysql = con.conectarMySQL();
    Connection cnPosgreSQL = con.conectarPostgreSQL();
    
    PreparedStatement ps;
    ResultSet rs;
    
    public void consultarItem (JComboBox cbx , String tabla, String campo){
        
        cbx.addItem("---Seleccione---");
        String sql = "SELECT "+campo+" FROM "+tabla+" where estado= 1";
        try {
            ps =cnSqlServer.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbx.addItem(rs.getString(1));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void consultarItemNoStatus (JComboBox cbx , String tabla, String campo){
        
        cbx.addItem("---Seleccione---");
        String sql = "SELECT "+campo+" FROM "+tabla;
        try {
            ps =cnSqlServer.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbx.addItem(rs.getString(1));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void consultarItemNoStatusHora (JComboBox cbx , String tabla, String campo){
        
        cbx.addItem("---Seleccione---");
        String sql = "SELECT "+campo+" FROM "+tabla;
        try {
            ps =cnSqlServer.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbx.addItem(formatoHora(rs.getString(1)));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    String formatoHora(String hora24) {
        LocalTime hora = LocalTime.parse(hora24);

        DateTimeFormatter formatoHoras = DateTimeFormatter.ofPattern("HH:mm");
        String horaFormateada = hora.format(formatoHoras);

        return horaFormateada;
    }
    
    
    public void consultarItems (JComboBox cbx , String tabla, String campo){
        
        cbx.addItem("---Seleccione---");
        String sql = "SELECT "+campo+" FROM "+tabla+" where estado= 1";
        try {
            ps =cnSqlServer.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbx.addItem(rs.getString(1));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void consultarItemMySQL (JComboBox cbx , String tabla, String campo){
        

        
        cbx.addItem("---Seleccione---");
        String sql = "SELECT "+campo+" FROM "+tabla;
        try {
            ps =cnMysql.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cbx.addItem(rs.getString(1));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    
    public void obtenerIdPelicula(String nombre) {
         System.out.println(nombre);
    String id = null;
    String sql = "SELECT movie_id FROM Movies WHERE title = ?";
    
    try {       
        ps = cnSqlServer.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        if (rs.next()) {
            id = rs.getString(1);
            System.out.println(id);
            setIdPelicula(rs.getString(1));  
        } else {
            System.out.println("No se encontraron resultados para la consulta.");
        }

    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet y PreparedStatement: " + e.toString());
        }
    }
    }

    
    public void obtenerNombrepelicula(String id) {
    String nombre = null;
    String sql = "SELECT title FROM Movies WHERE movie_id = ?";
    
    try {
        ps = cnSqlServer.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            nombre = rs.getString(1);
            setNombrePelicula(nombre);
        } else {
            System.out.println("No se encontraron resultados para la consulta.");
        }

    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet y PreparedStatement: " + e.toString());
        }
    }
    }
    
    public void obtenerIdSala(String nombre) {
         System.out.println(nombre);
    String id = null;
    String sql = "SELECT room_id FROM Rooms WHERE room_name = ?";
    
    try {
        ps = cnSqlServer.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        if (rs.next()) {
            id = rs.getString(1);
            System.out.println(id);
            setIdSala(rs.getString(1));
        } else {
            System.out.println("No se encontraron resultados para la consulta.");
        }

    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet y PreparedStatement: " + e.toString());
        }
    }
    }

    
    public void obtenerNombreSala(String id) {
    String nombre = null;
    String sql = "SELECT room_name FROM Rooms WHERE room_id = ?";
    
    try {
        ps = cnSqlServer.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            nombre = rs.getString(1);
            setNombreSala(nombre);
        } else {
            System.out.println("No se encontraron resultados para la consulta.");
        }

    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet y PreparedStatement: " + e.toString());
        }
    }
    }
    
     public void obtenerIdCliente(String nombre) {
         System.out.println(nombre);
    String id = null;
    String sql = "SELECT id_cliente FROM cliente WHERE nombre = ?";
    
    try {
        ps = cnMysql.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();

        if (rs.next()) {
            id = rs.getString(1);
            System.out.println(id);
            setIdCliente(rs.getString(1));
        } else {
            System.out.println("No se encontraron resultados para la consulta.");
        }

    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet y PreparedStatement: " + e.toString());
        }
    }
    }

    
    public void obtenerNombrec(String id) {
    String nombre = null;
    String sql = "SELECT nombre FROM cliente WHERE id_cliente = ?";
    
    try {
        ps = cnMysql.prepareStatement(sql);
        ps.setString(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            nombre = rs.getString(1);
            setNombreCliente(nombre);
        } else {
            System.out.println("No se encontraron resultados para la consulta.");
        }

    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar ResultSet y PreparedStatement: " + e.toString());
        }
    }
    }
    
}
