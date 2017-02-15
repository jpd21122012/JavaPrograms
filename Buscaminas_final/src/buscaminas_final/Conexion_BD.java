package buscaminas_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion_BD {
    // declaracion de variables para hacer la conexion a la base de datos
    private String cadenaConexion;
    private String user;
    private String password;
    private String driver;
    private Statement st;
    private Connection con;

    public Conexion_BD(){
        // se selecciona el url por defecto de nuestro servidor, su contraseña,usuario y driver
    this.cadenaConexion="jdbc:mysql://localhost:3306/buscaminas";
    this.user="root";
    this.password="";
    this.driver="com.mysql.jdbc.Driver";
    }
     // Setters y Getters de las variables para la conexion
    public String getCadenaConexion() {
        return cadenaConexion;
    }

    public void setCadenaConexion(String cadenaConexion) {
        this.cadenaConexion = cadenaConexion;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
/*
    Metodo booleano que sirve para saber si la conexion se realizo con exito
    */
    public boolean obtenerConexion(){
        boolean conectado=false;
        try{
            Class.forName(driver);
            con= DriverManager.getConnection(cadenaConexion,user,password);
            st = con.createStatement();
            conectado = true;
        }catch(SQLException ex){
            System.out.println("error->conexion...fail!->"+ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
            return conectado;
    }
    // se cierra la conexion con la base de datos
    public void cerrarConexion(){
        try{
            st.close();
            con.close();
        }catch(SQLException ex){}
        catch(NullPointerException ex){
        }
    }
// setter y getter de la variable de conexion
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
