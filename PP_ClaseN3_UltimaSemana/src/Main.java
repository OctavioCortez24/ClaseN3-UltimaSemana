import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Alumno alumno=new Alumno("Leandro","Cortez","45876507","17");
        Conexion con=new Conexion("jdbc:mysql://localhost:3306/prueba","root","");
    }
}
