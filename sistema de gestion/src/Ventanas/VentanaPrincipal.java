
package Ventanas;

import Curso.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JMenuItem ingresarAlumno, modificarAlumno, eliminarAlumno;
    private JMenuItem ingresarDocente, modificarDocente, eliminarDocente;
    private JMenuItem ingresarCurso, modificarCurso, eliminarCurso;
    
    public VentanaPrincipal(){
        super("Sistema de gestion  -  CFP 403");
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JMenuBar menuBar = new JMenuBar();        
        this.setJMenuBar(menuBar);
        
        JMenu alumno = new JMenu("Alumno");
        ingresarAlumno = new JMenuItem("Ingresar alumno");
        ingresarAlumno.addActionListener(this);
        modificarAlumno = new JMenuItem("Modificar alumno");
        modificarAlumno.addActionListener(this);
        eliminarAlumno = new JMenuItem("Eliminar alumno");
        eliminarAlumno.addActionListener(this);
        
        JMenu docente = new JMenu("Docente");
        ingresarDocente = new JMenuItem("Ingresar docente");
        ingresarDocente.addActionListener(this);
        modificarDocente = new JMenuItem("Modificar docente");
        modificarDocente.addActionListener(this);
        eliminarDocente = new JMenuItem("Eliminar docente");
        eliminarDocente.addActionListener(this);
        
        JMenu curso = new JMenu("Curso");
        ingresarCurso = new JMenuItem("Dar de alta un curso");
        ingresarCurso.addActionListener(this);
        modificarCurso = new JMenuItem("Modificar curso");
        modificarCurso.addActionListener(this);
        eliminarCurso = new JMenuItem("Eliminar curso");
        eliminarCurso.addActionListener(this);
        
        JMenu reportes = new JMenu("Reportes");
        JMenuItem listarDocentes = new JMenuItem("Listar docentes");
        JMenuItem listarAlumnos = new JMenuItem("Listar alumnos");
        JMenuItem listarCursos = new JMenuItem("Listar cursos");
        JMenuItem listarAsistencia = new JMenuItem("Listar asistencia a cursos");
               
        JMenu ayuda = new JMenu("Ayuda");
        JMenuItem ayudaDocumentacion = new JMenuItem("Documentacion");
        JMenuItem ayudaAcercaDe = new JMenuItem("Acerca de ");
        
        alumno.add(ingresarAlumno);
        alumno.add(modificarAlumno);
        alumno.add(eliminarAlumno);
        
        docente.add(ingresarDocente);
        docente.add(modificarDocente);
        docente.add(eliminarDocente);
        
        curso.add(ingresarCurso);
        curso.add(modificarCurso);
        curso.add(eliminarCurso);
        
        reportes.add(listarDocentes);
        reportes.add(listarAlumnos);
        reportes.add(listarCursos);
        reportes.add(listarAsistencia);
        
        ayuda.add(ayudaDocumentacion);
        ayuda.add(ayudaAcercaDe);
        
        menuBar.add(alumno);
        menuBar.add(docente);
        menuBar.add(curso);
        menuBar.add(reportes);
        menuBar.add(ayuda);
    
        InternalFrame ifr = new InternalFrame(this);
    
    }
    
    public void Mostrar(){
        ImageIcon img = new ImageIcon("src/Imagenes/icon32.png");
        this.setIconImage(img.getImage());
        this.setSize (900, 700);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                
        //ALumno
        
        if (e.getActionCommand() == "Ingresar alumno") {
            // Constructor de alumno
        }
        if (e.getActionCommand() == "Modificar alumno") {
            // Constructor de alumno
        }
        if (e.getActionCommand() == "Eliminar alumno") {
            // Constructor de alumno
        }
        
        
        // Curso
        
        if (e.getActionCommand() == "Dar de alta un curso") {
            IngresarCurso Curso = new IngresarCurso();
            Curso.Mostrar();
        }
        if (e.getActionCommand() == "Modificar curso") {
            ModificarCurso Curso = new ModificarCurso();
            Curso.Mostrar();
        }
        if (e.getActionCommand() == "Eliminar curso") {
            EliminarCurso Curso = new EliminarCurso();
            Curso.Mostrar();
        }
        
    }
    
}
