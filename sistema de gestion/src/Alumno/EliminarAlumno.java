/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class EliminarAlumno extends JInternalFrame
{
 
    private final LayoutManager layout = new GridLayout (3, 1);
    
    private JComboBox jcbDNI;
    private JTextField jtfNombreAlumno;
    private JButton jbAceptar;
    
    public EliminarAlumno()
    {
        
        super ( "Eliminar Alumno" );
        
        this.Configurar();
        this.agregarComponentes();
        
    }
    
    private void agregarComponentes ()
    {
        
        String [] DNIAlumnos = this.obtenerDNIs();
        
        JPanel panelDNI = new JPanel ( new FlowLayout (FlowLayout.CENTER) );
        this.jcbDNI = new JComboBox(DNIAlumnos);
        panelDNI.add ( new JLabel ("DNI del Alumno: ") );
        panelDNI.add(this.jcbDNI);
        
        JPanel panelNombreAlumno = new JPanel( new FlowLayout ( FlowLayout.CENTER ) );
        this.jtfNombreAlumno = new JTextField (20);
        this.jtfNombreAlumno.setEditable(false);
        panelNombreAlumno.add ( new JLabel ("Nombre del Alumno: ") );
        panelNombreAlumno.add ( this.jtfNombreAlumno );
        
        JPanel panelBoton = new JPanel ( new FlowLayout ( FlowLayout.CENTER ) );
        this.jbAceptar = new JButton ("Inscribir Alumno");
        panelBoton.add ( this.jbAceptar );
        
        this.add(panelDNI);
        this.add(panelNombreAlumno);
        this.add(panelBoton);
        
    }
    
    private String [] obtenerDNIs ()
    {
        String[] DNIs = { "12345678", "12345678", "12345678" };
        return DNIs;
    }
    
    private void Configurar ()
    {
        
        this.setResizable ( true );
        this.setClosable ( true );
        this.setMaximizable ( false );
        this.setIconifiable ( true );
        this.setSize ( 400 , 150 );
        this.setLayout(this.layout);
        this.setVisible ( true );
        
    }
    
}