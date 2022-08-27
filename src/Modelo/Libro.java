package Modelo;

import Modelo.Prestamo;
import java.util.Scanner;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class Libro {

    public String ISBN, titulo, autor;
    public int idLibro;
    public boolean estado = false;
    public String codigo;

    public Libro(int id) {
          
        this.setIdLibro(id);
        this.setISBN(JOptionPane.showInputDialog(null, "Digite ISBN:",
                "Digite los Datos del Libro", JOptionPane.QUESTION_MESSAGE));
        this.setTitulo(JOptionPane.showInputDialog(null, "Digite Titulo:",
                "Digite los Datos del Libro", JOptionPane.QUESTION_MESSAGE));
        this.setAutor(JOptionPane.showInputDialog(null, "Digite Autor:",
                "Digite los Datos del Libro", JOptionPane.QUESTION_MESSAGE));
        this.setEstado(false);
        
    }

    public Libro(String is, String ti, String au, boolean es) {
        
        this.ISBN = is;
        this.titulo = ti;
        this.autor = au;
        this.estado = es;
        
    }

    public String getEstadoTexto() {    

        if (estado == false) {

            return "En Biblioteca";

        } else {

            return "Prestado al Codigo de Estudiante # " + codigo;

        }

    }
    
        public void setEstadoTexto(String codigo) {    

            this.codigo = codigo;
            
    }   

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

}
