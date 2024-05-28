/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registro.productos.myql;

/**
 *
 * @author User
 */
public class Alumno {

    //atributos del alumno
    private String nombres;
    private String apellidos;
    private int dni;
    private String seccion;
    private double nota1;
    private double nota2;
    private double nota3;

    public Alumno(String nombres, String apellidos, int dni, String seccion, double nota1, double nota2, double nota3) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.seccion = seccion;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }


    //metodo para calcular el promedio
    private double promedio() {
        return (nota1 + nota2 + nota3) / 3;
    }

    //metodo para ver si esta aprovado o desaprovado
    public String aprovadoDesaprobado() {
        String condicion = "";
        if (promedio() <= 10.5) {
            condicion = "Desaprobado";
        } else {
            condicion = "Aprovado";
        }
        return condicion;
    }

}
