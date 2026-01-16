package Clases;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Conexion{
    
            String hostMysql;
            String userMysql;
            String passwordMysql;
            String hostPostgreSQL;
            String userPostgreSQL;
            String passwordPostgreSQL;
            String hostSqlserver;
            String userSqlserver;
            String passwordSqlserver;
            Connection con;

    

    public Connection conectarMySQL() {
        cargarConfiguracion();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://" + hostMysql 
                + ":3306/taquilla?allowPublicKeyRetrieval=true&user=" + userMysql 
                + "&password=" + passwordMysql + "&useSSL=false&serverTimezone=UTC";

        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);
            System.out.println("Conexión exitosa a MySQL");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e1) {
            System.out.println("Error de conexión: " + e1);
        }
        return con;
    }

    
    public Connection conectarPostgreSQL(){
        cargarConfiguracion();
        String driver = "org.postgresql.Driver";
        String user = userPostgreSQL;
        String password = passwordPostgreSQL;
        String url = "jdbc:postgresql://"+hostPostgreSQL+":5432/dulceria_cine?user="
                +user+"&password="+password+"&ssl=false";


        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);
            System.out.println("Conexión exitosa a Posgtresql");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e1) {
            System.out.println("Error de conexión: " + e1);
        }
        
        return con;
    }

    public Connection conectarSQLServer() {
        cargarConfiguracion();
        String url = "jdbc:sqlserver://"
                +hostSqlserver+":1433;database=ProjectionDB;user="
                +userSqlserver+";password="+passwordSqlserver+";encrypt=false;loginTimeout=30";
        
        try {
            con = DriverManager.getConnection(url);
            System.out.println("\u001B[32mConexión exitosa a SQL Server\u001B[0m");
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null,"Error de conexión a SQL Server: " + e1.getMessage());
        }
        
        return con;
    }
    
    
    public void cargarConfiguracion() {
        
        
        try {
            Properties prop = new Properties();
            InputStream input = Conexion.class.getClassLoader().getResourceAsStream("source/config.properties");
            prop.load(input);
            
            hostMysql = prop.getProperty("db.hostMysql");
            userMysql = prop.getProperty("db.userMysql");
            passwordMysql = prop.getProperty("db.passwordMysql");
            
            hostPostgreSQL = prop.getProperty("db.hostPostgreSQL");
            userPostgreSQL = prop.getProperty("db.userPostgreSQL");
            passwordPostgreSQL = prop.getProperty("db.passwordPostgreSQL");
            
            hostSqlserver = prop.getProperty("db.hostSqlserver");
            userSqlserver = prop.getProperty("db.userSqlserver");
            passwordSqlserver = prop.getProperty("db.passwordSqlserver");
            

            int sw = 1;
            if (sw == 0) {
                System.out.println("host"); 
                System.out.println(hostMysql);
                System.out.println(hostPostgreSQL);
                System.out.println(hostSqlserver);
                System.out.println("user");
                System.out.println(userMysql);
                System.out.println(userPostgreSQL);
                System.out.println(userSqlserver);
                System.out.println("password");
                System.out.println(passwordMysql);
                System.out.println(passwordPostgreSQL);
                System.out.println(passwordSqlserver); 
            }
        
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.cargarConfiguracion();
        Connection conexionMySQL = conexion.conectarMySQL();
        Connection conexionPostgreSQL = conexion.conectarPostgreSQL();
        Connection conexionSQLServer = conexion.conectarSQLServer();
    }
}
