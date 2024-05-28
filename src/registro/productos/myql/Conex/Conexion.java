package registro.productos.myql.Conex;

//imporatamos la las librerias sql
import java.sql.*;

/**
 *
 * @author Jhonatan
 */
public class Conexion {

    private static final String URLBASE = "jdbc:mysql://localhost:3307/BDAlumnos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectarBD() {

        Connection conex = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conex = DriverManager.getConnection(URLBASE, USER, PASSWORD);

            System.out.println("0. Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Eror al conectar BD: " + e.toString());
        }
        return conex;
    }

}
