/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package itson.mvcconstancias;

import MVCCasoUso.*;
import itson.dominioconstancias.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author josma
 */
public class MVCConstancias {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IDominio dominio = new DominioSimulado();
            IModelo modelo = new Modelo(dominio);
            VistaConsulta vista = new VistaConsulta();

            ControladorConstancias controlador = new ControladorConstancias(vista, modelo);
            vista.setControlador(controlador);

            vista.setVisible(true);
        });
    }
}
