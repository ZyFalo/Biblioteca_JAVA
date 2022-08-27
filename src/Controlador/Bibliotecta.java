package Controlador;

import java.util.Scanner;
import Modelo.Libro;
import Modelo.Estudiante;
import Modelo.Prestamo;
import java.util.Enumeration;
import java.util.*;
import javax.swing.JOptionPane;

public class Bibliotecta {

    public static void main(String[] args) {

        Hashtable Estudiante = new Hashtable();
        Hashtable Prestamo = new Hashtable();

        Hashtable Libro = new Hashtable();

        Libro tempoLibro;
        Prestamo tempoPrestamo;
        Estudiante tempoEstudiante;

//        Bibliotecta solucion = new Bibliotecta();
        int opcion = 9;
        int key_libros = 0;
        int key_estudiantes = 0;
        int key_prestamos = 0;

        String con_admin = "UMB";
        String contrasenia = "";

        for (int intentos = 3; intentos >= 1; intentos--) {

            contrasenia = JOptionPane.showInputDialog("Ingrese la Contraseña de Administrador:\n\nNOTA: El programa se dejará de ejecutar si no \naciertas dentro de los intentos permitidos.\n\nPista: UMB\n\nIntentos:" + intentos + "/" + 3);

            if (contrasenia.equals(con_admin)) {

                intentos = 1;

                do {

                    opcion = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al programa de Biblioteca, a continuación seleccione su opción: \n"
                            + "\n"
                            + "❃ Libros:\n"
                            + "1 - Inserte Libros en la biblioteca \n"
                            + "2 - Consultar los libros y su disponibilidad \n"
                            + "3 - Eliminar Libro\n\n"
                            + "❃ Estudiante:\n"
                            + "4 - Registrar un estudiante \n"
                            + "5 - Consultar los estudiantes \n\n"
                            + "❃ Prestamos:\n"
                            + "6 - Solicitar un libro \n"
                            + "7 - Devolver un libro \n\n"
                            + "0 - Salir\n\n"));

                    switch (opcion) {

                        case 1:

                            int num_anadir = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos Libros desea añadir?"));

                            for (int nroEjemplares = 1; nroEjemplares <= num_anadir; nroEjemplares++) {

                                Libro.put(key_libros, new Libro(key_libros));

                                key_libros++;

                            }

                            Enumeration e = Libro.keys();

                            break;

                        case 2:

                            if (Libro.isEmpty()) {

                                JOptionPane.showMessageDialog(null, "No hay libros regitrados\n\n Intente:\n"
                                        + "1 - Inserte Libros en la biblioteca \n");

                            } else {

                                e = Libro.keys();

                                String Aux = "Estudiantes Registrados:\n\n";

                                while (e.hasMoreElements()) {

                                    tempoLibro = (Libro) Libro.get(e.nextElement());

                                    Aux = Aux + "Id: " + tempoLibro.getIdLibro() + "\n"
                                            + "ISBN: " + tempoLibro.getISBN() + "\n"
                                            + "Autor: " + tempoLibro.getAutor() + "\n"
                                            + "Titulo: " + tempoLibro.getTitulo() + "\n"
                                            + "Estado: " + tempoLibro.getEstadoTexto() + "\n\n";

                                }

                                JOptionPane.showMessageDialog(null, Aux);

                            }

                            break;

                        case 3:

                            if (!Libro.isEmpty()) {

                                e = Libro.keys();

                                String Aux = " ";

                                while (e.hasMoreElements()) {

                                    tempoLibro = (Libro) Libro.get(e.nextElement());

                                    Aux = Aux + "Id: " + tempoLibro.getIdLibro() + "\n"
                                            + "ISBN: " + tempoLibro.getISBN() + "\n"
                                            + "Autor: " + tempoLibro.getAutor() + "\n"
                                            + "Titulo: " + tempoLibro.getTitulo() + "\n"
                                            + "Estado: " + tempoLibro.getEstadoTexto() + "\n\n";

                                }

                                int id_eliminar = Integer.parseInt(JOptionPane.showInputDialog(null, Aux + "ID del Libro que desea eliminar:"));

                                if (Libro.containsKey(id_eliminar)) {

                                    tempoLibro = (Libro) Libro.get(id_eliminar);

                                    if (tempoLibro.getEstado() == false) {

                                        Libro.remove(id_eliminar);

                                        JOptionPane.showMessageDialog(null, "Libro eliminado con éxito.");

                                    } else {

                                        JOptionPane.showMessageDialog(null, "Imposible eliminar: Libro está en prestamo\n\n Intente:\n"
                                                + "7 - Devolver un libro\n\n");

                                    }

                                } else {

                                    JOptionPane.showMessageDialog(null, "El ID no existe o ya está prestado\n\n Intente:\n"
                                            + "1 - Inserte Libros en la biblioteca \n"
                                            + "2 - Consultar los libros y su disponibilidad \n"
                                            + "7 - Devolver un libro \n\n");

                                }

                            } else {

                                JOptionPane.showMessageDialog(null, "No hay libros para eliminar\n\n Intente:\n"
                                        + "1 - Inserte Libros en la biblioteca \n\n");

                            }

                            break;

                        case 4:

                            Estudiante.put(key_estudiantes, new Estudiante());
                            key_estudiantes++;

                            Enumeration a = Estudiante.keys();

                            break;

                        case 5:

                            if (Estudiante.isEmpty()) {

                                JOptionPane.showMessageDialog(null, "No hay estudiantes regitrados\n\n Intente:\n"
                                        + "4 - Registrar un estudiante \n\n");

                            } else {

                                a = Estudiante.keys();

                                String Aux2 = "Estudiantes Registrados:\n\n";

                                while (a.hasMoreElements()) {

                                    tempoEstudiante = (Estudiante) Estudiante.get(a.nextElement());

                                    Aux2 = Aux2 + "Nombre: " + tempoEstudiante.getNombre() + "\n"
                                            + "Codigo: " + tempoEstudiante.getCodigoEstudiante() + "\n\n";

                                }

                                JOptionPane.showMessageDialog(null, Aux2);

                            }

                            break;

                        case 6:

                            if (!Libro.isEmpty()) {

                                boolean existe_id = false;

                                String codigo = JOptionPane.showInputDialog("Ingrese su código de estudiante");

                                a = Estudiante.keys();

                                while (a.hasMoreElements() & existe_id == false) {

                                    tempoEstudiante = (Estudiante) Estudiante.get(a.nextElement());

                                    if (tempoEstudiante.getCodigoEstudiante().equals(codigo)) {

                                        existe_id = true;

                                    }

                                }

                                if (existe_id == true) {

                                    e = Libro.keys();

                                    String Aux = " ";

                                    while (e.hasMoreElements()) {

                                        tempoLibro = (Libro) Libro.get(e.nextElement());

                                        Aux = Aux + "Id: " + tempoLibro.getIdLibro() + "\n"
                                                + "ISBN: " + tempoLibro.getISBN() + "\n"
                                                + "Autor: " + tempoLibro.getAutor() + "\n"
                                                + "Titulo: " + tempoLibro.getTitulo() + "\n"
                                                + "Estado: " + tempoLibro.getEstadoTexto() + "\n\n";

                                    }

                                    int idPrestamo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Libro que desea \n\n" + Aux));

                                    tempoLibro = (Libro) Libro.get(idPrestamo);

                                    boolean existe_libro = false;

                                    if (tempoLibro.getIdLibro() == idPrestamo) {

                                        existe_libro = true;

                                    }

                                    if (existe_libro & tempoLibro.getEstado() == false) {

                                        Prestamo.put(idPrestamo, new Prestamo(idPrestamo, codigo));

                                        tempoLibro.setEstado(true);
                                        tempoLibro.setEstadoTexto(codigo);

                                    } else {

                                        JOptionPane.showMessageDialog(null, "ID de Libro no existe o ya está en prestamo\n\n Intente:\n"
                                                + "1 - Inserte Libros en la biblioteca \n"
                                                + "2 - Consultar los libros y su disponibilidad \n"
                                                + "7 - Devolver un libro \n\n");

                                    }

                                } else {

                                    JOptionPane.showMessageDialog(null, "Estudiante no registrado\n\n Intente:\n"
                                            + "4 - Registrar un estudiante \n"
                                            + "5 - Consultar los estudiantes \n\n");

                                }
                            } else {

                                JOptionPane.showMessageDialog(null, "No existen libros para prestar\n\n Intente:\n"
                                        + "1 - Inserte Libros en la biblioteca \n\n");

                            }
                            break;

                        case 7:

                            if (!Libro.isEmpty() & !Prestamo.isEmpty()) {

                                e = Libro.keys();

                                String Aux = " ";

                                while (e.hasMoreElements()) {

                                    tempoLibro = (Libro) Libro.get(e.nextElement());

                                    Aux = Aux + "Id: " + tempoLibro.getIdLibro() + "\n"
                                            + "ISBN: " + tempoLibro.getISBN() + "\n"
                                            + "Autor: " + tempoLibro.getAutor() + "\n"
                                            + "Titulo: " + tempoLibro.getTitulo() + "\n"
                                            + "Estado: " + tempoLibro.getEstadoTexto() + "\n\n";

                                }

                                int devolver_id = Integer.parseInt(JOptionPane.showInputDialog(Aux + "Ingrese el ID del libro que va a devolver"));

                                if (Libro.containsKey(devolver_id)) {

                                    tempoLibro = (Libro) Libro.get(devolver_id);

                                    if (tempoLibro.getEstado() == true) {

                                        Prestamo.remove(devolver_id);

                                        tempoLibro.setEstado(false);
                                        tempoLibro.setEstadoTexto("");
                                    }

                                } else {

                                    JOptionPane.showMessageDialog(null, "El Libro no existe o ya está prestado\n\n Intente:\n"
                                            + "1 - Inserte Libros en la biblioteca \n"
                                            + "2 - Consultar los libros y su disponibilidad \n"
                                            + "7 - Devolver un libro \n\n");

                                }

                            } else {

                                JOptionPane.showMessageDialog(null, "No hay libros o no hay prestamos activos\n\n Intente:\n"
                                        + "1 - Inserte Libros en la biblioteca \n"
                                        + "6 - Solicitar un libro \n\n");

                            }

                            break;
                    }

                } while (opcion != 0);

            }

        }

    }

}
