package buscaminas_final;

public class Usuario {

    private int id_usuario;
    private String nombreUsuario;

    public Usuario(int id_usuario, String nombreUsuario) {
        this.id_usuario = id_usuario;
        this.nombreUsuario = nombreUsuario;
    }
     public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return nombreUsuario;
    }

}
