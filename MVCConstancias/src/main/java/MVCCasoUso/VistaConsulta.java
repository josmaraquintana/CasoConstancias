/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVCCasoUso;

import entidades.Alumno;
import entidades.Constancia;
import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;

/**
 *
 * @author josma
 */
public class VistaConsulta extends JFrame implements IVista {
    
    private String txtID;
    private JButton btnGenerar;
    private JTextField campoID;
    private JTextArea areaDatos;
    private DefaultListModel<Alumno> modeloLista;
    private JList<Alumno> listaCoincidencias;

    private ControladorConstancias controlador;
    private Alumno alumnoSeleccionado;

    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public VistaConsulta() {
        super("Generar Constancia de Alumno Inscrito");
        construirInterfaz();
    }

    public void setControlador(ControladorConstancias controlador) {
        this.controlador = controlador;
    }

    private void construirInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2, 10, 10));

        JPanel panelIzquierdo = new JPanel(new BorderLayout(5, 5));
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));

        campoID = new JTextField();
        campoID.setBorder(BorderFactory.createTitledBorder("Ingrese ID"));
        panelIzquierdo.add(campoID, BorderLayout.NORTH);

        areaDatos = new JTextArea();
        areaDatos.setEditable(false);
        areaDatos.setLineWrap(true);
        panelIzquierdo.add(new JScrollPane(areaDatos), BorderLayout.CENTER);

        btnGenerar = new JButton("Generar");
        panelIzquierdo.add(btnGenerar, BorderLayout.SOUTH);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));

        modeloLista = new DefaultListModel<>();
        listaCoincidencias = new JList<>(modeloLista);
        panelDerecho.add(new JScrollPane(listaCoincidencias), BorderLayout.CENTER);

        add(panelIzquierdo);
        add(panelDerecho);

        campoID.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { escribirID(campoID.getText()); }
            public void removeUpdate(DocumentEvent e) { escribirID(campoID.getText()); }
            public void changedUpdate(DocumentEvent e) { escribirID(campoID.getText()); }
        });

        listaCoincidencias.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Alumno seleccionado = listaCoincidencias.getSelectedValue();
                if (seleccionado != null && controlador != null) {
                    controlador.buscarAlumno(seleccionado.getId());
                }
            }
        });

        btnGenerar.addActionListener(e -> {
            if (alumnoSeleccionado != null && controlador != null) {
                controlador.generarConstancia(alumnoSeleccionado.getId());
            } else {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un alumno de la lista antes de generar la constancia.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void escribirID(String id) {
        this.txtID = id;
        if (controlador != null) {
            controlador.buscarCoincidencias(id);
        }
    }

    @Override
    public void mostrarAlumno(Alumno alumno) {
        this.alumnoSeleccionado = alumno;
        if (alumno == null) {
            areaDatos.setText("Alumno no encontrado.");
            return;
        }
        areaDatos.setText(
                "Semestre\n" + alumno.getSemestre() + "\n\n" +
                "Cantidad de Materias\n" + alumno.getMaterias()
        );
    }

    @Override
    public void mostrarConstancia(Constancia constancia) {
        if (constancia == null) {
            areaDatos.append("\n\nNo se pudo generar la constancia.");
            return;
        }
        areaDatos.setText(
                "Constancia generada\n\n" +
                "Alumno: " + constancia.getAlumno().getNombre() + "\n" +
                "Semestre: " + constancia.getAlumno().getSemestre() + "\n" +
                "Cantidad de Materias: " + constancia.getAlumno().getMaterias() + "\n" +
                "Folio: " + constancia.getFolio() + "\n" +
                "Fecha: " + formatoFecha.format(constancia.getFecha())
        );
    }

    @Override
    public void mostrarCoincidencias(List<Alumno> coincidencias) {
        modeloLista.clear();
        if (coincidencias != null) {
            for (Alumno a : coincidencias) {
                modeloLista.addElement(a);
            }
        }
    }
}
