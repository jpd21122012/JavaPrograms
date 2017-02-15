package buscaminas_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas_BD {
 
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion_BD bd;
    // contructor donde hace una conexion a la base de datos
    public Consultas_BD(){
        this.bd=new Conexion_BD();
    }
/*/
    Metodo que recibe un parametro; en este caso un nombre, el cual inserta el parametro string a la base de datos, 
    por medio de una consulta
    */
    public boolean AgregarUsuario(String nombre) {
        boolean regresa = false;
        int row = 0;
        try {
            String query = "INSERT INTO nombres (nombre) VALUES (?)";
            bd.obtenerConexion();
            ps = bd.getCon().prepareStatement(query);
            ps.setString(1, nombre);
            System.out.println(ps.toString());
            row = ps.executeUpdate();
            if (row > 0) {
                regresa = true;
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return regresa;
    }
/*
    Este metodo recibe tres parametros, usados para agregar la puntuacion del usuario a la base de datos
    */
    public boolean AgregarPuntuacion(int idUsuario, String nivel, int puntuacion) {
        boolean regresa = false;
        
        int row = 0;
        try {
            String query = "INSERT INTO puntuacion (id_usuario, dificultad, puntuacion, fecha) VALUES (?, ?, ?, NOW())";
            bd.obtenerConexion();
            ps = bd.getCon().prepareStatement(query);
            ps.setInt(1, idUsuario);
            ps.setString(2, nivel);
            ps.setInt(3, puntuacion);
            System.out.println(ps.toString());
            
            row = ps.executeUpdate();
            if (row > 0) {
                regresa = true;
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return regresa;
    }
    /*
    Metodo de tipo arreglo en donde de la puntuacion se sabra el ranking, recibe un parametro de la dificultad que se esta jugando
    y se hace una consulta para obtener los diferentes rankings dependiendo de la dificultad
    */
    public ArrayList<Puntuacion> Ranking(String nivel) {
    ArrayList<Puntuacion> regresa = new ArrayList<>();
        try {
            String query = "SELECT "
                    + "nombres.nombre, "
                    + "puntuacion.puntuacion, "
                    + "puntuacion.dificultad, "
                    + "puntuacion.fecha "
                    + "FROM "
                    + "nombres "
                    + "INNER JOIN puntuacion ON nombres.id_usuario = puntuacion.id_usuario WHERE puntuacion.dificultad LIKE ? ORDER BY puntuacion.puntuacion DESC";
            bd.obtenerConexion();
            ps = bd.getCon().prepareStatement(query);
            ps.setString(1, nivel);
            System.out.println(ps.toString());
            rs =ps.executeQuery();
            int posicion = 1;
            while(rs.next()){
            regresa.add(new Puntuacion(posicion, rs.getInt("puntuacion"), new Usuario(rs.getString("nombre")), rs.getString("dificultad"), rs.getString("fecha")));
            posicion++;
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return regresa;
    }
/*
    Metodo en donde se hace una consulta para obtener el usuario con el cual se jugara
    */
    public String[] ObtenerUsuarios() {
        ArrayList<String> regresa = new ArrayList<>();
        try {
            String query = "SELECT nombres.nombre FROM nombres";
            bd.obtenerConexion();
            ps = bd.getCon().prepareStatement(query);
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                regresa.add(rs.getString("nombre"));
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return regresa.toArray(new String[regresa.size()]);
    }
    
    // Este metodo hace una consulta, la cual con la sentencia select obtiene dependiendo el nombre,
    // su numero de id con el cual esta relacionado
    public int idUsuario(String usuario) {
        int regresa=0;
        try {
            String query = "SELECT nombres.id_usuario FROM nombres WHERE nombres.nombre = ? ";
            bd.obtenerConexion();
            ps = bd.getCon().prepareStatement(query);
           ps.setString(1, usuario);
            System.out.println(ps.toString());
            rs =ps.executeQuery();
            while(rs.next()){
                regresa=rs.getInt("id_usuario");
            }
            
            bd.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return regresa;
    }
    /*
    En este metodo principal se crea un objeto de esta clase, y se agrega un usuario, un metodo para obtener el ranking
    global, y esos datos de puntuacion que se obtengan de la base de datos se convertiran en un string utilizable y entendible en lenguaje
    humano
    */
    public static void main(String[] args) {
        Consultas_BD m =new Consultas_BD();
        m.AgregarUsuario("Pedro");
        ArrayList<Puntuacion> p = m.Ranking("%");
        for (Puntuacion p1 : p) {
            System.out.println(p1.toString());
        }
    }
}
