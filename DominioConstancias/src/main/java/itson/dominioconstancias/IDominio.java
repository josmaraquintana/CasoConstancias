/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.dominioconstancias;

import entidades.*;
import java.util.List;

/**
 *
 * @author josma
 */
public interface IDominio {
    public Alumno solicitarAlumno(String id);

    public Constancia solicitarConstancia(String id);

    public List<Alumno> solicitarCoincidencias(String idParcial);
}
