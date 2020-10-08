
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
public final class InscribirAlumno extends JInternalFrame
{

    private final LayoutManager layout = new GridLayout ( 4, 1 );
    private JComboBox jcbDNI;
    private JTextField jtfNombreAlumno;
    private JComboBox jcbNombreCurso;
    private JButton jbAceptar;
    
    public InscribirAlumno ()
    {

        super ( "Inscribir Alumno" );
        
        this.Configurar();
        this.agregarComponentes();
        
    }
    
    private void agregarComponentes ()
    {
        
        String [] DNIAlumnos = this.obtenerDNIs();
        String [] NombresCursos = this.obtenerCursos();
        
        JPanel panelDNI = new JPanel ( new FlowLayout (FlowLayout.CENTER) );
        this.jcbDNI = new JComboBox(DNIAlumnos);
        panelDNI.add ( new JLabel ("DNI del Alumno: ") );
        panelDNI.add(this.jcbDNI);
        
        JPanel panelNombreAlumno = new JPanel( new FlowLayout ( FlowLayout.CENTER ) );
        this.jtfNombreAlumno = new JTextField (20);
        this.jtfNombreAlumno.setEditable(false);
        panelNombreAlumno.add ( new JLabel ("Nombre del Alumno: ") );
        panelNombreAlumno.add ( this.jtfNombreAlumno );
        
        JPanel panelCurso = new JPanel ( new FlowLayout (FlowLayout.CENTER) );
        this.jcbNombreCurso = new JComboBox (NombresCursos);
        panelCurso.add ( new JLabel ("Nombre del Curso: ") );
        panelCurso.add ( this.jcbNombreCurso );
        
        JPanel panelBoton = new JPanel ( new FlowLayout ( FlowLayout.CENTER ) );
        this.jbAceptar = new JButton ("Inscribir Alumno");
        panelBoton.add ( this.jbAceptar );
        
        this.add(panelDNI);
        this.add(panelNombreAlumno);
        this.add(panelCurso);
        this.add(panelBoton);
        
    }
    
    private String [] obtenerDNIs ()
    {
        String[] DNIs = { "12345678", "12345678", "12345678" };
        return DNIs;
    }
    
    private String [] obtenerCursos ()
    {
        String[] Cursos = { "Java", "AutoCAD", "PhotoShop" };
        return Cursos;
    }

    private void Configurar ()
    {

        this.setResizable ( true );
        this.setClosable ( true );
        this.setMaximizable ( false );
        this.setIconifiable ( true );
        this.setSize(417, 200);
        this.setResizable(false);
        this.setLayout ( this.layout );

    }
    
    public InscribirAlumno Mostrar ()
    {
        
        this.setVisible ( true );
        
        return this;
        
    }
    
}
