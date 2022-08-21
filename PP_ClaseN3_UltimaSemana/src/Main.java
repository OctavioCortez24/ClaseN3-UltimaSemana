import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Alumno alumno=new Alumno("Leandro","Cortez",45876507,17);
        Conexion conexion=new Conexion("jdbc:mysql://localhost:3306/prueba","root","");
        Connection con= conexion.getConexion();
        String querry="INSERT INTO alumno (Nombre, Edad, Dni, Apellido) VALUES (?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(querry);
            ps.setString(1,alumno.getNombre());
            ps.setInt(2,alumno.getEdad());
            ps.setInt(3,alumno.getDni());
            ps.setString(4,alumno.getApellido());
            ps.executeUpdate();
            System.out.println("Todo Ok");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
