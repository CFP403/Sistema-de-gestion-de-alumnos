

package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JMenuItem ingresarAlumno, modificarAlumno, eliminarAlumno;
    private JMenuItem ingresarDocente, modificarDocente, eliminarDocente;
    
    public VentanaPrincipal(){
        super("Sistema de gestion  -  CFP 403");
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JMenuBar menuBar = new JMenuBar();        
        this.setJMenuBar(menuBar);
        
        //Alumno
        JMenu alumno = new JMenu("Alumno");
        ingresarAlumno = new JMenuItem("Ingresar alumno");
        KeyStroke ctrlN = KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
        ingresarAlumno.setAccelerator(ctrlN);
        ingresarAlumno.addActionListener(this);
                
        modificarAlumno = new JMenuItem("Modificar alumno");
        KeyStroke ctrlM = KeyStroke.getKeyStroke(KeyEvent.VK_M, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
        modificarAlumno.setAccelerator(ctrlM);
        modificarAlumno.addActionListener(this);
        
        eliminarAlumno = new JMenuItem("Eliminar alumno");
        eliminarAlumno.addActionListener(this);
        KeyStroke ctrlE = KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
        eliminarAlumno.setAccelerator(ctrlE);
        
        //Docente
        JMenu docente = new JMenu("Docente");
        ingresarDocente = new JMenuItem("Ingresar docente");
        ingresarDocente.addActionListener(this);
        
        modificarDocente = new JMenuItem("Modificar docente");
        modificarDocente.addActionListener(this);
          
        eliminarDocente = new JMenuItem("Eliminar docente");
        eliminarDocente.addActionListener(this);
        
        //Curso
        JMenu curso = new JMenu("Curso");
        JMenuItem ingresarCurso = new JMenuItem("Dar de alta un curso");
        JMenuItem modificarCurso = new JMenuItem("Modificar curso");
        JMenuItem eliminarCurso = new JMenuItem("Eliminar curso");
        
        //Reportes
        JMenu reportes = new JMenu("Reportes");
        JMenuItem listarDocentes = new JMenuItem("Listar docentes");
        JMenuItem listarAlumnos = new JMenuItem("Listar alumnos");
        JMenuItem listarCursos = new JMenuItem("Listar cursos");
        JMenuItem listarAsistencia = new JMenuItem("Listar asistencia a cursos");
             
        //Ayuda
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
       
        /* Shortcuts Alumno */
        if (e.getSource() == ingresarAlumno) {
            //Ventana ingresar alumno
            JOptionPane.showMessageDialog ( this, "Ventana Ingresar Alumno", "Ingresar Alumno", JOptionPane.INFORMATION_MESSAGE );
        }
        
        if (e.getSource() == modificarAlumno) {
            //Ventana modificar alumno
            JOptionPane.showMessageDialog ( this, "Ventana Modificar Alumno", "Modificar Alumno", JOptionPane.INFORMATION_MESSAGE );
        }
        
        if (e.getSource() == eliminarAlumno) {
            //Ventana eliminar alumno
            JOptionPane.showMessageDialog ( this, "Ventana Eliminar Alumno", "Eliminar Alumno", JOptionPane.INFORMATION_MESSAGE );
        }
        
        /* Shortcuts Docente */
        if (e.getSource() == ingresarDocente) {
            //Ventana ingresar alumno
            JOptionPane.showMessageDialog ( this, "Ventana Ingresar Docente", "Ingresar Docente", JOptionPane.INFORMATION_MESSAGE );
        }
        
        if (e.getSource() == modificarDocente) {
            //Ventana modificar alumno
            JOptionPane.showMessageDialog ( this, "Ventana Modificar Docente", "Modificar Docente", JOptionPane.INFORMATION_MESSAGE );
        }
        
        if (e.getSource() == eliminarDocente) {
            //Ventana eliminar alumno
            JOptionPane.showMessageDialog ( this, "Ventana Eliminar Docente", "Eliminar Docente", JOptionPane.INFORMATION_MESSAGE );
        }
    }
}
