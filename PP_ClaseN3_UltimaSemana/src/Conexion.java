import java.sql.*;
public class Conexion {
    private String uRL;
    private String usuario;
    private String contrasena;
    private Connection conexion;

    public Conexion(){

    }
    public Conexion(String uRL,String usuario,String contrasena){
        this.uRL=uRL;
        this.usuario=usuario;
        this.contrasena=contrasena;
        CrearConexion();
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getuRL() {
        return uRL;
    }

    public void setuRL(String uRL) {
        this.uRL = uRL;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void CrearConexion(){
        try{
           conexion=DriverManager.getConnection(uRL,usuario,contrasena);
            System.out.println("Funciona");
        }catch (SQLException e){
            System.out.println("No funciono");
            throw new RuntimeException(e);
        }
    }
}
