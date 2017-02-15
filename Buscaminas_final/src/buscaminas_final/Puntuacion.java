package buscaminas_final;
public class Puntuacion {
/*
Se declaran las variables se utilizaran para sacar la puntuacion, asi como sus constructores con parametros y los 
    respectivos getters y setters de las variables 
*/
    private int idPuntuacion;
    private int puntuacion;
    private Usuario usuario;
    private String dificultad;
    private String fecha;

    public Puntuacion(int idPuntuacion, int puntuacion, Usuario usuario, String dificultad, String fecha) {
        this.idPuntuacion = idPuntuacion;
        this.puntuacion = puntuacion;
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.fecha = fecha;
    }

    public Puntuacion(int puntuacion, Usuario usuario, String dificultad, String fecha) {
        this.puntuacion = puntuacion;
        this.usuario = usuario;
        this.dificultad = dificultad;
        this.fecha = fecha;
    }
    
    public int getIdPuntuacion() {
        return idPuntuacion;
    }

    public void setIdPuntuacion(int idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return idPuntuacion + ".- " +usuario + " ----- " + puntuacion +"<br>";
    }
    
    
}
