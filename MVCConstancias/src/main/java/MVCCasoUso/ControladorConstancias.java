/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVCCasoUso;

import entidades.Alumno;

/**
 *
 * @author josma
 */
public class ControladorConstancias {
    private IVista vista;
    private IModelo modelo;

    public ControladorConstancias(IVista vista, IModelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void buscarAlumno(String id) {
        Alumno alumno = modelo.buscarAlumno(id);
        vista.mostrarAlumno(alumno);
    }

    public void generarConstancia(String idAlumno) {
        vista.mostrarConstancia(modelo.generarConstancia(idAlumno));
    }

    public void buscarCoincidencias(String idParcial) {
        vista.mostrarCoincidencias(modelo.buscarCoincidencias(idParcial));
    }
}
