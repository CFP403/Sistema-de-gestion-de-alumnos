


package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    
    public VentanaPrincipal(){
        super("Sistema de gestion  -  CFP 403");
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JMenuBar menuBar = new JMenuBar();        
        this.setJMenuBar(menuBar);
        
        JMenu alumno = new JMenu("Alumno");
        JMenuItem ingresarAlumno = new JMenuItem("Ingresar alumno");
        JMenuItem modificarAlumno = new JMenuItem("Modificar alumno");
        JMenuItem eliminarAlumno = new JMenuItem("Eliminar alumno");
        
        JMenu docente = new JMenu("Docente");
        JMenuItem ingresarDocente = new JMenuItem("Ingresar docente");
        JMenuItem modificarDocente = new JMenuItem("Modificar docente");
        JMenuItem eliminarDocente = new JMenuItem("Eliminar docente");
        
        JMenu curso = new JMenu("Curso");
        JMenuItem ingresarCurso = new JMenuItem("Dar de alta un curso");
        JMenuItem modificarCurso = new JMenuItem("Modificar curso");
        JMenuItem eliminarCurso = new JMenuItem("Eliminar curso");
        
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
    }
    
    public void Mostrar(){
        this.setSize (900, 700);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
