
package Ventanas;

import Curso.EliminarCurso;
import Curso.IngresarCurso;
import Curso.ModificarCurso;

import Alumno.EliminarAlumno;
import Alumno.IngresarAlumno;
import Alumno.InscribirAlumno;
import Alumno.ModificarAlumno;

import Profesor.EliminarProfesor;
import Profesor.IngresarProfesor;
import Profesor.ModificarProfesor;


import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements ActionListener
{
    
    private JMenuItem ingresarAlumno, modificarAlumno, eliminarAlumno, inscribirAlumno;
    private JMenuItem ingresarDocente, modificarDocente, eliminarDocente;
    private JMenuItem ingresarCurso, modificarCurso, eliminarCurso;
    private JDesktopPane panelInterno;
    
    public VentanaPrincipal()
    {
        
        super ( "Sistema de gestion  -  CFP 403" );
        
        this.BarraHerramientas();
        
        this.ConfigurarDesktopPane();
        
    }
    
    private void ConfigurarDesktopPane ()
    {
        
        this.panelInterno = new JDesktopPane ();
        this.setContentPane ( this.panelInterno );
        
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
            inscribirAlumno = new JMenuItem ( "Inscribir alumno" );
            inscribirAlumno.addActionListener(this);
                // Agregamos los items:
                alumno.add(ingresarAlumno);
                alumno.add(inscribirAlumno);
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
    
    }
    
    public void Mostrar()
    {
        
        ImageIcon img = new ImageIcon("src/Imagenes/icon32.png");
        this.setIconImage ( img.getImage() );
        this.setSize ( 1000, 700 );
        this.setVisible ( true );
        this.setLocationRelativeTo ( null );
        this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );  
    
    }

    @Override
    public void actionPerformed ( ActionEvent itemSeleccionado ) 
    {
        
        System.out.println ( "Seleccionado: " + itemSeleccionado.getActionCommand() );
        
        // Menu Alumno:
        if ( itemSeleccionado.getActionCommand().equals ( "Ingresar alumno" ) ) 
        {
            
            this.panelInterno.add ( new IngresarAlumno ().Mostrar() );
            
        }
        
        if ( itemSeleccionado.getActionCommand().equals ( "Inscribir alumno" ) )
        {
            
            this.panelInterno.add ( new InscribirAlumno ().Mostrar() );
            
        }
        
        if ( itemSeleccionado.getActionCommand().equals ( "Modificar alumno" ) ) 
        {
            
            this.panelInterno.add ( new ModificarAlumno () );
            
        }
        
        if ( itemSeleccionado.getActionCommand().equals ( "Eliminar alumno" ) ) 
        {
            
            this.panelInterno.add ( new EliminarAlumno () );
            
        }
        
        
        // Menu Curso:
        if ( itemSeleccionado.getActionCommand().equals ( "Dar de alta un curso" ) ) 
        {
        
            this.panelInterno.add ( new IngresarCurso () );
        
        }
        
        if ( itemSeleccionado.getActionCommand().equals ( "Modificar curso" ) ) 
        {
        
            this.panelInterno.add ( new ModificarCurso () );
        
        }
        
        if ( itemSeleccionado.getActionCommand().equals ( "Eliminar curso" ) ) 
        {
        
            this.panelInterno.add ( new EliminarCurso () );
        
        }
        
        // Menu Profesor:
        if ( itemSeleccionado.getActionCommand().equals ( "Ingresar docente" ) )
        {
            
            this.panelInterno.add ( new IngresarProfesor () );
            
        }
        
        if ( itemSeleccionado.getActionCommand().equals ( "Modificar docente" ) )
        {
            
            this.panelInterno.add ( new ModificarProfesor () );
            
        }
        
        if ( itemSeleccionado.getActionCommand().equals ( "Eliminar docente" ) )
        {
            
            this.panelInterno.add ( new EliminarProfesor () );
            
        }
        
    }
    
}
