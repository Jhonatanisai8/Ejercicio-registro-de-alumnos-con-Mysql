package registro.productos.myql;

import registro.productos.myql.Conex.Conexion;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhonatan
 */
public class Metodos {

    Conexion conexion = new Conexion();

    public static void insertarAlumnio(Alumno alumno) {
        try {
            Connection conectar = Conexion.conectarBD();
            String sql = "insert into alumnos values (?,?,?,?,?,?,?,?,?)";

            PreparedStatement consultaPreparada = conectar.prepareStatement(sql);

            consultaPreparada.setString(1, "0");
            consultaPreparada.setString(2, alumno.getNombres());
            consultaPreparada.setString(3, alumno.getApellidos());
            consultaPreparada.setInt(4, alumno.getDni());

            switch (alumno.getSeccion()) {
                case "A":
                    consultaPreparada.setInt(5, 1);
                    break;
                case "B":
                    consultaPreparada.setInt(5, 2);
                    break;
            }
            consultaPreparada.setDouble(6, alumno.getNota1());
            consultaPreparada.setDouble(7, alumno.getNota2());
            consultaPreparada.setDouble(8, alumno.getNota3());
            consultaPreparada.setString(9, alumno.aprovadoDesaprobado());
            consultaPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.toString());
        }

    }

    public void listarTabla(DefaultTableModel modelo, JTable tblDatos, int opcion) {
        for (int i = 0; i < tblDatos.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
        String sqlA = "SELECT alumnos.id, alumnos.nombres, alumnos.appellidos, alumnos.dni, seccion.nombre, alumnos.nota01, alumnos.nota02, alumnos.nota03, alumnos.nivel_academico FROM alumnos INNER JOIN seccion ON seccion.id = alumnos.idseccion WHERE seccion.nombre like \"A\"";
        String sqlB = "SELECT alumnos.id, alumnos.nombres, alumnos.appellidos, alumnos.dni, seccion.nombre, alumnos.nota01, alumnos.nota02, alumnos.nota03, alumnos.nivel_academico FROM alumnos INNER JOIN seccion ON seccion.id = alumnos.idseccion WHERE seccion.nombre like \"B\"";
        //     tblDatos.setModel(modelo);
        PreparedStatement consultaPreparada = null;
        try {
            Connection conectar = Conexion.conectarBD();
            switch (opcion) {
                case 1:
                    consultaPreparada = conectar.prepareStatement(sqlA);
                    break;
                case 2:
                    consultaPreparada = conectar.prepareStatement(sqlB);
                    break;
            }

            ResultSet resultado = consultaPreparada.executeQuery();

            //obtenemos los datos de la tabla en la base de datos
            ResultSetMetaData datos = resultado.getMetaData();
            int cantColumnas = datos.getColumnCount();

            //cargamos los datos 
            while (resultado.next()) {
                Object arreglo[] = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    arreglo[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(arreglo);
            }
            tblDatos.setModel(modelo);
            conectar.close();
        } catch (SQLException e) {
            System.out.println("Error al listar en tabla: " + e.toString());
        }
    }
}
