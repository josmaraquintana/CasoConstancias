/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVCCasoUso;

import entidades.*;
import itson.dominioconstancias.IDominio;
import java.util.List;

/**
 *
 * @author josma
 */
public class Modelo implements IModelo {

    private IDominio dominio;

    public Modelo(IDominio dominio) {
        this.dominio = dominio;
    }

    @Override
    public Alumno buscarAlumno(String id) {
        return dominio.solicitarAlumno(id);
    }

    @Override
    public Constancia generarConstancia(String id) {
        return dominio.solicitarConstancia(id);
    }

    @Override
    public List<Alumno> buscarCoincidencias(String id) {
        return dominio.solicitarCoincidencias(id);
    }
}
