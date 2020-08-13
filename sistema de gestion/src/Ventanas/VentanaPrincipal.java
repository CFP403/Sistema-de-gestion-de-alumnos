
package Ventanas;

import Curso.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JMenuItem ingresarAlumno, modificarAlumno, eliminarAlumno;
    private JMenuItem ingresarDocente, modificarDocente, eliminarDocente;
    private JMenuItem ingresarCurso, modificarCurso, eliminarCurso;
    
    public VentanaPrincipal()
    {
        
        super("Sistema de gestion  -  CFP 403");
        
        this.Configuracion();
        
        this.BarraHerramientas();
        
    }
    
    private void Configuracion ()
    {
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
    }
    
    private void BarraHerramientas ()
    {
        
        // Creamos la Barra de herramientas:
        JMenuBar menuBar = new JMenuBar();        
        this.setJMenuBar(menuBar);
        
            // Menu Alumno:
            JMenu alumno = new JMenu("Alumno");
            ingresarAlumno = new JMenuItem("Ingresar alumno");
            ingresarAlumno.addActionListener(this);
            modificarAlumno = new JMenuItem("Modificar alumno");
            modificarAlumno.addActionListener(this);
            eliminarAlumno = new JMenuItem("Eliminar alumno");
            eliminarAlumno.addActionListener(this);
                // Agregamos los items:
                alumno.add(ingresarAlumno);
                alumno.add(modificarAlumno);
                alumno.add(eliminarAlumno);
            
            // Menu Docente:
            JMenu docente = new JMenu("Docente");
            ingresarDocente = new JMenuItem("Ingresar docente");
            ingresarDocente.addActionListener(this);
            modificarDocente = new JMenuItem("Modificar docente");
            modificarDocente.addActionListener(this);
            eliminarDocente = new JMenuItem("Eliminar docente");
            eliminarDocente.addActionListener(this);
                // Agregamos los items:
                docente.add(ingresarDocente);
                docente.add(modificarDocente);
                docente.add(eliminarDocente);

            // Menu Curso:
            JMenu curso = new JMenu("Curso");
            ingresarCurso = new JMenuItem("Dar de alta un curso");
            ingresarCurso.addActionListener(this);
            modificarCurso = new JMenuItem("Modificar curso");
            modificarCurso.addActionListener(this);
            eliminarCurso = new JMenuItem("Eliminar curso");
            eliminarCurso.addActionListener(this);
                // Agregamos los items:
                curso.add(ingresarCurso);
                curso.add(modificarCurso);
                curso.add(eliminarCurso);
            
            // Menu Reportes:
            JMenu reportes = new JMenu("Reportes");
            JMenuItem listarDocentes = new JMenuItem("Listar docentes");
            JMenuItem listarAlumnos = new JMenuItem("Listar alumnos");
            JMenuItem listarCursos = new JMenuItem("Listar cursos");
            JMenuItem listarAsistencia = new JMenuItem("Listar asistencia a cursos");
                // Agregamos los items:
                reportes.add(listarDocentes);
                reportes.add(listarAlumnos);
                reportes.add(listarCursos);
                reportes.add(listarAsistencia);
            
            // Menu Ayuda:
            JMenu ayuda = new JMenu("Ayuda");
            JMenuItem ayudaDocumentacion = new JMenuItem("Documentacion");
            JMenuItem ayudaAcercaDe = new JMenuItem("Acerca de ");
                // Agregamos los items:
                ayuda.add(ayudaDocumentacion);
                ayuda.add(ayudaAcercaDe);
            
        // Agregamos los menúes a la barra:
        menuBar.add(alumno);
        menuBar.add(docente);
        menuBar.add(curso);
        menuBar.add(reportes);
        menuBar.add(ayuda);

        InternalFrame ifr = new InternalFrame(this);
    
    }
    
    public void Mostrar()
    {
        ImageIcon img = new ImageIcon("src/Imagenes/icon32.png");
        this.setIconImage(img.getImage());
        this.setSize (900, 700);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        // Menu Alumno:
        if ( e.getActionCommand().equals ( "Ingresar alumno" ) ) 
        {
            
        }
        if ( e.getActionCommand().equals ( "Modificar alumno" ) ) 
        {
           
        }
        if ( e.getActionCommand().equals ( "Eliminar alumno" ) ) 
        {
            
        }
        
        
        // Curso
        
        if ( e.getActionCommand().equals ( "Dar de alta un curso" ) ) 
        {
        
            IngresarCurso Curso = new IngresarCurso();
            Curso.Mostrar();
        
        }
        if (e.getActionCommand().equals ( "Modificar curso" ) ) 
        {
        
            ModificarCurso Curso = new ModificarCurso();
            Curso.Mostrar();
        
        }
        
        if (e.getActionCommand().equals ( "Eliminar curso" ) ) 
        {
        
            EliminarCurso Curso = new EliminarCurso();
            Curso.Mostrar();
        
        }
        
    }
    
}
