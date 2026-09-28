/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MVCCasoUso;

import entidades.*;
import java.util.List;

/**
 *
 * @author josma
 */
public interface IModelo {
    Alumno buscarAlumno(String id);

    Constancia generarConstancia(String id);

    List<Alumno> buscarCoincidencias(String id);
}
