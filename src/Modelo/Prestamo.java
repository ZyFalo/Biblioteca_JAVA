package Modelo;

import javax.swing.JOptionPane;
import Modelo.Libro;
import java.util.Hashtable;

public class Prestamo {

    private int IdLibro, IdPrestamo;
    private String codigoEstudiante, fechaPrestamo, fechaDevolucion;
    private Hashtable estanteria;

    public Prestamo (int id, String codigo) {

        this.setIdLibro(id);
        this.setIdPrestamo(id);

        this.setCodigoEstudiante(codigo);
        this.setFechaPrestamo(JOptionPane.showInputDialog(null, "Digite la fecha de préstamo:",
                "Digite los Datos del Libro", JOptionPane.QUESTION_MESSAGE));
        this.setFechaDevolucion(JOptionPane.showInputDialog(null, "Digite la fecha de devolución:",
                "Digite los Datos del Libro", JOptionPane.QUESTION_MESSAGE));

    }

    public Prestamo(String codigoEstudiante, String fechaPrestamo, String fechaDevolucion) {

        this.codigoEstudiante = codigoEstudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        
    }

    public int getIdLibro() {
        return IdLibro;
    }

    public void setIdLibro(int IdLibro) {
        this.IdLibro = IdLibro;
    }

    public int getIdPrestamo() {
        return IdPrestamo;
    }

    public void setIdPrestamo(int IdPrestamo) {
        this.IdPrestamo = IdPrestamo;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
    
    
    
    
    
    
    
    
    
    
