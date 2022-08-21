import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //Creo el objeto alumno
        Alumno alumno=new Alumno("Leandro","Cortez",45876507,17);
        //Creo la conexion con el servidor
        Conexion conexion=new Conexion("jdbc:mysql://localhost:3306/prueba","root","");
        Connection con= conexion.getConexion();
        //Creo el insert para poder ingresar alumnos.
        String inserAlumno="INSERT INTO alumno (Nombre, Edad, Dni, Apellido) VALUES (?,?,?,?)";
        try{
            //Inserto el alumno en la BD
            PreparedStatement ps=con.prepareStatement(inserAlumno);
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
