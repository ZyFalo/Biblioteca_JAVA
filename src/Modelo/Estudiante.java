package Modelo;

import javax.swing.JOptionPane;

public class Estudiante {

    public String Nombre;
    public String codigoEstudiante;

    public Estudiante() {

        this.setCodigoEstudiante(JOptionPane.showInputDialog(null, "Digite su Codigo de Estudiante:",
                "Digite los Datos del Estudiante", JOptionPane.QUESTION_MESSAGE));
        this.setNombre(JOptionPane.showInputDialog(null, "Digite su Nombre y Apellido:",
                "Digite los Datos del Estudiante", JOptionPane.QUESTION_MESSAGE));

    }

    public Estudiante(String Nombre, String codigoEstudiante) {
        this.Nombre = Nombre;
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
