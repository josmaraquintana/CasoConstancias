/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.dominioconstancias;

import entidades.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author josma
 */
public class DominioSimulado implements IDominio {

    private final List<Alumno> alumnos;
    private int contadorFolio = 1;

    public DominioSimulado() {
        alumnos = new ArrayList<>();
        alumnos.add(new Alumno("2021001", "Josmara Quintana", 5, 6));
        alumnos.add(new Alumno("2021002", "Daniel Ruiz", 3, 7));
        alumnos.add(new Alumno("2021003", "Diego Navarro", 8, 5));
        alumnos.add(new Alumno("2022010", "Ana Garcia", 2, 8));
        alumnos.add(new Alumno("2022011", "Carlos Lopez", 4, 6));
        alumnos.add(new Alumno("2020099", "Beatriz Torres", 9, 4));
    }

    @Override
    public Alumno solicitarAlumno(String id) {
        for (Alumno a : alumnos) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Constancia solicitarConstancia(String id) {
        Alumno alumno = solicitarAlumno(id);
        if (alumno == null) {
            return null;
        }
        String folio = "F-" + String.format("%04d", contadorFolio++);
        return new Constancia(folio, new Date(), alumno);
    }

    @Override
    public List<Alumno> solicitarCoincidencias(String idParcial) {
        List<Alumno> coincidencias = new ArrayList<>();
        if (idParcial == null || idParcial.isEmpty()) {
            return coincidencias;
        }
        for (Alumno a : alumnos) {
            if (a.getId().contains(idParcial)) {
                coincidencias.add(a);
            }
        }
        return coincidencias;
    }
}