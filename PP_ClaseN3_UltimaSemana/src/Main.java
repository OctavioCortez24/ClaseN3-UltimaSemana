import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList alumnosDeLaBD=new ArrayList();
        Alumno alumnoBD;
        //Creo el objeto alumno
        Alumno alumno=new Alumno("Leandro","Cortez",45876507,17);
        //Creo la conexion con el servidor
        Conexion conexion=new Conexion("jdbc:mysql://localhost:3306/prueba","root","");
        Connection con= conexion.getConexion();
        //Creo el insert para poder ingresar alumnos.
        String inserAlumno="INSERT INTO alumno (Nombre, Edad, Dni, Apellido) VALUES (?,?,?,?)";
       try{
            //Inserto el alumno en la BD
           /* PreparedStatement ps=con.prepareStatement(inserAlumno);
            ps.setString(1,alumno.getNombre());
            ps.setInt(2,alumno.getEdad());
            ps.setInt(3,alumno.getDni());
            ps.setString(4,alumno.getApellido());
            ps.executeUpdate();
            System.out.println("Todo Ok");

            //Extraigo a los alumnos de la base de datos
           PreparedStatement prepared = con.prepareStatement("Select* from alumno;");
           ResultSet rs= prepared.executeQuery();
          while (rs.next()){
              String nombre=rs.getString("Nombre");
              String apellido=rs.getString("Apellido");
              int edad= rs.getInt(2);
              int dni=rs.getInt(3);
              alumnoBD =new Alumno(nombre,apellido,dni,edad);// Instancio un objeto alumno con los datos que tengo en la BD
              alumnosDeLaBD.add(alumnoBD);// Esto es un array que guarda a los alumnos que estan en la base de datos
          }*/

          //Modifico un alumno y lo guardo
           Statement st=con.createStatement();
           String query="UPDATE alumno SET Apellido='Castro'WHERE Dni=43213252";
           // El UPDATE indica que tabla voy a modificar
           //El SET indica cual es el apartado que se va a modificar, el ='Apellido Nuevo' es el nuevo dato
           //El WHERE debe ser la primary Key, en mi caso es DNI
           st.execute(query);// Ya se modifico el alumno

           System.out.println("Modifique el alumno Octavio Cortez. Ahora se llama Octavio Castro");


        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
           conexion.Desconectar();
       }





    }
}
